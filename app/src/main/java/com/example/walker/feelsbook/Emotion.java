package com.example.walker.feelsbook;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Emotion implements Comparable<Emotion>, Serializable {
    //Class that acts as the parent class for all of the different emotions

    /**
     * Emotion serialization ID
     */
    private static final long serializationID = 1234567891;
    protected String date;
    protected String comment;
    protected String mood;

    public Emotion(){

    }
    public Emotion(String mood){
        TimeZone tz = TimeZone.getTimeZone("Canada/Mountain");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        this.date= nowAsISO;
        comment = "";
        this.mood = mood;
    }
    public  String getDate(){
        return this.date;
    }
    public  void setDate(String s){
        this.date=s;
    }
    public  void setComment(String s){
        this.comment=s;
    }
    public String toString(){
        return date + " | " + mood + " | " + comment;
    }
    @Override
    public int compareTo(Emotion otherEmotion){
        return otherEmotion.getDate().compareTo(this.date);

    }
    public boolean equals(Object otherEmotion){
        if(otherEmotion != null && otherEmotion.getClass()==this.getClass()){
           return this.equals((Emotion) otherEmotion);
        }else {
            return false;
        }
    }
    public boolean equals(Emotion otherEmotion){
        if(otherEmotion == null){
            return false;
        }
        return getDate().equals(otherEmotion.getDate());
    }
    public int hashCode(){
       return  ("Emotion" + getDate()).hashCode();
    }
    public boolean matches(Emotion emotion){
        if(this.mood.equals(emotion.mood)) return true;
        return false;
    }

}
