/*
Copyright 2018 Walker Peters, wpeters@ualberta.ca

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.example.walker.feelsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public void editHistory(MenuItem menu){
        Toast.makeText(this, "View/Edit History", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,EmotionViewActivity.class);
        startActivity(intent);
    }
    public void viewCount(MenuItem menu){
        Toast.makeText(this, "Emotion Counts", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,EmotionCountActivity.class);
        startActivity(intent);
    }
    public void chooseLove(View v){
        EmotionHistoryListController st = new EmotionHistoryListController();
        Love love = new Love();
        EditText textView = findViewById(R.id.optionalComment);
        love.comment = textView.toString();
        st.addEmotion(love);
        Toast.makeText(this, "Love has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseJoy(View v){
        EmotionHistoryListController st = new EmotionHistoryListController();
        Joy joy = new Joy();
        EditText textView = findViewById(R.id.optionalComment);
        joy.comment = textView.toString();
        st.addEmotion(joy);
        Toast.makeText(this, "Joy has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseAnger(View v){
        EmotionHistoryListController st = new EmotionHistoryListController();
        Anger anger = new Anger();
        EditText textView = findViewById(R.id.optionalComment);
        anger.comment = textView.toString();
        st.addEmotion(anger);
        Toast.makeText(this, "Anger has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseSadness(View v){
        EmotionHistoryListController st = new EmotionHistoryListController();
        Sadness sad = new Sadness();
        EditText textView = findViewById(R.id.optionalComment);
        sad.comment = textView.toString();
        st.addEmotion(sad);
        Toast.makeText(this, "Sadness has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseSurprise(View v){
        EmotionHistoryListController st = new EmotionHistoryListController();
        Surprise sur = new Surprise();
        EditText textView = findViewById(R.id.optionalComment);
        sur.comment = textView.toString();
        st.addEmotion(sur);
        Toast.makeText(this, "Surprise has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseFear(View v){
        EmotionHistoryListController st = new EmotionHistoryListController();
        Fear fear = new Fear();
        EditText textView = findViewById(R.id.optionalComment);
        fear.comment = textView.toString();
        st.addEmotion(fear);
        Toast.makeText(this, "Fear has been Recorded", Toast.LENGTH_SHORT).show();
    }

}