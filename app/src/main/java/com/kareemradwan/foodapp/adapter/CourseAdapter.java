package com.kareemradwan.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;
    private List<Course> courseList;
    private int layout = -1;
    private boolean isMostRequest = false;

    public CourseAdapter(List<Course> courses) {
        this.courseList = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        if (layout != -1) {
            return new CourseViewHolder(LayoutInflater.from(context).inflate(layout, null, false));

        } else {
            return new CourseViewHolder(LayoutInflater.from(context).inflate(R.layout.item_course, null, false));
        }
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        //holder.tvTitle.setText(courseList.get(position).getTitle());
        holder.imgCourse.setBackgroundResource(courseList.get(position).getImage());


        if (isMostRequest && position == 0) {
            holder.shadowColor.setVisibility(View.VISIBLE);
            holder.tvTitle.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public void setIsMostRequest(boolean isMostRequest) {
        this.isMostRequest = isMostRequest;
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCourse;
        TextView tvTitle;
        View shadowColor;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCourse = itemView.findViewById(R.id.img_item_course);
            tvTitle = itemView.findViewById(R.id.tv_course_title);
            shadowColor = itemView.findViewById(R.id.view_shadow);

        }
    }
}
