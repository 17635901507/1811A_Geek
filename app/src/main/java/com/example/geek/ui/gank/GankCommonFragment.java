package com.example.geek.ui.gank;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.geek.R;
import com.example.geek.adapter.RlvGankAdapter;
import com.example.geek.base.BaseFragment;
import com.example.geek.bean.gank.GankBean;
import com.example.geek.mvp.gank.GankConstract;
import com.example.geek.mvp.gank.GankPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankCommonFragment extends BaseFragment implements GankConstract.IGankView<GankBean> {

    private static final String TAG = "GankCommonFragment";
    private String s;
    private GankConstract.IGankPresenter iGankPresenter;
    private RecyclerView rv;
    private RlvGankAdapter adapter;
    private ImageView iv_tech_blur;
    private ImageView iv_tech_origin;
    private TextView tv_tech_copyright;
    private AppBarLayout appBar;
    private CoordinatorLayout coordinator;
    private SwipeRefreshLayout refresh;

    public GankCommonFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public GankCommonFragment(String s) {
        this.s = s;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setPresenter(new GankPresenter());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_gank_common, container, false);
        initView(inflate);
        iGankPresenter.getTechList(s, 20, 1);
        return inflate;
    }

    @Override
    public void onSuccess(GankBean bean) {
        if(bean.getResults()!=null){
            adapter.setList((ArrayList<GankBean.ResultsBean>) bean.getResults());
        }
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onFail: " + msg);
    }

    @Override
    public void setPresenter(GankConstract.IGankPresenter presenter) {
        iGankPresenter = presenter;
        iGankPresenter.attachView(this);
    }

    @Override
    public Context getContextObject() {
        return getContext();
    }

    private void initView(View inflate) {
        rv = (RecyclerView) inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RlvGankAdapter(getActivity());
        rv.setAdapter(adapter);

        iv_tech_blur = (ImageView) inflate.findViewById(R.id.iv_tech_blur);
        iv_tech_origin = (ImageView) inflate.findViewById(R.id.iv_tech_origin);
        tv_tech_copyright = (TextView) inflate.findViewById(R.id.tv_tech_copyright);
        appBar = (AppBarLayout) inflate.findViewById(R.id.appBar);
        coordinator = (CoordinatorLayout) inflate.findViewById(R.id.coordinator);
        refresh = (SwipeRefreshLayout) inflate.findViewById(R.id.refresh);


        String imgUrl ="https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg";
        //模糊图片效果
        Glide.with(getActivity()).load(imgUrl).into(iv_tech_blur);
        tv_tech_copyright.setText("小红花");
    }
}
