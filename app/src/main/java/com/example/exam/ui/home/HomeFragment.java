package com.example.exam.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView rvHome;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = root.findViewById(R.id.rvHome);

        homeViewModel.getImages().observe(getViewLifecycleOwner(), new Observer<List<Image>>() {
            @Override
            public void onChanged(List<Image> images) {
                ImageAdapter imageAdapter = new ImageAdapter(getContext(), images, 1);
                rvHome.setLayoutManager(new GridLayoutManager(getContext(),3));
                rvHome.setAdapter(imageAdapter);
            }
        });
        return root;
    }
}