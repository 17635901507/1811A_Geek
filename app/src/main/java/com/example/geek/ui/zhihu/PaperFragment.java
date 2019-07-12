package com.example.geek.ui.zhihu;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.geek.R;
import com.example.geek.CalenderActivity;
import com.example.geek.adapter.RlvPaperAdapter;
import com.example.geek.base.BaseFragment;
import com.example.geek.bean.zhihu.BeforePaperBean;
import com.example.geek.bean.zhihu.PaperBean;
import com.example.geek.mvp.zhihu.paper.PaperConstract;
import com.example.geek.mvp.zhihu.paper.PaperPresenter;
import com.example.geek.utils.DateUtil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
//李开新  1811A
public class PaperFragment extends BaseFragment implements PaperConstract.IPaperView<PaperBean,BeforePaperBean>, View.OnClickListener {
    private static final String TAG = "PaperFragment";

    private RecyclerView rv;
    private PaperConstract.IPaperPresenter presenter;
    private RlvPaperAdapter adapter;
    private FloatingActionButton floatingActionButton;
    boolean isBefore;
    //广播接收器
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String date = intent.getStringExtra("date");
            //判断是否是当天
            String yyyymmdd = DateUtil.getYYYYMMDD();
            if(date.equals(yyyymmdd)){
                isBefore = false;
                adapter.setBefore(isBefore,"今日新闻");
                presenter.getPaperData();
            }else{
                isBefore = true;
                adapter.setBefore(isBefore,date);
                presenter.getBeforePaperData(date);
            }
            Log.d(TAG, "日期为："+date+"----"+isBefore);

        }
    };

    public PaperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_paper, container, false);
        initView(inflate);
        presenter.getPaperData();
        return inflate;
    }

    private void initView(View inflate) {
        //初始化广播，注册广播
        initBroadCaseManager();

        rv = (RecyclerView) inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new RlvPaperAdapter(getActivity());
        rv.setAdapter(adapter);
        floatingActionButton = (FloatingActionButton) inflate.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);

    }

    //初始化广播，注册广播
    private void initBroadCaseManager() {
        IntentFilter intentFilter = new IntentFilter("com.geek.calender");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    public void onSuccess(PaperBean data) {
        ArrayList<PaperBean.StoriesBean> list = (ArrayList<PaperBean.StoriesBean>) data.getStories();
        ArrayList<PaperBean.TopStoriesBean> bannerList = (ArrayList<PaperBean.TopStoriesBean>) data.getTop_stories();
        adapter.setList(list);
        adapter.setBannerList(bannerList);
        //adapter.setBeforeList(list);
        //adapter.setTitle(data.getDate());
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), "onFail:"+msg, Toast.LENGTH_LONG).show();
        Log.d(TAG, "onFail: "+msg);
    }

    @Override
    public void onBeforeSuccess(BeforePaperBean data) {
        adapter.setBeforeList((ArrayList<BeforePaperBean.StoriesBean>) data.getStories());
    }

    @Override
    public void onBeforeFail(String msg) {
        Log.d(TAG, "onBeforeFail: "+msg);
        Toast.makeText(getActivity(),"onBeforeFail:"+ msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(PaperConstract.IPaperPresenter presenter) {
        this.presenter = presenter;
        presenter.attachView(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setPresenter(new PaperPresenter());
    }

    @Override
    public Context getContextObject() {
        return getContext();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton:
                startActivity(new Intent(getActivity(), CalenderActivity.class));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //注销广播
        unRegisterBroadcast();
    }

    private void unRegisterBroadcast() {
        if(broadcastReceiver != null){
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(broadcastReceiver);
        }
    }
}
