package com.kareemradwan.foodapp.ui.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.kareemradwan.foodapp.MainActivity;
import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.adapter.SlidingImage_Adapter;
import com.kareemradwan.foodapp.model.AboutModel;
import com.kareemradwan.foodapp.ui.account.LoginActivity;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class OnBoardingActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<AboutModel> imageModelArrayList;

    // Views
//    Button btnGetStared , btnNext ;
    ImageButton btnGetStared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//
//        if (APPSharedPrefrencess.getValue(this, APPSharedPrefrencess.MY_PREFS_ABOUT_PAGE_KEY).equals("true")) {
//
//            startActivity(new Intent(OnboardingActivity.this, MainActivity.class));
//            finish();
//
//        }

        setContentView(R.layout.activity_on_boarding);


        btnGetStared = findViewById(R.id.btn);
        btnGetStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(OnBoardingActivity.this, LoginActivity.class), 435);

            }
        });
        imageModelArrayList = populateList();
//        btnGetStared = findViewById(R.id.btn_start);
//        btnNext = findViewById(R.id.btn_next);


//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                nextStep();
//            }
//        });

        init();

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


//        btnGetStared.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                APPSharedPrefrencess.setValue(getApplicationContext() , APPSharedPrefrencess.MY_PREFS_ABOUT_PAGE_KEY , "true");
//                startActivity(new Intent(StepsActivity.this  , LoginActivity.class));
//                finish();
//            }
//        });


    }

    private void getStated() {
//        APPSharedPrefrencess.setValue(this, APPSharedPrefrencess.MY_PREFS_ABOUT_PAGE_KEY, "true");
//
//        startActivity(new Intent(OnboardingActivity.this, MainActivity.class));
//        finish();
    }


    private void init() {


        mPager = findViewById(R.id.pager);
        CirclePageIndicator indicator =
                findViewById(R.id.indicator);

        mPager.setAdapter(new SlidingImage_Adapter(this, imageModelArrayList));

        indicator.setViewPager(mPager);


        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
        NUM_PAGES = imageModelArrayList.size();

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }


    private ArrayList<AboutModel> populateList() {

        ArrayList<AboutModel> list = new ArrayList<>();

        list.add(new AboutModel(R.drawable.ic_onborading_1, "طوري مهارتك ونمي قدراتك ", "نهتم بتطوير مهاراتك من خلال الكورسات المفيدة والتي ستدخلك إلى عالم الإبداع"));
        list.add(new AboutModel(R.drawable.ic_onborading_2, "سوقي منتجك ", "اصنعي منتجك بيدك واعرضيه لتحصلي على الكثير من الطلبات "));
        list.add(new AboutModel(R.drawable.ic_onborading_3, "كوني انت ", "شاركي تجربتك واعرضي قصة نجاحك واحصلي على كثير من الدعم "));
        return list;
    }
}
