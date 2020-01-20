package com.kareemradwan.foodapp.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.model.AboutModel;

import java.util.ArrayList;

public class SlidingImage_Adapter extends PagerAdapter {


    private ArrayList<AboutModel> imageModelArrayList;
    private LayoutInflater inflater;
    private Context context;
    private boolean isAds = false;


    public SlidingImage_Adapter(Context context, ArrayList<AboutModel> imageModelArrayList) {
        this.context = context;
        this.imageModelArrayList = imageModelArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = null;
        if (!isAds) {
            imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);
            assert imageLayout != null;
            final ImageView imageView = imageLayout
                    .findViewById(R.id.image);
            TextView tvTitle = imageLayout.findViewById(R.id.about_title);
            TextView tvDesc = imageLayout.findViewById(R.id.about_description);
            imageView.setImageResource(imageModelArrayList.get(position).getImageIcon());
            tvTitle.setText(imageModelArrayList.get(position).getTitle());
            tvDesc.setText(imageModelArrayList.get(position).getDescription());

        } else {
            imageLayout = inflater.inflate(R.layout.item_store_pager, view, false);
            assert imageLayout != null;
            final ImageView imageView = imageLayout
                    .findViewById(R.id.image);

            TextView tvTitle = imageLayout.findViewById(R.id.about_title);
          //  TextView tvDesc = imageLayout.findViewById(R.id.about_description);
            imageView.setBackgroundResource(imageModelArrayList.get(position).getImageIcon());
            tvTitle.setText(imageModelArrayList.get(position).getTitle());
          //  tvDesc.setText(imageModelArrayList.get(position).getDescription());

        }


        view.addView(imageLayout, 0);
        return imageLayout;
    }

    public void isAds(boolean isAds) {
        this.isAds = isAds;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
