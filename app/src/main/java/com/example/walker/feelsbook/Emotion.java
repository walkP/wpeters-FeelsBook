package com.example.walker.feelsbook;

public class Emotion implements Comparable<Emotion> {
    //Class that acts as the paren class for all of the different emotions

    protected String date;
    protected String comment;
    protected String mood;

    public Emotion(){
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

}
