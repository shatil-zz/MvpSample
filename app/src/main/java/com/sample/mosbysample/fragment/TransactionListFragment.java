package com.sample.mosbysample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import com.sample.mosbysample.R;
import com.sample.mosbysample.adapter.TransactionListAdapter;
import com.sample.mosbysample.model.TransactionModel;
import com.sample.mosbysample.model.ErrorViewModel;
import com.sample.mosbysample.model.SuccessViewModel;
import com.sample.mosbysample.mvp.home.TransactionListContract;
import com.sample.mosbysample.mvp.home.TransactionListPresenterImp;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public class TransactionListFragment extends MvpFragment<TransactionListContract.View, TransactionListContract.Presenter> implements TransactionListContract.View {
    ListView listView;
    TransactionListAdapter adapter;

    @Override
    public TransactionListContract.Presenter createPresenter() {
        return new TransactionListPresenterImp(Schedulers.computation(), AndroidSchedulers.mainThread());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_list, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new TransactionListAdapter(getContext(), R.layout.adapter_transaction_list, new ArrayList<TransactionModel>());
        listView.setAdapter(adapter);
        getPresenter().loadData();
    }

    @Override
    public void startLoad() {

    }

    @Override
    public void success(SuccessViewModel result) {

    }

    @Override
    public void error(ErrorViewModel result) {

    }

    @Override
    public void showData(List<TransactionModel> modelList) {
        adapter.addAll(modelList);
        adapter.notifyDataSetChanged();
    }
}
