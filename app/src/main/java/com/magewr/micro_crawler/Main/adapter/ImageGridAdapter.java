package com.magewr.micro_crawler.Main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.magewr.micro_crawler.R;
import com.magewr.micro_crawler.data.vo.VOImage;
import com.magewr.micro_crawler.databinding.ItemImageBinding;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageGridAdapter extends RecyclerView.Adapter<ImageGridAdapter.ImageGridViewHolder> {

    private List<VOImage> imageList = new ArrayList<>();

    @NonNull
    @Override
    public ImageGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageGridViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageGridViewHolder holder, int position) {
        VOImage imageData = imageList.get(position);
        Glide.with(holder.bnd.getRoot().getContext())
                .load(imageData.getUrl())
                .transition(withCrossFade())
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .fitCenter())
                .into(holder.bnd.imgImg);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public void setImageList(List<VOImage> imageList) {
        this.imageList = imageList;
        notifyDataSetChanged();
    }

    class ImageGridViewHolder extends RecyclerView.ViewHolder {

        ItemImageBinding bnd;

        public ImageGridViewHolder(@NonNull View itemView) {
            super(itemView);
            bnd = DataBindingUtil.bind(itemView);
        }
    }
}
