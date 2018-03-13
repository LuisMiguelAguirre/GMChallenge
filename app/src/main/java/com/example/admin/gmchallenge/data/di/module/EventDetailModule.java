package com.example.admin.gmchallenge.data.di.module;

import com.example.admin.gmchallenge.data.di.scope.ActivityScope;
import com.example.admin.gmchallenge.data.view.eventdetail.EventDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Luis on 3/13/18.
 */

@ActivityScope
@Module
public class EventDetailModule {

    @Provides
    @ActivityScope
    EventDetailPresenter providesEventDetailPresenter(){
        return new EventDetailPresenter();
    }


}
