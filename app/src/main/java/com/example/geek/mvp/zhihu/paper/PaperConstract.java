package com.example.geek.mvp.zhihu.paper;

import com.example.geek.base.IBaseCallBack;
import com.example.geek.base.IBasePresenter;
import com.example.geek.base.IBaseView;
import com.trello.rxlifecycle2.components.support.RxFragment;

public interface PaperConstract {

    interface IPaperView<T,R> extends IBaseView<IPaperPresenter>{
        void onSuccess(T data);
        void onFail(String msg);

        void onBeforeSuccess(R data);
        void onBeforeFail(String msg);
    }

    interface IPaperPresenter extends IBasePresenter<IPaperView>{
        void getPaperData();

        void getBeforePaperData(String date);
    }

    interface IPaperRepository{
        void getPaperData(RxFragment fragment, IBaseCallBack callBack);
        void getBeforePaperData(RxFragment fragment,String date, IBaseCallBack callBack);
    }
}
