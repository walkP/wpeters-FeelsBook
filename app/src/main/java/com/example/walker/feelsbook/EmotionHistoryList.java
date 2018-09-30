package com.example.walker.feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class EmotionHistoryList {

    protected ArrayList<Emotion> emotionHistoryList;

    public EmotionHistoryList(){
        emotionHistoryList = new ArrayList<Emotion>();
    }
    public Collection<Emotion> getEmotionHistory(){
        return emotionHistoryList;
    }
    public void addEmotion(Emotion newEmotion){
        emotionHistoryList.add(newEmotion);
    }
    public void deleteEmotion(Emotion emotion){
        emotionHistoryList.remove(emotion);
    }

}
