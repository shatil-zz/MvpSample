package com.sample.mosbysample.model;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public class TransactionModel {
    int id;
    String title;
    long amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
