package com.byiryu.templatemvp.ui.base;


import androidx.annotation.StringRes;

public interface BaseContract {


    interface Presenter<T extends View> {


        void onAttach(T view);

        void onDetach();

//    void handleApiError(ANError error);
//
//    void setUserAsLoggedOut();
    }


    interface View {

        void showLoading();

        void hideLoading();

//    void openActivityOnTokenExpire();
//
//    void onError(@StringRes int resId);
//
//    void onError(String message);

        void showMessage(String message);

        void showMessage(@StringRes int resId);

//    boolean isNetworkConnected();

        void hideKeyboard();

    }


}
