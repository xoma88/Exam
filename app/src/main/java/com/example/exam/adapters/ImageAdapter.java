package com.example.exam.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam.R;
import com.example.exam.ui.infoImage.InfoImageFragment;
import com.example.exam.models.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Image> images;
    int fragment;


    public ImageAdapter (Context context, List<Image> images, int fragment){
        this.inflater = LayoutInflater.from(context);
        this.images = images;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_image_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Image image = images.get(position);

        Picasso.get().load(String.valueOf(image.getUrl())).into(holder.imageGallery);

        holder.imageGallery.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                ((AppCompatActivity)v.getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, new InfoImageFragment(image, fragment))
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageGallery;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageGallery = itemView.findViewById(R.id.imageGallery);
        }
    }
}
