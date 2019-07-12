package com.example.geek.mvp.zhihu.special;

import com.example.geek.base.IBaseCallBack;
import com.example.geek.base.IBasePresenter;
import com.example.geek.base.IBaseView;
import com.trello.rxlifecycle2.components.support.RxFragment;

public interface SpecialConstract {
    interface ISpecialView<T> extends IBaseView<ISpecialPresenter> {
        void onSuccess(T data);
        void onFail(String msg);
    }

    interface ISpecialPresenter extends IBasePresenter<ISpecialView>{
        void getSpecialData();
    }

    interface ISpecialRepository{
        void getSpecialData(RxFragment fragment, IBaseCallBack callBack);
    }
}
