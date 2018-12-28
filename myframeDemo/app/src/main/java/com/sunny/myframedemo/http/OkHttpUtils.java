package com.sunny.myframedemo.http;

import android.app.VoiceInteractor;
import android.widget.BaseAdapter;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Sunny on 18-12-19.
 */

public class OkHttpUtils {

    private static OkHttpClient okHttpClient;

    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils() {
        okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(1500, TimeUnit.SECONDS)
                .writeTimeout(1500,TimeUnit.SECONDS)
                .readTimeout(1500,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    public static OkHttpUtils INSTANCE() {
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                okHttpUtils=new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }


    public static OkHttpClient getOkHttpClient(){
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                okHttpUtils=new OkHttpUtils();
            }
        }
        return okHttpClient;
    }

    private Interceptor interceptor =new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request=chain.request();
            Request request1=request.newBuilder()
                    .addHeader("Accept-Charset", "utf-8")
                    .build();

            return chain.proceed(request1);
        }
    };


    private void postFile(String url, File file, Callback callback){
        RequestBody requestBody=RequestBody.create(MediaType.parse(""),file);
        Call call=okHttpClient.newCall(new Request.Builder().url(url).post(requestBody).build());
        call.enqueue(callback);
    }

    private void postJson(String url,String  json,Callback callback){
        RequestBody requestBody=RequestBody.create(MediaType.parse(""),json);
        Call call=okHttpClient.newCall(new Request.Builder().url(url).post(requestBody).build());
        call.enqueue(callback);
    }

    private void postFormBody(String  url, FormBody formBody,Callback callback){
        Call call=okHttpClient.newCall(new Request.Builder().url(url).post(formBody).build());
        call.enqueue(callback);
    }

    private void postRequestBody(String url, RequestBody requestBody,Callback callback){
        Call call=okHttpClient.newCall(new Request.Builder().url(url).post(requestBody).build());
        call.enqueue(callback);
    }

    private void get(String url,Callback callback){
        Call call=okHttpClient.newCall(new Request.Builder().url(url).build());
        call.enqueue(callback);

    }

}
