package com.pzdf.testview.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pzdf.testview.myview.ProgressBar;
import com.pzdf.testview.R;

public class ProgressBarFragment extends Fragment {
    ProgressBar mProgressBar;
    public static ProgressBarFragment newInstance(String item) {
        ProgressBarFragment itemFragment = new ProgressBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progressbar, null);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
//        TextView tv = (TextView) view.findViewById(R.id.text);
////        Bundle bundle = getArguments();
////        tv.setText(bundle.getString("title"));
        startProgressBar();
        return view;
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
}
