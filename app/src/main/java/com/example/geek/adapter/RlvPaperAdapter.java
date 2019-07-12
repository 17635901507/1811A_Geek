package com.example.geek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geek.R;
import com.example.geek.bean.zhihu.BeforePaperBean;
import com.example.geek.bean.zhihu.PaperBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

//李开新 1811A
public class RlvPaperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<PaperBean.TopStoriesBean> bannerList = new ArrayList<>();
    private ArrayList<PaperBean.StoriesBean> list = new ArrayList<>();
    private ArrayList<BeforePaperBean.StoriesBean> beforeList = new ArrayList<>();

    boolean isBefore;
    String title = "今日新闻";
    private final LayoutInflater inflater;

    public void setBefore(boolean isBefore,String title) {
        this.isBefore = isBefore;
        if(title != null){
            this.title = title;
        }
        notifyDataSetChanged();
    }

    public RlvPaperAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(ArrayList<PaperBean.StoriesBean> list) {
        if(this.list != null){
            this.list.clear();

        }
        if(list != null){
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setBannerList(ArrayList<PaperBean.TopStoriesBean> bannerList) {
        if(this.bannerList!=null){
            this.bannerList.clear();
        }
        if(bannerList != null){
            this.bannerList.addAll(bannerList);
        }
        notifyDataSetChanged();
    }

    public void setBeforeList(ArrayList<BeforePaperBean.StoriesBean> beforeList) {
        if(this.beforeList != null){
            this.beforeList.clear();
        }
        if(beforeList != null){
            this.beforeList.addAll(beforeList);
        }
        notifyDataSetChanged();
    }

    public void setTitle(String title) {
        if(title != null){
            this.title = title;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case BANNER:
                return new BannerViewHolder(inflater.inflate(R.layout.layout_banner, null));
            case DATE:
                return new DateViewHolder(inflater.inflate(R.layout.layout_date, null));
            case ITEM:
                return new ItemViewHolder(inflater.inflate(R.layout.layout_item, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(!isBefore){
            if(viewHolder instanceof BannerViewHolder){
                ((BannerViewHolder)viewHolder).banner.setImages(bannerList);
                ((BannerViewHolder) viewHolder).banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        PaperBean.TopStoriesBean bean = (PaperBean.TopStoriesBean) path;
                        Glide.with(context).load(bean.getImage()).into(imageView);
                    }
                }).start();
            }else if(viewHolder instanceof DateViewHolder){
                ((DateViewHolder) viewHolder).tv_date.setText(title);
            }else if(viewHolder instanceof ItemViewHolder){
                if(bannerList.size()>0){
                    i = i - 1;
                }
                if(title != null){
                    i = i - 1;
                }
                if(bannerList.size() <= 0){
                    return;
                }
                PaperBean.StoriesBean storiesBean = list.get(i);
                ((ItemViewHolder) viewHolder).tv_title.setText(storiesBean.getTitle());
                if(storiesBean.getImages()!=null && storiesBean.getImages().size()>0){
                    Glide.with(context).load(storiesBean.getImages().get(0)).into(((ItemViewHolder) viewHolder).img);
                }
            }
        }else{
            if(viewHolder instanceof DateViewHolder){
                ((DateViewHolder) viewHolder).tv_date.setText(title);
            }else if(viewHolder instanceof ItemViewHolder){

                if(title != null){
                    i = i - 1;
                }
                if(beforeList.size() <= 0){
                    return;
                }
                BeforePaperBean.StoriesBean storiesBean = beforeList.get(i);
                ((ItemViewHolder) viewHolder).tv_title.setText(storiesBean.getTitle());
                if(storiesBean.getImages()!=null && storiesBean.getImages().size()>0){
                    Glide.with(context).load(storiesBean.getImages().get(0)).into(((ItemViewHolder) viewHolder).img);
                }
            }
        }
    }

    private static final int BANNER = 0;
    private static final int DATE = 1;
    private static final int ITEM = 2;
    @Override
    public int getItemViewType(int position) {
        if(!isBefore){
            if(position == 0 && bannerList.size()>0){
                return BANNER;
            }else if(position == 1 && title != null){
                return DATE;
            }else{
                return ITEM;
            }
        }else{
            if(position == 0 && title!= null){
                return DATE;
            }else{
                return ITEM;
            }
        }
    }

    @Override
    public int getItemCount() {
       int size = 0;
       if(!isBefore){
           if(list.size()>0){
               size = list.size();
           }
           if(bannerList.size() > 0){
               size = list.size()+1;
           }
           if(title != null){
               size = list.size()+1+1;
           }
       }else{
           if(beforeList.size()>0){
                size = beforeList.size();
           }
           if(title != null){
               size = beforeList.size()+1;
           }
       }
       return size;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{
        private Banner banner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
    class DateViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_date;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }
    class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv_title;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
