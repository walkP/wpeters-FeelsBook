package com.example.walker.feelsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EmotionEditActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_entry);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String oldComment = extras.getString("oldComment");
        String oldDate = extras.getString("oldDate");

        EditText editDateText = findViewById(R.id.editDateEditText);
        EditText editCommentText = findViewById(R.id.editCommentEditText);

        editDateText.setText(oldDate);
        editCommentText.setText(oldComment);
    }
    public void saveEdit(View v){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int index = extras.getInt("index");
        EditText editDateText = findViewById(R.id.editDateEditText);
        EditText editCommentText = findViewById(R.id.editCommentEditText);
        String newDate = editDateText.getText().toString();
        String newComment = editCommentText.getText().toString();

        EmotionHistoryListController.getEmotionList().setNewDate(newDate,index);
        EmotionHistoryListController.getEmotionList().setNewComment(newComment,index);

        Collections.sort(EmotionHistoryListController.getEmotionList().emotionHistoryList);

        Toast.makeText(EmotionEditActivity.this,
        "Entry has been edited", Toast.LENGTH_SHORT).show();
        finish();
    }

}

