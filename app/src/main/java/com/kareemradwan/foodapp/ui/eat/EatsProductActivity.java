package com.kareemradwan.foodapp.ui.eat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.adapter.CourseAdapter;
import com.kareemradwan.foodapp.adapter.ProductAdapter;
import com.kareemradwan.foodapp.model.Course;
import com.kareemradwan.foodapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class EatsProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eats_product);


        initRec1();

        initRec2();
    }

    private void initRec2() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        List<Product> products = new ArrayList<>();
        products.add(new Product("مقلوبة", "50", 50, R.drawable.ic_eat_grid_1));
        products.add(new Product("بيتزا", "", 70, R.drawable.ic_eat_grid_2));
        products.add(new Product("معكرونة", "", 20, R.drawable.ic_eat_grid_3));
        products.add(new Product("منسف", "", 35, R.drawable.ic_eat_grid_4));
        products.add(new Product("معكرونة", "", 99, R.drawable.ic_eat_grid_5));
        products.add(new Product("منسف", "", 40, R.drawable.ic_eat_grid_6));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ProductAdapter adapter = new ProductAdapter(products);
        adapter.isEat(true);
        adapter.setIsGrid(true);
        recyclerView.setAdapter(adapter);
    }

    private void initRec1() {

        RecyclerView recyclerView1 = findViewById(R.id.recyclerView);


        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("", R.drawable.ic_eat_product_1));
        courses.add(new Course("", R.drawable.ic_eat_product_2a));
        courses.add(new Course("", R.drawable.ic_eat_product_3a));

        CourseAdapter courseAdapter = new CourseAdapter(courses);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        courseAdapter.setIsMostRequest(true);

        recyclerView1.setAdapter(courseAdapter);
    }
}
