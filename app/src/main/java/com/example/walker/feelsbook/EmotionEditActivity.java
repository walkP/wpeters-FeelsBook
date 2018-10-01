package com.example.walker.feelsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collection;

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
    public void saveEdit(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int index = extras.getInt("index");
        EditText editDateText = findViewById(R.id.editDateEditText);
        EditText editCommentText = findViewById(R.id.editCommentEditText);
        String newDate = editDateText.toString();
        String newComment = editCommentText.toString();

        EmotionHistoryListController.getEmotionList().setNewDate(newDate,index);
        EmotionHistoryListController.getEmotionList().setNewComment(newComment,index);

        Intent intent2 = new Intent(EmotionEditActivity.this,EmotionViewActivity.class);
        startActivity(intent2);
    }
    public void cancelEdit(){
        Intent intent = new Intent(EmotionEditActivity.this,EmotionViewActivity.class);
        startActivity(intent);
    }
}

