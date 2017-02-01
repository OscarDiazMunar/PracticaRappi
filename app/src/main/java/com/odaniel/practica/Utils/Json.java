package com.odaniel.practica.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * The type Json.
 */
public final class Json
{
    /**
     * Constructor
     */
    public Json()
    {
    }

    /**
     * Serialize string.
     *
     * @param <T> the type parameter
     * @param obj the obj
     * @return the string
     */
    public static <T> String serialize(T obj)
    {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * De serialize t.
     *
     * @param <T>        the type parameter
     * @param jsonString the tipodocumento string
     * @param tClass     the t class
     * @return the t
     * @throws ClassNotFoundException the class not found exception
     */
    public static <T> T deSerialize(String jsonString, Class<T> tClass) throws ClassNotFoundException
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, tClass);
    }

    /**
     * De serialize list t.
     *
     * @param <T>        class
     * @param jsonString json string
     * @param type       type class
     * @return object deserialize
     * @throws ClassNotFoundException the class not found exception
     */
    public static <T> T deSerializeList(String jsonString, Type type) throws ClassNotFoundException
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, (Type) type);
    }
}
