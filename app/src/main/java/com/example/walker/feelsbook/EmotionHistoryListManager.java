package com.example.walker.feelsbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmotionHistoryListManager {
    //Manager responsible for the serialization and deserialization of the Emotion List
    //This class was designed to save preferences and stores them for persistence when app
    //restarted, also contains the method for counting Emotions

    static final String prefFile = "EmotionHistoryList";
    static final String elKey = "emotionHistoryList";

    Context context;

    static private EmotionHistoryListManager emotionHistoryListManager = null;

    public EmotionHistoryListManager(Context context){
        this.context = context;
    }
    public EmotionHistoryList loadEmotionHistoryList() throws IOException, ClassNotFoundException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String emotionHistoryListData = settings.getString(elKey, "");
        if(emotionHistoryListData.equals("")){
            return new EmotionHistoryList();
        }else{
            return emotionHistoryListFromString(emotionHistoryListData);
        }
    }

    public static void initManager(Context context){
        if(emotionHistoryListManager == null){
            if(context == null){
                throw new RuntimeException("Missing context for EmotionHistoryListManager");
            }
            emotionHistoryListManager = new EmotionHistoryListManager(context);
        }
    }

    public static EmotionHistoryListManager getManager(){
        if(emotionHistoryListManager == null){
            throw new RuntimeException("Did not initialize Manager");
        }
        return emotionHistoryListManager;
    }

    static private EmotionHistoryList emotionHistoryListFromString(String emotionHistoryListData) throws ClassNotFoundException, IOException{
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(emotionHistoryListData,Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (EmotionHistoryList)oi.readObject();

    }
    static private String emotionHistoryListToString(EmotionHistoryList el) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(el);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public void saveEmotionHistoryList(EmotionHistoryList el) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(elKey,emotionHistoryListToString(el));
        editor.commit();

    }
    public int countEmotion(Emotion emotionToMatch){
        int count =0;
        for(Emotion emotion : EmotionHistoryListController.getEmotionList().emotionHistoryList){
            if(emotion.matches(emotionToMatch)){
                count++;
            }
        }
        return count;
    }

}
