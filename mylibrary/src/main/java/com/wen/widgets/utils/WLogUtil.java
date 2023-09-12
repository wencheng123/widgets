package com.wen.widgets.utils;

import android.util.Log;

/***
 * @Author wen
 * @Date 2023/9/12 14:17
 * @Desc  日志打印工具类
 *
 ***/
public class WLogUtil {

    private static final String TAG = "WLogUtil=== ";

    public static void i(String msg) {
        Log.i(TAG, msg);
    }
}
