package com.example.jingyidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jingyidemo.datastructure.MyArray;
import com.example.jingyidemo.utils.JumpUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView dataStructureTv;
    private TextView handlerTestTv;
    private TextView fragmentTestTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        findViews();
        initListener();
    }

    private void findViews() {
        dataStructureTv = findViewById(R.id.data_structure_activity_jump_tv);
        handlerTestTv = findViewById(R.id.handler_test_activity_jump_tv);
        fragmentTestTv = findViewById(R.id.fragment_test_activity_jump_tv);
    }

    private void initListener() {
        dataStructureTv.setOnClickListener(this);
        handlerTestTv.setOnClickListener(this);
        fragmentTestTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == dataStructureTv) {
            JumpUtils.getInstance().jumpToDataStructureTestActivity(this);
        }   else if (view == handlerTestTv) {
            JumpUtils.getInstance().jumpToHandlerTestActivity(this);
        } else if (view == fragmentTestTv) {
            JumpUtils.getInstance().jumpToFragmentTestActivity(this);
        }
    }
}