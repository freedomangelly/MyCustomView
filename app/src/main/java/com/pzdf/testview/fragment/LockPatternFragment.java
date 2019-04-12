package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pzdf.testview.R;

public class LockPatternFragment extends Fragment {
    public static LockPatternFragment newInstance(String item) {
        LockPatternFragment itemFragment = new LockPatternFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lockpattern, null);
//        TextView tv = (TextView) view.findViewById(R.id.text);
////        Bundle bundle = getArguments();
////        tv.setText(bundle.getString("title"));
        return view;
    }
}
