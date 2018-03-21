package com.sample.mosbysample.mvp.core;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public class MvpCorePresenterImp<V extends MvpCoreView> extends MvpBasePresenter<V> {

    V view;

    @Override
    public void attachView(V view) {
            super.attachView(view);
        this.view = view;
    }

    public boolean hasView() {
        return view != null;
    }

    public V getViewInterface() {
        return view;
    }

}
