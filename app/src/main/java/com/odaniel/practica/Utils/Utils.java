package com.odaniel.practica.Utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by odiaz on 01/02/2017.
 */
public final class Utils
{
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());
    /**
     * Instantiates a new Utils.
     */
    public Utils()
    {
    }

    /**
     * Created date string.
     *
     * @param milis the milis
     * @return the string
     */
    public static String created_date(String milis)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.Date.DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(milis));

        return simpleDateFormat.format(calendar.getTime());
    }

    public static boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void grabarAchivo(Context context, String jsonResponse, String filename) {
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(jsonResponse.getBytes());
            Log.e("graba archivo", "grabar todo archivo");
            outputStream.close();
        } catch (Exception e) {
            Log.e("grabar error", e.toString());
            e.printStackTrace();
        }
    }

    public static String leerFicheroMemoriaInterna(Context context, String filename)
    {
        InputStreamReader flujo=null;
        BufferedReader lector=null;
        try
        {
            flujo= new InputStreamReader(context.openFileInput(filename));
            lector= new BufferedReader(flujo);
            String texto = lector.readLine();
            return texto;
        }
        catch (Exception ex)
        {
            Log.e("error", "Error al leer fichero desde memoria interna");
        }
        finally
        {
            try {
                if(flujo!=null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "error";
    }
}
