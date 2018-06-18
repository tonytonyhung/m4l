package leduyhung.me.m4l.rest;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import leduyhung.me.m4l.Constants;
import leduyhung.me.m4l.util.GsonUtil;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRestApi {

    public static final int TIMEOUT = 3;

    private static OkHttpClient.Builder httpClient;
    private static HttpLoggingInterceptor httpLoggingInterceptor;
    private static Retrofit retrofit;
    private static Retrofit.Builder builder;
    private static TaskApi taskApi;

    public static TaskApi request() {

        if (taskApi == null) {

            builder = new Retrofit.Builder().baseUrl(Constants.Server.SERVER_ADDRESS).addConverterFactory(GsonConverterFactory.create(GsonUtil.newInstance()));
            httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        httpClient = new OkHttpClient.Builder().connectTimeout(TIMEOUT, TimeUnit.SECONDS).readTimeout(TIMEOUT, TimeUnit.SECONDS).writeTimeout(TIMEOUT, TimeUnit.SECONDS);
        httpClient.addInterceptor(httpLoggingInterceptor);
        retrofit = builder.client(httpClient.build()).build();
        taskApi = retrofit.create(TaskApi.class);

        return taskApi;
    }
}