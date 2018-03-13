package com.example.admin.gmchallenge.data.view.eventlist;


import com.example.admin.gmchallenge.data.model.Meetup;
import com.example.admin.gmchallenge.data.utils.BasePresenter;
import com.example.admin.gmchallenge.data.utils.BaseView;

import java.util.List;

/**
 * Created by Luis on 3/13/18.
 */

public interface EventListContract {

    interface View extends BaseView {

        void onEventsReceived(List<Meetup> meetupList);

        void onPermissionCheck();

        void onCurrentLocation();


    }

    interface Presenter extends BasePresenter<View> {

        void getEventList(String lat, String lon);

        void getCurrentLocation();

        void checkPermission();
    }

}
