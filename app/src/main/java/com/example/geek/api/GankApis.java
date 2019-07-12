package com.example.geek.api;


import com.example.geek.bean.gank.GankBean;
import com.example.geek.bean.gank.GankListGirlBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GankApis {


    String HOST_GANK = "http://gank.io/api/";


    /**
     * 技术文章列表
     http://gank.io/api/data/Android/20/1
     http://gank.io/api/data/iOS/20/1
     http://gank.io/api/data/%E5%89%8D%E7%AB%AF/20/1
     */
    @GET("data/{tech}/{num}/{page}")
    Observable<GankBean> getTechList(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);


    /**
     * 妹纸列表
     */
    @GET("data/福利/{num}/{page}")
    Observable<GankListGirlBean> getGirlList(@Path("num") int num, @Path("page") int page);


    /**
     * 随机妹纸图
     */
    @GET("random/data/福利/{num}")
    Observable<GankListGirlBean> getRandomGirl(@Path("num") int num);


    /**
     * 搜索
     */
    @GET("search/query/{query}/category/{type}/count/{count}/page/{page}")
    Observable getSearchList(@Path("query") String query, @Path("type") String type, @Path("count") int num, @Path("page") int page);
}
