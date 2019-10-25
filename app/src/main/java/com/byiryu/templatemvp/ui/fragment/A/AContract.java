package com.byiryu.templatemvp.ui.fragment.A;


import com.byiryu.templatemvp.ui.base.BaseContract;

public interface AContract {
    interface Presenter<V extends AContract.View> extends BaseContract.Presenter<V> {

    }

    interface View extends BaseContract.View {

    }
}
