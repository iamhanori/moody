package com.example.moody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ProfileUpdateActivity extends AppCompatActivity {

    ImageButton backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        backImg = findViewById(R.id.btn_back_profile_update);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileUpdateActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}