package com.example.doan.View.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Model.Category;
import com.example.doan.R;
import com.example.doan.View.activity.CateogryActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context ctx;
    private List<Category> categoriesList;

    public CategoryAdapter(Context ctx, List<Category> categoriesList) {
        this.ctx = ctx;
        this.categoriesList = categoriesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View LaptopView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_single, parent, false);
        return new ViewHolder(LaptopView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category  category = categoriesList.get(position);
        String path = category.getCategoryImage();
        String name = category.getCategoryName() ;
        holder.categoryTitle.setText(name);
        Picasso.get().load(String.valueOf(path)).into(holder.categoryImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDetailsPage(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage_CateSingle);
            categoryTitle = itemView.findViewById(R.id.categoryName_CateSingle);

        }
    }
    private void goDetailsPage(int position) {
        Intent i = new Intent(ctx, CateogryActivity.class);
        i.putExtra("category_id" , categoriesList.get(position).getId());
        i.putExtra("categoryName", categoriesList.get(position).getCategoryName());
        ctx.startActivity(i);
    }
}
