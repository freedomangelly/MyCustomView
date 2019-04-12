package com.pzdf.testview.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import com.pzdf.testview.myview.QQStepView;
import com.pzdf.testview.R;

public class QQStepViewFragment extends Fragment {
    QQStepView qqStepView;
    public static QQStepViewFragment newInstance(String item) {
        QQStepViewFragment itemFragment = new QQStepViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qqstepview, null);
        qqStepView = (QQStepView) view.findViewById(R.id.step_view);
//        TextView tv = (TextView) view.findViewById(R.id.text);
////        Bundle bundle = getArguments();
////        tv.setText(bundle.getString("title"));
        startQqStepView();
        return view;
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
}
