package com.wen.widgets.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/***
 * @Author wen
 * @Date 2023/9/15 14:21
 * @Desc 手机屏幕密度计算工具类
 *
 ***/
public class WDensityUtil {


    /**
     * 将dip转为px
     *
     * @param context 上下文
     * @param dpValue dip
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px转为dip
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 获取手机屏幕的宽、高
     *
     * @param context
     * @return Point(宽, 高)
     */
    public static Point getScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }
}
