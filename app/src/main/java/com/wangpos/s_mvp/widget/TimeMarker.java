package com.wangpos.s_mvp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.wangpos.s_mvp.R;

/**
 * Created by qiyue on 2016/9/19 0019.
 *
 * 实现思路，把时间线分为三个部分，上竖线，下竖线，和中间圆
 *
 * 先在onMeasure测量圆的高度 resolveSize是一个很好的方法
 * 先在onSizeChange中设置圆的位置，通过圆的位置的中心点对准上边界画出上竖线，下竖线也是一样
 *
 *
 */
public class TimeMarker extends View {
    private int mMakerSize ;

    private int lineSize;
    private Drawable mStartLine;
    private Drawable mEndLine;
    private Drawable mTimerMaker;
    private Paint mOutCirclePaint;
    Rect bounds;
    public TimeMarker(Context context) {
        super(context);
    }

    public TimeMarker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public TimeMarker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.TimeLineMarker);
        lineSize = a.getDimensionPixelSize(R.styleable.TimeLineMarker_lineSize,10);
        mMakerSize = a.getDimensionPixelSize(R.styleable.TimeLineMarker_markerSize,20);
        mEndLine = a.getDrawable(R.styleable.TimeLineMarker_endLine);
        mStartLine = a.getDrawable(R.styleable.TimeLineMarker_beginLine);
        mTimerMaker = a.getDrawable(R.styleable.TimeLineMarker_marker);
        a.recycle();
        mOutCirclePaint = new Paint();
        mOutCirclePaint.setColor(Color.RED);
        mOutCirclePaint.setStrokeWidth(4);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = mMakerSize + getPaddingLeft() + getPaddingRight();
        int h = mMakerSize + getPaddingTop() + getPaddingBottom();
        /**
         * 测量，父容器允许的宽高，还有就是子控件
         *
         * resolveSizeAndState ，很棒的一个方法
         */
        int widthSize = resolveSizeAndState(w,widthMeasureSpec,0);
        int heightSize = resolveSizeAndState(h,heightMeasureSpec,0);
        setMeasuredDimension(widthSize,heightSize);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mEndLine!=null) {
            mEndLine.draw(canvas);
        }
        if(mStartLine!=null) {
            mStartLine.draw(canvas);
        }
        if(mTimerMaker!=null) {
            mTimerMaker.draw(canvas);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int pleft = getPaddingLeft();
        int pRight = getPaddingRight();
        int pTop = getPaddingTop();
        int pBottom = getPaddingBottom();
        /**
         * 根据父类测量的宽高
         */
        int width = getWidth();
        int height = getHeight();
        /**
         * 圆的宽高大小
         */
        int circleWidth = width - pleft -pRight;
        int circleHeight = height -pTop - pBottom;
        /**
         *
         */
        if (mTimerMaker!=null){
            //取最小值
            int makerSize = Math.min(mMakerSize,circleWidth);
            mTimerMaker.setBounds(pleft,pTop,pleft+makerSize,pTop+makerSize);
            bounds = mTimerMaker.getBounds();
        }else{
            //没有数据的时候
            bounds = new Rect(pleft,pTop,pleft+circleWidth,pTop+height);
        }
        int lineLeft=bounds.centerX() - (lineSize>>1);//表示除以2的意思
        /**
         *   设置开始线位置
         */
        if ( mStartLine != null){
             mStartLine.setBounds(lineLeft,0,lineLeft+lineSize,bounds.top);
        }
        /**
         *   设置结束线位置
         */
        if ( mEndLine != null){
             mEndLine.setBounds(lineLeft,bounds.bottom,lineLeft+lineSize,height);
        }
    }

    public int getmMakerSize() {
        return mMakerSize;
    }

    public void setmMakerSize(int mMakerSize) {
        this.mMakerSize = mMakerSize;
    }

    public int getLineSize() {
        return lineSize;
    }

    public void setLineSize(int lineSize) {
        this.lineSize = lineSize;
    }

    public Drawable getmStartLine() {
        return mStartLine;
    }

    public void setmStartLine(Drawable mStartLine) {
        this.mStartLine = mStartLine;
    }

    public Drawable getmEndLine() {
        return mEndLine;
    }

    public void setmEndLine(Drawable mEndLine) {
        this.mEndLine = mEndLine;
    }

    public Drawable getmTimerMaker() {
        return mTimerMaker;
    }

    public void setmTimerMaker(Drawable mTimerMaker) {
        this.mTimerMaker = mTimerMaker;
    }




}
