package com.example.walker.feelsbook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EmotionHistoryList implements Serializable{
    //ArrayList that holds all emotions, also has some methods to alter the list
    //Also updates listeners

    protected ArrayList<Emotion> emotionHistoryList = null;;
    protected transient ArrayList<Listener> listeners = null;

    public EmotionHistoryList(){
        emotionHistoryList = new ArrayList<Emotion>();
        listeners = new ArrayList<Listener>();
    }
    public Collection<Emotion> getEmotionHistory(){
        return emotionHistoryList;
    }
    private ArrayList<Listener> getListeners(){
        if(listeners == null){
            listeners = new ArrayList<Listener>();
        }
        return listeners;
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
    public int size(){
        return emotionHistoryList.size();
    }
    public void notifyListener(){
        for(Listener listener : getListeners() ){
            listener.update();
        }
    }
    public void addListener(Listener l){
        getListeners().add(l);
    }
    public void removeListener(Listener l){
        getListeners().remove(l);
    }

}
