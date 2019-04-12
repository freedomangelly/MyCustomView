package com.pzdf.testview.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pzdf.testview.R;
import com.pzdf.testview.myview.ShapeView;

public class ShapeViewFragment extends Fragment {
    ShapeView mShapeView;
    public static ShapeViewFragment newInstance(String item) {
        ShapeViewFragment itemFragment = new ShapeViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shapeview, null);
        mShapeView = (ShapeView) view.findViewById(R.id.shape_view);

        return view;
    }
    public void click(View view){
        view.setVisibility(View.GONE);
    }

    public void start(View view){
        Intent intent = new Intent(getContext(),getActivity().getClass());
        startActivity(intent);
    }
}
