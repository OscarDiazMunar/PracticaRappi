package com.odaniel.practica.Presentation.ListadoTemas.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.odaniel.practica.Models.RedditJson.Data;
import com.odaniel.practica.Presentation.ListadoTemas.Implementations.ListadoTemasActivity;
import com.odaniel.practica.Presentation.ListadoTemas.Implementations.OnItemClickListener;
import com.odaniel.practica.R;
import com.odaniel.practica.Repositories.ImageLoader.ImageLoader;
import com.odaniel.practica.Utils.Utils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by odiaz on 31/01/2017.
 */
public class ListTemasAdapter extends RecyclerView.Adapter<ListTemasAdapter.ViewHolder>
{


    private List<Data> dataTemas;
    private ImageLoader imageLoader;
    private OnItemClickListener clickListener;
    private Context context;

    public ListTemasAdapter(List<Data> dataTemas, ImageLoader imageLoader, OnItemClickListener clickListener, Context context)
    {
        this.dataTemas = dataTemas;
        this.imageLoader = imageLoader;
        this.clickListener = clickListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_list_temas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Data data = dataTemas.get(position);
        holder.setClickListener(data, clickListener);
        holder.txtTitle.setText(data.getTitle());
        holder.txtDate.setText(Utils.created_date(data.getCreated()));
        holder.txtDisplayName.setText(data.getDisplay_name());
        if (data.getOver18().equals("false"))
        {
            holder.txtOver18.setText(context.getString(R.string.all_public));
        }

        holder.txtPublicDescription.setText(data.getPublic_description());
        holder.txtSubscribers.setText(context.getString(R.string.subscribers)+data.getSubscribers());
        //holder.txtPublicDescription.setText(Html.fromHtml(data.getDescription_html()));
        imageLoader.load(holder.imgIcon, data.getIcon_img());
    }

    @Override
    public int getItemCount()
    {
        return dataTemas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        @InjectView(R.id.imgIcon)
        ImageView imgIcon;
        @InjectView(R.id.txtTitle)
        TextView txtTitle;
        @InjectView(R.id.txtDate)
        TextView txtDate;
        @InjectView(R.id.txtDisplayName)
        TextView txtDisplayName;
        @InjectView(R.id.txtOver18)
        TextView txtOver18;
        @InjectView(R.id.txtPublicDescription)
        TextView txtPublicDescription;
        @InjectView(R.id.txtSubscribers)
        TextView txtSubscribers;
        View view;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.view = itemView;
            ButterKnife.inject(this, itemView);
        }

        public void setClickListener(final Data data,
                                     final OnItemClickListener listener)
        {
            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    listener.onItemClick(data);
                }
            });
        }
    }

    public void add(Data data)
    {
        this.dataTemas.add(data);
        this.notifyDataSetChanged();
    }
}
