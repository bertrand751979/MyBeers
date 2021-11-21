package com.example.mybeers.fragment;

import static com.example.mybeers.activity.MainActivity.BEER_LIST_KEY;
import static com.example.mybeers.activity.MainActivity.EXTRA_LIST_KEY;
import static com.example.mybeers.activity.MainActivity.FAVORITE_LIST_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybeers.OnImageStarClickedAction;
import com.example.mybeers.OnLinearClickedAction;
import com.example.mybeers.R;
import com.example.mybeers.SharedPreferencesManager;
import com.example.mybeers.activity.ScrollingActivity;
import com.example.mybeers.adapter.BeerAdapter;
import com.example.mybeers.model.Root;

import java.util.ArrayList;

public class FragmentDisplayBeer extends Fragment{
  private RecyclerView recyclerView;
  private BeerAdapter adapterBeer;
  private ArrayList<Root>listBeer;
  private ArrayList<Root> myFavoriteList = new ArrayList<>();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    listBeer= new ArrayList<Root>(SharedPreferencesManager.getInstance(this.getContext()).getBeerList(BEER_LIST_KEY));
  }


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    setHasOptionsMenu(true);
    return inflater.inflate(R.layout.fragment_list_beer, container, false);

  }


  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.recycler_view_list_beer);
    setViewItem();

  }

  private void setViewItem(){
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    OnImageStarClickedAction onImageStarClickedAction = new OnImageStarClickedAction() {
      @Override
      public void addToFavorite(Root root) {
      myFavoriteList.add(root);
      SharedPreferencesManager.getInstance(FragmentDisplayBeer.this.getContext()).addBeerToListFavorite(root,FAVORITE_LIST_KEY);
        Toast.makeText(FragmentDisplayBeer.this.getContext(), "Ajoutée aux Favoris", Toast.LENGTH_SHORT).show();
      }
    };
    OnLinearClickedAction onLinearClickedAction = new OnLinearClickedAction() {
      @Override
      public void intentDescription(Root root) {
          Intent intent = new Intent(FragmentDisplayBeer.this.getContext(), ScrollingActivity.class);
          intent.putExtra(EXTRA_LIST_KEY,root);
          startActivity(intent);
        Toast.makeText(FragmentDisplayBeer.this.getContext(), "Vers descriptif", Toast.LENGTH_SHORT).show();
      }
    };
    adapterBeer = new BeerAdapter(listBeer,onImageStarClickedAction, onLinearClickedAction);
    recyclerView.setAdapter(adapterBeer);

  }

}
