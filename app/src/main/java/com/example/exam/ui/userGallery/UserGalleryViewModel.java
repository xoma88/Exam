package com.example.exam.ui.userGallery;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exam.dataBase.ImageHandler;
import com.example.exam.models.Image;

import java.util.ArrayList;
import java.util.List;

public class UserGalleryViewModel extends ViewModel {

    private MutableLiveData<List<Image>> mImages;
    private MutableLiveData<Integer> mUserId;

    public LiveData<List<Image>> getImages(Context ctx) {
        if (mImages == null){
            mImages = new MutableLiveData<List<Image>>();
            loadImages(ctx);
        }
        return mImages;
    }

    public LiveData<Integer> setUserId(Integer userId) {
        mUserId = new MutableLiveData<Integer>();
        mUserId.setValue(userId);

        return mUserId;
    }

    private void loadImages(Context ctx) {
        List<Image> images = new ArrayList<>();

        ImageHandler imageHandler = new ImageHandler(ctx);
        List<Image> imagesLoad = imageHandler.getAllImage();

        for (int i = 0; i < imagesLoad.size(); i++) {

            if (imagesLoad.get(i).getAuthorId() == mUserId.getValue()) {
                images.add(imagesLoad.get(i));
            }
        }
        mImages.setValue(images);
    }
}