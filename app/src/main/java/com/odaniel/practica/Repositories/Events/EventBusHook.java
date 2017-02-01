package com.odaniel.practica.Repositories.Events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Odiaz on 05/12/2016.
 */
@Target(ElementType.METHOD)
public @interface EventBusHook
{
}
