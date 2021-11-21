package com.example.mybeers.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mybeers.R;
import com.example.mybeers.model.Root;

public class FavoriteBeerViewHolder extends RecyclerView.ViewHolder {
    private TextView vhFavoriteName;
    private TextView vhFavoriteTagline;
    private TextView vhFavoriteDescription;
    private ImageView vhFavoriteBeerPhoto;

    public FavoriteBeerViewHolder(@NonNull View view) {
        super(view);
        vhFavoriteName = view.findViewById(R.id.raw_favorite_name);
        vhFavoriteTagline = view.findViewById(R.id.raw_favorite_tagline);
        vhFavoriteDescription = view.findViewById(R.id.raw_favorite_description);
        vhFavoriteBeerPhoto = view.findViewById(R.id.raw_favorite_img_beer);
    }

    public TextView getVhFavoriteName() {
        return vhFavoriteName;
    }

    public void setVhFavoriteName(TextView vhFavoriteName) {
        this.vhFavoriteName = vhFavoriteName;
    }

    public TextView getVhFavoriteTagline() {
        return vhFavoriteTagline;
    }

    public void setVhFavoriteTagline(TextView vhFavoriteTagline) {
        this.vhFavoriteTagline = vhFavoriteTagline;
    }

    public TextView getVhFavoriteDescription() {
        return vhFavoriteDescription;
    }

    public void setVhFavoriteDescription(TextView vhFavoriteDescription) {
        this.vhFavoriteDescription = vhFavoriteDescription;
    }

    public ImageView getVhFavoriteBeerPhoto() {
        return vhFavoriteBeerPhoto;
    }

    public void setVhFavoriteBeerPhoto(ImageView vhFavoriteBeerPhoto) {
        this.vhFavoriteBeerPhoto = vhFavoriteBeerPhoto;
    }

    public void bind (Root root){
        vhFavoriteName.setText(root.getName());
        vhFavoriteTagline.setText(root.getTagline());
        vhFavoriteDescription.setText(root.getDescription());
        Glide.with(vhFavoriteBeerPhoto.getContext())
                .load(root.getImage_url())
                .into(vhFavoriteBeerPhoto);
    }

}
