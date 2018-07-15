package com.example.android.dictionary_acadview;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.dictionary_acadview.HomeActivity;
import com.example.android.dictionary_acadview.R;

public class MainActivity extends AppCompatActivity {
    private static int time_splash=4000;
    String str="Dictionary";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent i= new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        },time_splash);

    }
}
