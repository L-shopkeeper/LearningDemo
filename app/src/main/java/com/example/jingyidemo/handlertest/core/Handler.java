package com.example.jingyidemo.handlertest.core;


public class Handler {

    private Looper mLooper;

    private MessageQueue mQueue;

    public Handler() {
        mLooper = Looper.myLooper();
        if (mLooper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        //handler里的MQ是从Looper里拿到的
        mQueue = mLooper.mQueue;
    }

    /**
     * Subclasses must implement this to receive messages.
     */
    //给开发者提供的开放API,用于重写和回调监听
    public void handleMessage(Message msg) {
    }

    public void sendMessage(Message message) {
        //将消息放入消息队列中
        enqueueMessage(message);
    }

    private void enqueueMessage(Message message) {
        //在消息入队前，将本handler放入message
        message.target = this;

        //使用mQueue，将消息放入
        mQueue.equeueMessage(message);
    }

    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }
}
