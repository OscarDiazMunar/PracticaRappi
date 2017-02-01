package com.odaniel.practica.Presentation.SplashRappiPrueba.Implementations;

import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.odaniel.practica.Presentation.Base.BaseActivity;
import com.odaniel.practica.Presentation.SplashRappiPrueba.Interfaces.ISplashRappiPruebaPresenter;
import com.odaniel.practica.Presentation.SplashRappiPrueba.Interfaces.ISplashRappiPruebaView;
import com.odaniel.practica.R;
import com.odaniel.practica.Utils.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * The type Splash rappi prueba activity.
 */
public class SplashRappiPruebaActivity extends BaseActivity implements ISplashRappiPruebaView
{


    /**
     * The Img splash rappi.
     */
    @InjectView(R.id.imgSplashRappi)
    ImageView imgSplashRappi;

    ISplashRappiPruebaPresenter splashRappiPruebaPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_rappi_prueba);
        ButterKnife.inject(this);

        splashRappiPruebaPresenter = new SplashRappiPruebaPresenter(this);
        Animation move = splashRappiPruebaPresenter.animation();
        imgSplashRappi.setAnimation(move);
        splashRappiPruebaPresenter.startSplash(Constants.Splash.SPLASH_SCREEN_DELAY);

        settingToolbar(Constants.ToolBarType.NO_TOOLBAR);

    }
}
