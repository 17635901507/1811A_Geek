package com.example.geek.mvp.gank;

import com.example.geek.base.IBaseCallBack;
import com.trello.rxlifecycle2.components.support.RxFragment;

public class GankPresenter implements GankConstract.IGankPresenter {
    private GankConstract.IGankRepository iGankRepository;
    private GankConstract.IGankView iGankView;

    public GankPresenter() {
        iGankRepository = new GankRepository();
    }

    @Override
    public void getTechList(String tech, int num, int page) {
        if(iGankRepository != null){
            iGankRepository.getTechList((RxFragment) iGankView, tech, num, page, new IBaseCallBack() {
                @Override
                public void onSuccess(Object data) {
                    if(iGankView != null){
                        iGankView.onSuccess(data);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if(iGankView != null){
                        iGankView.onFail(msg);
                    }
                }
            });
        }
    }

    @Override
    public void getFuliList(int num, int page) {
        if(iGankRepository != null){
            iGankRepository.getFuliList((RxFragment) iGankView, num, page, new IBaseCallBack() {
                @Override
                public void onSuccess(Object data) {
                    if(iGankView != null){
                        iGankView.onSuccess(data);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if(iGankView != null){
                        iGankView.onFail(msg);
                    }
                }
            });
        }
    }

    @Override
    public void attachView(GankConstract.IGankView view) {
        iGankView = view;
    }

    @Override
    public void detachView(GankConstract.IGankView view) {
        iGankView = null;
    }
}
