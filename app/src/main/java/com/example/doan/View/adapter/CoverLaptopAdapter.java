package com.example.doan.View.adapter;



import static android.app.PendingIntent.getActivity;
import static androidx.core.content.ContextCompat.getAttributionTag;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Model.Category;
import com.example.doan.Model.Slider;
import com.example.doan.R;
import com.example.doan.View.activity.CateogryActivity;
import com.example.doan.View.activity.HomeActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CoverLaptopAdapter extends RecyclerView.Adapter<CoverLaptopAdapter.ViewHolder> {
    private Context ctx;
    private List<Slider> coverLaptopList;

    public CoverLaptopAdapter(Context ctx, List<Slider> coverLaptopList) {
        this.ctx = ctx;
        this.coverLaptopList = coverLaptopList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View LaptopView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cover_single, parent, false);
        return new ViewHolder(LaptopView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Slider laptop = coverLaptopList.get(position);
        String path = laptop.getPath();
        Picasso.get().load(String.valueOf(path)).into(holder.laptopImage_coverPage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDetailsPage(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return coverLaptopList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView laptopImage_coverPage;
        public ViewHolder(View itemView) {
            super(itemView);
            laptopImage_coverPage = itemView.findViewById(R.id.laptopImage_coverPage);
        }
    }

    private void goDetailsPage(int position) {

    }


}
