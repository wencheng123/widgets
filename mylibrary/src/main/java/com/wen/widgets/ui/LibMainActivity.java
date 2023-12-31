package com.wen.widgets.ui;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.wen.widgets.R;
import com.wen.widgets.utils.WDensityUtil;
import com.wen.widgets.utils.WKeyBoardUtil;
import com.wen.widgets.utils.WLogUtil;
import com.wen.widgets.utils.WToastUtil;
import com.wen.widgets.wheelview.ArrayWheelAdapter;
import com.wen.widgets.wheelview.OnItemSelectedListener;
import com.wen.widgets.wheelview.WheelView;

import java.util.ArrayList;

/***
 * @Author wen
 * @Date 2023/9/12 14:48
 * @Desc
 *
 ***/
public class LibMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_main_activity);

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        WheelView wheelView = findViewById(R.id.wheel_view);
        wheelView.setAdapter(new ArrayWheelAdapter(list));
        wheelView.setAlphaGradient(true);
        wheelView.setCyclic(false);
//        wheelView.setCurrentItem(0);
//        wheelView.setDividerType(WheelView.DividerType.ROUND_RECT);
        wheelView.setLineSpacingMultiplier(2f);
        wheelView.setTextSize(18f);
        wheelView.setDividerColor(Color.parseColor("#EEEEEE"));
        wheelView.setTextColorCenter(Color.parseColor("#333333"));
        wheelView.setTextColorOut(Color.parseColor("#999999"));


        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                Point screenSize = WDensityUtil.getScreenSize(LibMainActivity.this);
            }
        });

        View view = findViewById(R.id.view);

        WKeyBoardUtil.addOnSoftKeyboardListener(this, new WKeyBoardUtil.OnKeyStateListener() {
            @Override
            public void onKeyboardShow(int keyboardHeight) {
                WLogUtil.i("=====onShow:" + keyboardHeight);
                if (keyboardHeight > 0) {
                    view.getLayoutParams().height = keyboardHeight;
                }
            }
            @Override
            public void onKeyboardHide() {
                WLogUtil.i("=====onHide:" );
//                TextView textView = new TextView(LibMainActivity.this);
//                textView.setText("测试自定义View");
                WToastUtil.show(LibMainActivity.this,"textView");


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WKeyBoardUtil.removeOnSoftKeyboardListener(this);

    }
}
