package com.example.admin.gmchallenge.data.di.component;


import com.example.admin.gmchallenge.data.di.module.AppModule;
import com.example.admin.gmchallenge.data.di.module.EventDetailModule;
import com.example.admin.gmchallenge.data.di.module.EventListModule;

import dagger.Component;

/**
 * Created by Luis on 3/13/18.
 */

@Component(modules = AppModule.class)
public interface AppComponent {


    EventListComponent plus(EventListModule eventListModule);

    EventDetailComponent plus(EventDetailModule eventDetailModule);

}
