package com.example.doan.ViewModel;



import static com.example.doan.Utils.SaveToken.getToken;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.doan.Model.BuyResponse;
import com.example.doan.Model.Category;
import com.example.doan.Model.DataResponse;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.Order;
import com.example.doan.Model.Slider;
import com.example.doan.Repository.CategoryRepository;
import com.example.doan.Repository.LaptopRepository;
import com.example.doan.Repository.OrderRepository;
import com.example.doan.Repository.SliderRepository;

import java.util.List;
import java.util.Vector;


public class OrderViewModel extends ViewModel {
    private MutableLiveData<List<Order>> listOrder = new MutableLiveData<List<Order>>();
    private MutableLiveData<Boolean> isOrder = new MutableLiveData<>();

    private OrderRepository orderRepository ;
    private CategoryRepository  categoryRepository ;
    public OrderViewModel() {
        this.orderRepository = new OrderRepository();

    }

    public MutableLiveData<List<Order>> getListOrder() {
        return listOrder;
    }

    public void setListOrder(String token) {
        orderRepository.getAllOrder(token).observeForever(new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                listOrder.setValue(orders);
            }
        });
    }

    public MutableLiveData<Boolean> getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(BuyResponse buyResponse) {
        orderRepository.insertOrder(getToken(), buyResponse).observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                isOrder.setValue(aBoolean);
            }
        });
    }
}
