package com.odaniel.practica.Presentation.DetalleTemas.Implementations;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Presentation.Base.BaseActivity;
import com.odaniel.practica.Presentation.DetalleTemas.Interfaces.IDetalleTemasView;
import com.odaniel.practica.R;
import com.odaniel.practica.Repositories.ImageLoader.GlideImageLoader;
import com.odaniel.practica.Repositories.ImageLoader.ImageLoader;
import com.odaniel.practica.Utils.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * The type Detalle temas activity.
 */
public class DetalleTemasActivity extends BaseActivity implements IDetalleTemasView
{

    /**
     * The Img banner.
     */
    @InjectView(R.id.imgBanner)
    ImageView imgBanner;
    /**
     * The Txt title detalle.
     */
    @InjectView(R.id.txtTitleDetalle)
    TextView txtTitleDetalle;
    /**
     * The Txt public description detalle.
     */
    @InjectView(R.id.txtPublicDescriptionDetalle)
    TextView txtPublicDescriptionDetalle;
    /**
     * The Txt subscribers detalle d.
     */
    @InjectView(R.id.txtSubscribersDetalleD)
    TextView txtSubscribersDetalleD;
    /**
     * The Txt spoilers d.
     */
    @InjectView(R.id.txtSpoilersD)
    TextView txtSpoilersD;
    /**
     * The Txt links d.
     */
    @InjectView(R.id.txtLinksD)
    TextView txtLinksD;
    /**
     * The Img icon detalle.
     */
    @InjectView(R.id.imgIconDetalle)
    ImageView imgIconDetalle;
    /**
     * The Txt header.
     */
    @InjectView(R.id.txtHeader)
    TextView txtHeader;
    /**
     * The Img header.
     */
    @InjectView(R.id.imgHeader)
    ImageView imgHeader;

    private Data dataDetalle;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_temas);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        dataDetalle = intent.getParcelableExtra(Constants.Connection.RESPONSE_DATA_CLICK);
        setFieldsTemaDetalle(dataDetalle);
    }

    private void setFieldsTemaDetalle(Data dataDetalle)
    {
        imageLoader = new GlideImageLoader(this);
        imageLoader.load(imgBanner, dataDetalle.getBanner_img());
        imageLoader.load(imgIconDetalle, dataDetalle.getIcon_img());
        imageLoader.load(imgHeader, dataDetalle.getHeader_img());
        txtTitleDetalle.setText(dataDetalle.getTitle());
//        txtTitleDetalle.setTextColor(Color.parseColor(dataDetalle.getKey_color()));
        txtSubscribersDetalleD.setText(dataDetalle.getSubscribers());
        txtLinksD.setText(dataDetalle.getUrl());
        txtHeader.setText(dataDetalle.getHeader_title());
        txtPublicDescriptionDetalle.setText(dataDetalle.getSubmit_text());
    }
}
