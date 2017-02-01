package com.odaniel.practica.Repositories.ImageLoader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by odiaz on 31/01/2017.
 */
public class GlideImageLoader implements ImageLoader
{
    private RequestManager glideRequestManager;

    /**
     * Instantiates a new Glide image loader.
     *
     * @param context the context
     */
    public GlideImageLoader(Context context)
    {
        this.glideRequestManager = Glide.with(context);
    }

    @Override
    public void load(ImageView imageView, String url)
    {
        glideRequestManager.load(url).into(imageView);
    }
}
