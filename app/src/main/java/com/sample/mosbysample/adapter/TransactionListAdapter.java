package com.sample.mosbysample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.sample.mosbysample.R;
import com.sample.mosbysample.model.TransactionModel;

/**
 * Created by Shahanur on 20-Mar-18.
 */

public class TransactionListAdapter extends ArrayAdapter<TransactionModel>{

    public TransactionListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public TransactionListAdapter(@NonNull Context context, int resource, @NonNull List<TransactionModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.adapter_transaction_list, null);
        }
        TransactionModel model=getItem(position);
        if(model!=null)
        {
            ((TextView)v.findViewById(R.id.tv1)).setText(model.getTitle());
            ((TextView)v.findViewById(R.id.tv2)).setText(Html.fromHtml("Transaction Amount: <b>"+model.getAmount()+"</b>"));
        }
        return v;
    }
}
