package com.example.geek.base;

import android.content.Context;

public interface IBaseView<T extends IBasePresenter> {
    void setPresenter(T presenter);
    Context getContextObject();
}
