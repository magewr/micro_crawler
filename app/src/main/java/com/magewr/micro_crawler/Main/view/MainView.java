package com.magewr.micro_crawler.Main.view;

import com.magewr.micro_crawler.base.BaseView;
import com.magewr.micro_crawler.data.vo.VOImage;

import java.util.List;

public interface MainView extends BaseView {
    void showImageList(List<VOImage> imageList);
}
