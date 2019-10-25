package com.byiryu.templatemvp.ui.fragment.C;

import com.byiryu.templatemvp.ui.base.BaseContract;

public interface CContract {
    interface Presenter<V extends CContract.View> extends BaseContract.Presenter<V> {

    }

    interface View extends BaseContract.View {

    }
}
