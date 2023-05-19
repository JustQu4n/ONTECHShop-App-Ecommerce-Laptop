package com.example.doan.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.doan.R;

public class FirstViewAdapter extends PagerAdapter {
    private Context context ;
    private LayoutInflater inflater ;


    public FirstViewAdapter(Context context) {
        this.context = context;
    }

    private int[] images = {
            R.drawable.ontechimage,
            R.drawable.ontechimage,
            R.drawable.ontechimage,
    } ;

    private  String[] titles = {
            "Wellcome to ONTECH",
            "A great shopping experience",
            "Enjoy"
    } ;
    private String[] descs = {
            "ONTECH is one of the leading companies in the distribution of laptop products.",
            "We give you a great shopping experience.",
            "Enjoy these wonderful moments your way."
    };

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.view_page, container, false);

        // Initialize views
        ImageView imageView = v.findViewById(R.id.imgViewPager);
        TextView txtTitle = v.findViewById(R.id.txtTitleViewPager);
        TextView txtDesc = v.findViewById(R.id.txtDescViewPager);

        imageView.setImageResource(images[position]);
        txtTitle.setText(titles[position]);
        txtDesc.setText(descs[position]);

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

}
