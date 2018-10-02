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
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        EmotionHistoryListManager.initManager(this.getApplicationContext());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public void editHistory(MenuItem menu){
        Intent intent = new Intent(MainActivity.this,EmotionViewActivity.class);
        startActivity(intent);
    }
    public void viewCount(MenuItem menu){
        Intent intent = new Intent(MainActivity.this,EmotionCountActivity.class);
        startActivity(intent);
    }
    EmotionHistoryListController st = new EmotionHistoryListController();
    public void chooseLove(View v){
        Emotion emotion = new Emotion("Love");
        EditText editText = findViewById(R.id.optionalComment);
        emotion.comment = editText.getText().toString();
        st.addEmotion(emotion);
        editText.getText().clear();
        Toast.makeText(this, "Love has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseJoy(View v){
        Emotion emotion = new Emotion("Joy");
        EditText editText = findViewById(R.id.optionalComment);
        emotion.comment = editText.getText().toString();
        st.addEmotion(emotion);
        editText.getText().clear();
        Toast.makeText(this, "Joy has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseAnger(View v){
        Emotion emotion = new Emotion("Anger");
        EditText editText = findViewById(R.id.optionalComment);
        emotion.comment = editText.getText().toString();
        st.addEmotion(emotion);
        editText.getText().clear();
        Toast.makeText(this, "Anger has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseSadness(View v){
        Emotion emotion = new Emotion("Sadness");
        EditText editText = findViewById(R.id.optionalComment);
        emotion.comment = editText.getText().toString();
        st.addEmotion(emotion);
        editText.getText().clear();
        Toast.makeText(this, "Sadness has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseSurprise(View v){
        Emotion emotion = new Emotion("Surprise");
        EditText editText = findViewById(R.id.optionalComment);
        emotion.comment = editText.getText().toString();
        st.addEmotion(emotion);
        editText.getText().clear();
        Toast.makeText(this, "Surprise has been Recorded", Toast.LENGTH_SHORT).show();
    }
    public void chooseFear(View v){
        Emotion emotion = new Emotion("Fear");
        EditText editText = findViewById(R.id.optionalComment);
        emotion.comment = editText.getText().toString();
        st.addEmotion(emotion);
        editText.getText().clear();
        Toast.makeText(this, "Fear has been Recorded", Toast.LENGTH_SHORT).show();
    }

}