package com.example.moody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import io.github.muddz.styleabletoast.StyleableToast;

public class WriteReviewActivity extends AppCompatActivity {
    Button addReviewBtn;
    ImageButton writeBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        addReviewBtn = (Button) findViewById(R.id.btn_add_review);

        addReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WriteReviewActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        writeBackBtn = findViewById(R.id.btn_write_back);
        writeBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = WriteReviewActivity.this;
                new StyleableToast.Builder(context).text("리뷰 등록 완료!").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(WriteReviewActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}