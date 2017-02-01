package com.odaniel.practica.Presentation.SplashRappiPrueba.Implementations;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.odaniel.practica.MainActivity;
import com.odaniel.practica.Presentation.Base.IBasePresenter;
import com.odaniel.practica.Presentation.ListadoTemas.Implementations.ListadoTemasActivity;
import com.odaniel.practica.Presentation.SplashRappiPrueba.Interfaces.ISplashRappiPruebaPresenter;
import com.odaniel.practica.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by odiaz on 31/01/2017.
 */
public class SplashRappiPruebaPresenter implements ISplashRappiPruebaPresenter, IBasePresenter
{
    private SplashRappiPruebaActivity splashRappiPruebaActivity;

    /**
     * Instantiates a new Splash rappi prueba presenter.
     *
     * @param splashRappiPruebaActivity the splash rappi prueba activity
     */
    public SplashRappiPruebaPresenter(SplashRappiPruebaActivity splashRappiPruebaActivity)
    {
        this.splashRappiPruebaActivity = splashRappiPruebaActivity;
    }

  /*  @Override
    public void startSplash(int timeSplash)
    {
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
// Start the next activity
                Intent mainIntent = new Intent().setClass(
                        splashRappiPruebaActivity, ListadoTemasActivity.class);
                splashRappiPruebaActivity.startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                splashRappiPruebaActivity.finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, timeSplash);


    }*/

    @Override
    public void startSplash(final int timeSplash)
    {
        /*TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
// Start the next activity
                Intent mainIntent = new Intent().setClass(
                        splashRappiPruebaActivity, ListadoTemasActivity.class);
                splashRappiPruebaActivity.startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                splashRappiPruebaActivity.finish();
            }
        };*/

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(timeSplash);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(splashRappiPruebaActivity,ListadoTemasActivity.class);
                    splashRappiPruebaActivity.startActivity(intent);
                }
            }
        };
        timerThread.start();

    }



    @Override
    public Animation animation()
    {
        Animation move;
        move = AnimationUtils.loadAnimation(splashRappiPruebaActivity, R.animator.anomationsplash);
        move.reset();

        return move;
    }

    @Override
    public void onCreate()
    {

    }

    @Override
    public void onDestroy()
    {

    }

    @Override
    public void onResume()
    {

    }

    @Override
    public void onPause()
    {

    }
}
