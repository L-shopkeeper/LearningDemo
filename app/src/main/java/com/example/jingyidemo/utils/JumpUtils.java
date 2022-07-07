package com.example.jingyidemo.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.jingyidemo.MainActivity;
import com.example.jingyidemo.datastructure.DataStructureTestActivity;

/**
 * 界面跳转工具类
 */
public class JumpUtils {

    private static JumpUtils jumpUtils;

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

    public void jumpToHandlerTestActivity() {
    }
}
