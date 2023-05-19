package com.example.doan.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.doan.Model.Category;
import com.example.doan.Model.DataResponse;
import com.example.doan.Model.InforShipping;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.Slider;
import com.example.doan.Model.UserProfile;
import com.example.doan.Repository.CategoryRepository;
import com.example.doan.Repository.LaptopRepository;
import com.example.doan.Repository.ProfileRepository;
import com.example.doan.Repository.SliderRepository;
import com.example.doan.Repository.UserRepository;

import java.util.List;
import java.util.Vector;


public class ProfileViewModel extends ViewModel {

    private ProfileRepository profileRepository;
    private static UserRepository userRepository ;
    private MutableLiveData<UserProfile> userProfile = new MutableLiveData<>();
    private static MutableLiveData<List<InforShipping>> listInforShipping = new MutableLiveData<>();
    private MutableLiveData<InforShipping> addressDefault  = new MutableLiveData<>();

    private static MutableLiveData<Boolean> isHasAddressDefault = new MutableLiveData<>();



    public ProfileViewModel() {
        this.profileRepository = new ProfileRepository();
        this.userRepository = new UserRepository();
    }

    public MutableLiveData<UserProfile> getUserProfile() {
        return userProfile;
    }

    public void getProfile(String token) {
        profileRepository.getProfile(token).observeForever(new Observer<UserProfile>() {
            @Override
            public void onChanged(UserProfile rs) {
                userProfile.setValue(rs);
            }
        });

    }

    public MutableLiveData<List<InforShipping>> getListInforShipping() {
        return listInforShipping;
    }

    public static void setValueAddress(String token) {
        userRepository.getAllAdress(token).observeForever(new Observer<List<InforShipping>>() {
            @Override
            public void onChanged(List<InforShipping> inforShippings) {
                if(inforShippings != null) {
                    listInforShipping.setValue(inforShippings);

                } else {
                    listInforShipping.setValue(null);
                    isHasAddressDefault.setValue(true);

                }
            }
        });
    }

     static  public void updateAddress(String token, int id) {
        userRepository.updateAddress(token, id).observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    setValueAddress(token);
                }
            }
        });



    }

    public void setAddressDefault() {
        // set for address default
        userRepository.getAddressDefault().observeForever(new Observer<InforShipping>() {
            @Override
            public void onChanged(InforShipping inforShipping) {
                if(inforShipping !=null ) {
                    addressDefault.setValue(inforShipping);
                    isHasAddressDefault.setValue(true);
                } else {
                    isHasAddressDefault.setValue(false);
                }
            }
        });
    }

    public MutableLiveData<InforShipping> getAddressDefault() {
        return this.addressDefault;
    }

    public  MutableLiveData<Boolean> getIsHasAddressDefault() {
        return this.isHasAddressDefault;
    }


}
