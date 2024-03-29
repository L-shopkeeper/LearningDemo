 package com.example.jingyidemo.sortalgorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jingyidemo.MainActivity;
import com.example.jingyidemo.R;

import java.util.Arrays;

public class SortAlgorithmActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_algorithm);

        //初始化
        findViews();
        initListener();

        //乱序数组
        int[] arr = {5, 7, 2, 9, 4, 1, 0, 5, 7};
        Log.d(MainActivity.LOG_TAG, "乱序数组为：" + Arrays.toString(arr));

        //冒泡排序
//        bubbleSort(arr);
//        Log.d(MainActivity.LOG_TAG, "冒泡排序后的数组为：" + Arrays.toString(arr));

        //快速排序
//        quickSort(arr, 0, arr.length-1);
//        Log.d(MainActivity.LOG_TAG, "快速排序后的数组为：" + Arrays.toString(arr));

        //直接插入排序
//        insertSort(arr);
//        Log.d(MainActivity.LOG_TAG, "插入排序后的数组为：" + Arrays.toString(arr));

        //希尔排序
//        shellSort(arr);
//        Log.d(MainActivity.LOG_TAG, "希尔排序后的数组为：" + Arrays.toString(arr));

        //选择排序
        selectSort(arr);
        Log.d(MainActivity.LOG_TAG, "选择排序后的数组为：" + Arrays.toString(arr));
    }

    private void findViews() {
        backTv = findViewById(R.id.act_sort_algorithm_back_tv);

    }

    private void initListener() {
        backTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == backTv) {
            finish();
        }
    }

    /**
     * 冒泡排序
     * 需要比较arr.length-1轮
     * 每轮需要比较arr.length-1-轮数次，轮数from 0
     *  result:
     *  乱序数组为：[5, 7, 2, 9, 4, 1, 0, 5, 7]
     *  冒泡排序后的数组为：[0, 1, 2, 4, 5, 5, 7, 7, 9]
     *
     *  时间复杂度为O(n2)
     */
    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     *  快速排序
     *  快排条件：左坐标<右坐标，本例排序目标左小右大
     *  思想：找一个基准数字standard，比基准大的放左边，比基准小的放右边
     *  备注：基准数字一般用第0个数
     *  先从最右开始找，如果最右大于standard,那么就移动右坐标high--,继续比较新arr[high]和standard
     *  如果小于standard,那么就将当前右边这个放到最左边，目前最左边是standard,相当于standard消失了
     *  替换完后，就移动左坐标low++,比较新的arr[low]和standard的大小,如果arr[low]<standard,就继续移动
     *  左坐标low++,如果arr[low]>=standard,那么就把当前的arr[high]替换成arr[low],那arr[high]不会消失吗？
     *  不会。因为在执行左边的比较逻辑前，已经把右边的arr[high]赋值给了左边，也就是说此时被替换掉的arr[high]
     *  实际上是小于standard.
     *  经过循环，会使high不断减小，low不断增大，直到high=low;break;
     *  high=low;此时要把standard赋值给high
     *  递归
     *
     *  时间复杂度为O(nlogn)
     *
     *  在最糟情况下，其运行时间为O(n2)。在平均情况下，快速排序的运行时间为O(nlogn)。
     *
     *  最糟情况：假设你总是将第一个元素用作基准值，且要处理的数组是有序的。
     *  由于快速排序算法不检查输入数组是否有序，因此它依然尝试对其进行排序。
     *  注意，数组并没有被分成两半，相反，其中一个子数组始终为空，这导致调用栈非常长。
     *
     *  平均情况：假设你总是将中间的元素用作基准值，在这种情况下，调用栈如下。
     *  调用栈短得多！因为你每次都将数组分成两半，所以不需要那么多递归调用。
     *  你很快就到达 了基线条件，因此调用栈短得多。
     *
     *  在最糟情况下，栈长为 O(n)，而在最佳情况下，栈长为O(log n)。
     *
     *  调用栈的高度为O(log n)，而每层需要的时间为O(n)。
     *  因此整个算法需要的时间为O(n) * O(log n) = O(n log n)。
     *  这就是最佳情况。 在最糟情况下，有O(n)层，因此该算法的运行时间为O(n) * O(n) = O(n2)。
     */
    private void quickSort(int[] arr, int start, int end) {
        //开始排序的条件
        if (start < end) {
            //把数组中的第0个数作为标准数
            int standard = arr[start];
            //记录开始位置和结束位置的坐标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            //循环条件：循环直到两边位置坐标相等重合,一旦中和就可以开始递归
            while (low < high) {
                //右边的数字比标准数大或相等，向前移
                while (low < high && standard <= arr[high]) {
                    high--;
                }
                //右边的数字比标准数小，使用右边的数字替换左边的数字
                arr[low] = arr[high];
                //如果坐标的数字比标准数小或相等，坐标向后移动
                while (low < high && standard >= arr[low]) {
                    low++;
                }
                //左边的数字比标准数大，使用左边的数字替换右边的数字
                arr[high] = arr[low];
            }
            //两边位置坐标相等重合,把标准数填到low,开始递归
            arr[low] = standard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    /**
     * 直接插入排序
     *
     *  
     *
     * 时间复杂度O(n)*O(n)=O(n2)
     */
    private void insertSort(int[] arr) {
        //遍历所有的数字
        for (int i = 1; i < arr.length; i++) {
            //如果当前数字比前一个数字小
            if (arr[i] < arr[i - 1]) {
                //把当前遍历数字存起来
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    //把前一个数字赋给后一个数字
                    arr[j + 1] = arr[j];
                }
                //直到有temp>arr[j],把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
                arr[j + 1] = temp;
            }
        }
    }

    /**
     * 希尔排序
     * 1.先分组，组内排序
     * 2.缩小步长到1
     *
     *  三层for循环+if
     *
     *  时间复杂度依赖于步长的设计，不超过O(n2)
     */
    private void shellSort(int[] arr) {
        //遍历所有步长
        for (int d = arr.length / 2; d > 0; d = d / 2) {
            //遍历所有元素,i从步长开始，并不是从头开始
            //
            for (int i = d; i < arr.length; i++) {
                //遍历本组中所有的元素
                for (int j = i - d; j >= 0; j -= d) {
                    //如果当前元素大于加上步长后的那个元素
                    if (arr[j] > arr[j + d]) {
                        int temp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = temp;
                    }
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * 每轮都是把最小的挑出来放到最前面
     *
     * 时间复杂度为O(n2)
     *
     */
    private void selectSort(int[] arr) {
        //遍历所有的数
        for(int i=0;i<arr.length;i++) {
            int minIndex = i;
            //把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
            for (int j=i+1;j<arr.length;j++) {
                //如果后面比较的数比记录的最小的数小
                if(arr[minIndex] > arr[j]) {
                    //记录下最小的那个数的下标
                    minIndex = j;
                }
                //如果最小的数和当前遍历数的下标不一致，说明下标为minIndex的数比当前遍历的数更小
                //交换位置
                if(i!=minIndex){
                    int temp =arr[i];
                    arr[i] = arr[minIndex];
                    arr[minIndex] = temp;
                }


            }



        }



    }
}