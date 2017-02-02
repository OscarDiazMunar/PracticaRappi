package com.odaniel.practica.Models;

import com.odaniel.practica.Presentation.Base.BaseModel;

/**
 * The type Response.
 *
 * @author by Odiaz on 25/07/2016.
 */
public class Response extends BaseModel
{
    private int statusCode;
    private String message;

    /**
     * Instantiates a new Response.
     */
    public Response()
    {
    }

    /**
     * Instantiates a new Response.
     *
     * @param statusCode the status code
     * @param message    the message
     */
    public Response(int statusCode, String message)
    {
        this.statusCode = statusCode;
        this.message = message;
    }

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public int getStatusCode()
    {
        return statusCode;
    }

    /**
     * Sets status code.
     *
     * @param statusCode the status code
     */
    public void setStatusCode(int statusCode)
    {
        this.statusCode = statusCode;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message)
    {
        this.message = message;
    }
}

