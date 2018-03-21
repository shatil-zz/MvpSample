package com.sample.mosbysample.model;

/**
 * Created by Shahanur on 15-Mar-18.
 */

public class ErrorViewModel {

    private int errorType;
    private int errorCode;
    private boolean isFinished;

    public ErrorViewModel(int errorType, int errorCode, boolean isFinished) {
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.isFinished = isFinished;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

}
