package com.phong_tro.ultils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUltil {
    public static Date parseDate(String input){
        Date date = null;
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String parseString(Date date) {
        String result = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        result = formatter.format(date);
        return result;
    }
}
