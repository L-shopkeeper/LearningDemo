package com.example.jingyidemo.datastructure;

public class MyQueue {

    int[] elements;

    //入队
    public void add(int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    //出队
    public int poll() {
        if (elements.length == 0) {
            throw new RuntimeException("queue is empty");
        }
        int[] newArr = new int[elements.length - 1];
        int element = elements[0];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i + 1];
        }
        elements = newArr;
        return element;
    }
}
