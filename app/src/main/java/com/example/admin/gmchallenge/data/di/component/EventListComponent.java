package com.example.admin.gmchallenge.data.di.component;

import com.example.admin.gmchallenge.data.di.module.EventListModule;
import com.example.admin.gmchallenge.data.di.scope.ActivityScope;
import com.example.admin.gmchallenge.data.view.eventlist.EventListActivity;

import dagger.Subcomponent;

/**
 * Created by Luis on 3/13/18.
 */
@ActivityScope
@Subcomponent(modules = EventListModule.class)
public interface EventListComponent {

    void inject(EventListActivity eventListActivity);

}
