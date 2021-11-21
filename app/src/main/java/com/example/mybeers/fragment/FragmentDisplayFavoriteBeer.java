package com.example.mybeers.fragment;

import static com.example.mybeers.activity.MainActivity.EXTRA_LIST_KEY;
import static com.example.mybeers.activity.MainActivity.FAVORITE_LIST_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybeers.R;
import com.example.mybeers.SharedPreferencesManager;
import com.example.mybeers.adapter.FavoriteAdapter;
import com.example.mybeers.model.Root;

import java.util.ArrayList;

public class FragmentDisplayFavoriteBeer extends Fragment {
    private RecyclerView recyclerView;
    private FavoriteAdapter adapterFavorite;
    private ArrayList<Root> listFavoriteBeer;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listFavoriteBeer = new ArrayList<Root>(SharedPreferencesManager.getInstance(this.getContext()).getFavoriteBeerList(FAVORITE_LIST_KEY));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_list_favorite);
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager( new LinearLayoutManager(this.getContext()));
        adapterFavorite = new FavoriteAdapter(listFavoriteBeer);
        recyclerView.setAdapter(adapterFavorite);
    }

}
