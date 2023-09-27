package com.wen.widgets.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;

/***
 * @Author wen
 * @Date 2023/9/26 18:15
 * @Desc 软键盘工具类
 ***/
public class WKeyBoardUtil {

    /**
     * 显示软键盘
     *
     * @param context
     * @param view
     */
    public static void showSoftInput(Context context, View view) {
        try {
            InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.showSoftInput(view, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示软键盘
     *
     * @param context
     * @param view
     * @param delay   延迟多少毫秒显示软键盘
     */
    public static void showSoftInput(Context context, View view, int delay) {
        try {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showSoftInput(context, view);
                }
            }, (long) delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 隐藏软键盘
     *
     * @param context
     * @param view
     */
    public static void hideSoftInput(Context context, View view) {
        try {
            InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = null;

    /**
     * 添加软键盘高度监听
     *
     * @param activity
     * @param keyStateListener 软键盘监听
     */
    public static void addOnSoftKeyboardListener(Activity activity, OnKeyStateListener keyStateListener) {
        if (activity == null) {
            return;
        }

        final View decorView = activity.getWindow().getDecorView();
        final int statusBarHeight = getStatusBarHeight(activity);
        final int navigationHeight = getNavigationHeight(activity);

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int height = decorView.getHeight();
                int displayHeight = rect.bottom - rect.top;
                int keyboardHeight = height - displayHeight - statusBarHeight - navigationHeight;
                if (keyStateListener != null) {
                    if (keyboardHeight > 200) {
                        keyStateListener.onKeyboardShow(keyboardHeight);
                    } else {
                        keyStateListener.onKeyboardHide();
                    }
                }
            }
        };
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    /**
     * 移除软键盘高度监听
     *
     * @param activity
     */
    public static void removeOnSoftKeyboardListener(Activity activity) {
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        onGlobalLayoutListener = null;
    }


    /**
     * 获取状态栏高度
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        //红米K40报错改为下面的方法获取
//        int statusBarHeight = 0;
//        try {
//            Class<?> c = Class.forName("com.android.internal.R$dimen");
//            Object object = c.newInstance();
//            Field field = c.getField("status_bar_height");
//            int x = Integer.parseInt(field.get(object).toString());
//            statusBarHeight = context.getResources().getDimensionPixelSize(x);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return statusBarHeight;

        int statusBarHeight = 0;
        try {
            Resources resources = context.getResources();
            int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
            statusBarHeight = resources.getDimensionPixelSize(resourceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 获取底部导航栏的高度
     */
    public static int getNavigationHeight(Context context) {
        int navigationHeight = 0;
        try {
            Resources resources = context.getResources();
            int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            navigationHeight = resources.getDimensionPixelSize(resourceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return navigationHeight;
    }

    public interface OnKeyStateListener {

        /**
         * 软键盘显示回调
         *
         * @param keyboardHeight
         */
        void onKeyboardShow(int keyboardHeight);

        /**
         * 软键盘隐藏回调
         */
        void onKeyboardHide();
    }
}
