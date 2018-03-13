package com.example.admin.gmchallenge.data.view.eventlist;

import android.util.Log;

import com.example.admin.gmchallenge.data.model.Meetup;
import com.example.admin.gmchallenge.data.data.remote.NetworkDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Luis on 3/13/18.
 */

public class EventListPresenter implements EventListContract.Presenter, Observer<List<Meetup>> {


    EventListContract.View view;
    NetworkDataSource networkDataSource;

    @Inject
    public EventListPresenter(NetworkDataSource networkDataSource) {
        this.networkDataSource = networkDataSource;

    }

    @Override
    public void attachView(EventListContract.View view) {
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
    public void getEventList(String lat, String lon) {


        networkDataSource.getEvents(lat, lon)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                // TODO: 3/13/18 Implement flatmap to clean meetup objects
                .subscribe(this);

    }

    @Override
    public void getCurrentLocation() {

        view.onCurrentLocation();

    }

    @Override
    public void checkPermission() {

        view.onPermissionCheck();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<Meetup> meetups) {

        Log.d("TAG", "onNext: " + meetups.size());
        view.onEventsReceived(meetups);
    }

    @Override
    public void onError(Throwable e) {
        view.onErrorReceived(e.toString());
    }

    @Override
    public void onComplete() {

    }
}
