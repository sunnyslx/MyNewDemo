package com.sunny.myframedemo.http;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sunny on 18-12-14.
 */

public interface NewService {

    @GET("xiandu/data/id/appinn/count/10/page/1")
    Call<News> getNews();

    @GET("xiandu/data/id/appinn/count/10/page/1")
    Observable<News> getNews1();
}
