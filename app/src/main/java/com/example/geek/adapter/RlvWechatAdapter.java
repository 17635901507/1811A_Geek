package com.example.geek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geek.R;
import com.example.geek.bean.wechat.WechatBean;
import com.example.geek.utils.GlideUtil;

import java.util.ArrayList;

public class RlvWechatAdapter extends RecyclerView.Adapter<RlvWechatAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WechatBean.NewslistBean> list = new ArrayList<>();
    private final LayoutInflater inflater;

    public RlvWechatAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(ArrayList<WechatBean.NewslistBean> list) {
        if(list != null){
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = inflater.inflate(R.layout.layout_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        WechatBean.NewslistBean newslistBean = list.get(i);
        viewHolder.tv_title.setText(newslistBean.getTitle());
        GlideUtil.load(context,newslistBean.getPicUrl(),viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
