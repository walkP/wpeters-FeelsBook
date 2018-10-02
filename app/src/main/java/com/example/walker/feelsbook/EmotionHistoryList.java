package com.example.walker.feelsbook;

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
    protected ArrayList<Emotion> emotionHistoryList = null;;
    protected transient ArrayList<Listener> listeners = null;
    protected int loveCount;
    protected int joyCount;
    protected int surpriseCount;
    protected int angerCount;
    protected int sadnessCount;
    protected int fearCount;

    public EmotionHistoryList(){
        emotionHistoryList = new ArrayList<Emotion>();
        listeners = new ArrayList<Listener>();
        loveCount=0;
        joyCount=0;
        surpriseCount=0;
        angerCount=0;
        sadnessCount=0;
        fearCount=0;
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
        if(emotion.mood.equals("Love")) loveCount--;
        if(emotion.mood.equals("Joy")) joyCount--;
        if(emotion.mood.equals("Surprise")) surpriseCount--;
        if(emotion.mood.equals("Anger")) angerCount--;
        if(emotion.mood.equals("Sadness")) sadnessCount--;
        if(emotion.mood.equals("Fear")) fearCount--;
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
