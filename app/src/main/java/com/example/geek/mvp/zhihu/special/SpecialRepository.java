package com.example.geek.mvp.zhihu.special;

import com.example.geek.api.DataService;
import com.example.geek.base.BaseRepository;
import com.example.geek.base.IBaseCallBack;
import com.example.geek.bean.zhihu.SpecialBean;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class SpecialRepository extends BaseRepository implements SpecialConstract.ISpecialRepository {
    @Override
    public void getSpecialData(RxFragment fragment, IBaseCallBack callBack) {
        observer(fragment, DataService.getZhihuService().getSectionData(), new Function<SpecialBean, ObservableSource<SpecialBean>>() {
            @Override
            public ObservableSource<SpecialBean> apply(SpecialBean sectionBean) throws Exception {
                if(sectionBean!=null && sectionBean.getData()!=null && sectionBean.getData().size()>0){
                    return Observable.just(sectionBean);
                }
                return Observable.error(new NullPointerException("数据返回为空或者空指针:"+(sectionBean==null ?"" : "null")));
            }
        },callBack);
    }
}
