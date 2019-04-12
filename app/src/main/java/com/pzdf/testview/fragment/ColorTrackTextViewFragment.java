package com.pzdf.testview.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pzdf.testview.myview.ColorTrackTextView;
import com.pzdf.testview.R;

public class ColorTrackTextViewFragment extends Fragment {
    ColorTrackTextView mColorTrackTextView;
    public static ColorTrackTextViewFragment newInstance(String item) {
        ColorTrackTextViewFragment itemFragment = new ColorTrackTextViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colortracktextview, null);
        mColorTrackTextView=view.findViewById(R.id.color_track_tv);
//        TextView tv = (TextView) view.findViewById(R.id.text);
////        Bundle bundle = getArguments();
////        tv.setText(bundle.getString("title"));
        leftToRight();
        return view;
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
