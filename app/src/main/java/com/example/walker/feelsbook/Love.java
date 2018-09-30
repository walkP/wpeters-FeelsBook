package com.example.walker.feelsbook;

import java.util.Date;

public class Love extends Emotion {

    @Override
    public void setDate(){
        this.date=date;
    }
    @Override
    public Date getDate(){
        return this.date;
    }

    public Love(){

        this.date=date;
        count++;
    }
    public Love(Date date2){

        this.date=date2;

    }
}
