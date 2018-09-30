package com.example.walker.feelsbook;

import java.util.Date;

public class Surprise extends Emotion {

    @Override
    public void setDate(){
        this.date=date;
    }
    @Override
    public Date getDate(){
        return this.date;
    }

    public Surprise(){

        this.date=date;
        count++;
        comment = "";
    }
    public Surprise(Date date2){

        this.date=date2;

    }
}
