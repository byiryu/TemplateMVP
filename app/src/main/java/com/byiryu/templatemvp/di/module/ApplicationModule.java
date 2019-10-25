package com.byiryu.templatemvp.di.module;


import android.app.Application;
import android.content.Context;

import com.byiryu.templatemvp.data.pref.ApplicationPreference;
import com.byiryu.templatemvp.data.pref.Preference;
import com.byiryu.templatemvp.di.scope.ApplicationContext;
import com.byiryu.templatemvp.di.scope.PreferenceContext;
import com.byiryu.templatemvp.utils.ApplicationCons;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

//    @Provides
//    @ApiInfo
//    String provideApiKey() {
//        return BuildConfig.API_KEY;
//    }

    @Provides
    @PreferenceContext
    String providePreferenceName() {
        return ApplicationCons.PREF_NAME;
    }

    @Provides
    @Singleton
    Preference providePreferencesHelper(ApplicationPreference applicationPreference) {
        return applicationPreference;
    }
}

