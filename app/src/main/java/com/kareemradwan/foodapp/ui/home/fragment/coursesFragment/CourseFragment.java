package com.kareemradwan.foodapp.ui.home.fragment.coursesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.adapter.CourseAdapter;
import com.kareemradwan.foodapp.model.Course;

import java.util.ArrayList;

public class CourseFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_courses, null, false);

        // initRecyclerView1();
        initRecyclerView2();
        // initRecyclerView3();


        return view;
    }


    private void initRecyclerView2() {
        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView2);

        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("", R.drawable.ic_course_ads_1));
        courses.add(new Course("", R.drawable.ic_course_ads_2));
        courses.add(new Course("", R.drawable.ic_course_ads_3));

        CourseAdapter courseAdapter = new CourseAdapter(courses);
        courseAdapter.setLayout(R.layout.item_course);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView1.setAdapter(courseAdapter);
    }

    private void initRecyclerView3() {
        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView5);
        ArrayList<Course> courses = (ArrayList<Course>) Course.getList();

        courses.add(new Course("الكورس الرابع", R.drawable.ic_services_3));
        CourseAdapter courseAdapter = new CourseAdapter(courses);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView1.setAdapter(courseAdapter);
    }

    private void initRecyclerView1() {
        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView4);
        CourseAdapter courseAdapter = new CourseAdapter(Course.getList());
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView1.setAdapter(courseAdapter);
    }
}

