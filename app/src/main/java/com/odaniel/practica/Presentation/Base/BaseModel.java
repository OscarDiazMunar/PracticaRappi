package com.odaniel.practica.Presentation.Base;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Base model.
 */
public class BaseModel implements Serializable
{
    /**
     * Is model array boolean.
     *
     * @param json the tipodocumento
     * @return the boolean
     */
    public static boolean isModelArray(String json)
    {
        try
        {
            new JSONArray(json);
        } catch (JSONException jsonException)
        {
            return false;
        }
        return true;
    }

    /**
     * Object from tipodocumento base model.
     *
     * @param json the tipodocumento
     * @param type the type
     * @return the base model
     */
    public static BaseModel objectFromJson(String json, Class<? extends BaseModel> type) throws com.google.gson.JsonParseException
    {
        return new Gson().fromJson(json, type);
    }

    /**
     * Array from tipodocumento array list.
     *
     * @param json the tipodocumento
     * @param type the type
     * @return the array list
     * @throws JSONException the tipodocumento exception
     */
    @SuppressWarnings("unchecked")
    public static Set<BaseModel> arrayFromJson(String json, Class<BaseModel> type)
            throws com.google.gson.JsonParseException, JSONException
    {
        Set objectArray = new HashSet();
        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++)
        {
            String jsonObject = jsonArray.get(i).toString();
            objectArray.add(BaseModel.objectFromJson(jsonObject, type));
        }
        return objectArray;
    }

    /**
     * To tipodocumento string string.
     *
     * @return the string
     */
    public String toJsonString()
    {
        return new Gson().toJson(this);
    }
}

