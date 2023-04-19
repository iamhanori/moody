package com.example.moody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;   // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터 베이스

    private EditText et_Email, et_Pwd; // 이메일, 비밀번호
    private Button bt_Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        et_Email = findViewById(R.id.upet_email);
        et_Pwd = findViewById(R.id.upet_password);
        bt_Next =findViewById(R.id.upbt_next);

        // 다음 버튼
        bt_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 회원가입 처리 시작
                String strEmail = et_Email.getText().toString();
                String strPwd = et_Pwd.getText().toString();

                // Firebase Auto 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToKen(firebaseUser.getUid());
                            account.setEmail(firebaseUser.getEmail());
                            account.setPassword(strPwd);

                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                            Toast.makeText(SignUpActivity.this, "회원 가입 성공", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(SignUpActivity.this, "회원 가입 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}