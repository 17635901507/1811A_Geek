package com.example.geek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.geek.R;
import com.example.geek.base.Constants;
import com.example.geek.bean.gold.GoldTabBean;
import com.example.geek.ui.wechat.Text;

import java.util.ArrayList;

public class RlvGoldManagerAdapter extends RecyclerView.Adapter<RlvGoldManagerAdapter.ViewHolder> {
    private Context context;
    private final LayoutInflater inflater;
    ArrayList<GoldTabBean> list = (ArrayList<GoldTabBean>) Constants.tabGoldList;

    public RlvGoldManagerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = inflater.inflate(R.layout.layout_item_gold_manager, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final GoldTabBean goldTabBean = list.get(i);
        viewHolder.tv_title.setText(goldTabBean.getTitle());
        viewHolder.sc_gold_manager_switch.setChecked(goldTabBean.isFlag());
        viewHolder.sc_gold_manager_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(viewHolder.getAdapterPosition()).setFlag(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SwitchCompat sc_gold_manager_switch;
        TextView tv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sc_gold_manager_switch = itemView.findViewById(R.id.sc_gold_manager_switch);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
