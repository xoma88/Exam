package com.example.exam.ui.infoImage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exam.models.Image;

public class InfoImageViewModel extends ViewModel {
    private MutableLiveData<Image> mImage;

    public LiveData<Image> setImage(Image image) {
        mImage = new MutableLiveData<Image>();
        mImage.setValue(image);

        return mImage;
    }

    public LiveData<Image> getImage() {
        return mImage;
    }
}