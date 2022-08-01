package com.example.jingyidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jingyidemo.datastructure.MyArray;
import com.example.jingyidemo.utils.JumpUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LOG_TAG = "jingyidebug";
    private TextView dataStructureTv;
    private TextView handlerTestTv;
    private TextView fragmentTestTv;
    private TextView sortAlgorithmTv;
    private TextView okhttpTestTv;
    private TextView broadcastTestTv;
    private TextView serviceTestTv;


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
        sortAlgorithmTv = findViewById(R.id.sort_algorithm_activity_jump_tv);
        okhttpTestTv = findViewById(R.id.okhttp_test_activity_jump_tv);
        broadcastTestTv = findViewById(R.id.broadcast_test_activity_jump_tv);
        serviceTestTv = findViewById(R.id.service_test_activity_jump_tv);
    }

    private void initListener() {
        dataStructureTv.setOnClickListener(this);
        handlerTestTv.setOnClickListener(this);
        fragmentTestTv.setOnClickListener(this);
        sortAlgorithmTv.setOnClickListener(this);
        okhttpTestTv.setOnClickListener(this);
        broadcastTestTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == dataStructureTv) {
            JumpUtils.getInstance().jumpToDataStructureTestActivity(this);
        }   else if (view == handlerTestTv) {
            JumpUtils.getInstance().jumpToHandlerTestActivity(this);
        } else if (view == fragmentTestTv) {
            JumpUtils.getInstance().jumpToFragmentTestActivity(this);
        } else if (view == sortAlgorithmTv) {
            JumpUtils.getInstance().jumpToSortAlgorithmActivity(this);
        } else if (view == okhttpTestTv) {
            JumpUtils.getInstance().jumpToOKHttpTestActivity(this);
        } else if (view == broadcastTestTv) {
            JumpUtils.getInstance().jumpToBroadcastTestActivity(this);
        } else if (view == serviceTestTv) {
            JumpUtils.getInstance().jumpToServiceTestActivity(this);
        }
    }
}