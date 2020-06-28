package com.example.exam.ui.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exam.dataBase.ImageHandler;
import com.example.exam.models.Image;
import com.example.exam.models.User;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Image>> mImages;
    private MutableLiveData<User> mUser;

    public LiveData<List<Image>> getImages(Context ctx) {
        if (mImages == null){
            mImages = new MutableLiveData<List<Image>>();
            loadImages(ctx);
        }
        return mImages;
    }

    private void loadImages(Context ctx) {
        ImageHandler imageHandler = new ImageHandler(ctx);
        List<Image> images = imageHandler.getAllImage();

        mImages.setValue(images);
    }
}