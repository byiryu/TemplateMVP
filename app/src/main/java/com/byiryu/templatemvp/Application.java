package com.byiryu.templatemvp;

import com.byiryu.templatemvp.di.component.ApplicationComponent;
import com.byiryu.templatemvp.di.component.DaggerApplicationComponent;
import com.byiryu.templatemvp.di.module.ApplicationModule;

public class Application extends android.app.Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

//        AppLogger.init();

//        AndroidNetworking.initialize(getApplicationContext());
//        if (BuildConfig.DEBUG) {
//            AndroidNetworking.enableLogging(Level.BODY);
//        }

//        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
