package com.example.walker.feelsbook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Love extends Emotion {

    @Override
    public void setDate(){
        this.date=date;
    }
    @Override
    public String getDate(){
        return this.date;
    }

    public Love() {

        TimeZone tz = TimeZone.getTimeZone("Canada/Mountain");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        this.date= nowAsISO;
        count++;
        comment = "";
        mood = "Love";
    }
}
