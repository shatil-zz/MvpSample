package com.sample.mosbysample.model;

/**
 * Created by Shahanur on 15-Mar-18.
 */

public class SuccessViewModel {
    private int successType;
    private int successCode;
    private boolean isFinished;
    String TAG;


    public SuccessViewModel() {
        this(0, 0);
    }

    public SuccessViewModel(int successType, int successCode) {
        this(successType, successCode, false);
    }

    public SuccessViewModel(int successType, int successCode, boolean isFinished) {
        this.successType = successType;
        this.successCode = successCode;
        this.isFinished = isFinished;
    }

    public int getSuccessType() {
        return successType;
    }

    public void setSuccessType(int successType) {
        this.successType = successType;
    }

    public int getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(int successCode) {
        this.successCode = successCode;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }
}
