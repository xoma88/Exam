package com.example.exam.ui.infoImage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.exam.R;
import com.example.exam.models.Image;
import com.example.exam.ui.home.HomeFragment;
import com.example.exam.ui.userGallery.UserGalleryFragment;
import com.squareup.picasso.Picasso;

public class InfoImageFragment extends Fragment {

    private InfoImageViewModel infoImageViewModel;

    Image image;
    ImageView imageInfo;
    TextView tvName, tvAuthor, tvDescription, tvPath;
    Button btnCancel;
    int fragment;

    public InfoImageFragment(Image image, int fragment){
        this.image = image;
        this.fragment = fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        infoImageViewModel = ViewModelProviders.of(this).get(InfoImageViewModel.class);

        View root = inflater.inflate(R.layout.fragment_info_image, container, false);

        imageInfo = root.findViewById(R.id.ivinfoimage);
        tvName = root.findViewById(R.id.tvName);
        tvAuthor = root.findViewById(R.id.tvAuthor);
        tvDescription = root.findViewById(R.id.tvDescription);
        tvPath = root.findViewById(R.id.tvPath);
        btnCancel = root.findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragment == 1) {
                    ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, new HomeFragment())
                            .commit();
                }
                else if (fragment == 2){
                    ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, new UserGalleryFragment(image.getAuthorId()))
                            .commit();
                }
            }
        });

        tvAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity)v.getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, new UserGalleryFragment(image.getAuthorId()))
                        .commit();
            }
        });

        infoImageViewModel.setImage(image);
        infoImageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<Image>() {
            @Override
            public void onChanged(Image image) {
                Picasso.get().load(String.valueOf(image.getUrl())).into(imageInfo);
                tvName.setText(image.getName());
                tvAuthor.setText(image.getAuthor());
                tvDescription.setText(image.getDescription());
                tvPath.setText(image.getUrl());
            }
        });

        return root;
    }
}
