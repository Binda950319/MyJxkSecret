package com.wbh.myjxksecret.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;

/**
 * Created by Administrator on 2016/10/26.
 */
public class GobalView extends View{
    public static final String[] LETTERS = {"A","B","C","D","E","F","G","H","I",
            "J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#"};
    private Paint mTextPaint;
    // 指定一个 默认值（不在我们的数组下标范围内）
    private int pressedPosition = -1;
    private ExpandableListView expandableListView;

    // 持有一个TextView
//    private TextView mSelectedText;

//    public void setSelectedText(TextView mSelectedText){
//        this.mSelectedText = mSelectedText;
//    }

    public GobalView(Context context) {
        this(context,null);
    }

    public GobalView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GobalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mTextPaint = new Paint();
        // 设置抗锯齿
        mTextPaint.setAntiAlias(true);

    }

    public void setselectedItem(ExpandableListView expandableListView){
        this.expandableListView=expandableListView;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取高度
        int height = getHeight();
        // 获取宽度
        int width = getWidth();
        // 字符序列的长度
        int lettersLength = LETTERS.length;
        // 每一个字符的高度
        int singleHeight = height / lettersLength;
        // 绘制每一个字母
        for (int i = 0; i < lettersLength; i++) {
            int yPosition = singleHeight + i * singleHeight-10;
            // 宽度的一半  减去 文字宽度的一半
            int xPosition = (int) (width/2 - mTextPaint.measureText(LETTERS[i])/2);
            if (pressedPosition == i) {
                mTextPaint.setColor(Color.GREEN);
                mTextPaint.setTextSize(30);
            }else{

                mTextPaint.setColor(Color.BLACK);
                mTextPaint.setTextSize(30);
            }
            canvas.drawText(LETTERS[i],xPosition,yPosition,mTextPaint);
        }
    }

    /**
     *  ACTION_DOWN 手指落下
     *  ACTION_MOVE 手指移动
     *  ACTION_UP   手指抬起
     *
     *
     *  如果一个事件没有消费，也没有被拦截，那么只有ACTION_DOWN的动作
     *  不会有陆续的动作，如果我们想要获取其它动作，我们就要消费事件。
     *  返回值true 代表消费事件，false 表示不处理事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                getParent().requestDisallowInterceptTouchEvent(true);
                // 获取纵向的落点
                float eventYy = event.getY();
                // 单一的字母的高度
                int singleHeighty = getMeasuredHeight() / LETTERS.length;
                // 计算按下的位置
                pressedPosition = ((int) (eventYy / singleHeighty));

                boolean ishave=false;
                int posi=0;
                if (expandableListView != null) {
                    if (pressedPosition >= 0 && pressedPosition < LETTERS.length) {
                        expandableListView.setSelectedGroup(pressedPosition);
//                        expandableListView.smoothScrollToPosition(pressedPosition);
                    }

                }
                // 申请重绘
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                getParent().requestDisallowInterceptTouchEvent(true);
                // 获取纵向的落点
                float eventY = event.getY();
                // 单一的字母的高度
                int singleHeight = getMeasuredHeight() / LETTERS.length;
                // 计算按下的位置
                pressedPosition = ((int) (eventY / singleHeight));


                if (expandableListView != null) {
                    if (pressedPosition >= 0 && pressedPosition < LETTERS.length) {
                        expandableListView.setSelectedGroup(pressedPosition);
//                        expandableListView.smoothScrollToPosition(pressedPosition);

                    }

                }
                // 申请重绘
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                // 还原按下位置为默认状态
                pressedPosition = -1;
//                // 隐藏选中的字母
//                if (mSelectedText != null) {
//                    mSelectedText.setVisibility(GONE);
//                }
                // 申请重绘
                invalidate();
                break;
        }
        return true;
    }
}
