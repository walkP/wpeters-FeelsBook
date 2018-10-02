package com.example.walker.feelsbook;

public class EmotionHistoryListController {
    //Controller used for altering an EmotionHistoryList

    //Lazy Singleton
    private static EmotionHistoryList emotionList = null;
    static public EmotionHistoryList getEmotionList(){
        if (emotionList == null){
            emotionList = new EmotionHistoryList();
        }
        return emotionList;
    }
    public void addEmotion(Emotion emotion){
        getEmotionList().addEmotion(emotion);
    }
    public String getEmotion(int i){
       return getEmotionList().getEmotionMood(i);
    }
    public String getEmotionDate(int i){
        return getEmotionList().getEmotionDate(i);
    }
    public String getEmotionCoomment(int i){
        return getEmotionList().getEmotionComment(i);
    }

}
