package com.byiryu.templatemvp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import com.byiryu.templatemvp.R;
import com.byiryu.templatemvp.api.ApiService;
import com.byiryu.templatemvp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View{

    private static final String TAG = "MainActivity";
    @Inject
    MainContract.Presenter<MainContract.View> mainPresenter;

    @Inject
    MainViewPagerAdapter mPagerAdapter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.mainViewPager)
    ViewPager mViewPager;

    @BindViews({R.id.layout_A, R.id.layout_B, R.id.layout_C, R.id.layout_D})
    List<ConstraintLayout> layoutList;



    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mainPresenter.onAttach(this);

        setUp();


    }

    @Override
    protected void setUp() {

        setSupportActionBar(mToolbar);
//
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_user);
        }

        initTab(layoutList.get(0));

        for(int i=0; i<layoutList.size(); i++){
            int finalI = i;
            layoutList.get(i).setOnClickListener(v->{
                initTab(layoutList.get(finalI));
                mViewPager.setCurrentItem(finalI);
            });
        }

        mPagerAdapter.setCount(4);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                initTab(layoutList.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDetach();
        super.onDestroy();
    }

    void initTab(ConstraintLayout selectedView){
        for(ConstraintLayout parent : layoutList){
            parent.getChildAt(0).setSelected(false);
        }
        selectedView.getChildAt(0).setSelected(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        switch (id) {
            case android.R.id.home:
//                if(isLogin) {
//                    intent = new Intent(this, ProfileActivity.class);
//                    startActivity(intent);
//                }else{
//                    LoginManager.getInstance().logOut();
//                    intent = new Intent(this, LoginActivity.class);
//                    startActivity(intent);
//                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
