package com.byiryu.templatemvp.ui;


import com.byiryu.templatemvp.di.scope.ActivityScoped;
import com.byiryu.templatemvp.ui.base.BaseContract;

public interface MainContract {

    @ActivityScoped
    interface Presenter<V extends View> extends BaseContract.Presenter<V> {

    }

    interface View extends BaseContract.View {
    }
}
