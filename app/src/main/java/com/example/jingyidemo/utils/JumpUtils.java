package com.example.jingyidemo.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.jingyidemo.MainActivity;
import com.example.jingyidemo.broadcasttest.BroadcastTestActivity;
import com.example.jingyidemo.datastructure.DataStructureTestActivity;
import com.example.jingyidemo.fragmenttest.FragmentTestActivity;
import com.example.jingyidemo.handlertest.HandlerTestActivity;
import com.example.jingyidemo.okhttptest.OkhttpTestActivity;
import com.example.jingyidemo.servicetest.ServiceTestActivity;
import com.example.jingyidemo.sortalgorithm.SortAlgorithmActivity;

/**
 * 界面跳转工具类
 */
public class JumpUtils {

    private static JumpUtils jumpUtils;


    /**
     * DCL:双重检查
     * advantage
     * 1. 懒汉式：调用时才会初始化
     * 2.解决了懒汉式每次调用都会消耗线程同步的资源synchroized
     */
    public static JumpUtils getInstance() {
        if (jumpUtils == null) {
            synchronized (JumpUtils.class) {
                if (jumpUtils == null) {
                    jumpUtils = new JumpUtils();
                }
            }
        }
        return jumpUtils;
    }


    public void jumpToDataStructureTestActivity(Activity activity) {
        Intent intent = new Intent(activity , DataStructureTestActivity.class);
        activity.startActivity(intent);
    }

    public void jumpToHandlerTestActivity(Activity activity) {
        Intent intent = new Intent(activity , HandlerTestActivity.class);
        activity.startActivity(intent);
    }

    public void jumpToFragmentTestActivity(Activity activity) {
        Intent intent = new Intent(activity , FragmentTestActivity.class);
        activity.startActivity(intent);
    }

    public void jumpToSortAlgorithmActivity(Activity activity) {
        Intent intent = new Intent(activity, SortAlgorithmActivity.class);
        activity.startActivity(intent);
    }

    public void jumpToOKHttpTestActivity(MainActivity activity) {
        Intent intent = new Intent(activity, OkhttpTestActivity.class);
        activity.startActivity(intent);
    }

    public void jumpToBroadcastTestActivity(Activity activity){
        Intent intent = new Intent(activity, BroadcastTestActivity.class);
        activity.startActivity(intent);
    }

    public void jumpToServiceTestActivity(Activity activity){
        Intent intent = new Intent(activity, ServiceTestActivity.class);
        activity.startActivity(intent);
    }
}
