package com.example.geek.ui.gold;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.geek.R;
import com.example.geek.adapter.RlvGoldManagerAdapter;
import com.example.geek.base.BaseActivity;

public class GoldManagerActivity extends BaseActivity {

    private RecyclerView rv;
    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_manager);
        initView();
    }

    private void initView() {
        tb = (Toolbar) findViewById(R.id.tb);
        tb.setTitle("");
        setSupportActionBar(tb);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        RlvGoldManagerAdapter adapter = new RlvGoldManagerAdapter(this);
        rv.setAdapter(adapter);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent();
        intent.setAction("com.gold.manager");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
