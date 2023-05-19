package com.example.doan.View.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.doan.Model.Order;
import com.example.doan.View.fragment.OrderFragment;
import com.example.doan.View.fragment.OrderdFragment;
import com.example.doan.View.fragment.ReceivedFragment;
import com.example.doan.View.fragment.ShippedFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter   {



    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return   new OrderFragment();
            case 1 :
                return  new OrderdFragment();
            case 2 :
                return  new ShippedFragment();
            case 3:
                return  new ReceivedFragment();
            default:
                return new OrderFragment() ;
        }
    }
    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position) {
        // Return the title for the given position
        switch (position) {
            case 0:
                return "Order";
            case 1:
                return "Orderd";
            case 2:
                return "Shipping";
            case 3:
                return "Recived";

            default:
                return "Order";
        }

    }

}
