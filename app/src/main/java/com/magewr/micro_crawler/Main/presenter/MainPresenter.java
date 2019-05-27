package com.magewr.micro_crawler.Main.presenter;

import com.magewr.micro_crawler.Main.view.MainView;
import com.magewr.micro_crawler.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView> {

    public void getImageList() {
        compositeDisposable.add(
                dataManager.getRemoteRepository().getImageList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(imageList -> view.showImageList(imageList)));
    }
}
