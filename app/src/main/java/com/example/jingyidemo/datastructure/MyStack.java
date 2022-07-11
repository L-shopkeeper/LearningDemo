package com.example.jingyidemo.datastructure;

public class MyStack {

    int[] elements;

    public MyStack() {
    }

    //压入栈
    public void push(int element) {
        //创建一个新数组，比之前的数组长度+1
        int[] newArr = new int[elements.length + 1];
        //将旧数组的数据转移到新数组
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        //将新被压入栈的元素添加到新数组尾部
        newArr[elements.length] = element;
        //新数组替换掉旧数组
        elements = newArr;
    }

    //出栈
    public int pop() {
        if (elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        //创建一个新数组，比之前的数组长度-1
        int[] newArr = new int[elements.length - 1];
        //将旧数组的数据转移到新数组
        for (int i = 0; i < elements.length - 1; i++) {
            newArr[i] = elements[i];
        }
        //替换数组
        elements = newArr;
        //返回数组中的最后一个元素
        return newArr[elements.length - 1];
    }

    //查看栈顶元素
    public int peek() {
        //栈中没有元素
        if (elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        return elements[elements.length - 1];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return elements.length == 0;
    }
}
