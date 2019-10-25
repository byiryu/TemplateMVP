package com.byiryu.templatemvp.di.component;

import android.app.Application;
import android.content.Context;

import com.byiryu.templatemvp.api.ApiService;
import com.byiryu.templatemvp.di.module.ApplicationModule;
import com.byiryu.templatemvp.di.module.NetworkModule;
import com.byiryu.templatemvp.di.scope.ApplicationContext;
import com.byiryu.templatemvp.di.scope.ApplicationScoped;

import dagger.Component;


@ApplicationScoped
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    public ApiService getApiInterface();

    public void inject(com.byiryu.templatemvp.Application mainApplication);

    @ApplicationContext
    Context context();

    Application application();

}