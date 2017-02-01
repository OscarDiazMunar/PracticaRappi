package com.odaniel.practica.Models.RedditJson;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by odiaz on 31/01/2017.
 */
public class DataFather implements Parcelable {
    @SerializedName("modhash")
    private String modhash;

    @SerializedName("children")
    private List<Children> children;

    @SerializedName("after")
    private String after;

    @SerializedName("before")
    private String before;

    public String getModhash()
    {
        return modhash;
    }

    public void setModhash(String modhash)
    {
        this.modhash = modhash;
    }

    public List<Children> getChildren()
    {
        return children;
    }

    public void setChildren(List<Children> children)
    {
        this.children = children;
    }

    public String getAfter()
    {
        return after;
    }

    public void setAfter(String after)
    {
        this.after = after;
    }

    public String getBefore()
    {
        return before;
    }

    public void setBefore(String before)
    {
        this.before = before;
    }

    protected DataFather(Parcel in) {
        modhash = in.readString();
        children = (List<Children>) in.readValue(Children.class.getClassLoader());
        after = in.readString();
        before = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(modhash);
        dest.writeValue(children);
        dest.writeString(after);
        dest.writeString(before);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DataFather> CREATOR = new Parcelable.Creator<DataFather>() {
        @Override
        public DataFather createFromParcel(Parcel in) {
            return new DataFather(in);
        }

        @Override
        public DataFather[] newArray(int size) {
            return new DataFather[size];
        }
    };
}