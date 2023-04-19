package com.example.moody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SignFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_finish);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}