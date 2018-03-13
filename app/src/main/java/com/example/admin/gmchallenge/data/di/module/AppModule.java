package com.example.admin.gmchallenge.data.di.module;


import com.example.admin.gmchallenge.data.data.remote.NetworkDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Luis 3/13/18.
 */

@Module
public class AppModule {


    String baseUrl;
    String key;

    public AppModule(String baseUrl, String key) {
        this.baseUrl = baseUrl;
        this.key = key;
    }

    @Provides
    NetworkDataSource providesNetworkDataSource(){
        return new NetworkDataSource(baseUrl, key);
    }
}
