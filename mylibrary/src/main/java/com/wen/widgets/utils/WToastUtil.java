package com.wen.widgets.utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/***
 * @Author wen
 * @Date 2023/9/27 12:25
 * @Desc Toast工具类
 *
 ***/
public class WToastUtil {

    private static Toast mToast = null;

    /**
     * Toast-短提示
     *
     * @param context
     * @param msg
     */
    public static void show(Context context, String msg) {
        if (context == null || msg == null || msg.isEmpty()) {
            WLogUtil.e("===WToastUitl->show()参数异常");
            return;
        }

        if (mToast == null) {
            mToast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * Toast-短提示（自定义View）
     *
     * @param context
     * @param msg
     */
    public static void show(Context context, View view) {
        if (context == null || view == null) {
            WLogUtil.e("===WToastUitl->show()参数异常");
            return;
        }
        if (mToast == null) {
            mToast = new Toast(context);
        }
        mToast.setView(view);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    /**
     * 关闭Toast
     */
    private static void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
