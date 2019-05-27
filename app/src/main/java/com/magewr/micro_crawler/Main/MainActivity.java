package com.magewr.micro_crawler.Main;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.magewr.micro_crawler.Main.adapter.ImageGridAdapter;
import com.magewr.micro_crawler.Main.presenter.MainPresenter;
import com.magewr.micro_crawler.Main.view.MainView;
import com.magewr.micro_crawler.R;
import com.magewr.micro_crawler.base.BaseActivity;
import com.magewr.micro_crawler.data.vo.VOImage;
import com.magewr.micro_crawler.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends BaseActivity implements MainView {

    private ActivityMainBinding bnd;
    private MainPresenter presenter;
    private ImageGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bnd = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new MainPresenter();
        presenterManager.addPresenter(presenter);
        presenter.onAttachView(this);

        adapter = new ImageGridAdapter();
        bnd.gridImage.setAdapter(adapter);
        bnd.gridImage.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        presenter.getImageList();
    }

    @Override
    public void showImageList(List<VOImage> imageList) {
        adapter.setImageList(imageList);
    }
}
