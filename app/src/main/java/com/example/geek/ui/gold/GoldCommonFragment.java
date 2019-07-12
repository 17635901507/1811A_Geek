package com.example.geek.ui.gold;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geek.R;
import com.example.geek.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldCommonFragment extends BaseFragment {

    private int i;
    private TextView txt;

    public GoldCommonFragment(String s) {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public GoldCommonFragment(int i) {
        this.i = i;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_gold_common, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        txt = (TextView) inflate.findViewById(R.id.txt);
        txt.setText(i+"");
    }
}
