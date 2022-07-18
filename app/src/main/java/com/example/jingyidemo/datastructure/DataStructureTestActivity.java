package com.example.jingyidemo.datastructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jingyidemo.MainActivity;
import com.example.jingyidemo.R;

public class DataStructureTestActivity extends AppCompatActivity implements View.OnClickListener {

     private TextView backTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datastructure_test);

        //初始化
        findViews();
        initListener();

        //测试MyArray数组
        //testMyArray();
        //测试二分查找
        //testBinarySearch();
        //测试栈
        //testMyStack();
        //测试队列
        //testMyQueue();

        //测试链表
//        testLinkedList();

        //测试循环链表
//        testLoopNode();
        
        //测试双向链表
//        testDoubleNode();

        //递归-测试斐波那契数列
        testFibonacci();

        //递归-测试汉诺塔问题
        testHanoi();

    }

    private void testHanoi() {
        //  |   |   |
        //  |   |   |
        //  -   -   -
        //  A   B   C
        hanoi(3, 'A', 'B', 'C');
    }

    private void hanoi(int n, char from, char in, char to) {
        //只有一个盘子
        if (n == 1) {
            //移动这个盘子
            Log.d(MainActivity.LOG_TAG, "第" + n + "个盘从" + from + "移动到" + to);
        } else {
            //无论有多少盘子，都认为只有两个。上面的盘子和最下面的盘子。
            //先把上面的盘子都移动到中间
            hanoi(n - 1, from, to, in);
            //移动最下面的盘子
            Log.d(MainActivity.LOG_TAG, "第" + n + "个盘从" + from + "移动到" + to);
            //把暂时放到中间的盘子移动到目的地
            hanoi(n - 1, in, from, to);
        }
    }

    private void testFibonacci() {
        //Fibonacci数列：1 1 2 3 5 8 13 21 ...
        //打印第n项
        Log.d(MainActivity.LOG_TAG, "" + getFibonacci(8));
    }

    private int getFibonacci(int i) {
        if(i == 1 || i == 2) {
            return 1;
        } else {
            return getFibonacci(i - 1) + getFibonacci(i - 2);
        }
    }

    private void testDoubleNode() {
        //创建节点
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        //追加节点
        n1.after(n2);
        n2.after(n3);
        //查看 3 3 1
        Log.d(MainActivity.LOG_TAG, "" + n1.pre().getData());
        Log.d(MainActivity.LOG_TAG, "" + n2.next().getData());
        Log.d(MainActivity.LOG_TAG, "" + n3.next().getData());

    }

    private void testLoopNode() {
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);
        //追加节点
        n1.after(n2);
        n2.after(n3);
        n3.after(n4);
        //输出
        Log.d(MainActivity.LOG_TAG, "" + n1.next().getData());
        Log.d(MainActivity.LOG_TAG, "" + n2.next().getData());
        Log.d(MainActivity.LOG_TAG, "" + n3.next().getData());
        Log.d(MainActivity.LOG_TAG, "" + n4.next().getData());

    }


    private void findViews() {
        backTv = findViewById(R.id.act_data_structure_back_tv);
    }

    private void initListener() {
        backTv.setOnClickListener(this);
    }

    private void testMyArray() {
        MyArray array = new MyArray();
        array.add(1);
        array.add(2);
        array.show();
        Log.d(MainActivity.LOG_TAG, "binarySearch result = " + array.binarySearch(2));
    }

    private void testBinarySearch() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //想查的值
        int dst = 0;
        //结果index
        int result = -1;

        //二分查找，关键是要正确更新start和end
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            //如果中间值等于目标值则直接停止循环
            if (arr[mid] == dst) {
                result = mid;
                break;
            } else {
                if (arr[mid] > dst) {
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
        Log.d(MainActivity.LOG_TAG, "binarySearch result = " + result);
    }

    private void testMyStack() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
    }

    private void testMyQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.add(9);
        myQueue.add(8);
        myQueue.add(7);
        Log.d(MainActivity.LOG_TAG, "" + myQueue.poll());
    }


    private void testLinkedList() {
        //创建节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        //链接起来
        node1.append(node2).append(node3).append(new Node(4));
        //显示所有节点
        node1.show();
        //删除node3,需要在node3前一个节点调用removeNext
        node1.next().removeNext();
        //显示所有节点
        node1.show();
        //插入一个新节点1254
        Node node = new Node(5);
        node1.next().after(node);
        //显示所有节点
        node1.show();
    }

    @Override
    public void onClick(View view) {
        if (view == backTv) {
            finish();
        }
    }
}