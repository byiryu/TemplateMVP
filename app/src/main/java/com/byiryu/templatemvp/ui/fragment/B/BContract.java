package com.byiryu.templatemvp.ui.fragment.B;

import android.content.Context;

import com.byiryu.templatemvp.ui.base.BaseContract;


public interface BContract {

    interface Presenter<V extends View> extends BaseContract.Presenter<V> {

        void setBRecyclerModel(BRecyclerViewContract.Model model);

        void setBRecyclerView(BRecyclerViewContract.View view);

        void onViewPrepared(Context context);

    }

    interface View extends BaseContract.View {

    }
}
