package com.odaniel.practica.Presentation.ListadoTemas.Implementations;

import android.util.Log;

import com.odaniel.practica.BuildConfig;
import com.odaniel.practica.Models.ErrorData;
import com.odaniel.practica.Models.RedditJson.Children;
import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Models.RedditJson.MainJson;
import com.odaniel.practica.Presentation.Base.IBasePresenter;
import com.odaniel.practica.Presentation.ListadoTemas.Interfaces.IListadoTemasPresenter;
import com.odaniel.practica.Repositories.Events.BaseErrorEvent;
import com.odaniel.practica.Repositories.Events.BaseSuccessEvent;
import com.odaniel.practica.Repositories.Events.EventBusHook;
import com.odaniel.practica.Repositories.Managers.HTTPRequestManager;
import com.odaniel.practica.Utils.Constants;
import com.odaniel.practica.Utils.ReadAssetsHelper;

import de.greenrobot.event.EventBus;

/**
 * Created by odiaz on 31/01/2017.
 */
public class ListadoTemasPresenter implements IListadoTemasPresenter, IBasePresenter
{

    private ListadoTemasActivity listadoTemasActivity;
    private EventBus eventBus = EventBus.getDefault();
    private BaseErrorEvent baseErrorEvent = new BaseErrorEvent();
    private ErrorData errorData = new ErrorData();
    private HTTPRequestManager<BaseSuccessEvent, BaseErrorEvent> request;
    private MainJson mainJson;

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
    public void onCreate()
    {

    }

    @Override
    public void onDestroy()
    {

    }

    @Override
    public void onResume()
    {
        eventBus.register(this);
    }

    @Override
    public void onPause()
    {
        eventBus.unregister(this);
    }

    @EventBusHook
    public void onEvent(BaseSuccessEvent baseSuccessEvent)
    {
        MainJson mainJsonResponse;
        switch (request.getResponseCode())
        {
            case Constants.CodResponseWebservice.RESPONSE_NOOK:
                Log.e("el consumo", baseSuccessEvent.getResponse());
                mainJsonResponse = ReadAssetsHelper.getMainJsonResponse(baseSuccessEvent.getResponse());
                //Log.e("aqui el otro", mainJsonResponse.getData().getChildren().getData().getName());
                mainJson = mainJsonResponse;

                listadoTemasActivity.elobjeto(mainJsonResponse);

                break;
            case Constants.CodResponseWebservice.RESPONSE_OK:
                Log.e("el consumo existe", baseSuccessEvent.getResponse());
                mainJsonResponse = ReadAssetsHelper.getMainJsonResponse(baseSuccessEvent.getResponse());
                mainJson = mainJsonResponse;
                fillListadapter(mainJsonResponse);
                listadoTemasActivity.elobjeto(mainJsonResponse);
                //responseValidateUserParcelable = ReadAssetsHelper.getListResponseValidateUserUserParcelable(baseSuccessEvent.getResponse());
                //typeAlertResponse(responseValidateUserParcelable);
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

    @EventBusHook
    public void onEvent(BaseErrorEvent baseErrorEvent)
    {

    }
}
