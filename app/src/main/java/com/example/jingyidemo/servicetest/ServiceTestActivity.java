package com.example.jingyidemo.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jingyidemo.R;

public class ServiceTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backTv;
    private Button startServiceBtn;
    private Button stopServiceBtn;
    private Button bindServiceBtn;
    private Button unbindServiceBtn;

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        findView();
        initListener();
    }

    private void findView() {
        backTv = findViewById(R.id.act_service_test_back_tv);
        startServiceBtn = findViewById(R.id.start_service_btn);
        stopServiceBtn = findViewById(R.id.stop_service_btn);
        bindServiceBtn = findViewById(R.id.bind_service_btn);
        unbindServiceBtn = findViewById(R.id.unbind_service_btn);
    }


    private void initListener() {
        backTv.setOnClickListener(this);
        startServiceBtn.setOnClickListener(this);
        stopServiceBtn.setOnClickListener(this);
        bindServiceBtn.setOnClickListener(this);
        unbindServiceBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == backTv) {
            finish();
        } else if (v == startServiceBtn) {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        } else if (v == stopServiceBtn) {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        } else if (v == bindServiceBtn) {
            Intent bindIntent = new Intent(this, MyService.class);
            //BIND_AUTO_CREATE:表示在活动和服务进行绑定后自动创建服务
            //执行完这个后MyService才onCreat,但onstartCommand不会执行，需要等startService。
            bindService(bindIntent, connection, BIND_AUTO_CREATE);
        } else if (v == unbindServiceBtn) {
            unbindService(connection);
        }
    }
}