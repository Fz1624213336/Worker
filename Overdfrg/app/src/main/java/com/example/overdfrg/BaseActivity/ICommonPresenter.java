package com.example.overdfrg.BaseActivity;


public interface ICommonPresenter<T> {
    void getData(int whichApi, T... t);
}
