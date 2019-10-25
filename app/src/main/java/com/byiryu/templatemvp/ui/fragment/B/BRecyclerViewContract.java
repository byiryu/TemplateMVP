package com.byiryu.templatemvp.ui.fragment.B;

import android.content.Context;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.byiryu.templatemvp.ui.base.BaseAdapterContract;


public interface BRecyclerViewContract {

    interface View extends BaseAdapterContract.View{

        void setGlide(Context context, RequestManager requestManager, RequestOptions requestOptions);

        void setOnclickListener(BRecyclerViewAdapter.Callback onclickListener);

    }

    interface Model extends BaseAdapterContract.Model{

    }
}
