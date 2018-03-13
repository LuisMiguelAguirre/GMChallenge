package com.example.admin.gmchallenge.data.utils;

/**
 * Created by Luis on 3/13/18.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

    void showError(String error);

}
