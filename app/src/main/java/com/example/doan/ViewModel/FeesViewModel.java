package com.example.doan.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.doan.Model.District;
import com.example.doan.Model.Province;
import com.example.doan.Model.MyRequest;
import com.example.doan.Model.ShipFeeRequest;
import com.example.doan.Model.ShippingDefault;
import com.example.doan.Model.Ward;
import com.example.doan.Repository.FeesRepository;
import com.example.doan.Repository.UserRepository;

import java.util.List;

public class FeesViewModel extends ViewModel {

    private MutableLiveData<List<Province>> provinceList = new MutableLiveData<>() ;
    private MutableLiveData<List<District>> listDistrict = new MutableLiveData<>();
    private MutableLiveData<List<Ward>> listWard = new MutableLiveData<>();


    private MutableLiveData<Boolean> isInsertShippingDefault = new MutableLiveData<>();
    private MutableLiveData<Integer> service  = new MutableLiveData<>();
    private MutableLiveData<Double> fee = new MutableLiveData<>();


    private FeesRepository feesRepository ;
    private UserRepository userRepository;


    public MutableLiveData<List<Ward>> getListWard() {
        return listWard;
    }

    public void setListWard(int province_id) {
        feesRepository.getWards(province_id).observeForever(new Observer<List<Ward>>() {
            @Override
            public void onChanged(List<Ward> wards) {
                listWard.setValue(wards);
            }
        });
    }

    public MutableLiveData<List<District>> getListDistrict() {
        return listDistrict;
    }

    public void setListDistrict(int provinceId) {
        feesRepository.getDistricts(provinceId).observeForever(new Observer<List<District>>() {
            @Override
            public void onChanged(List<District> districts) {
                listDistrict.setValue(districts);
            }
        });
    }

    public MutableLiveData<Boolean> getIsInsertShippingDefault() {
        return isInsertShippingDefault;
    }

    public void setIsInsertShippingDefault(String token, ShippingDefault data) {
        userRepository.insertShippingDefault(token, data).observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) isInsertShippingDefault.setValue(true);
                else  isInsertShippingDefault.setValue(false);
            }
        });
    }

    public FeesViewModel() {
       userRepository = new UserRepository();
        feesRepository = new FeesRepository();
    }
    public  MutableLiveData<List<Province>> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList() {
      feesRepository.getProvinces().observeForever(new Observer<List<Province>>() {
          @Override
          public void onChanged(List<Province> provinces) {
              provinceList.setValue(provinces);
          }
      });
    }

    public MutableLiveData<Integer> getService() {
        return service;
    }

    public void setService(MyRequest serviceRequest) {
        feesRepository.getService(serviceRequest).observeForever(new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                service.setValue(integer);
            }
        });
    }

    public MutableLiveData<Double> getFee() {
        return fee;
    }

    public void setFee(ShipFeeRequest shipFeeRequest) {
        feesRepository.getFee(shipFeeRequest).observeForever(new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                fee.setValue(aDouble);
            }
        });
    }
}
