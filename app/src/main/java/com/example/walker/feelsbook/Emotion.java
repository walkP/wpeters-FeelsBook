package com.example.walker.feelsbook;

import java.util.Date;

public abstract class Emotion {

    protected Date date;
    protected int count=0;

    public Emotion(){

        this.date=date;

    }
    public abstract Date getDate();
    public abstract void setDate();
}
