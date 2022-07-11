package com.example.jingyidemo.datastructure;

import android.util.Log;

//一个节点
public class Node {

    //节点内容
    int data;

    //下一个节点
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    //为节点追加节点
    public Node append(Node node) {
        //当前节点
        Node currentNode = this;
        //无限循环向后找
        while (true) {
            //取出下一个节点
            Node nextNode = currentNode.next();
            //如果下一个节点为null,当前节点已经是最后一个节点
            if (nextNode == null) {
                break;
            }
            //赋给当前节点
            currentNode = nextNode;
        }
        //把需要追加的节点追加为到找到的当前节点的下一个节点
        currentNode.next = node;
        //永远返回第一个节点，但没关系，append内部会找到最后一个节点
        return this;
    }

    //获取下一个节点
    public Node next() {
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
        Node newNext = next.next;
        //把下下一个节点设置为当前节点的下一个节点
        this.next = newNext;
    }

    //显示所有节点信息
    public void show() {
        Node currentNode = this;
        while (true) {
            Log.d("jingyidebug",currentNode.data+"");
            //取出下一个节点
            currentNode = currentNode.next;
            if (currentNode == null) {
                break;
            }
        }
        Log.d("jingyidebug","-----------");
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(Node node) {
        //取出下一个节点，作为下下一个节点
        Node nextNextNode = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点。
        node.next = nextNextNode;
    }
}
