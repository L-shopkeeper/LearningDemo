package com.example.jingyidemo.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    //实现activity对service的控制，以及service反馈给activity信息，用户显示
    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d("MyService", "startDownload executed");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        //让活动activity和service的关系更紧密一点
        //在活动中指挥服务去干什么
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //服务创建时调用
        Log.d("MyService", "onCreate executed");
        //创建前台服务
        Intent intent = new Intent(this, ServiceTestActivity.class);
        //PendingIntent是对Intent的封装，但它不是立刻执行某个行为，
        // 而是满足某些条件或触发某些事件后才执行指定的行为
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
        //服务启动时调用
        //通常情况下，如果我们希望服务一旦启动就立刻去执行某个动作，就可以将逻辑卸载这里。
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //服务销毁时调用
        //回收不再使用的资源
    }
}