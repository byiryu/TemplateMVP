package com.byiryu.templatemvp.di.component;


import com.byiryu.templatemvp.di.module.ActivityModule;
import com.byiryu.templatemvp.di.scope.ActivityScoped;
import com.byiryu.templatemvp.ui.MainActivity;
import com.byiryu.templatemvp.ui.fragment.A.AFragment;
import com.byiryu.templatemvp.ui.fragment.B.BFragment;
import com.byiryu.templatemvp.ui.fragment.C.CFragement;
import com.byiryu.templatemvp.ui.fragment.D.DFragment;

import dagger.Component;

@ActivityScoped
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {



    // desc : activity

    void inject(MainActivity mainActivity);

    // desc : fragment

    void inject(AFragment aFragment);

    void inject(BFragment bFragment);

    void inject(CFragement cFragement);

    void inject(DFragment dFragment);



}