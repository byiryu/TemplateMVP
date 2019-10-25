package com.byiryu.templatemvp.ui.base;

import android.content.Context;

import javax.inject.Inject;

public class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {


    private static final String TAG = "BasePresenter";

    private V view;
    private Context context;

    @Inject
    public BasePresenter() {
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    public boolean isViewAttached() {
        return this.view != null;
    }

    public V getMvpView() {
        return this.view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new BaseViewNotAttachedException();
    }


    public static class BaseViewNotAttachedException extends RuntimeException {
        public BaseViewNotAttachedException() {
            super("Please call Presenter.onAttach(BaseContract.BaseView) before" +
                    " requesting data to the Presenter");
        }
    }
}
