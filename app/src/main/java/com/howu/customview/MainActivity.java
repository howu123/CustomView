package com.howu.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.howu.customview.view.TaijiView;

public class MainActivity extends AppCompatActivity {
    private TaijiView taijiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        taijiView =(TaijiView)findViewById(R.id.taiji);
        //添加旋转动画
        RotateAnimation animation = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        animation.setInterpolator(linearInterpolator);
        animation.setDuration(5000);
        animation.setFillAfter(true);//保持最后状态
        animation.setRepeatMode(Animation.RESTART);
        animation.setRepeatCount(Animation.INFINITE);//无限循环
        taijiView.startAnimation(animation);
    }
}
