package com.example.overdfrg.BaseActivity;


public interface ICommonView<T> {
    void onError(int whichApi, Throwable e);
    void onResponse(int whichApi, T... t);
}
