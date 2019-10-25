package com.byiryu.templatemvp.ui.fragment.B;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byiryu.templatemvp.R;
import com.byiryu.templatemvp.di.component.ActivityComponent;
import com.byiryu.templatemvp.ui.base.BaseFragment;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BFragment extends BaseFragment implements BContract.View {

    private static final String TAG = "BFragment";

    @Inject
    BContract.Presenter<BContract.View> presenter;

    @Inject
    BRecyclerViewAdapter BRecyclerViewAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.b_recyclerView)
    RecyclerView recyclerView;

    public static BFragment newInstance() {
        Bundle args = new Bundle();
        BFragment fragment = new BFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);
            presenter.setBRecyclerModel(BRecyclerViewAdapter);
            presenter.setBRecyclerView(BRecyclerViewAdapter);

//            homeRecyclerViewAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

        Log.e(TAG, "setup");

        mLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(BRecyclerViewAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        presenter.onViewPrepared(getContext());
    }




    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }
}
