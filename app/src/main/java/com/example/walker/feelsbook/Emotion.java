package com.example.walker.feelsbook;

import java.util.Date;

public class Emotion {

    protected String date;
    protected int count=0;
    protected String comment;
    protected String mood;

    public Emotion(){

        this.date=date;

    }
    public  String getDate(){
        return this.date;
    }
    public  void setDate(){
        this.date=date;
    }
    public String toString(){
        return date + " | " + mood + " | " + comment;
    }

}
