package com.example.doan.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.example.doan.Model.DataResponse;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.Slider;
import com.example.doan.Repository.LaptopRepository;
import com.example.doan.Repository.SliderRepository;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.List;
import java.util.Vector;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<SlideModel>> listSlider = new MutableLiveData<List<SlideModel>>();
    private MutableLiveData<List<Laptop>> listLaptopNew = new MutableLiveData<List<Laptop>>();
    private MutableLiveData<List<Laptop>> listLaptopSale = new MutableLiveData<List<Laptop>>();
    private  MutableLiveData<List<Laptop>> listLaptopSearch = new MutableLiveData<>();



    private SliderRepository sliderRepository ;
    private LaptopRepository laptopRepository ;


    public HomeViewModel() {
        this.sliderRepository = new SliderRepository();
        this.laptopRepository = new LaptopRepository();
    }
    public MutableLiveData<List<SlideModel>> getListSlider() {
        return this.listSlider;
    }
    public  void setListSlider() {
        sliderRepository.getSliders().observeForever(new Observer<List<Slider>>() {
            @Override
            public void onChanged(List<Slider> sliders) {
               List<SlideModel> list = new Vector<>();
               for(Slider item: sliders) {
                   SlideModel slider = new SlideModel(item.getPath(), ScaleTypes.FIT);
                   list.add(slider);
               }
               listSlider.setValue(list);
            }
        });
    }
    public  void setListLaptopNew(Integer id) {
        laptopRepository.getCategoryLaptop(id).observeForever(new Observer<DataResponse>() {
            @Override
            public void onChanged(DataResponse laptopResponse) {
                List<Laptop> laptops = laptopResponse.getData().getRows();
                listLaptopNew.setValue(laptops);
            }
        });
    }

    public MutableLiveData<List<Laptop>> getListLaptopNew() {
        return this.listLaptopNew;
    }

    public  void setListLaptopSale(Integer id) {
        laptopRepository.getCategoryLaptop(id).observeForever(new Observer<DataResponse>() {
            @Override
            public void onChanged(DataResponse laptopResponse) {
                List<Laptop> laptops = laptopResponse.getData().getRows();
                listLaptopSale.setValue(laptops);
            }
        });
    }

    public MutableLiveData<List<Laptop>> getListLaptopSale() {
        return this.listLaptopSale;
    }
    public MutableLiveData<List<Laptop>> getListLaptopSearch() {
        return listLaptopSearch;
    }

    public void setListLaptopSearch(String keySearch) {
        laptopRepository.getLaptopSearch(keySearch).observeForever(new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                Log.d("laptops", laptops.toString());
                listLaptopSearch.setValue(laptops);
            }
        });
    }
}
