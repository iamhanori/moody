package com.example.moody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.lang.annotation.Documented;

import io.github.muddz.styleabletoast.StyleableToast;

public class WriteReviewActivity extends AppCompatActivity {

    EditText et_title, et_content;

    Button addReviewBtn;
    ImageButton writeBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        addReviewBtn = (Button) findViewById(R.id.btn_add_review);

        addReviewBtn.setOnClickListener( (v) -> saveNote());

//        addReviewBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(WriteReviewActivity.this, Review.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        writeBackBtn = findViewById(R.id.btn_write_back);
        writeBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = WriteReviewActivity.this;
                new StyleableToast.Builder(context).text("리뷰 등록 완료!").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(WriteReviewActivity.this, Review.class);
                startActivity(intent);
                finish();
            }
        });

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        et_title = findViewById(R.id.et_rvTitle);
        et_content = findViewById(R.id.et_rvContent);

    }

    void saveNote() {
        String noteTitle = et_title.getText().toString();
        String noteContent = et_content.getText().toString();

        if(noteTitle == null || noteTitle.isEmpty()) {
            et_title.setError("Title is required");
            return;
        }

        ReviewData rd = new ReviewData();
        rd.setTitle(noteTitle);
        rd.setContent(noteContent);
        rd.setTimestamp(Timestamp.now());

        saveNoteToFirebase(rd);
    }

    void saveNoteToFirebase(ReviewData rd) {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document();

        documentReference.set(rd).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Utility.showToast(WriteReviewActivity.this, "success");
                    finish();
                } else {
                    Utility.showToast(WriteReviewActivity.this, "failed");
                }
            }
        });

    }

}