package com.wangpos.s_mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.ui.synctask.ImagePresenter;
import com.wangpos.s_mvp.ui.synctask.SyncTaskContract;
import com.wangpos.s_mvp.utils.GlideUtils;
import com.wangpos.s_mvp.widget.TimeModel;
import com.wangpos.s_mvp.widget.UploadProgressView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyue on 2018/6/29.
 */

public class UploadPhotoAdapter extends RecyclerView.Adapter<UploadPhotoAdapter.ViewHolder> implements SyncTaskContract.View {

    List<Integer>imageUrls = new ArrayList<>();

    SparseArray<UploadProgressView> progressSparseArray = new SparseArray<UploadProgressView>();
    private Context context;

    ImagePresenter presenter;

    public UploadPhotoAdapter(List<Integer> aImageUrls, Context ctx){
        this.imageUrls = aImageUrls;
        this.context = ctx;
        presenter = new ImagePresenter();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(parent.getContext(), R.layout.upload_item,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        progressSparseArray.append(position,holder.uploadView);


        loadImage(holder.ivContent,position);
//        GlideUtils.displayNative(holder.ivContent,imageUrls.get(position));
    }

    /**
     * 模拟不同的图片去不同的网络下载
     * @param ivContent
     * @param position
     */
    private void loadImage(ImageView ivContent, Integer position) {

        switch (position){
            case 0:
                presenter.loadImage1(ivContent);
                break;
            case 1:
                presenter.loadImage2(ivContent);
                break;
            case 2:
                presenter.loadImage3(ivContent);
                break;
            case 3:
                presenter.loadImage4(ivContent);
                break;
            case 4:
                presenter.loadImage5(ivContent);
                break;
            case 5:
                presenter.loadImage6(ivContent);
                break;
            case 6:
                presenter.loadImage7(ivContent);
                break;
            case 7:
                presenter.loadImage8(ivContent);
                break;
            case 8:
                presenter.loadImage9(ivContent);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }


    @Override
    public void onLoadSuccess(int id) {

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivContent;
        UploadProgressView uploadView;
        public ViewHolder(View itemView) {
            super(itemView);
            ivContent = (ImageView)itemView.findViewById(R.id.iv_photo);
//            uploadView = (UploadProgressView)itemView.findViewById(R.id.progressView);
        }
    }
}
