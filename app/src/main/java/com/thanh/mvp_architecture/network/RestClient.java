package com.thanh.mvp_architecture.network;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p/>
 * This is the main entry point for network communication. Use this class for instancing REST services which do the
 * actual communication.
 */
public class RestClient {

    private static final String BASE_URL = "http://www.mocky.io/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).client(getHttpClient().build());


    public static OkHttpClient.Builder getHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(5, TimeUnit.SECONDS)
                .pingInterval(1,TimeUnit.SECONDS)
                .eventListener(new EventListener() {
                    @Override
                    public void callStart(Call call) {
                        super.callStart(call);
                        Log.e("Start call","Start");
                    }

                    @Override
                    public void callEnd(Call call) {
                        super.callEnd(call);
                        Log.e("Stop call","End");
                    }
                });
        return httpClient;
    }

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
