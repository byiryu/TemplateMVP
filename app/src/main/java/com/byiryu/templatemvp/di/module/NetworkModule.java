package com.byiryu.templatemvp.di.module;

import com.byiryu.templatemvp.BuildConfig;
import com.byiryu.templatemvp.api.ApiService;
import com.byiryu.templatemvp.di.scope.ApplicationScoped;
import com.byiryu.templatemvp.utils.ApplicationCons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


    @Provides
    @ApplicationScoped
    ApiService getApiInterface(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @ApplicationScoped
    Gson provideGson() {
        return new GsonBuilder().serializeSpecialFloatingPointValues()
                .serializeNulls()
                .create();
    }


    @Provides
    @ApplicationScoped
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApplicationCons.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);

        return builder.build();

    }

    @Provides
    @ApplicationScoped
    public OkHttpClient proviceClient(HttpLoggingInterceptor httpLoggingInterceptor) {



//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.readTimeout(20000, TimeUnit.MILLISECONDS);
//        builder.connectTimeout(10000, TimeUnit.MILLISECONDS);
//        builder.retryOnConnectionFailure(true);
//        builder.addInterceptor(logging);
//        return builder.build();
        return new OkHttpClient.Builder()
                .readTimeout(20000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(httpLoggingInterceptor)
                .build();

    }


    @Provides
    @ApplicationScoped
    public HttpLoggingInterceptor provideLogger(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        return httpLoggingInterceptor;

    }
}
