package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pzdf.testview.R;

import java.util.ArrayList;
import java.util.List;

public class VerticalDragFragment extends Fragment {
    private ListView mListView;
    private List<String> mItems;
    public static VerticalDragFragment newInstance(String item) {
        VerticalDragFragment itemFragment = new VerticalDragFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verticaldrag, null);
//        TextView tv = (TextView) view.findViewById(R.id.text);
////        Bundle bundle = getArguments();
////        tv.setText(bundle.getString("title"));
        mListView = (ListView) view.findViewById(R.id.list_view);

        mItems = new ArrayList<String>();

        for (int i=0;i<200;i++){
            mItems.add("i -> "+i);
        }

        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mItems.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView item = (TextView) LayoutInflater.from(getContext())
                        .inflate(R.layout.item_lv, parent, false);
                item.setText(mItems.get(position));
                return item;
            }
        });
        return view;
    }
}
