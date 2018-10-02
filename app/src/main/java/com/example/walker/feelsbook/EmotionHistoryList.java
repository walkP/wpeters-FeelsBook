package com.example.walker.feelsbook;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EmotionHistoryList implements Serializable{
    //ArrayList that holds all emotions, also has some methods to alter the list
    //Also updates listeners

    /**
     * EmotionHistoryList serialization ID
     */
    private static final long serializationID = 321654987;
    protected ArrayList<Emotion> emotionHistoryList = null;
    protected transient ArrayList<Listener> listeners = null;
    protected int loveCount=0;
    protected int joyCount=0;
    protected int surpriseCount=0;
    protected int angerCount=0;
    protected int sadnessCount=0;
    protected int fearCount=0;

    public EmotionHistoryList(){
        emotionHistoryList = new ArrayList<Emotion>();
        listeners = new ArrayList<Listener>();
    }
    private ArrayList<Listener> getListeners(){
        if(listeners == null){
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }
    public Collection<Emotion> getEmotionHistory(){
        return emotionHistoryList;
    }
    public void addEmotion(Emotion newEmotion){
        if(newEmotion.mood =="Love") loveCount++;
        if(newEmotion.mood =="Joy") joyCount++;
        if(newEmotion.mood =="Surprise") surpriseCount++;
        if(newEmotion.mood =="Anger") angerCount++;
        if(newEmotion.mood =="Sadness") sadnessCount++;
        if(newEmotion.mood =="Fear") fearCount++;
        emotionHistoryList.add(newEmotion);
        Collections.sort(EmotionHistoryListController.getEmotionList().emotionHistoryList);
        notifyListener();
    }
    public void deleteEmotion(Emotion emotion){
        if(emotion.mood =="Love") loveCount--;
        if(emotion.mood =="Joy") joyCount--;
        if(emotion.mood =="Surprise") surpriseCount--;
        if(emotion.mood =="Anger") angerCount--;
        if(emotion.mood =="Sadness") sadnessCount--;
        if(emotion.mood =="Fear") fearCount--;
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
    public int getLoveCount(){
        return loveCount;
    }
    public int getJoyCount(){
        return joyCount;
    }
    public int getSurpriseCount(){
        return surpriseCount;
    }
    public int getAngerCount(){
        return angerCount;
    }
    public int getSadnessCount(){
        return sadnessCount;
    }
    public int getFearCount(){
        return fearCount;
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
    public boolean contains(Emotion testEmotion){
        return emotionHistoryList.contains(testEmotion);
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
