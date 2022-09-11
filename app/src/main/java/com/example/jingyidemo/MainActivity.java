package com.example.jingyidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
    private TextView glideTestTv;
    private TextView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG,"MainActivity#onCreate");
        //初始化
        findViews();
        initListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"MainActivity#onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"MainActivity#onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"MainActivity#onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"MainActivity#onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"MainActivity#onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"MainActivity#onDestory");
    }

    private void findViews() {
        dataStructureTv = findViewById(R.id.data_structure_activity_jump_tv);
        handlerTestTv = findViewById(R.id.handler_test_activity_jump_tv);
        fragmentTestTv = findViewById(R.id.fragment_test_activity_jump_tv);
        sortAlgorithmTv = findViewById(R.id.sort_algorithm_activity_jump_tv);
        okhttpTestTv = findViewById(R.id.okhttp_test_activity_jump_tv);
        broadcastTestTv = findViewById(R.id.broadcast_test_activity_jump_tv);
        serviceTestTv = findViewById(R.id.service_test_activity_jump_tv);
        glideTestTv = findViewById(R.id.glide_test_activity_jump_tv);
        customView = findViewById(R.id.custom_view_activity_jump_tv);
    }

    private void initListener() {
        dataStructureTv.setOnClickListener(this);
        handlerTestTv.setOnClickListener(this);
        fragmentTestTv.setOnClickListener(this);
        sortAlgorithmTv.setOnClickListener(this);
        okhttpTestTv.setOnClickListener(this);
        broadcastTestTv.setOnClickListener(this);
        glideTestTv.setOnClickListener(this);
        customView.setOnClickListener(this);
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
        } else if (view == glideTestTv) {
            JumpUtils.getInstance().jumpToGlideTestActivity(this);
        } else if (view == customView) {
            JumpUtils.getInstance().jumpToCustomViewActivity(this);
        }
    }
}