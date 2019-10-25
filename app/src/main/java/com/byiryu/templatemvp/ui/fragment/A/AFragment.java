package com.byiryu.templatemvp.ui.fragment.A;

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

public class AFragment extends BaseFragment implements AContract.View {
    private static final String TAG = "AFragment";

    @Inject
    AContract.Presenter<AContract.View> presenter;


    public static AFragment newInstance() {
        Bundle args = new Bundle();
        AFragment fragment = new AFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

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
