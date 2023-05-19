package com.example.doan.View.fragment;

import static com.example.doan.Utils.SaveToken.getToken;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doan.Model.Order;
import com.example.doan.R;
import com.example.doan.View.adapter.OrderAdapter;
import com.example.doan.ViewModel.OrderViewModel;

import java.util.ArrayList;
import java.util.List;


public class OrderdFragment extends Fragment {
    private OrderViewModel orderViewModel ;
    private RecyclerView recyclerView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_orderd, container, false);
        recyclerView = view.findViewById(R.id.rcOrdered);
        orderViewModel =  new ViewModelProvider(getActivity()).get(OrderViewModel.class);
        orderViewModel.setListOrder(getToken());
        orderViewModel.getListOrder().observeForever(new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                if(orders != null ) {
                    List<Order> list = new ArrayList<>();
                    for (Order item: orders) {
                        if(item.getStatus() == 1) {
                            list.add(item);
                        }

                    }
                    if(list != null ) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
                        recyclerView.setAdapter( new OrderAdapter(getActivity(), list));
                    }
                }
            }
        });


        return view ;
    }
}