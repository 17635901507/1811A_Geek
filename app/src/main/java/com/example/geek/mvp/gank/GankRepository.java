package com.example.geek.mvp.gank;

import com.example.geek.api.DataGankService;
import com.example.geek.base.BaseRepository;
import com.example.geek.base.IBaseCallBack;
import com.example.geek.bean.gank.GankBean;
import com.example.geek.bean.gank.GankListGirlBean;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class GankRepository extends BaseRepository implements GankConstract.IGankRepository {
    @Override
    public void getTechList(RxFragment fragment, String tech, int num, int page, IBaseCallBack callBack) {
        observer(fragment, DataGankService.getService().getTechList(tech,num,page), new Function<GankBean, ObservableSource<GankBean>>() {
            @Override
            public ObservableSource<GankBean> apply(GankBean o) throws Exception {
                if(o!=null && o.getResults()!=null && o.getResults().size()>0){
                    return Observable.just(o);
                }
                return Observable.error(new NullPointerException("数据返回为空或空指针"+ o == null ? "" : "返回数据错误"));
            }
        },callBack);
    }

    @Override
    public void getFuliList(RxFragment fragment,  int num, int page, IBaseCallBack callBack) {
        observer(fragment, DataGankService.getService().getGirlList(num, page), new Function<GankListGirlBean, ObservableSource<GankListGirlBean>>() {
            @Override
            public ObservableSource<GankListGirlBean> apply(GankListGirlBean bean) throws Exception {
                if(bean!=null && bean.getResults()!=null && bean.getResults().size()>0){
                    return Observable.just(bean);
                }
                return Observable.error(new NullPointerException("福利数据返回为空或空指针"+ bean == null ? "" : "福利返回数据错误"));
            }
        },callBack);
    }
}
