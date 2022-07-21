package com.example.jingyidemo.okhttptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jingyidemo.MainActivity;
import com.example.jingyidemo.R;

import java.io.IOException;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_test);

        //初始化
        findViews();
        initListener();

        //okhttp的使用
        okhttpUseAction();
        //线程池
        Executors.newCachedThreadPool();
    }

    private void findViews() {
        backTv = findViewById(R.id.act_okhttp_test_back_tv);

    }

    private void initListener() {
        backTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == backTv) {
            finish();
        }
    }

    private void okhttpUseAction() {
        //五个类OKhttpClient request Call response Callback

        OkHttpClient client = new OkHttpClient.Builder().dispatcher(null).addInterceptor(null).build();

        Request request = new Request.Builder().url("https://www.baidu.com").get().build();

        Call call = client.newCall(request);

        //同步请求 -- 需要我们自己开启子线程才能使用  -- 耗时
//        try {
//            Response response = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //异步GET请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(MainActivity.LOG_TAG, "请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //曾然在子线程
                Log.d(MainActivity.LOG_TAG, "当前线程:" + Thread.currentThread().getName());
                Log.d(MainActivity.LOG_TAG, "请求成功" + response.body().string());
            }
        });

    }
}