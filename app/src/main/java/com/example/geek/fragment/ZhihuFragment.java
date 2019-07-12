package com.example.geek.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.geek.R;
import com.example.geek.adapter.MyZhihuVpAdapter;
import com.example.geek.base.BaseFragment;
import com.example.geek.ui.zhihu.HotFragment;
import com.example.geek.ui.zhihu.PaperFragment;
import com.example.geek.ui.zhihu.SpecialFragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuFragment extends BaseFragment {


    private TabLayout tab;
    private ViewPager vp;
    private RelativeLayout rl;

    public ZhihuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_zhihu, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tab = (TabLayout) inflate.findViewById(R.id.tab);
        vp = (ViewPager) inflate.findViewById(R.id.vp);
        rl = (RelativeLayout) inflate.findViewById(R.id.rl);

        ArrayList<Integer> titles = new ArrayList<>();
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        titles.add(R.string.paper);
        titles.add(R.string.select);
        titles.add(R.string.hot);
        fragments.add(new PaperFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new HotFragment());
        MyZhihuVpAdapter adapter = new MyZhihuVpAdapter(getChildFragmentManager(),getActivity(), fragments, titles);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
}
