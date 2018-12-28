package com.sunny.myframedemo.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.sunny.myframedemo.R;

public class WebViewActivity extends AppCompatActivity  implements View.OnClickListener{

    private EditText editText;
    private WebView webView;
    private Button button;
    private static final String TAG=WebViewActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        editText=findViewById(R.id.url);
        webView=findViewById(R.id.show);
//        StringBuilder builder=new StringBuilder();
//        builder.append("<html>");
//        builder.append("<head>");
//        builder.append("<title> 欢迎您 </title>");
//        builder.append("</head>");
//        builder.append("<body>");
//        builder.append("<h2>欢迎您访问<a href=\"http:www.crazyit.org\">"+"疯狂java联盟</a></h2>");
//        builder.append("</body>");
//        builder.append("</html>");
//        webView.loadDataWithBaseURL(null,builder.toString(),"text/html","utf-8");

        button=findViewById(R.id.click);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.click){
            String webUrl=editText.getText().toString();
            Log.i(TAG, "onClick:  webURl="+webUrl);
            webView.loadUrl(webUrl);
        }
    }
}
