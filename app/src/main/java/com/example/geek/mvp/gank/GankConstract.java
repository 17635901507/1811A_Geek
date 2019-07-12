package com.example.geek.mvp.gank;

import com.example.geek.base.IBaseCallBack;
import com.example.geek.base.IBasePresenter;
import com.example.geek.base.IBaseView;
import com.trello.rxlifecycle2.components.support.RxFragment;

public interface GankConstract {
    interface IGankView<T> extends IBaseView<IGankPresenter>{
        void onSuccess(T bean);
        void onFail(String msg);
    }

    interface IGankPresenter extends IBasePresenter<IGankView>{
        void getTechList(String tech,int num,int page);
        void getFuliList(int num,int page);
    }

    interface IGankRepository{
        void getTechList(RxFragment fragment, String tech, int num, int page, IBaseCallBack callBack);
        void getFuliList(RxFragment fragment, int num, int page, IBaseCallBack callBack);
    }
}
