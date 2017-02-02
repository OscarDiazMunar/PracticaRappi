package com.odaniel.practica.Presentation.ListadoTemas.Implementations;

import android.content.Intent;
import android.util.Log;

import com.odaniel.practica.BuildConfig;
import com.odaniel.practica.Models.ErrorData;
import com.odaniel.practica.Models.RedditJson.Children;
import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Models.RedditJson.MainJson;
import com.odaniel.practica.Presentation.Base.IBasePresenter;
import com.odaniel.practica.Presentation.DetalleTemas.Implementations.DetalleTemasActivity;
import com.odaniel.practica.Presentation.ListadoTemas.Interfaces.IListadoTemasPresenter;
import com.odaniel.practica.Repositories.Events.BaseErrorEvent;
import com.odaniel.practica.Repositories.Events.BaseSuccessEvent;
import com.odaniel.practica.Repositories.Events.EventBusHook;
import com.odaniel.practica.Repositories.Managers.HTTPRequestManager;
import com.odaniel.practica.Utils.Constants;
import com.odaniel.practica.Utils.ReadAssetsHelper;
import com.odaniel.practica.Utils.Utils;

import de.greenrobot.event.EventBus;

/**
 * Created by odiaz on 31/01/2017.
 */
public class ListadoTemasPresenter implements IListadoTemasPresenter, IBasePresenter
{

    private ListadoTemasActivity listadoTemasActivity;
    private EventBus eventBus = EventBus.getDefault();
    private BaseErrorEvent baseErrorEvent = new BaseErrorEvent();
    private BaseSuccessEvent baseSuccessEvent = new BaseSuccessEvent();
    private ErrorData errorData = new ErrorData();
    private HTTPRequestManager<BaseSuccessEvent, BaseErrorEvent> request;

    /**
     * Instantiates a new Listado temas presenter.
     *
     * @param listadoTemasActivity the listado temas activity
     */
    public ListadoTemasPresenter(ListadoTemasActivity listadoTemasActivity)
    {
        this.listadoTemasActivity = listadoTemasActivity;
    }

    @Override
    public void consumeWebServiceReddit()
    {
        String URL =  BuildConfig.API_BASE_URL;

        request = new HTTPRequestManager<>(listadoTemasActivity,
                URL,
                BaseSuccessEvent.class,
                BaseErrorEvent.class);
        request.execute();
    }

    @Override
    public void loadDataoffline()
    {
        String lineJson = Utils.leerFicheroMemoriaInterna(listadoTemasActivity, Constants.FilesName.FILE_JSON);
        Log.e("el file", lineJson);
        if (!lineJson.equals("error"))
        {
            baseSuccessEvent.setTypeResponse(1);
            baseSuccessEvent.setResponse(lineJson);
            eventBus.post(baseSuccessEvent);
        }
        else
        {
            errorData.setErrorType(0);
            errorData.setMessage(Constants.Connection.NO_INTERNET_FIRST);
            baseErrorEvent.setErrorData(errorData);
            eventBus.post(baseErrorEvent);
        }


    }

    @Override
    public void onClickTemaDetalle(Data data)
    {
        Intent intent = new Intent(listadoTemasActivity, DetalleTemasActivity.class);
        intent.putExtra(Constants.Connection.RESPONSE_DATA_CLICK, data);
        listadoTemasActivity.startActivity(intent);
    }

    @Override
    public void onCreate()
    {
        eventBus.register(this);

    }

    @Override
    public void onDestroy()
    {

    }

    @Override
    public void onResume()
    {
        //eventBus.register(this);
    }

    @Override
    public void onPause()
    {
        eventBus.unregister(this);
    }

    /**
     * On event.
     *
     * @param baseSuccessEvent the base success event
     */
    @EventBusHook
    public void onEvent(BaseSuccessEvent baseSuccessEvent)
    {
        MainJson mainJsonResponse;
        switch (baseSuccessEvent.getTypeResponse())
        {
            case 0:
                switch (request.getResponseCode())
                {
                    case Constants.CodResponseWebservice.RESPONSE_NOOK:
                        Log.e("el consumo", baseSuccessEvent.getResponse());
                        mainJsonResponse = ReadAssetsHelper.getMainJsonResponse(baseSuccessEvent.getResponse());
                        errorData.setErrorType(0);
                        errorData.setMessage(Constants.Connection.NO_CONNECTION);
                        baseErrorEvent.setErrorData(errorData);
                        eventBus.post(baseErrorEvent);
                        break;
                    case Constants.CodResponseWebservice.RESPONSE_OK:
                        Log.e("el consumo existe", baseSuccessEvent.getResponse());
                        mainJsonResponse = ReadAssetsHelper.getMainJsonResponse(baseSuccessEvent.getResponse());
                        Utils.grabarAchivo(listadoTemasActivity, baseSuccessEvent.getResponse(), Constants.FilesName.FILE_JSON);
                        fillListadapter(mainJsonResponse);
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                listadoTemasActivity.showDialogErrorNoInternetOrNetwork(Constants.Connection.NO_INTERNET_NETWORK,
                                                                        Constants.Connection.NO_INTERNET_LOAD_DATA);
                mainJsonResponse = ReadAssetsHelper.getMainJsonResponse(baseSuccessEvent.getResponse());

                fillListadapter(mainJsonResponse);
                break;
            default:
                break;
        }

    }

    /**
     * On event.
     *
     * @param baseErrorEvent the base error event
     */
    @EventBusHook
    public void onEvent(BaseErrorEvent baseErrorEvent)
    {
        switch (baseErrorEvent.getErrorData().getErrorType())
        {
            case Constants.ErrorType.NO_DATA_LOAD:
                listadoTemasActivity.showDialogErrorNoInternetOrNetwork(Constants.Connection.NO_INTERNET_NETWORK,
                                                                        Constants.Connection.NO_INTERNET_FIRST);
                break;
            case Constants.ErrorType.FAIL_CONNECTION_NO_EXIST:
                listadoTemasActivity.showDialogErrorNoInternetOrNetwork(Constants.Connection.NO_CONNECTION,
                        Constants.Connection.NO_CONNECTION);
                break;
            default:
                break;

        }
    }

    private void fillListadapter(MainJson mainJsonResponse)
    {
        for(Children children : mainJsonResponse.getData().getChildren())
        {
            listadoTemasActivity.addData(children.getData());
        }

    }
}
