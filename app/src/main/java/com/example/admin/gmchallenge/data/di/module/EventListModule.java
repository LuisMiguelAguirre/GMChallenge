package com.example.admin.gmchallenge.data.di.module;


import com.example.admin.gmchallenge.data.di.scope.ActivityScope;
import com.example.admin.gmchallenge.data.data.remote.NetworkDataSource;
import com.example.admin.gmchallenge.data.view.eventlist.EventListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Luis on 3/13/18.
 */
@ActivityScope
@Module
public class EventListModule {

    @Provides
    @ActivityScope
    EventListPresenter providesEVentListPresenter(NetworkDataSource networkDataSource){
        return new EventListPresenter(networkDataSource);
    }
}
