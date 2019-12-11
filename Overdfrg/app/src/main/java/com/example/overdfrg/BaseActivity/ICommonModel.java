package com.example.overdfrg.BaseActivity;


public interface ICommonModel<T> {
    void getData(ICommonView view, int whichApi, T... t);
}
