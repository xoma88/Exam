package com.example.exam.ui.myGallery;

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

import com.example.exam.R;

public class MyGalleryFragment extends Fragment {

    private MyGalleryViewModel myGalleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myGalleryViewModel =
                ViewModelProviders.of(this).get(MyGalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_gallery, container, false);
        //final TextView textView = root.findViewById(R.id.text_myGallery);
        //myGalleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
        //    }
        //});
        return root;
    }
}