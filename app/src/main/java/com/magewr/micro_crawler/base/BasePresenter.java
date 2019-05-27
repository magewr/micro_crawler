package com.magewr.micro_crawler.base;

import com.magewr.micro_crawler.data.DataManager;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends BaseView> {

    protected V view;
    protected DataManager dataManager;
    protected CompositeDisposable compositeDisposable;

    public BasePresenter() {
        this.dataManager = new DataManager();
    }

    public void onStart() {

    }

    public void onStop() {

    }

    public void onAttachView(V baseView) {
        this.view = baseView;
        compositeDisposable = new CompositeDisposable();
    }

    public void onDetachView() {
        this.view = null;
        if(null != compositeDisposable) {
            this.compositeDisposable.dispose();
            this.compositeDisposable = null;
        }
    }
}
