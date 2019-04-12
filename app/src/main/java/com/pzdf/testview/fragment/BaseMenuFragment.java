package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pzdf.testview.R;
import com.pzdf.testview.myview.ListDataScreenView;
import com.pzdf.testview.myview.ListScreenMenuAdapter;

public class BaseMenuFragment extends Fragment {
    private ListDataScreenView mListDataScreenView;
    public static BaseMenuFragment newInstance(String item) {
        BaseMenuFragment itemFragment = new BaseMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basemenu, null);
        mListDataScreenView = (ListDataScreenView) view.findViewById(R.id.list_data_screen_view);
        mListDataScreenView.setAdapter(new ListScreenMenuAdapter(getContext()));
        return view;
    }
}
