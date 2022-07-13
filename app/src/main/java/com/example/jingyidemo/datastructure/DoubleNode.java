package com.example.jingyidemo.datastructure;

public class DoubleNode {
    //循环链表的pre\next都要指向自己
    //上一个节点
    private DoubleNode pre = this;
    //下一个节点
    private DoubleNode next = this;
    //节点数据
    int data;

    //构造方法
    public DoubleNode(int data) {
        this.data = data;
    }

    //增加节点
    public void after(DoubleNode node) {
        //原来的下一个节点
        DoubleNode nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //新节点的上一个节点是当前节点
        node.pre = this;
        //新节点的下一个节点是原来的下一个节点
        node.next = nextNext;
        //原来的下一个节点的上一个节点是新节点
        nextNext.pre = node;
    }

    //获取下一个节点
    public DoubleNode next() {
        return this.next;
    }

    //获取上一个节点
    public DoubleNode pre() {
        return this.pre;
    }

    public int getData() {
        return data;
    }
}
