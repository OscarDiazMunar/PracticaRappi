package com.odaniel.practica.Models.RedditJson;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by odiaz on 31/01/2017.
 */
public class Children implements Parcelable {

    @SerializedName("data")
    private Data data;

    @SerializedName("kind")
    private String kind;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
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

    protected Children(Parcel in) {
        data = (Data) in.readValue(Data.class.getClassLoader());
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
    public static final Parcelable.Creator<Children> CREATOR = new Parcelable.Creator<Children>() {
        @Override
        public Children createFromParcel(Parcel in) {
            return new Children(in);
        }

        @Override
        public Children[] newArray(int size) {
            return new Children[size];
        }
    };
}