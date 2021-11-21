package com.example.mybeers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybeers.OnImageStarClickedAction;
import com.example.mybeers.OnLinearClickedAction;
import com.example.mybeers.R;
import com.example.mybeers.model.Root;
import com.example.mybeers.viewHolder.BeerViewHolder;

import java.util.ArrayList;

public class BeerAdapter extends RecyclerView.Adapter<BeerViewHolder> {
    private ArrayList<Root>listAdapter;
    private OnImageStarClickedAction onImageStarClickedAction;
    private OnLinearClickedAction onLinearClickedAction;

    public BeerAdapter(ArrayList<Root> listAdapter, OnImageStarClickedAction onImageStarClickedAction, OnLinearClickedAction onLinearClickedAction) {
        this.listAdapter = listAdapter;
        this.onImageStarClickedAction = onImageStarClickedAction;
        this.onLinearClickedAction = onLinearClickedAction;
    }

    public void setListAdapter(ArrayList<Root> listAdapter) {
        this.listAdapter = listAdapter;
    }

    @NonNull
    @Override
    public BeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_beer,parent,false);
        return new BeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeerViewHolder holder, int position) {
        holder.bind(listAdapter.get(position),onImageStarClickedAction,onLinearClickedAction );
    }

    @Override
    public int getItemCount() {
        return listAdapter.size();
    }
}
