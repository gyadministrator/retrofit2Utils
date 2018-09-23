package com.gy.android.retrofit2utils.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Administrator
 * time:2018/9/23
 * decription:
 **/
public class RetrofitFactory {
    private static RetrofitFactory retrofitFactory;

    /**
     * 不让外界实例化
     */
    private RetrofitFactory() {
    }

    /**
     * 得到RetrofitFactory的实例
     *
     * @return
     */
    public static RetrofitFactory getInstance() {
        if (retrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofitFactory == null) {
                    retrofitFactory = new RetrofitFactory();
                }
            }
        }
        return retrofitFactory;
    }

    /**
     * 得到retrofit
     *
     * @param baseUrl 服务器基地址
     * @return
     */
    public Retrofit Builder(String baseUrl) {
        // 初始化okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        // 初始化Retrofit
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
