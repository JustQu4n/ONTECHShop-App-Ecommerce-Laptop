package com.example.doan.View.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.models.SlideModel;
import com.example.doan.Model.Category;
import com.example.doan.Model.Slider;
import com.example.doan.R;
import com.example.doan.View.adapter.CategoryAdapter;
import com.example.doan.View.adapter.CoverLaptopAdapter;
import com.example.doan.ViewModel.HomeViewModel;
import com.example.doan.ViewModel.ShopViewModel;

import java.util.List;


public class ShopFragment extends Fragment {

    private ShopViewModel shopViewModel;
    private RecyclerView coveRecyclerView;
    private RecyclerView categoriesRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        shopViewModel  = new   ViewModelProvider(getActivity()).get(ShopViewModel.class);
        categoriesRecyclerView = view.findViewById(R.id.categoriesRecView);
        coveRecyclerView = view.findViewById(R.id.coverRecView_shopFrag);
        shopViewModel.setListSlider();
        shopViewModel.setListCategories();

        shopViewModel.getListSlider().observeForever(new Observer<List<Slider>>() {
            @Override
            public void onChanged(List<Slider> sliders) {
                coveRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                coveRecyclerView.setHasFixedSize(true);
                coveRecyclerView.setAdapter(new CoverLaptopAdapter(getActivity(), sliders));
            }
        });
        shopViewModel.getListCategories().observeForever(new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoriesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2 ));
                categoriesRecyclerView.setAdapter(new CategoryAdapter(getActivity(), categories));
            }
        });

        return view ;
    }
}