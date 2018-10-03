package com.example.walker.feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;



public class EmotionCountActivity extends AppCompatActivity{
    //View that shows the counts of each Emotion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emotion_count);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        EmotionHistoryListManager.initManager(this.getApplicationContext());


        TextView textView = findViewById(R.id.loveCountTextView);
        textView.setText(Integer.toString(EmotionHistoryListController.countLove()));

        TextView textView1 = findViewById(R.id.joyCountTextView);
        textView1.setText(Integer.toString(EmotionHistoryListController.countJoy()));

        TextView textView2 = findViewById(R.id.surpriseCountTextView);
        textView2.setText(Integer.toString(EmotionHistoryListController.countSurprise()));

        TextView textView3 = findViewById(R.id.angerCountTextView);
        textView3.setText(Integer.toString(EmotionHistoryListController.countAnger()));

        TextView textView4 = findViewById(R.id.sadnessCountTextView);
        textView4.setText(Integer.toString(EmotionHistoryListController.countSadness()));

        TextView textView5 = findViewById(R.id.fearCountTextView);
        textView5.setText(Integer.toString(EmotionHistoryListController.countFear()));

    }

}
