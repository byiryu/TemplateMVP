package com.byiryu.templatemvp.ui.fragment.D;

import com.byiryu.templatemvp.ui.base.BasePresenter;


import javax.inject.Inject;

public class DPresenter<V extends DContract.View> extends BasePresenter<V> implements DContract.Presenter<V> {

    private static final String TAG = "DContract";

    private DContract.View view ;

    @Inject
    DPresenter(){
        super();
    }

}
