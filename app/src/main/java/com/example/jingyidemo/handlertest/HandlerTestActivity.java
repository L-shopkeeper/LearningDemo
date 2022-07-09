package com.example.jingyidemo.handlertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingyidemo.R;

/**
 * 1.Handler内存泄露测试
 * 2.为什么不能在子线程创建Handler
 * 3.textView.setText()只能在主线程执行，这句话是错误！
 * 4.new Handler()两种写法有什么区别
 * 5.ThreadLocal用法和原理
 */
public class HandlerTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backTv;

    private TextView contentTv;

    //handler的两种写法
    private Handler handler1 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            startActivity(new Intent(HandlerTestActivity.this, HandlerSecondActivity.class));
            return false;
        }
    });

    //这是google备胎api,不推荐
    private Handler handler2 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            contentTv.setText(msg.obj.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);

        //初始化
        findViews();
        initListener();
        //测试内存泄露
        test();

        //分析handler的post发消息与取消息
        handler1.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private void findViews() {
        backTv = findViewById(R.id.act_handler_test_back_tv);
        contentTv = findViewById(R.id.act_handler_test_content_tv);
    }

    private void initListener() {
        backTv.setOnClickListener(this);
    }

    private void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
//                message.obj = "Net163";
//                message.what = 163;
//                handler2.sendMessage(message);

                //1.Handler内存泄露测试
                //三秒内我关闭界面，会走到onDestroy,但界面真的被销毁了吗
                //为什么界面已经在3秒内关闭了，界面的handler1的收消息还有相应？还是会跳到HandlerSecondActivity
//                SystemClock.sleep(3000);
//                message.what = 3;
//                handler1.sendMessage(message);
                //换一种写法就可以使onDestroy里的removeMessages生效
//                message.what = 3;
//                handler1.sendMessageDelayed(message, 3000);

                //测试置空方法
//                SystemClock.sleep(3000);
//                message.what = 3;
//                if(handler1 != null) {
//                    handler1.sendMessage(message);
//                }

                //2.为什么不能在子线程创建Handler
                // java.lang.RuntimeException: Can't create handler inside thread that has not called Looper.prepare()
                //应用在启动时，会调用activityThread的main方法-7607行
                //main()方法里有Looper.prepareMainLooper();
//                new Handler();

                //3.textView.setText()只能在主线程执行，这句话是错误！
//                contentTv.setText("jingyi test");
                //上面可以执行，换一个Toast试试
//                Toast.makeText(HandlerTestActivity.this, "jingyi test", Toast.LENGTH_SHORT);
                //java.lang.RuntimeException: Can't create handler inside thread that has not called Looper.prepare()
                //报错和new Handler()一样

                //先睡眠1s,再执行setText
                SystemClock.sleep(1000);
                contentTv.setText("jingyi test");
                //闪退,报错android.view.ViewRootImpl$CalledFromWrongThreadException:
                // Only the original thread that created a view hierarchy can touch its views.
                //只有创建视图层次结构的原始线程才能接触其视图。

            }
        }).start();
    }

    @Override
    public void onClick(View view) {
        if (view == backTv) {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "HandlerTestActivity-onDestroy()", Toast.LENGTH_SHORT);
        Log.d("jingyidebug","HandlerTestActivity-onDestroy()");
        //在ondestroy我们移除message.what=3 的消息
        //实验会发现没有作用，3秒后仍会执行handler1的handleMessage(),why?
        //reason:因为SystemClock.sleep(3000);后线程睡眠了，此时还没handler1.sendMessage(message);
        //消息队列里还没有消息，removeMessages(3)什么都没有
        handler1.removeMessages(3);
        //还可以置空
        handler1 = null;
    }
}