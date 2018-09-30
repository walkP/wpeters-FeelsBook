package com.example.walker.feelsbook;

import java.util.Date;

public class Anger extends Emotion {

    @Override
    public void setDate(){
        this.date=date;
    }
    @Override
    public Date getDate(){
        return this.date;
    }

    public Anger(){

        this.date=date;
        count++;
    }
    public Anger(Date date2){

        this.date=date2;

    }
}
