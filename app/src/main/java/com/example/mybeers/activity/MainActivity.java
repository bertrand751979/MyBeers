package com.example.mybeers.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mybeers.MyBeerApi;
import com.example.mybeers.R;
import com.example.mybeers.SharedPreferencesManager;
import com.example.mybeers.fragment.FragmentDisplayBeer;
import com.example.mybeers.fragment.FragmentDisplayFavoriteBeer;
import com.example.mybeers.model.Root;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private ArrayList<Root> myListBeer = new ArrayList<>();
    public static String BEER_LIST_KEY = "beerListKey";
    public static String EXTRA_LIST_KEY= "extraListKey";
    public static String FAVORITE_LIST_KEY= "extraListKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        callService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNav.setSelectedItemId(R.id.nav_beer);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_beer:
                    selectedFragment = new FragmentDisplayBeer();
                    break;
            }

            switch (item.getItemId()) {
                case R.id.nav_favorite:
                    selectedFragment = new FragmentDisplayFavoriteBeer();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    public void callService(){
        MyBeerApi.MyBeerService service =  MyBeerApi.getInstance().getClient().create(MyBeerApi.MyBeerService.class);
        Call<List<Root>> call= service.getBeers();
        call.enqueue(new Callback<List<Root>>() {
            @Override
            public void onResponse(Call<List<Root>> call, Response<List<Root>> response) {
                updateView(response);
            }

            @Override
            public void onFailure(Call<List<Root>> call, Throwable t) {

            }
            });


    }

    private void updateView(Response<List<Root>> response) {
        if (response.body().size() > 0) {
            myListBeer = (ArrayList<Root>) response.body();
            Log.e("la liste", String.valueOf(myListBeer.size()));
            SharedPreferencesManager.getInstance(this).saveBeerList(myListBeer, BEER_LIST_KEY);
            Toast.makeText(MainActivity.this, "Reponse du serveur", Toast.LENGTH_SHORT).show();
        }
    }














}