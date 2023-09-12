package com.wen.widgets.wheelview;

import java.util.List;

/***
 * @Author wen
 * @Date 2023/9/12 15:13
 * @Desc
 *
 ***/
public class ArrayWheelAdapter implements WheelAdapter<String> {

    private List<String> mList;

    public ArrayWheelAdapter(List<String> list) {
        mList = list;
    }

    @Override
    public int getItemsCount() {
        return mList.size();
    }

    @Override
    public String getItem(int index) {
        return mList.get(index);
    }

    @Override
    public int indexOf(String o) {
        return mList.indexOf(o);
    }
}
