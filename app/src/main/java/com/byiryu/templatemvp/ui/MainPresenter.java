package com.byiryu.templatemvp.ui;

import com.byiryu.templatemvp.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter<V extends MainContract.View> extends BasePresenter<V> implements MainContract.Presenter<V>{


    private static final String TAG = "MainPresenter";


    @Inject
    MainPresenter(){
        super();
    }

}
