package com.example.admin.gmchallenge.data.view.eventdetail;

import com.example.admin.gmchallenge.data.model.Meetup;
import com.example.admin.gmchallenge.data.utils.BasePresenter;
import com.example.admin.gmchallenge.data.utils.BaseView;

/**
 * Created by Luis on 3/13/18.
 */

public interface EventDetailContract {

    interface View extends BaseView {

        void onEventDetailReceived(Meetup meetup);

    }

    interface Presenter extends BasePresenter<View> {

        void getEventDetail(Meetup meetup);
    }

}
