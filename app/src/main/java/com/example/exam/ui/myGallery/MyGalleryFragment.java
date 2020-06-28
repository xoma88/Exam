package com.example.exam.ui.myGallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam.R;

public class MyGalleryFragment extends Fragment {

    private MyGalleryViewModel myGalleryViewModel;

    RecyclerView rvMyGallery;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myGalleryViewModel = ViewModelProviders.of(this).get(MyGalleryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_my_gallery, container, false);

        rvMyGallery = root.findViewById(R.id.rvMyGallery);

        return root;
    }
}