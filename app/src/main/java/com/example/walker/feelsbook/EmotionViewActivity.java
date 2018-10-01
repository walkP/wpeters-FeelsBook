package com.example.walker.feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class EmotionViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emotion_history);

        ListView listView = (ListView)findViewById(R.id.emotionHistoryListView);
        Collection<Emotion> emotions = EmotionHistoryListController.getEmotionList().getEmotionHistory();
        final ArrayList<Emotion> list = new ArrayList<Emotion>(emotions);
        final ArrayAdapter<Emotion> emotionAdapter = new ArrayAdapter<Emotion>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(emotionAdapter);

        //Added a change observer
        EmotionHistoryListController.getEmotionList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Emotion> emotions = EmotionHistoryListController.getEmotionList().getEmotionHistory();
                list.addAll(emotions);
                emotionAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterview, View view, int position, long id) {
                //Toast.makeText(EmotionViewActivity.this, "Delete " + list.get(position).toString(), Toast.LENGTH_SHORT).show();
                Emotion emotion = list.get(position);
                EmotionHistoryListController.getEmotionList().deleteEmotion(emotion);


                return false;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }



}
