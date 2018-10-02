package com.example.walker.feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class EmotionCountActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emotion_count);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Collection<Emotion> emotions = EmotionHistoryListController.getEmotionList().getEmotionHistory();
        final ArrayList<Emotion> list = new ArrayList<Emotion>(emotions);

        int loveCount=0;
        int joyCount=0;
        int surpriseCount=0;
        int angerCount=0;
        int sadnessCount=0;
        int fearCount=0;

        TextView textView = findViewById(R.id.loveCountTextView);
        for(int i=0 ; i<list.size() ; i++){
            if(EmotionHistoryListController.getEmotionList().getEmotionMood(i) == "Love"){
                loveCount++;
            }
        }
        textView.setText(Integer.toString(loveCount));

        TextView textView1 = findViewById(R.id.joyCountTextView);
        for(int i=0 ; i<list.size() ; i++){
            if(EmotionHistoryListController.getEmotionList().getEmotionMood(i) == "Joy"){
                joyCount++;
            }
        }
        textView1.setText(Integer.toString(joyCount));

        TextView textView2 = findViewById(R.id.surpriseCountTextView);
        for(int i=0 ; i<list.size() ; i++){
            if(EmotionHistoryListController.getEmotionList().getEmotionMood(i) == "Surprise"){
                surpriseCount++;
            }
        }
        textView2.setText(Integer.toString(surpriseCount));

        TextView textView3 = findViewById(R.id.angerCountTextView);
        for(int i=0 ; i<list.size() ; i++){
            if(EmotionHistoryListController.getEmotionList().getEmotionMood(i) == "Anger"){
                angerCount++;
            }
        }
        textView3.setText(Integer.toString(angerCount));

        TextView textView4 = findViewById(R.id.sadnessCountTextView);
        for(int i=0 ; i<list.size() ; i++){
            if(EmotionHistoryListController.getEmotionList().getEmotionMood(i) == "Sadness"){
                sadnessCount++;
            }
        }
        textView4.setText(Integer.toString(sadnessCount));

        TextView textView5 = findViewById(R.id.fearCountTextView);
        for(int i=0 ; i<list.size() ; i++){
            if(EmotionHistoryListController.getEmotionList().getEmotionMood(i) == "Fear"){
                fearCount++;
            }
        }
        textView5.setText(Integer.toString(fearCount));

    }



}
