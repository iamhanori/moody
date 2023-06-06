package com.example.moody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MetaverseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metaverse);

        ImageButton backwardBtn = findViewById(R.id.meta_backward);

        backwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(MetaverseActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }
}