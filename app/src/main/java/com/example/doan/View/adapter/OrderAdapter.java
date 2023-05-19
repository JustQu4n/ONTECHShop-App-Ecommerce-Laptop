package com.example.doan.View.adapter;



import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Model.CartUpdate;
import com.example.doan.Model.Image;
import com.example.doan.Model.ItemOrder;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.Order;
import com.example.doan.R;
import com.example.doan.ViewModel.CartViewModel;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context ;
    private List<Order> listLaptop ;
    private CartViewModel cartViewModel ;

    public OrderAdapter(Context context, List<Order> listLaptop ) {
        this.context = context;
        this.listLaptop = listLaptop;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_order, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = listLaptop.get(position);
        holder.orderCode.setText("CODE [" + order.getId() + "] ");
        String images = String.valueOf(order.getItems().get(0).getLaptop().getImages().get(0).getPath());
        Double value = Double.valueOf(order.getTotal());
        Locale locale = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        holder.orderTotal.setText("Total order : " + nf.format(value));

        Picasso.get().load(images).into(holder.orderImage);
        String qty = "";
        List<String> newList = new ArrayList<>();
        for (ItemOrder item: order.getItems() ) {
            String t =  item.getQty() + "x " + item.getLaptop().getLaptopName();
            newList.add(t);
        }
        qty = newList.toString().replace("[", "").replace("]", "");
        holder.orderQty.setText("( "+ qty + " )");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when click a order

            }
        });

    }
    @Override
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

