package com.example.walker.feelsbook;

public class EmotionHistoryListController {

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
    public EmotionHistoryList getList(){
        return emotionList;
    }
}
