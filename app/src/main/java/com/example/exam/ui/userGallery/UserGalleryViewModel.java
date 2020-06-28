package com.example.exam.ui.userGallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exam.models.Image;

import java.util.ArrayList;
import java.util.List;

public class UserGalleryViewModel extends ViewModel {

    private MutableLiveData<List<Image>> mImages;
    private MutableLiveData<Integer> mUserId;

    public LiveData<List<Image>> getImages() {
        if (mImages == null){
            mImages = new MutableLiveData<List<Image>>();
            loadImages();
        }
        return mImages;
    }

    public LiveData<Integer> setUserId(Integer userId) {
        mUserId = new MutableLiveData<Integer>();
        mUserId.setValue(userId);

        return mUserId;
    }

    private void loadImages() {
        List<Image> images = new ArrayList<>();

        List<Image> imagesLoad = new ArrayList<>();
        //заполнение картинок
        {
            imagesLoad.add(new Image(0, String.format("image_%s", 1), String.format("name_%s", 1), 0, String.format("description_%s", 1), "https://img1.goodfon.ru/wallpaper/nbig/e/d8/kuby-chernye-sinie-kubiki-3d.jpg"));
            imagesLoad.add(new Image(1, String.format("image_%s", 2), String.format("name_%s", 1), 0, String.format("description_%s", 2), "https://i.pinimg.com/originals/16/81/53/16815372d03d148faca8203ccde9bc56.jpg"));
            imagesLoad.add(new Image(2, String.format("image_%s", 3), String.format("name_%s", 1), 0, String.format("description_%s", 3), "https://storge.pic2.me/cm/2560x1440/317/5b85ae7451669.jpg"));
            imagesLoad.add(new Image(3, String.format("image_%s", 4), String.format("name_%s", 1), 0, String.format("description_%s", 4), "https://storge.pic2.me/upload/496/5550a6708a4b3.jpg"));
            imagesLoad.add(new Image(4, String.format("image_%s", 5), String.format("name_%s", 1), 0, String.format("description_%s", 5), "https://img1.goodfon.ru/wallpaper/big/b/95/kvadraty-cvet-otrazhenie.jpg"));

            imagesLoad.add(new Image(5, String.format("image_%s", 6), String.format("name_%s", 2), 1, String.format("description_%s", 6), "https://i.pinimg.com/originals/65/60/da/6560da8bfab621f2cafefa171fbcd092.jpg"));
            imagesLoad.add(new Image(6, String.format("image_%s", 7), String.format("name_%s", 2), 1, String.format("description_%s", 7), "https://img1.goodfon.ru/wallpaper/big/f/73/messier-42-tumannost-orion.jpg"));
            imagesLoad.add(new Image(7, String.format("image_%s", 8), String.format("name_%s", 2), 1, String.format("description_%s", 8), "https://99px.ru/sstorage/53/2013/12/tmb_89172_1422.jpg"));
            imagesLoad.add(new Image(8, String.format("image_%s", 9), String.format("name_%s", 2), 1, String.format("description_%s", 9), "https://oboinastol.net/katalog_kartinok/tom09/010/skachat_oboi_1280x1024.jpg"));
            imagesLoad.add(new Image(9, String.format("image_%s", 10), String.format("name_%s", 2), 1, String.format("description_%s", 10), "https://img3.goodfon.ru/wallpaper/nbig/5/55/pacman-emissionnaya-tumannost.jpg"));

            imagesLoad.add(new Image(10, String.format("image_%s", 11), String.format("name_%s", 3), 2, String.format("description_%s", 11), "https://img1.goodfon.ru/wallpaper/big/6/fb/bmw-chernyy-fary-siniy-svet.jpg"));
            imagesLoad.add(new Image(11, String.format("image_%s", 12), String.format("name_%s", 3), 2, String.format("description_%s", 12), "https://99px.ru/sstorage/53/2013/10/tmb_83907_1450.jpg"));
            imagesLoad.add(new Image(12, String.format("image_%s", 13), String.format("name_%s", 3), 2, String.format("description_%s", 13), "https://img3.goodfon.ru/wallpaper/big/4/10/reshetka-fary-bumer-siluet-1929.jpg"));
            imagesLoad.add(new Image(13, String.format("image_%s", 14), String.format("name_%s", 3), 2, String.format("description_%s", 14), "https://pw.artfile.me/wallpaper/02-06-2018/650x407/avtomobili-fragmenty-avtomobilya-bmw-i8--1348905.jpg"));
            imagesLoad.add(new Image(14, String.format("image_%s", 15), String.format("name_%s", 3), 2, String.format("description_%s", 15), "https://img2.goodfon.ru/wallpaper/nbig/5/91/bmv-bmw-mashina.jpg"));

            imagesLoad.add(new Image(15, String.format("image_%s", 16), String.format("name_%s", 4), 3, String.format("description_%s", 16), "https://www.zastavki.com/pictures/originals/2014/_Gray_furniture_in_the_kitchen_091487_.jpg"));
            imagesLoad.add(new Image(16, String.format("image_%s", 17), String.format("name_%s", 4), 3, String.format("description_%s", 17), "https://okuhne.net/wp-content/uploads/2015/11/kuxnya-v-seryx-tonax.jpg"));
            imagesLoad.add(new Image(17, String.format("image_%s", 18), String.format("name_%s", 4), 3, String.format("description_%s", 18), "https://kitchen.cdnvideo.ru/wp-content/uploads/2015/07/seraya-kuxnya-v-interere.jpg"));
            imagesLoad.add(new Image(18, String.format("image_%s", 19), String.format("name_%s", 4), 3, String.format("description_%s", 19), "https://mebellka.ru/wp-content/uploads/2020/03/Sovremennyj-stil-kuhni.jpg"));
            imagesLoad.add(new Image(19, String.format("image_%s", 20), String.format("name_%s", 4), 3, String.format("description_%s", 20), "https://i.pinimg.com/originals/3b/ab/07/3bab078af7998c3bab7f4aa7e491b8c1.jpg"));

            imagesLoad.add(new Image(20, String.format("image_%s", 21), String.format("name_%s", 5), 4, String.format("description_%s", 21), "https://99px.ru/sstorage/53/2013/07/tmb_75639_4291.jpg"));
            imagesLoad.add(new Image(21, String.format("image_%s", 22), String.format("name_%s", 5), 4, String.format("description_%s", 22), "https://million-wallpapers.ru/wallpapers/6/40/471042666485597.jpg"));
            imagesLoad.add(new Image(22, String.format("image_%s", 23), String.format("name_%s", 5), 4, String.format("description_%s", 23), "https://img3.goodfon.ru/wallpaper/nbig/8/3b/klen-vetka-listya-osennie-fon.jpg"));
            imagesLoad.add(new Image(23, String.format("image_%s", 24), String.format("name_%s", 5), 4, String.format("description_%s", 24), "https://img2.goodfon.ru/wallpaper/big/4/ea/listya-osennie-fon-razmytost.jpg"));
            imagesLoad.add(new Image(24, String.format("image_%s", 25), String.format("name_%s", 5), 4, String.format("description_%s", 25), "https://99px.ru/sstorage/53/2015/12/tmb_151278_3020.jpg"));
        }
        for (int i = 0; i < imagesLoad.size(); i++) {

            if (imagesLoad.get(i).getAuthorId() == mUserId.getValue()) {
                images.add(imagesLoad.get(i));
            }
        }
        mImages.setValue(images);
    }
}