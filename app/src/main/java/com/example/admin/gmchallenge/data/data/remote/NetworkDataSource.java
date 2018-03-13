package com.example.admin.gmchallenge.data.data.remote;


import com.example.admin.gmchallenge.data.model.Meetup;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luis on 3/13/18.
 */

public class NetworkDataSource {


    String baseUrl;
    File cacheFile;
    String key;

    public NetworkDataSource(String baseUrl, String key) {
        this.baseUrl = baseUrl;
        // TODO: 3/13/18 Implement caching
        this.cacheFile = cacheFile;
        this.key = key;
    }

    public Retrofit getClient(){
        //Create a logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        //get a client for the adding the interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }

    public Observable<List<Meetup>> getEvents(String lat, String lon) {

        return getClient().create(NetworkService.class).getEventList(lat, lon, key);

    }
}
