package com.example.mybeers.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mybeers.OnImageStarClickedAction;
import com.example.mybeers.OnLinearClickedAction;
import com.example.mybeers.R;
import com.example.mybeers.model.Root;

public class BeerViewHolder extends RecyclerView.ViewHolder {
    private TextView vhName;
    private TextView vhTagline;
    private TextView vhDescription;
    private ImageView vhBeerPhoto;
    private ImageView vhImgStar;
    private LinearLayout vhbtnLinearLayout;

    public BeerViewHolder(@NonNull View view) {
        super(view);
        vhName =view.findViewById(R.id.raw_name);
        vhTagline =view.findViewById(R.id.raw_tagline);
        vhDescription =view.findViewById(R.id.raw_description);
        vhBeerPhoto =view.findViewById(R.id.raw_img_beer);
        vhImgStar =view.findViewById(R.id.raw_star);
        vhbtnLinearLayout =view.findViewById(R.id.linear_layout);
    }

    public TextView getVhName() {
        return vhName;
    }

    public void setVhName(TextView vhName) {
        this.vhName = vhName;
    }

    public TextView getVhTagline() {
        return vhTagline;
    }

    public void setVhTagline(TextView vhTagline) {
        this.vhTagline = vhTagline;
    }

    public TextView getVhDescription() {
        return vhDescription;
    }

    public void setVhDescription(TextView vhDescription) {
        this.vhDescription = vhDescription;
    }

    public ImageView getVhBeerPhoto() {
        return vhBeerPhoto;
    }

    public void setVhBeerPhoto(ImageView vhBeerPhoto) {
        this.vhBeerPhoto = vhBeerPhoto;
    }

    public ImageView getVhImgStar() {
        return vhImgStar;
    }

    public void setVhImgStar(ImageView vhImgStar) {
        this.vhImgStar = vhImgStar;
    }

    public LinearLayout getBtnLinearLayout() {
        return vhbtnLinearLayout;
    }

    public void setBtnLinearLayout(LinearLayout btnLinearLayout) {
        this.vhbtnLinearLayout = btnLinearLayout;
    }

    public void bind(Root root, OnImageStarClickedAction onImageStarClickedAction, OnLinearClickedAction onLinearClickedAction){
        vhName.setText(root.getName());
        vhDescription.setText(root.getDescription());
        vhTagline.setText(root.getTagline());
        vhImgStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageStarClickedAction.addToFavorite(root);
            }
        });
        Glide.with(vhBeerPhoto.getContext())
                .load(root.getImage_url())
                .into(vhBeerPhoto);
        vhbtnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLinearClickedAction.intentDescription(root);
            }
        });

    }



}
