package com.example.doan.View.adapter;

import static com.example.doan.Utils.SaveToken.getToken;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.doan.Model.InforShipping;
import com.example.doan.R;
import com.example.doan.Repository.UserRepository;
import com.example.doan.ViewModel.ProfileViewModel;

import java.util.List;



public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    private List<InforShipping> listInforShipping;
    private Context context ;

    public AddressAdapter(Context context, List<InforShipping> listInforShipping) {
        this.listInforShipping = listInforShipping ;
        this.context = context;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_address_shipping, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InforShipping item = listInforShipping.get(position);
        holder.address.setText("Đia chỉ : " + item.getAddress());
        holder.phone.setText("Số điện thoại  : " + item.getPhone());

        if(item.getStatus() == 1 ) {
            holder.check.setChecked(true);
        } else holder.check.setChecked(false);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // update default shipping

                updateShipping(position);

            }
        });


    }

    private void updateShipping(int position) {
        Integer id = listInforShipping.get(position).getId();
        ProfileViewModel.updateAddress(getToken(), id);
    }


    @Override
    public int getItemCount() {
        return listInforShipping.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView address ;
        private  TextView phone;
        private RadioButton check;
        public ViewHolder(View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.tvAddressShipping);
            phone = itemView.findViewById(R.id.tvPhoneShipping);
            check = itemView.findViewById(R.id.radioButtonAddress);
        }
    }






}
