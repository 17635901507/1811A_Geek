package com.example.geek.mvp.wechat;

import com.example.geek.base.IBaseCallBack;
import com.example.geek.base.IBasePresenter;
import com.example.geek.base.IBaseView;
import com.trello.rxlifecycle2.components.support.RxFragment;

public interface WechatConstract {

    interface IWechatView<T> extends IBaseView<IWechatPresenter>{
        void onSuccess(T data);
        void onFail(String msg);
    }

    interface IWechatPresenter extends IBasePresenter<IWechatView>{
        void getWechatData(String key,int num,int page);

    }

    interface IWechatRepository{
        void getPaperData(RxFragment fragment, String key,int num,int page,IBaseCallBack callBack);
    }
}
