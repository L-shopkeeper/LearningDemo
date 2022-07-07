package com.example.jingyidemo.datastructure;

import android.util.Log;

import java.util.Arrays;

/**
 * 自定义一个数组
 */
public class MyArray {

    //用于存储数据的数组
    private int[] elements;

    //构造方法
    public MyArray() {
        elements = new int[0];
    }

    //获取数组长度的方法
    public int size() {
        return elements.length;
    }

    //往数组末尾添加一个元素
    public void add(int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    //删除数组中的元素
    public void delete(int index) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("下表越界");
        }
        int[] newArr = new int[elements.length -1];
        for (int i = 0 ;i < newArr.length;i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                newArr[i] = elements[i+ 1];
            }
        }
        elements = newArr;
    }

    //获取指定位置某个元素
    public int get(int index) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("下表越界");
        }
        return elements[index];
    }

    //插入一个元素到指定位置
    public void insert(int index, int element) {
        if (index < 0 || index > elements.length) {
            return;
        }
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                if (i == index) {
                    newArr[i] = element;
                } else {
                    newArr[i] = elements[i - 1];
                }
            }
        }
        elements = newArr;
    }

    //替换某位置的元素
    public void set(int index, int element) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("下表越界");
        }
        elements[index] = element;
    }

    public void show() {
        Log.d("jingyidebug","" + Arrays.toString(elements));
    }

    //线性查找
    public int search(int target) {
        //遍历数组
        for(int i= 0;i< elements.length;i++) {
            if (elements[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //二分法查找
    public int binarySearch(int target) {
        //二分查找，关键是要正确更新start和end
        int start = 0;
        int end = elements.length - 1;
        int mid = (start + end) / 2;

        while (true) {
            //什么情况下没有这个元素？
            //如果开始位置在结束位置之后或重合。重合不行的，已经去掉了=
            if(start > end) {
                return -1;
            }
            //如果中间值等于目标值则直接停止循环
            if (elements[mid] == target) {
                return mid;
            } else {
                if (elements[mid] > target) {
                    //如果中间值大于目标值，说明目标值在中间值的前面，此时要将end缩小到mid-1
                    end = mid - 1;
                } else {
                    //如果中间值小于目标值，说明目标值在中间值的后面，此时要将start增大到mid+1
                    start = mid + 1;
                }
                //更新mid
                mid = (start + end) / 2;
            }
        }
    }
}
