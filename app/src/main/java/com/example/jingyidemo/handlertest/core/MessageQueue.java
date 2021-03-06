package com.example.jingyidemo.handlertest.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {

    //阻塞队列
    BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(50);
    
    //将Message消息存入阻塞队列中
    public void equeueMessage(Message message) {
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //从消息队列中取出消息
    public Message next() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
