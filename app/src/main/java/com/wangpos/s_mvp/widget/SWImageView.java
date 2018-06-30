package com.wangpos.s_mvp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by qiyue on 2018/6/29.
 * 等宽ImageView
 */

@SuppressLint("AppCompatCustomView")
public class SWImageView extends ImageView {
    public SWImageView(Context context) {
        super(context,null);
    }

    public SWImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SWImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,widthMeasureSpec);
    }
}
