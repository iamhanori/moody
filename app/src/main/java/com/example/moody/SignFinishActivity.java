package com.example.moody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SignFinishActivity extends AppCompatActivity {

    private Button btn_Next;
    private TextView idText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_finish);

        btn_Next = findViewById(R.id.fibt_finished);
        idText = findViewById(R.id.inet_id);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 완료 버튼
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 텍스트 바꾸기
//                idText.setText();
                Intent intent = new Intent(SignFinishActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}