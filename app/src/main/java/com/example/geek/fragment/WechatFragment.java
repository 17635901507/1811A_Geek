package com.example.geek.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.geek.R;
import com.example.geek.adapter.RlvWechatAdapter;
import com.example.geek.base.BaseFragment;
import com.example.geek.bean.wechat.WechatBean;
import com.example.geek.mvp.wechat.WechatConstract;
import com.example.geek.mvp.wechat.WechatPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseFragment implements WechatConstract.IWechatView<WechatBean> {
    private static final String TAG = "WechatFragment";

    private RecyclerView rv;
    private WechatConstract.IWechatPresenter iWechatPresenter;
    private RlvWechatAdapter adapter;

    public WechatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setPresenter(new WechatPresenter());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_wechat, container, false);
        initView(inflate);
        iWechatPresenter.getWechatData("52b7ec3471ac3bec6846577e79f20e4c",10,1);
        return inflate;
    }

    private void initView(View inflate) {
        rv = (RecyclerView) inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RlvWechatAdapter(getActivity());
        rv.setAdapter(adapter);
    }

    @Override
    public void onSuccess(WechatBean data) {
        adapter.setList((ArrayList<WechatBean.NewslistBean>) data.getNewslist());
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onFail: "+msg);
    }

    @Override
    public void setPresenter(WechatConstract.IWechatPresenter presenter) {
        iWechatPresenter = presenter;
        iWechatPresenter.attachView(this);
    }

    @Override
    public Context getContextObject() {
        return getContext();
    }
}
