package com.wbh.myjxksecret.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/10/28.
 * <p/>
 * 重写ViewPager，覆盖ViewPager的onInterceptTouchEvent(MotionEvent arg0)方法
 * 和onTouchEvent(MotionEvent arg0)方法，
 * 这两个方法的返回值都是boolean类型的，只需要将返回值改为false，
 * 那么ViewPager就不会消耗掉手指滑动的事件了，
 * 转而传递给上层View去处理或者该事件就直接终止了。
 */
public class MyViewPager extends ViewPager {
    private boolean noScroll = false;

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

}
