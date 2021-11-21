package com.example.mybeers;

import com.example.mybeers.model.Root;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MyBeerApi {
    public interface MyBeerService{
            @GET("beers")
        Call<List<Root>>getBeers();
    }
    private final static String BASE_URL="https://api.punkapi.com/v2/";
    private static MyBeerApi INSTANCE = null;
    private MyBeerApi(){}
    public static MyBeerApi getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MyBeerApi();
        }
        return INSTANCE;
    }

    public Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }




}
