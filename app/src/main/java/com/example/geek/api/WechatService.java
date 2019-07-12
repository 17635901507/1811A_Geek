package com.example.geek.api;

import com.example.geek.bean.wechat.WechatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WechatService {

    //http://api.tianapi.com/
    String URL_WECHAT = "http://api.tianapi.com/";

    //http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    @GET("wxnew")
    Observable<WechatBean> getWechatData(@Query("key") String key,@Query("num") int num,@Query("page") int page);
}
