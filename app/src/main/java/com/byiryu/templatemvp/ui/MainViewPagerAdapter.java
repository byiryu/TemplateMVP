package com.byiryu.templatemvp.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.byiryu.templatemvp.ui.fragment.A.AFragment;
import com.byiryu.templatemvp.ui.fragment.B.BFragment;
import com.byiryu.templatemvp.ui.fragment.C.CFragement;
import com.byiryu.templatemvp.ui.fragment.D.DFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private int tabCount;


    public MainViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        this.tabCount =0;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AFragment.newInstance();
            case 1:
                return BFragment.newInstance();
            case 2:
                return CFragement.newInstance();
            case 3:
                return DFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    public void setCount(int count) {
        this.tabCount = count;
    }
}
