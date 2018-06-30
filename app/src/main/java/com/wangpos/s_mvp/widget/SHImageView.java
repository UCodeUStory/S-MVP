package com.wangpos.s_mvp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by qiyue on 2018/6/29.
 */

@SuppressLint("AppCompatCustomView")
public class SHImageView extends ImageView {

    public SHImageView(Context context) {
        this(context,null);
    }

    public SHImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SHImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(heightMeasureSpec,heightMeasureSpec);
    }
}
