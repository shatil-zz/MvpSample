package com.sample.mosbysample.mvp.transaction;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import com.sample.mosbysample.model.TransactionModel;
import com.sample.mosbysample.model.SuccessViewModel;
import com.sample.mosbysample.mvp.core.MvpCorePresenterImp;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public class TransactionListPresenterImp extends MvpCorePresenterImp<TransactionListContract.View> implements TransactionListContract.Presenter {


    Scheduler asyncScheduler, uiScheduler;
    Disposable disposable;

    public TransactionListPresenterImp(Scheduler asyncScheduler, Scheduler uiScheduler) {
        this.uiScheduler = uiScheduler;
        this.asyncScheduler = asyncScheduler;
    }

    @Override
    public void loadData() {
        getViewInterface().startLoad();
        disposable = Observable.fromCallable(() -> loadListData())
                .observeOn(uiScheduler)
                .subscribeOn(asyncScheduler)
                .subscribe(items -> {
                    if (hasView()) {
                        getViewInterface().showData(items);
                        getViewInterface().success(new SuccessViewModel());
                    }
                });
    }

    public List<TransactionModel> loadListData() {
        SystemClock.sleep(5000);
        Random random = new Random(30);
        List<TransactionModel> listModels = new ArrayList<>();
        for (int count = 0; count < 50; count++) {
            TransactionModel model = new TransactionModel();
            model.setAmount(random.nextInt(2000) + 50);
            model.setTitle("Demo Name" + (count + 1));
            model.setId(count);
            listModels.add(model);
        }
        return listModels;
    }

    @Override
    public void destroy() {
        super.destroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
