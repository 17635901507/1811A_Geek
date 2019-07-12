package com.example.geek.mvp.wechat;

import com.example.geek.base.IBaseCallBack;
import com.example.geek.mvp.zhihu.paper.PaperConstract;
import com.example.geek.mvp.zhihu.paper.PaperRepository;
import com.trello.rxlifecycle2.components.support.RxFragment;

public class WechatPresenter implements WechatConstract.IWechatPresenter {
    private WechatConstract.IWechatRepository iWechatRepository;
    private WechatConstract.IWechatView iWechatView;

    public WechatPresenter() {
        iWechatRepository = new WechatRepository();
    }

    @Override
    public void getWechatData(String key, int num, int page) {
        if(iWechatRepository != null){
            iWechatRepository.getPaperData((RxFragment) iWechatView, key, num, page, new IBaseCallBack() {
                @Override
                public void onSuccess(Object data) {
                    if(iWechatView != null){
                        iWechatView.onSuccess(data);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if(iWechatView != null){
                        iWechatView.onFail(msg);
                    }
                }
            });
        }
    }

    @Override
    public void attachView(WechatConstract.IWechatView view) {
        iWechatView = view;
    }

    @Override
    public void detachView(WechatConstract.IWechatView view) {
        iWechatView = null;
    }
}
