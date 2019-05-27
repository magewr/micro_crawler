package com.magewr.micro_crawler.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.magewr.micro_crawler.common.mvp.PresenterManager;

public abstract class BaseActivity extends AppCompatActivity {

    protected PresenterManager presenterManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.presenterManager = new PresenterManager();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenterManager.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenterManager.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterManager.onReleasePresenter();
    }
}
