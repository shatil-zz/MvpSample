package com.sample.mosbysample.mvp.core;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public interface MvpCorePresenter<V extends MvpCoreView> extends MvpPresenter<V>{
    void loadData();
}
