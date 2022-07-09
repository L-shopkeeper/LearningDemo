package com.example.jingyidemo.handlertest.core;


public class Looper {

    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    public MessageQueue mQueue;

    private Looper() {
        mQueue = new MessageQueue();
    }

    public static void prepare() {
        //主线程只有唯一一个Looper对象
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        //应用启动时初始化赋值
        sThreadLocal.set(new Looper());
    }

    //轮训，提取消息
    public static void loop() {
        //从当前线程的ThreadLocalMap中获取唯一：Looper对象
        Looper me = myLooper();
        //从Looper对象中获取全局唯一消息队列MessageQueue对象
        final MessageQueue queue = me.mQueue;

        Message resultMessage;
        while (true) {
            Message msg = queue.next();
            if (msg != null) {
                msg.target.dispatchMessage(msg);
            }
        }

    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }
}
