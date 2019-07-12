package com.example.geek.mvp.wechat;

import com.example.geek.api.DataWechatService;
import com.example.geek.base.BaseRepository;
import com.example.geek.base.IBaseCallBack;
import com.example.geek.bean.wechat.WechatBean;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class WechatRepository extends BaseRepository implements WechatConstract.IWechatRepository {
    @Override
    public void getPaperData(RxFragment fragment,String key,int num,int page, IBaseCallBack callBack) {
        observer(fragment, DataWechatService.getZhihuService().getWechatData(key,num,page), new Function<WechatBean, ObservableSource<WechatBean>>() {
            @Override
            public ObservableSource<WechatBean> apply(WechatBean paperBean) throws Exception {
                if(paperBean != null && paperBean.getNewslist()!=null && paperBean.getNewslist()!= null && paperBean.getNewslist().size()>0 && paperBean.getNewslist().size()>0){
                    return Observable.just(paperBean);
                }
                return Observable.error(new NullPointerException("数据返回为空或空指针"+(paperBean==null ? "" : "微信数据返回错误")));
            }
        },callBack);
    }


}
