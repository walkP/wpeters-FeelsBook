package com.example.walker.feelsbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EmotionHistoryList{
    //ArrayList that holds all emotions, also has some methods to alter the list
    //Also updates listeners

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
        Collections.sort(EmotionHistoryListController.getEmotionList().emotionHistoryList);
        notifyListener();
    }
    public void deleteEmotion(Emotion emotion){
        emotionHistoryList.remove(emotion);
        Collections.sort(EmotionHistoryListController.getEmotionList().emotionHistoryList);
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
        Collections.sort(emotionHistoryList);
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
