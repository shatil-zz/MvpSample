package com.sample.mosbysample.mvp.transaction;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.sample.mosbysample.model.ErrorViewModel;
import com.sample.mosbysample.model.TransactionModel;
import com.sample.mosbysample.model.SuccessViewModel;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public class TransactionListPresenterImp extends MvpBasePresenter<TransactionListContract.View> implements TransactionListContract.Presenter {

    Scheduler asyncScheduler, uiScheduler;
    Disposable disposable;

    public TransactionListPresenterImp(Scheduler asyncScheduler, Scheduler uiScheduler) {
        this.uiScheduler = uiScheduler;
        this.asyncScheduler = asyncScheduler;
    }

    @Override
    public void loadData() {
        ifViewAttached(view -> {
            view.startLoad();
        });
        disposable = loadListData()
                .observeOn(uiScheduler)
                .subscribeOn(asyncScheduler)
                .subscribe(items -> {
                    ifViewAttached(view -> {
                        view.showData(items);
                        view.success(new SuccessViewModel());
                    });
                }, throwable -> {
                    ifViewAttached(view -> {
                        view.error(new ErrorViewModel(0, 0, true));
                    });
                });
    }

    public Observable<List<TransactionModel>> loadListData() {
        return Observable.fromCallable(() ->
        {
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
        });
    }

    @Override
    public void destroy() {
        super.destroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
