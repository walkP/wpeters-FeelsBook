package com.example.walker.feelsbook;

import java.util.Date;

public class Fear extends Emotion{

    @Override
    public void setDate(){
        this.date=date;
    }
    @Override
    public Date getDate(){
        return this.date;
    }

    public Fear(){

        this.date=date;
        count++;
        comment = "";
    }
    public Fear(Date date2){

        this.date=date2;

    }
}
