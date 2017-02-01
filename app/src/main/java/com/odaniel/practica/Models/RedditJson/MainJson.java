package com.odaniel.practica.Models.RedditJson;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by odiaz on 31/01/2017.
 */
public class MainJson implements Parcelable {
    @SerializedName("data")
    private DataFather data;

    @SerializedName("kind")
    private String kind;

    public DataFather getData ()
    {
        return data;
    }

    public void setData (DataFather data)
    {
        this.data = data;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", kind = "+kind+"]";
    }

    protected MainJson(Parcel in) {
        data = (DataFather) in.readValue(Data.class.getClassLoader());
        kind = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
        dest.writeString(kind);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MainJson> CREATOR = new Parcelable.Creator<MainJson>() {
        @Override
        public MainJson createFromParcel(Parcel in) {
            return new MainJson(in);
        }

        @Override
        public MainJson[] newArray(int size) {
            return new MainJson[size];
        }
    };
}
