package com.example.jingyidemo.datastructure;

import android.util.Log;

public class LoopNode {

    //节点内容
    int data;

    //下一个节点，只改这一处
    private LoopNode next = this ;

    public LoopNode(int data) {
        this.data = data;
    }

    //获取下一个节点
    public LoopNode next() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    //当前节点是否是最后一个节点
    public boolean isLast() {
        return next == null;
    }

    //删除下一个节点
    public void removeNext() {
        //先取出下一个节点
        LoopNode newNext = next.next;
        //把下下一个节点设置为当前节点的下一个节点
        this.next = newNext;
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(LoopNode node) {
        //取出下一个节点，作为下下一个节点
        LoopNode nextNextNode = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点。
        node.next = nextNextNode;

    }
}
