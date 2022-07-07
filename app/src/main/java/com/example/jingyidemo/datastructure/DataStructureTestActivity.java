package com.example.jingyidemo.datastructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        Log.d("jingyidebug", "binarySearch result = " + array.binarySearch(2));
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
        Log.d("jingyidebug", "binarySearch result = " + result);
    }

    @Override
    public void onClick(View view) {
        if (view == backTv) {
            finish();
        }
    }
}