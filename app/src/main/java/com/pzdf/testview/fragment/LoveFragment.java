package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pzdf.testview.R;
import com.pzdf.testview.myview.day26.LoveLayout;

import java.util.List;

public class LoveFragment extends Fragment {
    private ListView mListView;
    private List<String> mItems;
    private LoveLayout mLoveLayout;
//    private Button btn;

    public static LoveFragment newInstance(String item) {
        LoveFragment itemFragment = new LoveFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.love_fragment, null);
        mLoveLayout = (LoveLayout) view.findViewById(R.id.love_layout);
//        btn = (Button) view.findViewById(R.id.btn_love);
        mLoveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoveLayout.addLove();
            }
        });
        return view;
    }

}
