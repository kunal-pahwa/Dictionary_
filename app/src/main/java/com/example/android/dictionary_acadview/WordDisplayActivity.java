package com.example.android.dictionary_acadview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.example.android.dictionary_acadview.DatabaseHelper;
import com.example.android.dictionary_acadview.R;

public class WordDisplayActivity extends AppCompatActivity {

    Intent intent;
    DatabaseHelper db;
    ImageButton left,right;
    TextView textDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_display);
        db = new DatabaseHelper(getApplicationContext());

        intent = getIntent();

        textDisplay =(TextView) findViewById(R.id.textView);


        String word = intent.getStringExtra("word");
        String result = db.search(word);
        // textDisplay.setText(result);
        if(result != "")
            textDisplay.setText(result);



        }


}

