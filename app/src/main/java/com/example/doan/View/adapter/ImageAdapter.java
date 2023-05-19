package com.example.doan.View.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
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

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context ;
    private List<Image> listImage ;

    public ImageAdapter(Context context, List<Image> listImage ) {
        this.context = context;
        this.listImage = listImage ;

    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_single_laptop, parent, false);
        return new ImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Image image = listImage.get(position);
        String path = image.getPath();
        holder.image.setImageURI(Uri.parse(path));
        Picasso.get().load(String.valueOf(path)).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image ;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgSingle);
        }
    }






}