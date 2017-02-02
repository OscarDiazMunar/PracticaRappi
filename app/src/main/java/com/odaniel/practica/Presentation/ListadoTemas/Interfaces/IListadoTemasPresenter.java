package com.odaniel.practica.Presentation.ListadoTemas.Interfaces;

import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Models.RedditJson.MainJson;
import com.odaniel.practica.Presentation.Base.IBasePresenter;

/**
 * Created by odiaz on 31/01/2017.
 */
public interface IListadoTemasPresenter extends IBasePresenter
{
    /**
     * Consume web service reddit.
     */
    void consumeWebServiceReddit();

    /**
     * Load dataoffline.
     */
    void loadDataoffline();

    /**
     * On click tema detalle.
     *
     * @param data the data
     */
    void onClickTemaDetalle(Data data);
}
