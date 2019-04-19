package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pzdf.testview.R;
import com.pzdf.testview.myview.day25.BubbleMessageTouchListener;
import com.pzdf.testview.myview.day25.MessageBubbleView;

public class MessageBubble2Fragment extends Fragment {
    public static MessageBubble2Fragment newInstance(String item) {
        MessageBubble2Fragment itemFragment = new MessageBubble2Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_bubble2_fragment, null);

        MessageBubbleView.attach(view.findViewById(R.id.text_view),new  BubbleMessageTouchListener.BubbleDisappearListener() {
            @Override
            public void dismiss(View view) {
                view.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}
