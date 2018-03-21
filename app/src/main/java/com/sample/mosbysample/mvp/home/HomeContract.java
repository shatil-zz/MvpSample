package com.sample.mosbysample.mvp.home;
import com.sample.mosbysample.model.HomeModel;
import com.sample.mosbysample.mvp.core.MvpCorePresenter;
import com.sample.mosbysample.mvp.core.MvpCoreView;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public interface HomeContract {
    public interface View extends MvpCoreView {
        void showData(HomeModel model, boolean isProgress);
    }

    public interface Presenter extends MvpCorePresenter<View> {
    }
}
