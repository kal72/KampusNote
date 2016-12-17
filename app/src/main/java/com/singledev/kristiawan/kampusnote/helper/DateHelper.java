package com.singledev.kristiawan.kampusnote.helper;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ASUS on 05/10/2016.
 */

public class DateHelper {

    public static final String dateNow(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        return dateFormat.format(cal.getTime()).toString();
    }

    public static final String timeNow(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        return dateFormat.format(cal.getTime()).toString();
    }

    public static final String timeFormat(String time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        try {
            date = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateFormat.format(date).toString());
        return dateFormat.format(date).toString();
    }
}
