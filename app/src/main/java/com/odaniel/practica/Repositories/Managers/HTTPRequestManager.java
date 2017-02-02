package com.odaniel.practica.Repositories.Managers;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.odaniel.practica.Models.ErrorData;
import com.odaniel.practica.Repositories.Events.BaseErrorEvent;
import com.odaniel.practica.Repositories.Events.BaseSuccessEvent;
import com.odaniel.practica.Utils.Constants;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;

/**
 * Created by Odiaz on 05/12/2016.
 */
public class HTTPRequestManager<Success extends BaseSuccessEvent, Error extends BaseErrorEvent>
{
    /**
     * The constant TAG.
     */
    public static final String TAG = HTTPRequestManager.class.getSimpleName();
    private ProgressDialog progressDialog;
    private int responseCode;
    private ErrorData errorData;
    private Response.Listener<JSONObject> jsonResponseListener;
    private Response.ErrorListener errorListener;
    private EventBus eventBus = EventBus.getDefault();
    private HashMap<String, String> params;
    private HashMap<String, String> headers;
    private String url;
    private Context context;
    private Class<Success> successClass;
    private Class<Error> errorClass;

    /**
     * Instantiates a new Http request manager.
     *
     * @param context the context
     * @param url     the url
     * @param successClass  the p class
     * @param errorClass  the q class
     */
    public HTTPRequestManager(Context context, String url, Class<Success> successClass, Class<Error> errorClass) {
        this.context = context;
        this.url = url;
        params = new HashMap<>();
        headers = new HashMap<>();
        addJSONHeaders();
        errorData = new ErrorData();
        this.successClass = successClass;
        this.errorClass = errorClass;
        setListeners();
    }

    private void addJSONHeaders() {
        addHeader("Accept", "application/json");
        addHeader("Content-type", "application/json");
    }

    private void setListeners() {
        jsonResponseListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                dismissProgressDialog();
                try {
                    Success res = successClass.newInstance();
                    res.setResponse(response.toString());
                    res.setTypeResponse(0);
                    //Log.e("el repsonse", response.toString());
                    eventBus.post(res);
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        };
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dismissProgressDialog();
                try {
                    Error err = errorClass.newInstance();
                    errorData.setErrorType(Constants.ErrorType.FAIL_CONNECTION_NO_EXIST);
                    errorData.setMessage(error.toString());
                    err.setErrorData(errorData);
                    //Log.e("el repsonse error", error.toString());
                    eventBus.post(err);
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        };



    }


    /**
     * Gets params.
     *
     * @return the params
     */
    public HashMap<String, String> getParams() {
        return params;
    }

    /**
     * Gets headers.
     *
     * @return the headers
     */
    public HashMap<String, String> getHeaders() {
        return headers;
    }


    /**
     * Gets complete url.
     *
     * @return the complete url
     */
    public String getCompleteUrl() {
        return url;
    }

    /**
     * Gets response code.
     *
     * @return the response code
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Gets error data.
     *
     * @return the error data
     */
    public ErrorData getErrorData() {
        return errorData;
    }

    /**
     * Execute.
     */
    public  void execute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        dismissProgressDialog();
        progressDialog.setMessage("esta cargando...");
        progressDialog.show();
        addToRequestQueue(getJsonRequest());
    }


    /**
     * Dismiss progress dialog.
     */
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private <X> void addToRequestQueue(Request<X> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        VolleyManager.getInstance(context).getRequestQueue().add(req);
    }

    private <X> void addToRequestQueue(Request<X> req) {
        addToRequestQueue(req, "");
    }


    /**
     * Add param.
     *
     * @param name  the name
     * @param value the value
     */
    public void addParam(String name, String value) {
        params.put(name, value);
    }

    /**
     * Add header.
     *
     * @param name  the name
     * @param value the value
     */
    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    /**
     * Gets tipodocumento request.
     *
     * @return the tipodocumento request
     */
    public JsonObjectRequest getJsonRequest() {
        try {
            getUrl();
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage());
        }

        JSONObject jsonObject= null;
        return new JsonObjectRequest(url,jsonObject, jsonResponseListener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response)
            {
                responseCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
    }


    /**
     * Gets url.
     *
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    void getUrl() throws UnsupportedEncodingException {
        String combinedParams = "";
        if (!params.isEmpty()) {
            combinedParams += "?";
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String paramString = entry.getKey() + "="
                        + URLEncoder.encode(entry.getValue(), "UTF-8");
                if (combinedParams.length() > 1) {
                    combinedParams += "&" + paramString;
                } else {
                    combinedParams += paramString;
                }
            }
        }
        url = url + combinedParams;
    }
}
