package com.example.doan.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.doan.Model.CartRequest;
import com.example.doan.Model.District;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.Province;
import com.example.doan.Model.ShippingDefault;
import com.example.doan.Model.Ward;
import com.example.doan.Repository.CartRepository;
import com.example.doan.Repository.FeesRepository;
import com.example.doan.Repository.LaptopRepository;
import com.example.doan.Repository.UserRepository;

import java.util.List;

public class DetailViewModel extends ViewModel {
    private LaptopRepository laptopRepository ;
    private CartRepository cartRepository ;


    private MutableLiveData<Laptop> laptop = new MutableLiveData<>();
    private MutableLiveData<List<Laptop>> laptopRecommend = new MutableLiveData<>();
    private MutableLiveData<Boolean> isAddCart = new MutableLiveData<>();


    public  DetailViewModel() {
        laptopRepository = new LaptopRepository() ;
        cartRepository = new CartRepository();
    }

    public MutableLiveData<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(int laptopId) {
        laptopRepository.getLaptop(laptopId).observeForever(new Observer<Laptop>() {
            @Override
            public void onChanged(Laptop laptopData) {
                laptop.setValue(laptopData);
            }
        });
    }

    public MutableLiveData<List<Laptop>> getLaptopRecommend() {return laptopRecommend;}
    public void setLaptopRecommend(int laptopId) {
        laptopRepository.getCommendLaptop(laptopId).observeForever(new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                laptopRecommend.setValue(laptops);
            }
        });
    }


    public MutableLiveData<Boolean> getIsAddCart() {
        return isAddCart;
    }

    public void setIsAddCart(CartRequest cartRequest) {
       cartRepository.insertCart(cartRequest).observeForever(new Observer<Boolean>() {
           @Override
           public void onChanged(Boolean aBoolean) {
               isAddCart.setValue(aBoolean);
           }
       });
    }
}