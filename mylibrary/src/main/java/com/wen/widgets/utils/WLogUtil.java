package com.wen.widgets.utils;

import android.util.Log;

/***
 * @Author wen
 * @Date 2023/9/12 14:17
 * @Desc 日志打印工具类
 *
 ***/
public class WLogUtil {

    private static String TAG = "WLogUtil=== ";
    private static boolean isEnable = true;

    public static void setLogEnable(boolean enable) {
        isEnable = enable;
    }

    public static void setLogTag(String tag) {
        TAG = tag;
    }

    public static void i(String msg) {
        if (isEnable) {
            Log.i(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (isEnable) {
            Log.v(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (isEnable) {
            Log.e(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isEnable) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (isEnable) {
            Log.w(TAG, msg);
        }
    }
}
