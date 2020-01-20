package com.kareemradwan.foodapp.ui.home.fragment.homeFragment;

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

public class HomeFragment extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null, false);


        initRecyclerView1();
        initRecyclerView2();
        initRecyclerView3();

        return view;
    }

    private void initRecyclerView2() {
        // TODO : Last one

        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView10);


        CourseAdapter courseAdapter = new CourseAdapter(Course.getList());
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL , false));
        courseAdapter.setIsMostRequest(true);

        recyclerView1.setAdapter(courseAdapter);
    }

    private void initRecyclerView3() {
        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView3);
        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("الكورس الرابع", R.drawable.ic_video_2));
        courses.add(new Course("الكورس الرابع", R.drawable.ic_video_1));
        courses.add(new Course("الكورس الرابع", R.drawable.ic_course_2));


        CourseAdapter courseAdapter = new CourseAdapter(courses);
        courseAdapter.setLayout(R.layout.item_video);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true));
        recyclerView1.setAdapter(courseAdapter);
    }

    private void initRecyclerView1() {
        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("", R.drawable.ic_course_1));
        courses.add(new Course("", R.drawable.ic_course_2));
        courses.add(new Course("", R.drawable.ic_course_3));
        CourseAdapter courseAdapter = new CourseAdapter(courses);


        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView1.setAdapter(courseAdapter);
    }
}
