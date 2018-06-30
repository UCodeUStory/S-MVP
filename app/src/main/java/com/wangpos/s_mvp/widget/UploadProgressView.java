package com.wangpos.s_mvp.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.wangpos.s_mvp.R;


/**
 * Created by qiyue on 2017/4/17.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class UploadProgressView extends View {

    private int mWidth;
    private int mHeight;
    private Paint mPaint;

    private Paint mTextPaint;

    private int bitmapW;
    private int bitmapH;
    private int clipH;
    private ValueAnimator animator;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    /**
     * 定义自定义属性
     */
    private int scrollTime = 1000;

    private String text = "视频上传";

    private int  maskColor = 0x33000000;

    private float textSize = 40;

    private int textColor = 0xff333333;

    private int currentProgress = 0;



    public UploadProgressView(Context context) {
        this(context,null);
    }

    public UploadProgressView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public UploadProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.UploadProgressView);
        this.maskColor = ta.getColor(R.styleable.UploadProgressView_maskColor,0x33000000);
//        this.textSize = dip2px(getContext(),(ta.getDimension(R.styleable.UploadProgressView_text_Size,40f)));

        this.textSize = (int)ta.getDimension(R.styleable.UploadProgressView_text_Size,40f);
        this.textColor = ta.getColor(R.styleable.UploadProgressView_text_Color,0xff333333);
        this.scrollTime = ta.getInt(R.styleable.UploadProgressView_animationTime,1000);
        ta.recycle();

        text = getResources().getString(R.string.video_upload);
        initPaints();
        initData();
    }

    private void initPaints() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(maskColor);
        mPaint.setTextAlign(Paint.Align.CENTER);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(textColor);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);



    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initData() {


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    /**
     * 动态改变显示区域
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Rect rectBg = new Rect(0,0,bitmapW,mHeight);
        Rect clipRect = new Rect(0,clipH,bitmapW,bitmapH);
        canvas.clipRect(clipRect);
        canvas.drawRect(rectBg,mPaint);
        canvas.restore();


//        Rect lineRect = new Rect(0,lineStart,mWidth,lineEnd);
//        canvas.drawBitmap(line,null,lineRect,mPaint);
        float x = mWidth/2;
        float y = mHeight/2;
        canvas.drawText(text,x,y,mTextPaint);
        canvas.drawText(currentProgress+"%",x,y+dip2px(getContext(),17),mTextPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
        bitmapW = mWidth;
        bitmapH = mHeight;
        // startAnimation();
        if (this.animator==null) {
            this.animator = ValueAnimator.ofInt(0, mHeight);
            animator.setDuration(scrollTime);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    public void startMyAnimation() {
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction =  animation.getAnimatedFraction();
                currentProgress = (int)(fraction*100);
                int h = (int) animation.getAnimatedValue();
//                L.i("qiyue",">>>>fraction>>>>>>>>>>>>>="+currentProgress);
                clipH = h;

                invalidate();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                 UploadProgressView.this.setVisibility(GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
        invalidate();
    }

    public void stopAnimation(){
        animator.cancel();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static float dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return  (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
