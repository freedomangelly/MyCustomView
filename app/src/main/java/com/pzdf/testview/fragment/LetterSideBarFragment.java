package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pzdf.testview.myview.LetterSideBar;
import com.pzdf.testview.R;

public class LetterSideBarFragment extends Fragment implements LetterSideBar.LetterTouchListener {
    LetterSideBar mLetterSideBar;
    TextView mLetterTv;
    public static LetterSideBarFragment newInstance(String item) {
        LetterSideBarFragment itemFragment = new LetterSideBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lettersidebarfragment, null);
        mLetterSideBar = (LetterSideBar) view.findViewById(R.id.letter_side_bar);
        mLetterTv = (TextView) view.findViewById(R.id.letter_tv);
        mLetterSideBar.setOnLetterTouchListener(this);
//        TextView tv = (TextView) view.findViewById(R.id.text);
////        Bundle bundle = getArguments();
////        tv.setText(bundle.getString("title"));
        return view;
    }

    @Override
    public void touch(CharSequence letter, boolean isTouch) {
        if(isTouch) {
            mLetterTv.setVisibility(View.VISIBLE);
            mLetterTv.setText(letter);
        }else{
            mLetterTv.setVisibility(View.GONE);
        }
    }
}
