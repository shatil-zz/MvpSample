package com.sample.mosbysample.mvp.home;

import com.sample.mosbysample.model.HomeModel;
import com.sample.mosbysample.model.SuccessViewModel;
import com.sample.mosbysample.mvp.core.MvpCorePresenterImp;

/**
 * Created by Shahanur on 18-Mar-18.
 */

public class HomePresenterImp extends MvpCorePresenterImp<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void loadData() {
        if (hasView()) {
            getViewInterface().startLoad();
            HomeModel model = new HomeModel();
            model.setName("John");
            model.setTitle("Mosby Test");
            getViewInterface().showData(model, false);
            getViewInterface().success(new SuccessViewModel());
        }
    }
}
