package com.pzdf.testview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pzdf.testview.R;

import java.util.List;

public class MessageBubbleFragment extends Fragment {
    private ListView mListView;
    private List<String> mItems;
    public static MessageBubbleFragment newInstance(String item) {
        MessageBubbleFragment itemFragment = new MessageBubbleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", item);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_bubble_fragment, null);

        // 获取完之后是不是要设置为 GONE
//        View loadingView = view.findViewById(R.id.load_view);
//        loadingView.setVisibility(View.VISIBLE);
        // 只是把它隐藏  58同城的加载动画讲过一次了
        // 10 个页面  内存泄漏  就是对象不可回收
        // 比如当前 Activity 关闭 但是实例一直存在内存中（就是被别人持有了）
        // 在项目中给大家讲 后面会专门讲 100 次  40次架构  10 kotlin  30 NDK  内存优化
        // 明天 上一次数学课 三角函数   QQ消息拖拽贝塞尔
        return view;
    }
}
