package com.odaniel.practica.Presentation.ListadoTemas.Interfaces;

import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Models.RedditJson.MainJson;
import com.odaniel.practica.Presentation.Base.IBaseView;

/**
 * Created by odiaz on 31/01/2017.
 */
public interface IListadoTemasView extends IBaseView
{
    void elobjeto(MainJson mainJson);
    void addData(Data data);
}
