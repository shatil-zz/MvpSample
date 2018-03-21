package com.sample.mosbysample.mvp.transaction;


import java.util.List;

import com.sample.mosbysample.model.TransactionModel;
import com.sample.mosbysample.mvp.core.MvpCorePresenter;
import com.sample.mosbysample.mvp.core.MvpCoreView;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public interface TransactionListContract {

    public interface View extends MvpCoreView {
        void showData(List<TransactionModel> modelList);
    }

    public interface Presenter extends MvpCorePresenter<View> {
    }
}
