package com.odaniel.practica.Utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by odiaz on 01/02/2017.
 */
public final class Utils
{
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


}
