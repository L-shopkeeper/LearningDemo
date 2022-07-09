package com.example.jingyidemo;

import android.util.Log;

import com.example.jingyidemo.handlertest.core.Handler;
import com.example.jingyidemo.handlertest.core.Looper;
import com.example.jingyidemo.handlertest.core.Message;

import org.junit.Test;

public class ActivityThread {

    @Test
    public void main() {
        //创建全局唯一的，主线程Looper对象，以及MessageQueue消息队列对象
        Looper.prepare();

        //模拟Activity中，创建Handler对象
        //new Handler前, 当前线程必须有Looper
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
//                Log.d("jingyidebug", "" + msg.obj);
                System.out.println(msg.obj);
            }
        };
        //消费消息，回调方法，回调接口

        //子线程发送消息，在子线程使用主线程的handler
        //在子线程更新UI，其实是在子线程里使用主线程的变量handler发送消息，主线程收到消息后更新UI。
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = "hello jingyi";
                handler.sendMessage(message);
            }
        }).start();

        //轮询，取出消息
        Looper.loop();
    }

}
