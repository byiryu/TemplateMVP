package com.byiryu.templatemvp.ui.fragment.B;

import android.content.Context;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.byiryu.templatemvp.R;
import com.byiryu.templatemvp.data.model.Recycler;
import com.byiryu.templatemvp.ui.base.BasePresenter;


import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;

public class BPresenter<V extends BContract.View> extends BasePresenter<V> implements BContract.Presenter<V>, BRecyclerViewAdapter.Callback {

    private static final String TAG = "BPresenter";

    private BContract.View view ;

    private Recycler recycler;

    private BRecyclerViewContract.Model adapterModel;
    private BRecyclerViewContract.View adapterView;

    @Inject
    RequestManager requestManager;

    @Inject
    RequestOptions requestOptions;

    @Inject
    BPresenter(){
        super();
    }

    @Override
    public void clickListener(String txt) {
        getMvpView().showMessage(txt + " OnClickListener Work!");
    }

    @Override
    public void setBRecyclerModel(BRecyclerViewContract.Model model) {
        this.adapterModel = model;
    }

    @Override
    public void setBRecyclerView(BRecyclerViewContract.View view) {
        this.adapterView = view;
        this.adapterView.setOnclickListener(this);
    }

    @Override
    public void onViewPrepared(Context context) {
        Log.e(TAG, "prepared");

        adapterView.setGlide(context,requestManager, requestOptions);

        ArrayList<Recycler> items = new ArrayList<>();

        items.add(new Recycler(R.color.light_blue, "item_1"));
        items.add(new Recycler(R.color.light_green, "item_2"));
        items.add(new Recycler(R.color.light_gray, "item_3"));


        adapterModel.clearItem();
        adapterModel.addItems(items);
        adapterView.notifyAdapter();

//        Call<Res<Recycler>> getRecycler = apiService.getRecycler("getRecycler");
//
//        Api.call(getRecycler, context, (isResult, call, response, data) -> {
//            if(!isResult) {
//                Log.e(TAG, "getRecycler error");
//                return;
//            }
//
//            recycler = data.getEntity();
//
//
//            adapterModel.clearItem();
//            adapterModel.addItems(store.getRes());
//            adapterView.notifyAdapter();
//        });
    }


}
