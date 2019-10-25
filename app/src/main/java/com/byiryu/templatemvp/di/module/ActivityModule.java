package com.byiryu.templatemvp.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.byiryu.templatemvp.di.scope.ActivityContext;
import com.byiryu.templatemvp.di.scope.ActivityScoped;
import com.byiryu.templatemvp.ui.MainContract;
import com.byiryu.templatemvp.ui.MainPresenter;
import com.byiryu.templatemvp.ui.MainViewPagerAdapter;
import com.byiryu.templatemvp.ui.fragment.A.AContract;
import com.byiryu.templatemvp.ui.fragment.A.APresenter;
import com.byiryu.templatemvp.ui.fragment.B.BContract;
import com.byiryu.templatemvp.ui.fragment.B.BPresenter;
import com.byiryu.templatemvp.ui.fragment.B.BRecyclerViewAdapter;
import com.byiryu.templatemvp.ui.fragment.C.CContract;
import com.byiryu.templatemvp.ui.fragment.C.CPresenter;
import com.byiryu.templatemvp.ui.fragment.D.DContract;
import com.byiryu.templatemvp.ui.fragment.D.DPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }


    /** desc
    *   context : activityContext
    *   activity : activityScoped
    * */

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }


    /** presenter */

    @Provides
    @ActivityScoped
    MainContract.Presenter<MainContract.View> provideMainPresenter(
            MainPresenter<MainContract.View> presenter) {
        return presenter;
    }

    @Provides
    BContract.Presenter<BContract.View> provideBPresenter(
            BPresenter<BContract.View> presenter) {
        return presenter;
    }

    @Provides
    CContract.Presenter<CContract.View> provideCPresenter(
            CPresenter<CContract.View> presenter) {
        return presenter;
    }
    @Provides
    DContract.Presenter<DContract.View> provideDPresenter(
            DPresenter<DContract.View> presenter) {
        return presenter;
    }

    @Provides
    AContract.Presenter<AContract.View> provideAPresenter(
            APresenter<AContract.View> presenter) {
        return presenter;
    }
    /** viewpager  */

    @Provides
    MainViewPagerAdapter provideMainPagerAdapter(AppCompatActivity activity) {
        return new MainViewPagerAdapter(activity.getSupportFragmentManager());
    }

    /** recyclerview */

    @Provides
    BRecyclerViewAdapter provideHomeRecyclerAdapter(){
        return new BRecyclerViewAdapter();
    }

    /** layout manager */

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    RequestManager provideReqeustManager(AppCompatActivity appCompatActivity){
        RequestManager requestManager = Glide.with(appCompatActivity);
        return requestManager;
    }

    @Provides
    RequestOptions provideRequestOption(AppCompatActivity appCompatActivity){
        return new RequestOptions();
    }

    // adapter 및 presneter 정의

}

