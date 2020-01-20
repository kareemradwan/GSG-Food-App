package com.kareemradwan.foodapp.model;

import com.kareemradwan.foodapp.R;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private int image;

    public Course() {
    }

    public Course(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public static List<Course> getList() {
        List<Course> list = new ArrayList<>();
        list.add(new Course("الكورس الأول ", R.drawable.ic_services_1));
        list.add(new Course("الكورس الثاني ", R.drawable.ic_services_2));
        list.add(new Course("الكورس الثالث ", R.drawable.ic_services_3));
        // list.add(new Course("الكورس الرابع " , R.drawable.ic_services_1));

        return list;
    }
}
