package com.example.geek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geek.R;
import com.example.geek.bean.gank.GankBean;
import com.example.geek.utils.GlideUtil;

import java.util.ArrayList;

public class RlvGankAdapter extends RecyclerView.Adapter<RlvGankAdapter.ViewHolder> {
    private Context context;
    private ArrayList<GankBean.ResultsBean> list = new ArrayList<>();
    private final LayoutInflater inflater;

    public RlvGankAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(ArrayList<GankBean.ResultsBean> list) {
        if(list != null){
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = inflater.inflate(R.layout.layout_item_gank_tech, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GankBean.ResultsBean resultsBean = list.get(i);
        viewHolder.tv_tech_author.setText(resultsBean.getWho());
        viewHolder.tv_tech_time.setText(resultsBean.getCreatedAt());
        if(resultsBean.getDesc()!= null){
            viewHolder.tv_tech_title.setText(resultsBean.getDesc()+"");
        }
        if(resultsBean.getImages()!=null && resultsBean.getImages().size()>0){
            GlideUtil.load(context,resultsBean.getImages().get(0),viewHolder.iv_tech_icon);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_tech_icon;
        TextView tv_tech_title,tv_tech_author,tv_tech_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_tech_icon = itemView.findViewById(R.id.iv_tech_icon);
            tv_tech_author = itemView.findViewById(R.id.tv_tech_author);
            tv_tech_title = itemView.findViewById(R.id.tv_tech_title);
            tv_tech_time = itemView.findViewById(R.id.tv_tech_time);
        }
    }
}
