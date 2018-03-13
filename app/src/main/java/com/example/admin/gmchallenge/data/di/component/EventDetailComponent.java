package com.example.admin.gmchallenge.data.di.component;

import com.example.admin.gmchallenge.data.di.module.EventDetailModule;
import com.example.admin.gmchallenge.data.di.scope.ActivityScope;
import com.example.admin.gmchallenge.data.view.eventdetail.EventDetailActivity;

import dagger.Subcomponent;

/**
 * Created by Luis on 3/13/18.
 */

@ActivityScope
@Subcomponent(modules = EventDetailModule.class)
public interface EventDetailComponent {

    void inject(EventDetailActivity eventDetailActivity);
}
