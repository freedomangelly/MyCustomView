package com.pzdf.testview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.pzdf.testview.fragment.BaseMenuFragment;
import com.pzdf.testview.fragment.ColorTrackTextViewFragment;
import com.pzdf.testview.fragment.LetterSideBarFragment;
import com.pzdf.testview.fragment.LockPatternFragment;
import com.pzdf.testview.fragment.LodingViewFragment;
import com.pzdf.testview.fragment.MyTestViewFragment;
import com.pzdf.testview.fragment.ProgressBarFragment;
import com.pzdf.testview.fragment.QQStepViewFragment;
import com.pzdf.testview.fragment.RatingBarFragement;
import com.pzdf.testview.fragment.ShapeViewFragment;
import com.pzdf.testview.fragment.VerticalDragFragment;
import com.pzdf.testview.myview.ColorTrackTextView;
import com.pzdf.testview.myview.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Email 240336124@qq.com
 * Created by Darren on 2017/5/21.
 * Version 1.0
 * Description:
 */
public class ViewPagerActivity extends AppCompatActivity {
    private String[] items = {"MyTestView", "QQStepView", "ColorTrackTextView", "RatingBar", "ShapeView", "ProgressBar", "LetterSideBar", "verticalDrag", "LockPattern", "LodingView", "baseMenu"};
    private LinearLayout mIndicatorContainer;// 变成通用的
    private List<ColorTrackTextView> mIndicators;
    private MyViewPager mViewPager;
    private HorizontalScrollView horizontalScrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mIndicators = new ArrayList<>();
        mIndicatorContainer = (LinearLayout) findViewById(R.id.indicator_view);
        mViewPager = (MyViewPager) findViewById(R.id.view_pager);
        horizontalScrollView = findViewById(R.id.scroll_view);
        initIndicator();
        initViewPager();
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = MyTestViewFragment.newInstance(items[position]);
                        break;
                    case 1:
                        fragment = QQStepViewFragment.newInstance(items[position]);
                        break;
                    case 2:
                        fragment = ColorTrackTextViewFragment.newInstance(items[position]);
                        break;
                    case 3:
                        fragment = RatingBarFragement.newInstance(items[position]);
                        break;
                    case 4:
                        fragment = ShapeViewFragment.newInstance(items[position]);
                        break;
                    case 5:
                        fragment = ProgressBarFragment.newInstance(items[position]);
                        break;
                    case 6:
                        fragment = LetterSideBarFragment.newInstance(items[position]);
                        break;
                    case 7:
                        fragment = VerticalDragFragment.newInstance(items[position]);
                        break;
                    case 8:
                        fragment = LockPatternFragment.newInstance(items[position]);
                        break;
                    case 9:
                        fragment = LodingViewFragment.newInstance(items[position]);
                        break;
                    case 10:
                        fragment = BaseMenuFragment.newInstance(items[position]);
                        break;

                }
                return fragment;

            }

            @Override
            public int getCount() {
                return items.length;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // position 代表当前的位置
                // positionOffset 代表滚动的 0 - 1 百分比

                // 1.左边  位置 position
                ColorTrackTextView left = mIndicators.get(position);
                left.setDirection(ColorTrackTextView.Direction.RIGHT_TO_LEFT);
                left.setCurrentProgress(1 - positionOffset);

                try {
                    ColorTrackTextView right = mIndicators.get(position + 1);
                    right.setDirection(ColorTrackTextView.Direction.LEFT_TO_RIGHT);
                    right.setCurrentProgress(positionOffset);
                } catch (Exception e) {

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化可变色的指示器
     */
    private void initIndicator() {
        for (int i = 0; i < items.length; i++) {
            // 动态添加颜色跟踪的TextView
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            ColorTrackTextView colorTrackTextView = new ColorTrackTextView(this);
            // 设置颜色
            colorTrackTextView.setTextSize(20);
            colorTrackTextView.setChangeColor(Color.RED);
            colorTrackTextView.setText(items[i]);
            colorTrackTextView.setLayoutParams(params);
            // 把新的加入LinearLayout容器
            mIndicatorContainer.addView(colorTrackTextView);
            // 加入集合
            mIndicators.add(colorTrackTextView);
        }

    }


}
