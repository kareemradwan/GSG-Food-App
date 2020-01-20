package com.kareemradwan.foodapp.ui.eat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.adapter.SlidingImage_Adapter;
import com.kareemradwan.foodapp.model.AboutModel;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class EatActivity extends AppCompatActivity {

    // pager
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<AboutModel> imageModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);


        initPagerAndIndicator();

        initCards();
    }

    private void initCards() {

        CardView card1 = findViewById(R.id.card_1);
        RelativeLayout card2 = findViewById(R.id.card_2);
        RelativeLayout card3 = findViewById(R.id.card_3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EatActivity.this , EatsProductActivity.class));
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EatActivity.this , EatsProductActivity.class));

            }
        });


        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EatActivity.this , EatsProductActivity.class));

            }
        });
    }

    private ArrayList<AboutModel> populateList() {
        ArrayList<AboutModel> list = new ArrayList<>();

        list.add(new AboutModel(R.drawable.ic_eat_product_1, "معمول بالفستق الحلبي ", "نهتم بتطوير مهاراتك من خلال الكورسات المفيدة والتي ستدخلك إلى عالم الإبداع"));
        list.add(new AboutModel(R.drawable.ic_eat_product_3, "مقلوبة ", "شاركي تجربتك واعرضي قصة نجاحك واحصلي على كثير من الدعم "));

        list.add(new AboutModel(R.drawable.ic_eat_product_3, "وجبة المسخن الفلسطيني ", "اصنعي منتجك بيدك واعرضيه لتحصلي على الكثير من الطلبات "));
        return list;
    }

    private void initPagerAndIndicator() {

        imageModelArrayList = populateList();


        mPager = findViewById(R.id.pager);
        CirclePageIndicator indicator =
                findViewById(R.id.indicator);

        SlidingImage_Adapter adapter = new SlidingImage_Adapter(this, imageModelArrayList);
        adapter.isAds(true);
        mPager.setAdapter(adapter);

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
    }

}
