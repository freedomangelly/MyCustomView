package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pzdf.testview.R;
import com.pzdf.testview.myview.day31.RedPackageView;

import java.util.List;

public class RedPackageFragment extends Fragment {
    private ListView mListView;
    private List<String> mItems;
    RedPackageView red_pack_view;
    public static RedPackageFragment newInstance(String item) {
        RedPackageFragment itemFragment = new RedPackageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.redpackage_fragment, null);
        red_pack_view=view.findViewById(R.id.red_pack_view);
        red_pack_view.setTotalProgress(3);
        red_pack_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red_pack_view.startAnimation(0,3);
            }
        });
        return view;
    }
}
