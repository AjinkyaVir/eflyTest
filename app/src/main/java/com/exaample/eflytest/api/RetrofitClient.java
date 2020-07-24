package com.exaample.eflytest.api;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ajinkya on 7/22/2020.
 */
public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = " http://eflytest.work/API/backend/Auth/ ";

    public Retrofit getRetrofitInstance(Context context) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
