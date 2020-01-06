package com.howu.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class TaijiView extends View {
    Paint mPaint;//画笔
    float mViewWidth;//屏幕宽
    float mViewHeight;//屏幕高

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
    }

    public TaijiView(Context context) {
        super(context);
    }

    public TaijiView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        canvas.translate(mViewWidth / 2, mViewHeight / 2);//将原点移到屏幕中心，其实是移动画布

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);//抗锯齿

        float r = (float) (mViewWidth / 2 * 0.8);

        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        Path path4 = new Path();
        Path path5 = new Path();
        Path path6 = new Path();

        mPaint.setStyle(Paint.Style.FILL);
        path1.addCircle(0, 0, r, Path.Direction.CW);
        path2.addRect(0, -r, r, r, Path.Direction.CW);
        path3.addCircle(0, -r / 2, r / 2, Path.Direction.CW);
        path4.addCircle(0, r / 2, r / 2, Path.Direction.CCW);
        path5.addCircle(0, -r / 2, r / 8, Path.Direction.CW);
        path6.addCircle(0, r / 2, r / 8, Path.Direction.CW);

        path1.op(path2, Path.Op.DIFFERENCE);//取差集，即path1减去path2后剩下的部分,得到半圆
        path1.op(path3, Path.Op.UNION);//取并集，即两者相加
        path1.op(path4, Path.Op.DIFFERENCE);
        path1.op(path5, Path.Op.DIFFERENCE);
        path1.op(path6, Path.Op.UNION);

        canvas.drawPath(path1, mPaint);
        //绘制外圈
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(0, 0, r, mPaint);
    }
}
