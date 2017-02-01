package com.odaniel.practica.Repositories.Events;

import com.odaniel.practica.Utils.Json;

/**
 * Created by Odiaz on 05/12/2016.
 */
public class BaseSuccessEvent
{
    private String response;

    /**
     * Gets response.
     *
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets response.
     *
     * @param response the response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * Gets typed response.
     *
     * @param <T>    the type parameter
     * @param tClass the t class
     * @return the typed response
     * @throws ClassNotFoundException the class not found exception
     */
    public <T> T getTypedResponse(Class<T> tClass) throws ClassNotFoundException {
        return Json.deSerialize(response, tClass);
    }
}
