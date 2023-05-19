package com.example.doan.View.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Model.Image;
import com.example.doan.Model.ItemOrder;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.Order;
import com.example.doan.R;
import com.example.doan.View.activity.DetailActivity;
import com.example.doan.ViewModel.CartViewModel;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LaptopBuyAdapter extends RecyclerView.Adapter<LaptopBuyAdapter.ViewHolder> {

    private Context context ;
    private List<Laptop> listLaptop ;

    public LaptopBuyAdapter(Context context, List<Laptop> listLaptop ) {
        this.context = context;
        this.listLaptop = listLaptop;
        Log.d("size", this.listLaptop.size() + "");
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_order, parent, false);
        return new LaptopBuyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Laptop laptop = listLaptop.get(position);
        holder.orderCode.setText(laptop.getLaptopName());
        String images = String.valueOf(laptop.getImages().get(0).getPath());
        Double value = Double.valueOf(laptop.getPrice()* laptop.getQty());
        Locale locale = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        holder.orderTotal.setText("Price : " + nf.format(value));
        Picasso.get().load(images).into(holder.orderImage);
        holder.orderQty.setText("x"+ laptop.getQty());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when click a order

            }
        });

    }

    public int getItemCount() {
        return listLaptop.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage ;
        TextView orderCode;
        TextView orderQty;
        TextView orderTotal;

        public ViewHolder(View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.imageOrder);
            orderCode = itemView.findViewById(R.id.tvCodeOrder);
            orderQty = itemView.findViewById(R.id.tvQty);
            orderTotal = itemView.findViewById(R.id.tvTotal);
        }
    }
}
