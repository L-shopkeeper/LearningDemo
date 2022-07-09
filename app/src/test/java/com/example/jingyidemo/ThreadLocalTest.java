package com.example.jingyidemo;

import androidx.annotation.Nullable;

import org.junit.Test;

public class ThreadLocalTest {

    @Test
    public void test() {
        //创建本地线程（主线程）
        final ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
            @Nullable
            @Override
            protected String initialValue() {
                //初始化方法，默认返回null
//                return super.initialValue();
                //重写初始化方法，默认返回“jingyi”
                return "jingyi";
            }
        };
        threadLocal.get();
    }
}
