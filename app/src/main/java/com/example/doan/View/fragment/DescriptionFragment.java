package com.example.doan.View.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doan.R;

import org.w3c.dom.Text;


public class DescriptionFragment extends Fragment {

    private String desc ;
    public DescriptionFragment(String desc) {
        // Required empty public constructor
        this.desc = desc ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        TextView tvDesc = view.findViewById(R.id.tvDescription);
        tvDesc.setText(desc);
        return view ;
    }
}