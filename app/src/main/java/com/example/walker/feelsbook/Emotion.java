package com.example.walker.feelsbook;

import java.io.Serializable;

public class Emotion implements Comparable<Emotion>, Serializable {
    //Class that acts as the paren class for all of the different emotions

    /**
     * Emotion serialization ID
     */
    private static final long serializationID = 1234567891;
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
    public boolean equals(Object otherEmotion){
        if(otherEmotion != null && otherEmotion.getClass()==this.getClass()){
           return this.equals((Emotion) otherEmotion);
        }else {
            return false;
        }
    }
    public boolean equals(Emotion otherEmotion){
        if(otherEmotion == null){
            return false;
        }
        return getDate().equals(otherEmotion.getDate());
    }
    public int hashCode(){
       return  ("Emotion" + getDate()).hashCode();
    }

}
