package com.pzdf.testview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;

import com.pzdf.testview.myview.ColorTrackTextView;
import com.pzdf.testview.myview.ProgressBar;
import com.pzdf.testview.myview.QQStepView;
import com.pzdf.testview.myview.ShapeView;

public class MainActivity extends AppCompatActivity {
    ColorTrackTextView mColorTrackTextView;
    QQStepView qqStepView;
    ShapeView mShapeView;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mColorTrackTextView=findViewById(R.id.color_track_tv);
//        qqStepView = (QQStepView) findViewById(R.id.step_view);
//        mShapeView = (ShapeView) findViewById(R.id.shape_view);
//        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
//
//        startQqStepView();
//        leftToRight();
//        startProgressBar();
//        startShapeView();
    }

    private void startShapeView() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mShapeView.exchange();
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
    }

    private void startProgressBar() {
        mProgressBar.setMax(4000);

        ValueAnimator animator = ObjectAnimator.ofFloat(0, 4000);
        animator.setDuration(4000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                mProgressBar.setProgress((int) progress);
                if(progress==4000){
                    startProgressBar();
                }
            }
        });
    }

    private void startQqStepView() {
        qqStepView.setStepMax(10000);

        // 属性动画 后面讲的内容
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 10000);
        valueAnimator.setDuration(3000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentStep = (float) animation.getAnimatedValue();
                qqStepView.setCurrentStep((int)currentStep);
                if((int)currentStep==10000){
                    startQqStepView();
                }
            }
        });
        valueAnimator.start();
    }


    public void leftToRight(){

        mColorTrackTextView.setDirection(ColorTrackTextView.Direction.LEFT_TO_RIGHT);
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentProgress = (float) animation.getAnimatedValue();
                mColorTrackTextView.setCurrentProgress(currentProgress);
                if((int)currentProgress==1){
                    rightToLeft();
                }
            }
        });
        valueAnimator.start();
    }

    public void rightToLeft(){
        mColorTrackTextView.setDirection(ColorTrackTextView.Direction.RIGHT_TO_LEFT);
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentProgress = (float) animation.getAnimatedValue();
                mColorTrackTextView.setCurrentProgress(currentProgress);
                if((int)currentProgress==1){
                    leftToRight();
                }
            }
        });
        valueAnimator.start();
    }
}
