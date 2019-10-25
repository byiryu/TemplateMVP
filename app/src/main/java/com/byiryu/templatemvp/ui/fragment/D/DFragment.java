package com.byiryu.templatemvp.ui.fragment.D;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.byiryu.templatemvp.R;
import com.byiryu.templatemvp.di.component.ActivityComponent;
import com.byiryu.templatemvp.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class DFragment extends BaseFragment implements DContract.View {

    private static final String TAG = "DFragment";

    @Inject
    DContract.Presenter<DContract.View> presenter;

//    @Inject
//    BlogAdapter mBlogAdapter;

//    @Inject
//    LinearLayoutManager mLayoutManager;

//    @BindView(R.id.blog_recycler_view)
//    RecyclerView mRecyclerView;

    public static DFragment newInstance() {
        Bundle args = new Bundle();
        DFragment fragment = new DFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);
//            mBlogAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
//        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setAdapter(mBlogAdapter);
//
//        mPresenter.onViewPrepared();
    }


    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }

}

