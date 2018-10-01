package com.example.walker.feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
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

        EmotionHistoryListController st = new EmotionHistoryListController();
        Collection<Emotion> emotions = EmotionHistoryListController.getEmotionList().getEmotionHistory();
        final ArrayList<Emotion> list = new ArrayList<Emotion>(emotions);

        TextView textView = findViewById(R.id.loveCountTextView);
        textView.setText("1");

        TextView textView1 = findViewById(R.id.joyCountTextView);
        textView1.setText("2");

        TextView textView2 = findViewById(R.id.surpriseCountTextView);
        textView2.setText("3");

        TextView textView3 = findViewById(R.id.angerCountTextView);
        textView3.setText("4");

        TextView textView4 = findViewById(R.id.sadnessCountTextView);
        textView4.setText("5");

        TextView textView5 = findViewById(R.id.fearCountTextView);
        textView5.setText("6");

    }



}
