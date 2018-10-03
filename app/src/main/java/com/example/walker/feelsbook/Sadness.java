package com.example.walker.feelsbook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Sadness extends Emotion {
    //Subclass of Emotion depicting Sadness

    public Sadness(){
        this.comment = "";
        this.mood = "Sadness";
        TimeZone tz = TimeZone.getTimeZone("Canada/Mountain");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        this.date= nowAsISO;
    }
}
