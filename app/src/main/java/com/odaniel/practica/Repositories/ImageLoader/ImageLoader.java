package com.odaniel.practica.Repositories.ImageLoader;

import android.widget.ImageView;

/**
 * Created by odiaz on 31/01/2017.
 */
public interface ImageLoader
{
    /**
     * Load.
     *
     * @param imageView the image view
     * @param url       the url
     */
    void load(ImageView imageView, String url);
}
