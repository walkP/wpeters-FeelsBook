package com.example.walker.feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class EmotionHistoryList {

    protected ArrayList<Emotion> emotionHistoryList;
    protected ArrayList<Listener> listeners;

    public EmotionHistoryList(){
        emotionHistoryList = new ArrayList<Emotion>();
        listeners = new ArrayList<Listener>();
    }
    public Collection<Emotion> getEmotionHistory(){
        return emotionHistoryList;
    }
    public void addEmotion(Emotion newEmotion){
        emotionHistoryList.add(newEmotion);
        notifyListener();
    }
    public void deleteEmotion(Emotion emotion){
        emotionHistoryList.remove(emotion);
        notifyListener();
    }
    public String getEmotionMood(int i){
        return emotionHistoryList.get(i).mood;
    }
    public String getEmotionDate(int i){
        return emotionHistoryList.get(i).date;
    }
    public String getEmotionComment(int i){
        return emotionHistoryList.get(i).comment;
    }
    public void setNewDate(String s, int i){
        emotionHistoryList.get(i).setDate(s);
        notifyListener();
    }
    public void setNewComment(String s, int i){
        emotionHistoryList.get(i).setComment(s);
        notifyListener();
    }
    public void notifyListener(){
        for(Listener listener : listeners ){
            listener.update();
        }
    }
    public void addListener(Listener l){
        listeners.add(l);
    }
    public void removeListener(Listener l){
        listeners.remove(l);
    }
}
