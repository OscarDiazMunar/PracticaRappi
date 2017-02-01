package com.odaniel.practica.Utils;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.odaniel.practica.Models.RedditJson.MainJson;

/**
 * Created by odiaz on 31/01/2017.
 */
public final class ReadAssetsHelper
{
    /**
     * Constructor
     */
    private ReadAssetsHelper()
    {
    }
    public static MainJson getMainJsonResponse(String responseJson)
    {
        MainJson mainJsonResponse = null;

        try
        {
            mainJsonResponse = Json.deSerializeList(responseJson, new TypeToken<MainJson>()
            {
            }.getType());
        } catch (ClassNotFoundException e)
        {
            Log.e(ReadAssetsHelper.class.getName(), e.getMessage());
        }
        return mainJsonResponse;
    }
}
