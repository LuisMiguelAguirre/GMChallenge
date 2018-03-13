package com.example.admin.gmchallenge.data;

import android.app.Application;
import android.content.Context;

import com.example.admin.gmchallenge.BuildConfig;
import com.example.admin.gmchallenge.data.di.component.AppComponent;
import com.example.admin.gmchallenge.data.di.component.DaggerAppComponent;
import com.example.admin.gmchallenge.data.di.component.EventDetailComponent;
import com.example.admin.gmchallenge.data.di.component.EventListComponent;
import com.example.admin.gmchallenge.data.di.module.AppModule;
import com.example.admin.gmchallenge.data.di.module.EventDetailModule;
import com.example.admin.gmchallenge.data.di.module.EventListModule;

/**
 * Created by Luis on 3/13/18.
 */

public class GMApplication extends Application {

    private AppComponent appComponent;
    private EventListComponent recipeListComponent;
    public static final String BASEURL = BuildConfig.BASEURL;
    public static final String KEY = BuildConfig.key;


    private EventDetailComponent recipeDetailComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(BASEURL, KEY);
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();

    }

    public static GMApplication get(Context context) {
        return (GMApplication) context.getApplicationContext();
    }


    public EventListComponent getEventListComponent() {

        recipeListComponent = appComponent.plus(new EventListModule());
        return recipeListComponent;
    }

    public EventDetailComponent getEventDetailComponent() {

        recipeDetailComponent = appComponent.plus(new EventDetailModule());
        return recipeDetailComponent;
    }

    public void clearEventListComponent() {
        recipeListComponent = null;

    }

    public void clearEventDetailComponent() {
        recipeListComponent = null;

    }
}
