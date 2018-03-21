package com.sample.mosbysample.mvp.core;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import com.sample.mosbysample.model.ErrorViewModel;
import com.sample.mosbysample.model.SuccessViewModel;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public interface MvpCoreView extends MvpView{
    void startLoad();
    void success(SuccessViewModel result);
    void error(ErrorViewModel result);
}
