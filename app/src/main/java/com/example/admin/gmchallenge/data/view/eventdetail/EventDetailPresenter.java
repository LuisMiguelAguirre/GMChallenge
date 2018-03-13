package com.example.admin.gmchallenge.data.view.eventdetail;


import com.example.admin.gmchallenge.data.model.Meetup;

/**
 * Created by Luis on 3/13/18.
 */

public class EventDetailPresenter implements EventDetailContract.Presenter{

    EventDetailContract.View view;


    @Override
    public void attachView(EventDetailContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }

    @Override
    public void showError(String error) {
        view.onErrorReceived(error);
    }

    @Override
    public void getEventDetail(Meetup meetup) {


        // TODO: 3/13/18 Clean meetup object for description
        view.onEventDetailReceived(meetup);
    }
}
