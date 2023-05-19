package com.example.doan.View.fragment;

import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.doan.Model.Laptop;
import com.example.doan.R;
import com.example.doan.View.activity.SearchActivity;
import com.example.doan.View.adapter.LaptopAdapter;
import com.example.doan.ViewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private ImageSlider imageSlider ;
    private ArrayList<SlideModel> listSlider ;
    private RecyclerView newRecView ;
    private RecyclerView saleRecView;
    private HomeViewModel homeViewModel;
    private ImageView imgSearch ;
    private EditText edtKeySearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.imgslider);
        newRecView = view.findViewById(R.id.newRecView);
        saleRecView = view.findViewById(R.id.saleRecView);
        imgSearch = view.findViewById(R.id.imgSearch);
        edtKeySearch = view.findViewById(R.id.edtKeySearch);
        homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        homeViewModel.setListSlider();
        homeViewModel.setListLaptopNew(14);
        homeViewModel.setListLaptopSale(11);
        homeViewModel.getListSlider().observeForever(new Observer<List<SlideModel>>() {
            @Override
            public void onChanged(List<SlideModel> slideModels) {
                imageSlider.setImageList(slideModels, ScaleTypes.FIT);
            }
        });
        homeViewModel.getListLaptopNew().observeForever(new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                newRecView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                newRecView.setHasFixedSize(true);
                newRecView.setAdapter(new LaptopAdapter(laptops, getActivity()));
            }
        });
        homeViewModel.getListLaptopSale().observeForever(new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                saleRecView.setLayoutManager(new GridLayoutManager(getContext(),2));
               // saleRecView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                saleRecView.setHasFixedSize(true);
                saleRecView.setAdapter(new LaptopAdapter(laptops, getActivity()));

            }
        });

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        return view ;
    }

    private void search() {
        String keySearch = edtKeySearch.getText().toString().trim();
        if( !keySearch.isEmpty()) {
             Intent i = new Intent(getContext(), SearchActivity.class);
             i.putExtra("keySearch", keySearch);
             startActivity(i);
        } else {
            Toast.makeText(getContext(), "Please enter key search", Toast.LENGTH_LONG).show();
        }
    }
}