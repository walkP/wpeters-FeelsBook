package com.example.walker.feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
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
        EmotionHistoryListManager.initManager(this.getApplicationContext());


        EmotionHistoryListController st = new EmotionHistoryListController();

        TextView textView = findViewById(R.id.loveCountTextView);
        textView.setText(Integer.toString(st.getLoveCount()));

        TextView textView1 = findViewById(R.id.joyCountTextView);
        textView1.setText(Integer.toString(st.getJoyCount()));

        TextView textView2 = findViewById(R.id.surpriseCountTextView);
        textView2.setText(Integer.toString(st.getSurpriseCount()));

        TextView textView3 = findViewById(R.id.angerCountTextView);
        textView3.setText(Integer.toString(st.getAngerCount()));

        TextView textView4 = findViewById(R.id.sadnessCountTextView);
        textView4.setText(Integer.toString(st.getSadnessCount()));

        TextView textView5 = findViewById(R.id.fearCountTextView);
        textView5.setText(Integer.toString(st.getFearCount()));

    }

}
