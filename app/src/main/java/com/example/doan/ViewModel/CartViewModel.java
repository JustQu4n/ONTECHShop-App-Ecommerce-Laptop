package com.example.doan.ViewModel;

import static com.example.doan.Utils.SaveToken.getToken;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.doan.Model.CartUpdate;
import com.example.doan.Model.DataResponse;
import com.example.doan.Model.Laptop;
import com.example.doan.Repository.CartRepository;
import com.example.doan.Utils.SaveToken;

import java.util.List;


public class CartViewModel extends ViewModel {

    private static  MutableLiveData<List<Laptop>>  cart = new MutableLiveData<>();
    private static MutableLiveData<Double> total = new MutableLiveData<>();
    private static MutableLiveData<Boolean> delSuccess = new MutableLiveData<>();
    private static MutableLiveData<Boolean> updateSuccess = new MutableLiveData<>();
    private static  CartRepository cartRepository;

    public CartViewModel() {
        cartRepository = new CartRepository();

    }

    public MutableLiveData<List<Laptop>> getCart() {
        return  cart ;
    }

    public static void setCart() {
        cartRepository.getAllItem(getToken()).observeForever(new Observer<DataResponse>() {
            @Override
            public void onChanged(DataResponse dataResponse) {

                List<Laptop> list = dataResponse.getData().getRows();
                cart.setValue(list);
                Double sum = 0.0 ;
                for (Laptop item : list
                     ) {
                    sum += item.getQty()* item.getPrice();
                }
                total.setValue(sum);
            }
        });
    }
    public MutableLiveData<Double> getTotal() {return  total; }
    public static void  removeItem(Integer position) {
        CartRepository.removeItem(position).observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                delSuccess.setValue(aBoolean);
                if(aBoolean) {
                    setCart();
                }
            }
        });
    }
    public static void  updateItem(Integer laptop_id,Integer  qty) {
        CartRepository.updateItem(laptop_id,  qty).observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                updateSuccess.setValue(aBoolean);
                if(aBoolean) {
                    setCart();
                }
            }
        });
    }

}
