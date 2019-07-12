package com.example.geek.api;

import java.util.concurrent.TimeUnit;

import butterknife.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataWechatService {
    private static  final long DEFAULT_TIMEOUT = 20000;
    private static volatile WechatService service;

    public static WechatService getZhihuService() {
        if(service == null){
            synchronized (DataWechatService.class){
                if(service == null){
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                            if(BuildConfig.DEBUG){
                                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                            }else{
                                interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
                            }
                            OkHttpClient client = new OkHttpClient.Builder()
                                    .addInterceptor(interceptor)
                                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                                    .build();
                            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(WechatService.URL_WECHAT)
                                    .client(client)
                                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                            service = retrofit.create(WechatService.class);
                }
            }
        }
        return service;
    }
}
