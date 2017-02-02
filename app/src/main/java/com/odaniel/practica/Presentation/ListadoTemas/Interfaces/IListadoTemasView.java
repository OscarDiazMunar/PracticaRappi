package com.odaniel.practica.Presentation.ListadoTemas.Interfaces;

import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Models.RedditJson.MainJson;
import com.odaniel.practica.Presentation.Base.IBaseView;

/**
 * Created by odiaz on 31/01/2017.
 */
public interface IListadoTemasView extends IBaseView
{
    /**
     * Add data.
     *
     * @param data the data
     */
    void addData(Data data);

    /**
     * Show dialog error no internet or network.
     */
    void showDialogErrorNoInternetOrNetwork(String title, String message);
}
