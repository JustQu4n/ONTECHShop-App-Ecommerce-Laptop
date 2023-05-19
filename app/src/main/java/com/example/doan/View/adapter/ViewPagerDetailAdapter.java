package com.example.doan.View.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doan.R;
import com.example.doan.View.fragment.CommentFragment;
import com.example.doan.View.fragment.DescriptionFragment;
import com.example.doan.View.fragment.OrderFragment;
import com.example.doan.View.fragment.OrderdFragment;
import com.example.doan.View.fragment.ReceivedFragment;
import com.example.doan.View.fragment.ShippedFragment;


public class ViewPagerDetailAdapter  extends FragmentStatePagerAdapter {

    private  String desc ;
    public ViewPagerDetailAdapter(@NonNull FragmentManager fm, int behavior, String desc) {
        super(fm, behavior);
        this.desc = desc ;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return  new DescriptionFragment(desc);
            case 1 :
                return  new CommentFragment();
            default:
                return new DescriptionFragment(desc);
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position) {
        // Return the title for the given position
        switch (position) {
            case 0:
                return "Description";
            case 1:
                return "Comment";
            default:
                return "Description";
        }

    }
}