package com.example.geek.ui.zhihu;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.geek.R;
import com.example.geek.adapter.RlvSpecialAdapter;
import com.example.geek.base.BaseFragment;
import com.example.geek.bean.zhihu.SpecialBean;
import com.example.geek.mvp.zhihu.special.SpecialConstract;
import com.example.geek.mvp.zhihu.special.SpecialPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFragment extends BaseFragment implements SpecialConstract.ISpecialView<SpecialBean> {


    private RecyclerView rv;
    private SpecialConstract.ISpecialPresenter iSpecialPresenter;
    private RlvSpecialAdapter adapter;

    public SpecialFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setPresenter(new SpecialPresenter());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_special, container, false);
        initView(inflate);
        iSpecialPresenter.getSpecialData();
        return inflate;
    }

    private void initView(View inflate) {
        rv = (RecyclerView) inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter = new RlvSpecialAdapter(getActivity());
        rv.setAdapter(adapter);
    }

    @Override
    public void onSuccess(SpecialBean data) {
        adapter.setList((ArrayList<SpecialBean.DataBean>) data.getData());
    }

    private static final String TAG = "SpecialFragment";
    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onFail: "+msg);
    }

    @Override
    public void setPresenter(SpecialConstract.ISpecialPresenter presenter) {
        iSpecialPresenter = presenter;
        iSpecialPresenter.attachView(this);
    }

    @Override
    public Context getContextObject() {
        return getContext();
    }
}
