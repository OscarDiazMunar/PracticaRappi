package com.odaniel.practica.Models;

/**
 * Created by Odiaz on 05/12/2016.
 */
public class ErrorData
{
    private String message;
    private int errorType;

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets error type.
     *
     * @return the error type
     */
    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }
}
