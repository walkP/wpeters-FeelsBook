package com.example.walker.feelsbook;

import java.io.IOException;

public class EmotionHistoryListController {
    //Controller used for altering an EmotionHistoryList
    //This class was designed to act as the controller for the EmotionHistoryList,
    //and it also makes sure the list stays how it is supposed to

    //Lazy Singleton
    private static EmotionHistoryList emotionList = null;
    //WARNING: throws a runTimeException
    static public EmotionHistoryList getEmotionList(){
        if (emotionList == null){
            try {
                emotionList = EmotionHistoryListManager.getManager().loadEmotionHistoryList();
                emotionList.addListener(new Listener() {
                    @Override
                    public void update() {
                        saveEmotionHistoryList();
                    }

                });
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize EmotionHistoryList from EmotionHistoryListManager");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize EmotionHistoryList from EmotionHistoryListManager");
            }
        }
        return emotionList;
    }

    static public void saveEmotionHistoryList(){
        try {
            EmotionHistoryListManager.getManager().saveEmotionHistoryList(getEmotionList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not deserialize EmotionHistoryList from EmotionHistoryListManager");
        }

    }
    public void addEmotion(Emotion emotion){
        getEmotionList().addEmotion(emotion);
    }
    public void deleteEmotion(Emotion emotion){
        getEmotionList().deleteEmotion(emotion);
    }
    static public int countLove(){ return EmotionHistoryListManager.getManager().countEmotion(new Love()); }
    static public int countJoy(){ return EmotionHistoryListManager.getManager().countEmotion(new Joy()); }
    static public int countSurprise(){
        return EmotionHistoryListManager.getManager().countEmotion(new Surprise());
    }
    static public int countAnger(){
        return EmotionHistoryListManager.getManager().countEmotion(new Anger());
    }
    static public int countSadness(){
        return EmotionHistoryListManager.getManager().countEmotion(new Sadness());
    }
    static public int countFear(){
        return EmotionHistoryListManager.getManager().countEmotion(new Fear());
    }

}
