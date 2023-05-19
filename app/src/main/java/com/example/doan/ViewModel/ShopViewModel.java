package com.example.doan.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.doan.Model.Category;
import com.example.doan.Model.DataResponse;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.Slider;
import com.example.doan.Repository.CategoryRepository;
import com.example.doan.Repository.LaptopRepository;
import com.example.doan.Repository.SliderRepository;

import java.util.List;
import java.util.Vector;


public class ShopViewModel extends ViewModel {

    private MutableLiveData<List<Slider>> listSlider = new MutableLiveData<List<Slider>>();
    private  MutableLiveData<List<Category>> listCategories = new MutableLiveData<>();
    private SliderRepository sliderRepository ;
    private CategoryRepository  categoryRepository ;
    public ShopViewModel() {
        this.sliderRepository = new SliderRepository();
        this.categoryRepository = new CategoryRepository() ;

    }
    public MutableLiveData<List<Slider>> getListSlider() {
        return this.listSlider;
    }
    public  void setListSlider() {
        sliderRepository.getSliders().observeForever(new Observer<List<Slider>>() {
            @Override
            public void onChanged(List<Slider> sliders) {
                listSlider.setValue(sliders);
            }
        });
    }

    public  void setListCategories() {
        categoryRepository.getAllCategories().observeForever(new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                listCategories.setValue(categories);
            }
        });
    }

    public MutableLiveData<List<Category>> getListCategories() {
        return listCategories;
    }
}
