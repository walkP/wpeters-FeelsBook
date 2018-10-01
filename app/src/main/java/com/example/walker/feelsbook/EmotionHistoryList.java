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
