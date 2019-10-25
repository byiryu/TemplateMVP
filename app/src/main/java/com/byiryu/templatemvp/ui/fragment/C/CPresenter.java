package com.byiryu.templatemvp.ui.fragment.C;

import com.byiryu.templatemvp.ui.base.BasePresenter;


import javax.inject.Inject;

public class CPresenter<V extends CContract.View> extends BasePresenter<V> implements CContract.Presenter<V> {

    private static final String TAG = "CPresenter";

    @Inject
    CPresenter(){
        super();
    }
}
