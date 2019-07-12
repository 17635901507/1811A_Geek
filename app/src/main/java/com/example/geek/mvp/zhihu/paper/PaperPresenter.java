package com.example.geek.mvp.zhihu.paper;

import com.example.geek.base.IBaseCallBack;
import com.trello.rxlifecycle2.components.support.RxFragment;

public class PaperPresenter implements PaperConstract.IPaperPresenter {

    private PaperConstract.IPaperRepository iPaperRepository;
    private PaperConstract.IPaperView iPaperView;

    public PaperPresenter() {
        iPaperRepository = new PaperRepository();
    }

    @Override
    public void getPaperData() {
        if (iPaperRepository != null) {
            iPaperRepository.getPaperData((RxFragment) iPaperView, new IBaseCallBack() {
                @Override
                public void onSuccess(Object data) {
                    if (iPaperView != null) {
                        iPaperView.onSuccess(data);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if (iPaperView != null) {
                        iPaperView.onFail(msg);
                    }
                }
            });
        }
    }

    //请求当天之前的数据
    @Override
    public void getBeforePaperData(String date) {
        if (iPaperRepository != null) {
            iPaperRepository.getBeforePaperData((RxFragment) iPaperView, date, new IBaseCallBack() {
                @Override
                public void onSuccess(Object data) {
                    if (iPaperView != null) {
                        iPaperView.onBeforeSuccess(data);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if (iPaperView != null) {
                        iPaperView.onBeforeFail(msg);
                    }
                }
            });
        }
    }


    @Override
    public void attachView(PaperConstract.IPaperView view) {
        iPaperView = view;
    }

    @Override
    public void detachView(PaperConstract.IPaperView view) {
        iPaperView = null;
    }
}
