package com.example.walker.feelsbook;

import java.util.Date;

public class Emotion {

    protected String date;
    protected String comment;
    protected String mood;

    public Emotion(){

        this.date=date;

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

}
