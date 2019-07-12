package com.example.geek.mvp.zhihu.paper;

import com.example.geek.R;
import com.example.geek.api.DataService;
import com.example.geek.base.BaseRepository;
import com.example.geek.base.IBaseCallBack;
import com.example.geek.bean.zhihu.BeforePaperBean;
import com.example.geek.bean.zhihu.PaperBean;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class PaperRepository extends BaseRepository implements PaperConstract.IPaperRepository {
    @Override
    public void getPaperData(RxFragment fragment, IBaseCallBack callBack) {
        observer(fragment, DataService.getZhihuService().getPaperData(), new Function<PaperBean, ObservableSource<PaperBean>>() {
            @Override
            public ObservableSource<PaperBean> apply(PaperBean paperBean) throws Exception {
                if(paperBean != null && paperBean.getStories()!=null && paperBean.getTop_stories()!= null && paperBean.getTop_stories().size()>0 && paperBean.getStories().size()>0){
                    return Observable.just(paperBean);
                }
                return Observable.error(new NullPointerException(R.string.papererror+(paperBean==null ? "" : R.string.papererror+"")));
            }
        },callBack);
    }

    @Override
    public void getBeforePaperData(RxFragment fragment, String date, IBaseCallBack callBack) {
        observer(fragment, DataService.getZhihuService().getBeforePaperData(date), new Function<BeforePaperBean, ObservableSource<BeforePaperBean>>() {
            @Override
            public ObservableSource<BeforePaperBean> apply(BeforePaperBean paperBean) throws Exception {
                if(paperBean != null && paperBean.getStories()!=null && paperBean.getDate()!= null&& paperBean.getStories().size()>0){
                    return Observable.just(paperBean);
                }
                return Observable.error(new NullPointerException(R.string.beforepapererror+(paperBean==null ? "" : R.string.beforepapererror+"")));
            }
        },callBack);
    }
}
