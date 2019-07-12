package com.example.geek.api;

import com.example.geek.bean.zhihu.BeforePaperBean;
import com.example.geek.bean.zhihu.HotBean;
import com.example.geek.bean.zhihu.PaperBean;
import com.example.geek.bean.zhihu.SpecialBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhihuService {
    //http://news-at.zhihu.com/api/4/
    String URL_ZHIHU = "http://news-at.zhihu.com/api/4/";

    //http://news-at.zhihu.com/api/4/news/latest
    @GET("news/latest")
    Observable<PaperBean> getPaperData();

    //http://news-at.zhihu.com/api/4/news/before/20181206
    @GET("news/before/{date}")
    Observable<BeforePaperBean> getBeforePaperData(@Path("date") String date);

    //http://news-at.zhihu.com/api/4/sections
    @GET("sections")
    Observable<SpecialBean> getSectionData();

    //http://news-at.zhihu.com/api/4/news/hot
    @GET("news/hot")
    Observable<HotBean> getHotData();
}
