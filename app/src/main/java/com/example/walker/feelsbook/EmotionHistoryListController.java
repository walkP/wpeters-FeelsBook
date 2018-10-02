package com.example.walker.feelsbook;

import java.io.IOException;

public class EmotionHistoryListController {
    //Controller used for altering an EmotionHistoryList

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
        public String getEmotion(int i){
       return getEmotionList().getEmotionMood(i);
    }
    public String getEmotionDate(int i){
        return getEmotionList().getEmotionDate(i);
    }
    public String getEmotionComment(int i){
        return getEmotionList().getEmotionComment(i);
    }

}
