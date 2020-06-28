package com.example.exam.ui.myGallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyGalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyGalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is my gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}