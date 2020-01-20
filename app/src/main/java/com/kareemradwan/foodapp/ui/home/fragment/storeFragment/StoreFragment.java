package com.kareemradwan.foodapp.ui.home.fragment.storeFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.adapter.ProductAdapter;
import com.kareemradwan.foodapp.adapter.SlidingImage_Adapter;
import com.kareemradwan.foodapp.model.AboutModel;
import com.kareemradwan.foodapp.model.Product;
import com.kareemradwan.foodapp.ui.eat.EatActivity;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class StoreFragment extends Fragment {
    private View view;

    // pager
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<AboutModel> imageModelArrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments_products, null, false);


        initPagerAndIndicator();

        initRecyclerView1();
        initRecyclerView2();

        initCardVires();
        return view;
    }


    private void initRecyclerView1() {

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView5);
        List<Product> products = new ArrayList<>();
        products.add(new Product("كلكول  صوف", "50", 50, R.drawable.ic_product_grid_1));
        products.add(new Product("محفظة تطريز", "", 90, R.drawable.ic_product_grid_2));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ProductAdapter adapter = new ProductAdapter(products);
        adapter.setIsGrid(true);
        recyclerView.setAdapter(adapter);

    }


    private void initCardVires() {
        CardView view1 = view.findViewById(R.id.eat1);
        CardView view2 = view.findViewById(R.id.eat2);
        CardView view3 = view.findViewById(R.id.eat3);


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getContext(), EatActivity.class), 32);
            }
        });

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getContext(), EatActivity.class), 32);

            }
        });


        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getContext(), EatActivity.class), 32);

            }
        });
    }

    private void initRecyclerView2() {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView6);
        List<Product> products = new ArrayList<>();
        products.add(new Product("نقش حناء", "تجميل", 120, R.drawable.ic_product_h_1));
        products.add(new Product("تصميم كروت ", "فنون", 90, R.drawable.ic_product_h_2));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);
    }

    private void initPagerAndIndicator() {
        imageModelArrayList = populateList();


        mPager = view.findViewById(R.id.pager);
        CirclePageIndicator indicator =
                view.findViewById(R.id.indicator);

        SlidingImage_Adapter adapter = new SlidingImage_Adapter(getContext(), imageModelArrayList);
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

    private ArrayList<AboutModel> populateList() {
        ArrayList<AboutModel> list = new ArrayList<>();

        list.add(new AboutModel(R.drawable.ic_product_pager_1, "طوري مهارتك ونمي قدراتك ", "نهتم بتطوير مهاراتك من خلال الكورسات المفيدة والتي ستدخلك إلى عالم الإبداع"));
        list.add(new AboutModel(R.drawable.ic_product_pager_1, "سوقي منتجك ", "اصنعي منتجك بيدك واعرضيه لتحصلي على الكثير من الطلبات "));
        list.add(new AboutModel(R.drawable.ic_product_pager_1, "كوني انت ", "شاركي تجربتك واعرضي قصة نجاحك واحصلي على كثير من الدعم "));
        return list;
    }
}
