package com.shouzhong.crash.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View v) {
        byte[] bs = null;
        bs[0] = 0;
    }

    public void onClick2(View v) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
