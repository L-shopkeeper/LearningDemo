package com.example.jingyidemo.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jingyidemo.R;

public class BroadcastTestActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        //通过动态注册的方式编写一个能够监听网络变化的程序
        intentFilter = new IntentFilter();
        //当网络状态发生改变时，系统发出的正是一条值为android.net.conn.CONNECTIVITY_CHANGE的广播
        //也就是说我们的广播接收器想要监听什么广播，就在这里添加相应的action
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //有注册就要有注销
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
            //告诉用户有网络还是没网络
            //ConnectivityManager：系统服务类，专门用户管理网络连接
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            //需要在AndroidManifest.xml里声明权限，访问系统的网络状态
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }
    }
}