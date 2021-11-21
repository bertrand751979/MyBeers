package com.example.mybeers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybeers.R;
import com.example.mybeers.model.Root;
import com.example.mybeers.viewHolder.FavoriteBeerViewHolder;
import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteBeerViewHolder> {
    private ArrayList<Root> listAdapterFavorite;

    public FavoriteAdapter(ArrayList<Root> listAdapterFavorite) {
        this.listAdapterFavorite = listAdapterFavorite;
    }

    public void setListAdapterFavorite(ArrayList<Root> listAdapterFavorite) {
        this.listAdapterFavorite = listAdapterFavorite;
    }

    @NonNull
    @Override
    public FavoriteBeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_favorite,parent,false);
        return new FavoriteBeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteBeerViewHolder holder, int position) {
        holder.bind(listAdapterFavorite.get(position));
    }

    @Override
    public int getItemCount() {
        return listAdapterFavorite.size();
    }
}
