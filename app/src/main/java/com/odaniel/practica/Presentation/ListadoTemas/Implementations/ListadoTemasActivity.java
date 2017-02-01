package com.odaniel.practica.Presentation.ListadoTemas.Implementations;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Models.RedditJson.MainJson;
import com.odaniel.practica.Presentation.Base.BaseActivity;
import com.odaniel.practica.Presentation.ListadoTemas.Adapters.ListTemasAdapter;
import com.odaniel.practica.Presentation.ListadoTemas.Interfaces.IListadoTemasPresenter;
import com.odaniel.practica.Presentation.ListadoTemas.Interfaces.IListadoTemasView;
import com.odaniel.practica.R;
import com.odaniel.practica.Repositories.ImageLoader.GlideImageLoader;
import com.odaniel.practica.Repositories.ImageLoader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ListadoTemasActivity extends BaseActivity implements IListadoTemasView, OnItemClickListener
{

    MainJson hola = null;
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
        listadoTemasPresenter.consumeWebServiceReddit();
        setupAdapter();
        setupRecyclerView();
//        hola.getData();
    }

    private void setupRecyclerView()
    {
        recyclerViewTemas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTemas.setAdapter(listTemasAdapter);
    }

    private void setupAdapter()
    {
        ImageLoader imageLoader = new GlideImageLoader(this);
        listTemasAdapter = new ListTemasAdapter(new ArrayList<Data>(), imageLoader, this);
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
    public void elobjeto(MainJson mainJson)
    {

        hola = mainJson;
        //Log.e("aqui locas", hola.getData().getAfter());
    }

    @Override
    public void addData(Data data)
    {
        listTemasAdapter.add(data);
    }

    @Override
    public void onItemClick(Data dataTema)
    {

    }
}
