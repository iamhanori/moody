package com.example.moody;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.moody.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FloatingActionButton moody;

    private ViewPager2 sliderViewPager;
    private LinearLayout layoutIndicator;

    private String[] images = new String[] {
            "https://www.figma.com/file/UmCsMspS1dVnSZ0Vcm12bl/%23moody?type=design&node-id=1500-202&t=fgX5azEvpiYwIJvb-4",
            "https://www.figma.com/file/UmCsMspS1dVnSZ0Vcm12bl/%23moody?type=design&node-id=1479-203&t=fgX5azEvpiYwIJvb-4"
    };

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

        sliderViewPager = findViewById(R.id.sliderViewPager);
        layoutIndicator = findViewById(R.id.layoutIndicators);

        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(this, images));

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
        setupIndicators(images.length);
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16,8,16,8);

        for(int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
    }

    // 화면 전환
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }



}