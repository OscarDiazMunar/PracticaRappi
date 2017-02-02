package com.odaniel.practica.Presentation.ListadoTemas.Implementations;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Models.RedditJson.MainJson;
import com.odaniel.practica.Presentation.Base.BaseActivity;
import com.odaniel.practica.Presentation.ListadoTemas.Adapters.ListTemasAdapter;
import com.odaniel.practica.Presentation.ListadoTemas.Interfaces.IListadoTemasPresenter;
import com.odaniel.practica.Presentation.ListadoTemas.Interfaces.IListadoTemasView;
import com.odaniel.practica.R;
import com.odaniel.practica.Repositories.ImageLoader.GlideImageLoader;
import com.odaniel.practica.Repositories.ImageLoader.ImageLoader;
import com.odaniel.practica.Utils.Constants;
import com.odaniel.practica.Utils.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * The type Listado temas activity.
 */
public class ListadoTemasActivity extends BaseActivity implements IListadoTemasView, OnItemClickListener
{

    /**
     * The Recycler view temas.
     */
    @InjectView(R.id.recyclerViewTemas)
    RecyclerView recyclerViewTemas;

    private ListTemasAdapter listTemasAdapter;
    private IListadoTemasPresenter listadoTemasPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_temas);
        ButterKnife.inject(this);


        listadoTemasPresenter = new ListadoTemasPresenter(this);
        listadoTemasPresenter.onCreate();
        setupAdapter();
        setupRecyclerView();

        if (Utils.isNetworkAvailable(this))
        {
            listadoTemasPresenter.consumeWebServiceReddit();
        }
        else
        {
            listadoTemasPresenter.loadDataoffline();
        }
    }

    private void setupRecyclerView()
    {
        recyclerViewTemas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTemas.setAdapter(listTemasAdapter);
    }

    private void setupAdapter()
    {
        ImageLoader imageLoader = new GlideImageLoader(this);
        listTemasAdapter = new ListTemasAdapter(new ArrayList<Data>(), imageLoader, this, getContext());
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        listadoTemasPresenter.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        listadoTemasPresenter.onPause();
    }

    @Override
    public void addData(Data data)
    {
        listTemasAdapter.add(data);
    }

    @Override
    public void showDialogErrorNoInternetOrNetwork(String title, String message)
    {
        showDialog(2,
                title,
                message,
                Constants.Dialog.OK_BUTTON,
                null,
                Constants.Connection.NO_INTERNET_NETWORK);
    }

    @Override
    public void onItemClick(Data dataTema)
    {
        listadoTemasPresenter.onClickTemaDetalle(dataTema);
    }


}
