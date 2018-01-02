package com.prndapplication.task.Common;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by kiyoung Lee on 2017-02-09.
 */

public class RetrofitClient<T> {

    private T service;

    public T getClient(Class<? extends T> type, String baseUrl){
        if(service == null){
            OkHttpClient okHttpClientclient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            }).build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClientclient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = client.create(type);
        }
        return service;
    }
}
