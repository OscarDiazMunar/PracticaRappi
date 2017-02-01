package com.odaniel.practica.Repositories.Events;

import com.odaniel.practica.Models.ErrorData;

/**
 * Created by Odiaz on 05/12/2016.
 */
public class BaseErrorEvent
{
    private ErrorData errorData;

    /**
     * Gets error data.
     *
     * @return the error data
     */
    public ErrorData getErrorData() {

        return errorData;
    }

    /**
     * Sets error data.
     *
     * @param errorData the error data
     */
    public void setErrorData(ErrorData errorData) {

        this.errorData = errorData;
    }
}
