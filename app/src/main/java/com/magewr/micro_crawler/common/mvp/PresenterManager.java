package com.magewr.micro_crawler.common.mvp;

import com.magewr.micro_crawler.base.BasePresenter;
import com.magewr.micro_crawler.base.BaseView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PresenterManager {

    private List<BasePresenter> mPresenterList;

    public PresenterManager() {
        mPresenterList = new ArrayList<>();
    }

    public PresenterManager addPresenter(BasePresenter presenter) {
        if (null == mPresenterList) {
            mPresenterList = new ArrayList<>();
        }
        mPresenterList.add(presenter);
        return this;
    }

    public void addPresenter(BasePresenter... presenters) {
        if (null == mPresenterList) {
            mPresenterList = new ArrayList<>();
        }
        mPresenterList.addAll(Arrays.asList(presenters));
    }

    public void onAttachView(BaseView view) {
        for (BasePresenter presenter : mPresenterList) {
            presenter.onAttachView(view);
        }
    }

    public void onStart() {
        for (BasePresenter presenter : mPresenterList) {
            presenter.onStart();
        }
    }

    public void onStop() {
        for (BasePresenter presenter : mPresenterList) {
            presenter.onStop();
        }
    }

    public void onReleasePresenter() {
        for (BasePresenter presenter : mPresenterList) {
            presenter.onDetachView();
        }

        mPresenterList.clear();
        mPresenterList = null;
    }
}
