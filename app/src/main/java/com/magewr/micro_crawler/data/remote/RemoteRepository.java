package com.magewr.micro_crawler.data.remote;

import com.magewr.micro_crawler.data.vo.VOImage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class RemoteRepository {

    private final String URL = "";

    public Single<List<VOImage>> getImageList() {
        return Single.create(singleEmitter -> {
            try {
                Document doc = Jsoup.connect(URL).get();
                Elements items = doc.select(".col-md-4");
                List<VOImage> imageList =
                    Observable.fromIterable(items)
                        .map(item -> {
                            String imgUrl = item.select("img").attr("src");
                            String caption = item.select("img").attr("alt");
                            return new VOImage(imgUrl, caption);
                        })
                        .toList()
                        .blockingGet();

                singleEmitter.onSuccess(imageList);
            } catch (Exception e) {
                singleEmitter.onError(e);
            }

        });
    }
}
