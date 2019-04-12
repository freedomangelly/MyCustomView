package com.pzdf.testview.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.pzdf.testview.R;

public class MyTestView extends View {
    private Paint mPaint;
    private String mText;
    private int mTextSize = 15;
    private int mTextColor = Color.BLACK;

    public MyTestView(Context context) {
        this(context,null);
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyTestView);

        mText = array.getString(R.styleable.MyTestView_darrenText);
        mTextColor = array.getColor(R.styleable.MyTestView_darrenTextColor, mTextColor);
        // 15 15px 15sp
        mTextSize = array.getDimensionPixelSize(R.styleable.MyTestView_darrenTextSize,sp2px(mTextSize));

        // 回收
        array.recycle();
        Log.i("info","MyTestView 3");
        mPaint=new Paint();
        mPaint.setTextAlign(Paint.Align.LEFT);//主要是这里的取值不一样
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(mTextSize);
//        this.draw(new Canvas());
    }

    private int sp2px(int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,sp,
                getResources().getDisplayMetrics());
    }
    /*继承不是view的自定义布局，执行onDraw的方法
    *        1。super.dispatchDraw(canvas);//调用此方法可以
    *        2。可以设置透明背景
    *        3。setWillNotDraw(true);
     */
    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("info","onDraw");




//        mPaint.setColor(Color.parseColor("#23AC3B"));
//
////        canvas.drawLine(200, 0, 200, getHeight(), mPaint);
//
//        Paint.FontMetricsInt fontMetrics=mPaint.getFontMetricsInt();
//        int dy=(Math.abs(fontMetrics.descent-fontMetrics.ascent)/2-fontMetrics.descent)+200;
//        int baseLine=dy;
//


////        canvas.drawLine(0, 0, getWidth(), getHeight(), mPaint);
//        canvas.drawLine(0, baseLine, getWidth(), baseLine, mPaint);
//
//        canvas.drawText("abcdefghijk", 200, baseLine, mPaint);


                /*// 画文本
        canvas.drawText();
        // 画弧
        canvas.drawArc();
        // 画圆
        canvas.drawCircle();*/
        // 画文字 text  x  y  paint
        // x 就是开始的位置   0
        // y 基线 baseLine   求？   getHeight()/2知道的   centerY


        //dy 代表的是：高度的一半到 baseLine的距离
        Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
        // top 是一个负值  bottom 是一个正值    top，bttom的值代表是  bottom是baseLine到文字底部的距离（正值）
        // 必须要清楚的，可以自己打印就好
        int dy = (fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
        int baseLine = getHeight()/2 + dy;

        int x = getPaddingLeft();

        canvas.drawText(mText,x,baseLine,mPaint);
        canvas.drawLine(0, fontMetrics.top, getWidth(), fontMetrics.top, mPaint);
        canvas.drawLine(0, fontMetrics.ascent, getWidth(), fontMetrics.ascent, mPaint);
        canvas.drawLine(0, fontMetrics.descent, getWidth(), fontMetrics.descent, mPaint);
        canvas.drawLine(0, fontMetrics.bottom, getWidth(), fontMetrics.bottom, mPaint);
        canvas.drawLine(0, baseLine, getWidth(), baseLine, mPaint);
                Log.i("info","base line="+baseLine);
        Log.i("info","fontMetrics.top="+fontMetrics.top);
        Log.i("info","fontMetrics.ascent="+fontMetrics.ascent);
        Log.i("info","fontMetrics.descent="+fontMetrics.descent);
        Log.i("info","fontMetrics.bottom="+fontMetrics.bottom);
    }



    /**
     * 自定义View的测量方法
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 布局的宽高都是由这个方法指定
        // 指定控件的宽高，需要测量
        // 获取宽高的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        // 1.确定的值，这个时候不需要计算，给的多少就是多少
        int width = MeasureSpec.getSize(widthMeasureSpec);

        // 2.给的是wrap_content 需要计算
        if(widthMode == MeasureSpec.AT_MOST){
            // 计算的宽度 与 字体的长度有关  与字体的大小  用画笔来测量
            Rect bounds = new Rect();
            // 获取文本的Rect
            mPaint.getTextBounds(mText,0,mText.length(),bounds);
            width = bounds.width() + getPaddingLeft() +getPaddingRight();
        }

        int height = MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode == MeasureSpec.AT_MOST){
            // 计算的宽度 与 字体的长度有关  与字体的大小  用画笔来测量
            Rect bounds = new Rect();
            // 获取文本的Rect
            mPaint.getTextBounds(mText,0,mText.length(),bounds);
            height = bounds.height() + getPaddingTop() + getPaddingBottom();
        }

        // 设置控件的宽高
        setMeasuredDimension(width,height);
    }

    /**
     * 处理跟用户交互的，手指触摸等等
     * @param event 事件分发事件拦截
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 手指按下
                Log.e("TAG","手指按下");
                break;

            case MotionEvent.ACTION_MOVE:
                // 手指移动
                Log.e("TAG","手指移动");
                break;

            case MotionEvent.ACTION_UP:
                // 手指抬起
                Log.e("TAG","手指抬起");
                break;
        }

        invalidate();

        return super.onTouchEvent(event);
    }
}
