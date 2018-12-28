package com.sunny.myframedemo.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import com.sunny.myframedemo.R;
import com.sunny.myframedemo.http.NewService;
import com.sunny.myframedemo.http.WeatherResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RxJavaActivity extends AppCompatActivity {

    private static final String TAG=RxJavaActivity.class.getSimpleName();
    private Retrofit retrofit;
    private EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        textView=findViewById(R.id.city);
        textView.getText().toString();
//        //创建被观察者,发射数据
//        io.reactivex.Observable<String> observable= io.reactivex.Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("你好");
//            }
//        });
//        io.reactivex.Observer<String> observer=new io.reactivex.Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.i(TAG, "onNext:  value="+value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        observable.subscribe(observer);
        ceateRetrofit();

    }


    private void ceateRetrofit(){
        retrofit=new Retrofit.Builder()
                .baseUrl("https://free-api.heweather.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private void  requestCity(){

    }


}
