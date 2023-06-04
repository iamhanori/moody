package com.example.moody;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.moody.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FloatingActionButton moody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Home());

        // 네비바
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new Home());
                    break;
                case R.id.navigation_product:
                    replaceFragment(new Product());
                    break;
                case R.id.navigation_store:
                    replaceFragment(new Store());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new Profile());
                    break;
            }

            return true;
        });


//        // 플로팅 버튼
//        moody = (FloatingActionButton) findViewById(R.id.floatingbtn_moody);
//        moody.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, M.class);
//                startActivityForResult(intent);
//            }
//        });

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    // 화면 전환
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }



}