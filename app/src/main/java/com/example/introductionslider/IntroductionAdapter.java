package com.example.introductionslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class IntroductionAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public IntroductionAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {
        R.drawable.icon_eat,
        R.drawable.icon_work,
        R.drawable.icon_sleep
    };

    public String[] slide_headings = {
        "EAT",
        "CODE",
        "SLEEP"
    };

    public String[] slide_text = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_introduction, container, false);

        ImageView sliderImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView sliderHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView sliderText = (TextView) view.findViewById(R.id.slide_text);

        sliderImageView.setImageResource(slide_images[position]);
        sliderHeading.setText(slide_headings[position]);
        sliderText.setText(slide_text[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout)object);
    }
}
