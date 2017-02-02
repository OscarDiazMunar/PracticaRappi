package com.odaniel.practica.Presentation.ListadoTemas.Implementations;

import com.odaniel.practica.Models.RedditJson.Data;

/**
 * Created by odiaz on 31/01/2017.
 */
public interface OnItemClickListener
{
    /**
     * On item click.
     *
     * @param dataTema the data tema
     */
    void onItemClick(Data dataTema);
}
