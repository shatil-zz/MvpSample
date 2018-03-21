package com.sample.mosbysample.mvp.home;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.sample.mosbysample.model.HomeModel;
import com.sample.mosbysample.model.SuccessViewModel;

/**
 * Created by Shahanur on 18-Mar-18.
 */

public class HomePresenterImp extends MvpBasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void loadData() {
        ifViewAttached(view -> {
            view.startLoad();
        });
        HomeModel model = new HomeModel();
        model.setName("John");
        model.setTitle("Mosby Test");
        ifViewAttached(view -> {
            view.showData(model, false);
            view.success(new SuccessViewModel());
        });
    }
}
