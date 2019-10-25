package com.byiryu.templatemvp.ui.fragment.D;


import com.byiryu.templatemvp.ui.base.BaseContract;

public interface DContract {

    interface Presenter<V extends View> extends BaseContract.Presenter<V> {

    }

    interface View extends BaseContract.View {

    }
}
