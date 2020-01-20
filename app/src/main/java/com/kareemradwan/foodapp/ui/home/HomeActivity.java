package com.kareemradwan.foodapp.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.ui.home.fragment.coursesFragment.CourseFragment;
import com.kareemradwan.foodapp.ui.home.fragment.homeFragment.HomeFragment;
import com.kareemradwan.foodapp.ui.home.fragment.settingsFragment.SettingsFragment;
import com.kareemradwan.foodapp.ui.home.fragment.storeFragment.StoreFragment;

public class HomeActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    // Fragment
    static HomeFragment homeFragment;
    static CourseFragment courseFragment;
    static StoreFragment storeFragment;
    static SettingsFragment settingsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.container);

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, getHomeFragment()).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        chnageFragment(getHomeFragment());
                        break;
                    case R.id.nav_course:
                        chnageFragment(getCourseFragment());
                        break;
                    case R.id.nav_store:
                        chnageFragment(getStoreFragment());
                        break;
                    case R.id.nav_profile:
                        chnageFragment(getSettingsFragment());
                        break;

                }
                return true;
            }
        });
    }

    private void chnageFragment(Fragment fragment) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }

    public HomeFragment getHomeFragment() {
        if (homeFragment == null)
            homeFragment = new HomeFragment();

        return homeFragment;
    }

    public StoreFragment getStoreFragment() {
        if (storeFragment == null)
            storeFragment = new StoreFragment();

        return storeFragment;
    }

    public SettingsFragment getSettingsFragment() {
        if (settingsFragment == null)
            settingsFragment = new SettingsFragment();

        return settingsFragment;
    }

    public CourseFragment getCourseFragment() {
        if (courseFragment == null)
            courseFragment = new CourseFragment();

        return courseFragment;
    }
}
