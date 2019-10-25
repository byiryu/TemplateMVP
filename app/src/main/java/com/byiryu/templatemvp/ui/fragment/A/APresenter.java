package com.byiryu.templatemvp.ui.fragment.A;

import com.byiryu.templatemvp.ui.base.BasePresenter;
import javax.inject.Inject;

public class APresenter<V extends AContract.View> extends BasePresenter<V> implements AContract.Presenter<V> {

    private static final String TAG = "APresenter";

    private AContract.View view ;

    @Inject
    APresenter(){
        super();
    }
}
