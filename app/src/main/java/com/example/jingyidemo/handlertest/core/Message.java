package com.example.jingyidemo.handlertest.core;

public class Message {
    //标识
    public int what;
    //消息内容
    public Object obj;
    //handler对象
    public Handler target;

    public Message() {
    }

    public Message(Object obj) {
        this.obj = obj;
    }
}
