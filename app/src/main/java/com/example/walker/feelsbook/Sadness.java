package com.example.walker.feelsbook;

import java.util.Date;

public class Sadness extends Emotion {

    @Override
    public void setDate(){
        this.date=date;
    }
    @Override
    public Date getDate(){
        return this.date;
    }

    public Sadness(){

        this.date=date;
        count++;
        comment = "";
    }
    public Sadness(Date date2){

        this.date=date2;

    }
}
