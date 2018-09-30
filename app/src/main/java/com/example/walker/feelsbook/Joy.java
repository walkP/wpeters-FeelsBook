package com.example.walker.feelsbook;

import java.util.Date;

public class Joy extends Emotion {

    @Override
    public void setDate(){
        this.date=date;
    }
    @Override
    public Date getDate(){
        return this.date;
    }

    public Joy(){

        this.date=date;
        count++;
        comment = "";
    }
    public Joy(Date date2){

        this.date=date2;

    }
}
