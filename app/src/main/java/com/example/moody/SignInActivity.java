package com.example.moody;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.github.muddz.styleabletoast.StyleableToast;

// login
public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;   // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터 베이스

    private EditText et_Email, et_Pwd; // 이메일, 비밀번호
    private Button inbtn_Next; // 다음 버튼

    private TextView tv_signup; // 회원가입하기
    private TextView tv_findID; // 아이디 찾기
    private TextView tv_changePW;   // 비밀번호 변경

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        et_Email = findViewById(R.id.inet_Email);
        et_Pwd = findViewById(R.id.inet_password);
        inbtn_Next = findViewById(R.id.inbtn_next);
        tv_signup = (TextView) findViewById(R.id.intv_signup);
        tv_findID = (TextView) findViewById(R.id.intv_findId);
        tv_changePW = (TextView) findViewById(R.id.intv_changePw);

        inbtn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = et_Email.getText().toString();
                String strPwd = et_Pwd.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            // 로그인 성공 (MainActivity로 이동)
                            Toast.makeText(SignInActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignInActivity.this, SignFinishActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SignInActivity.this, "아이디 및 비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // 회원가입하기 텍스트
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_findID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = SignInActivity.this;
                new StyleableToast.Builder(context).text("오픈 전인 서비스입니다!").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();
            }
        });

        tv_changePW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = SignInActivity.this;
                new StyleableToast.Builder(context).text("오픈 전인 서비스입니다!").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();
            }
        });

    }
}