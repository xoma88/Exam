package com.example.exam.ui.userGallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam.R;
import com.example.exam.adapters.ImageAdapter;
import com.example.exam.models.Image;

import java.util.List;

public class UserGalleryFragment extends Fragment {

    UserGalleryViewModel userGalleryViewModel;
    Integer userId;
    RecyclerView rvUserGallery;

    public UserGalleryFragment(Integer userId){
        this.userId = userId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        userGalleryViewModel = ViewModelProviders.of(this).get(UserGalleryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_user_gallery, container, false);
        rvUserGallery = root.findViewById(R.id.rvUserGallery);

        userGalleryViewModel.setUserId(userId);
        userGalleryViewModel.getImages(inflater.getContext()).observe(getViewLifecycleOwner(), new Observer<List<Image>>() {
            @Override
            public void onChanged(List<Image> images) {
                ImageAdapter imageAdapter = new ImageAdapter(getContext(), images, 2);
                rvUserGallery.setLayoutManager(new GridLayoutManager(getContext(),3));
                rvUserGallery.setAdapter(imageAdapter);
            }
        });

        return root;
    }
}
