package com.example.doan.View.adapter;

import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Model.Image;
import com.example.doan.Model.Laptop;
import com.example.doan.R;
import com.example.doan.ViewModel.CartViewModel;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context context ;
    private List<Laptop> listLaptop ;
    private CartViewModel cartViewModel ;

    public CartAdapter(Context context, List<Laptop> listLaptop ) {
        this.context = context;
        this.listLaptop = listLaptop;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Laptop laptop = listLaptop.get(position);
        List<Image> images = laptop.getImages();
        String path = images.get(0).getPath();
        Picasso.get().load(path).into(holder.laptopImage);
        Double value = Double.valueOf(laptop.getPrice()*laptop.getQty());
        Locale locale = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        holder.laptopPrice.setText(nf.format(value));
        holder.laptopName.setText(laptop.getLaptopName());
        holder.laptopQty.setText(laptop.getQty().toString());

        holder.cartDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delItem(position);
            }
        });


        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer qty = Integer.valueOf(holder.laptopQty.getText().toString()) ;
                if(qty >  1) {
                    qty -= 1 ;
                    holder.laptopQty.setText(qty.toString());

                }

            }
        });
        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer qty = Integer.valueOf(holder.laptopQty.getText().toString()) + 1  ;
                holder.laptopQty.setText(qty.toString());
            }
        });

        holder.cartUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer qty = Integer.valueOf(holder.laptopQty.getText().toString());
                updateItem(position, qty);
            }
        });
    }



    @Override
    public int getItemCount() {
        return listLaptop.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView laptopImage ;
        TextView laptopName;
        TextView laptopPrice;
        TextView laptopQty;
        ImageView increase ;
        ImageView decrease;
        ImageView cartDel;
        ImageView cartUpdate;
        public ViewHolder(View itemView) {
            super(itemView);
            laptopImage = itemView.findViewById(R.id.cartImage);
            laptopName = itemView.findViewById(R.id.tvAddressShipping);
            laptopPrice = itemView.findViewById(R.id.tvPhoneShipping);
            laptopQty = itemView.findViewById(R.id.quantityTvCart);
            decrease = itemView.findViewById(R.id.decreaseCart_item);
            increase = itemView.findViewById(R.id.plusLayout_item);
            cartDel = itemView.findViewById(R.id.cartDel);
            cartUpdate = itemView.findViewById(R.id.cartUpdate);
        }
    }
    private void delItem(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        Laptop laptop = listLaptop.get(position);
        Integer laptopId = laptop.getId();

// Thiết lập tiêu đề
        builder.setTitle("Notification");

// Thiết lập nội dung
        builder.setMessage("Do you really want to update?");

// Thiết lập nút đồng ý
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CartViewModel.removeItem(laptopId);
            }
        });

// Thiết lập nút từ chối
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Xử lý sự kiện khi người dùng nhấn nút Từ chối
                dialog.dismiss(); // Đóng dialog
            }
        });

// Tạo và hiển thị AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void updateItem(int position, int qty) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);



// Thiết lập tiêu đề
        builder.setTitle("Notification");

// Thiết lập nội dung
        builder.setMessage("Do you really want to update ?");

// Thiết lập nút đồng ý
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Laptop laptop = listLaptop.get(position);
                Integer laptopId = laptop.getId();
                CartViewModel.updateItem(laptop.getId(), qty);
            }
        });

// Thiết lập nút từ chối
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Xử lý sự kiện khi người dùng nhấn nút Từ chối
                dialog.dismiss(); // Đóng dialog
            }
        });

// Tạo và hiển thị AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}
