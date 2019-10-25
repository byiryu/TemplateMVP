package com.byiryu.templatemvp.ui.fragment.C;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.byiryu.templatemvp.R;
import com.byiryu.templatemvp.di.component.ActivityComponent;
import com.byiryu.templatemvp.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CFragement extends BaseFragment implements CContract.View {

    private static final String TAG = "CFragement";
    @Inject
    CContract.Presenter<CContract.View> presenter;


    public static CFragement newInstance() {
        Bundle args = new Bundle();
        CFragement fragment = new CFragement();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

        Log.e(TAG, "setup");
//        presenter.onViewPrepared();
    }


    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }

}
