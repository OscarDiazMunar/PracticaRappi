package com.odaniel.practica.Presentation.SplashRappiPrueba.Interfaces;

import android.view.animation.Animation;

import com.odaniel.practica.Presentation.Base.IBasePresenter;

/**
 * Created by odiaz on 31/01/2017.
 */
public interface ISplashRappiPruebaPresenter extends IBasePresenter
{
    /**
     * Start splash.
     *
     * @param timeSplash the time splash
     */
    void startSplash(int timeSplash);

    /**
     * Animation animation.
     *
     * @return the animation
     */
    Animation animation();
}
