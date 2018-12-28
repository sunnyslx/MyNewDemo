package com.sunny.myframedemo.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sunny.myframedemo.R;
import com.sunny.myframedemo.http.NewService;
import com.sunny.myframedemo.http.News;
import com.sunny.myframedemo.http.OkHttpUtils;
import com.sunny.myframedemo.rxjava.RxJavaActivity;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = RetrofitActivity.class.getSimpleName();
    private TextView textView;
    private Button retrofit;
    private Button retrofit_rxjava;
    private Button retrofit_okhttp;
    private Button mvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        retrofit = findViewById(R.id.translate);
        textView = findViewById(R.id.result);
        retrofit_rxjava = findViewById(R.id.retrofit_rxjava);
        retrofit_okhttp = findViewById(R.id.retrofit_okhttp);
        retrofit.setOnClickListener(this);
        retrofit_okhttp.setOnClickListener(this);
        retrofit_rxjava.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.translate:
                createRetrofit();
                break;
            case R.id.retrofit_okhttp:
                createRetrofitokhttp();
                break;
            case R.id.retrofit_rxjava:
                createRetrofitRxjava();
                break;
            case R.id.mvp:

                break;
            default:
                break;
        }
    }

    /**
     * retrofit请求网络
     */
    private void createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewService newService = retrofit.create(NewService.class);
        Call<News> newsCall = newService.getNews();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                textView.setText(response.body().getResults().get(0).getContent());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }

    /**
     * retrofit2.0+Rxjava2.0请求
     */
    private void createRetrofitRxjava() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gank.io/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewService newService = retrofit.create(NewService.class);

            newService.getNews1()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<News>() {
                    @Override
                    public void onNext(News value) {
                        textView.setText(value.getResults().get(0).getContent());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * retrofit+okhttp定制
     */
    private void createRetrofitokhttp(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("")
                .client(OkHttpUtils.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewService newService=retrofit.create(NewService.class);
        Call<News> newsCall=newService.getNews();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}
