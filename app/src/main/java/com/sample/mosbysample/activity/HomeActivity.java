package com.sample.mosbysample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import com.sample.mosbysample.fragment.TransactionListFragment;
import com.sample.mosbysample.model.ErrorViewModel;
import com.sample.mosbysample.model.HomeModel;
import com.sample.mosbysample.R;
import com.sample.mosbysample.model.SuccessViewModel;
import com.sample.mosbysample.mvp.home.HomeContract;
import com.sample.mosbysample.mvp.home.HomePresenterImp;

public class HomeActivity extends MvpActivity<HomeContract.View, HomeContract.Presenter> implements HomeContract.View {

    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activity = this;
        TransactionListFragment transactionListFragment = new TransactionListFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.demo_fragment, transactionListFragment);
        ft.commit();
        getPresenter().loadData();
    }

    @Override
    public HomeContract.Presenter createPresenter() {
        return new HomePresenterImp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override
    public void startLoad() {

    }

    @Override
    public void showData(HomeModel model, boolean isProgress) {
        ((TextView) findViewById(R.id.name)).setText(model.getName());
        ((TextView) findViewById(R.id.title)).setText(model.getTitle());
    }

    @Override
    public void success(SuccessViewModel result) {

    }

    @Override
    public void error(ErrorViewModel result) {

    }
}
