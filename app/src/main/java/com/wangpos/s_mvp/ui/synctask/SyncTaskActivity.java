package com.wangpos.s_mvp.ui.synctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.adapter.UploadPhotoAdapter;
import com.wangpos.s_mvp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class SyncTaskActivity extends BaseActivity {

    @$(R.id.recyclerView)
    public RecyclerView recyclerView;

    public UploadPhotoAdapter uploadPhotoAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_sync_task;
    }

    @Override
    public void initView() {
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        uploadPhotoAdapter = new UploadPhotoAdapter(getDatas(),getApplicationContext());
        recyclerView.setAdapter(uploadPhotoAdapter);
    }

    public List<Integer> getDatas() {
        List<Integer>imageUrls = new ArrayList<>();
        imageUrls.add(R.drawable.anime1);
        imageUrls.add(R.drawable.anime2);
        imageUrls.add(R.drawable.anime3);
        imageUrls.add(R.drawable.anime4);
        imageUrls.add(R.drawable.anime5);
        imageUrls.add(R.drawable.anime6);
        imageUrls.add(R.drawable.anime7);
        imageUrls.add(R.drawable.anime8);
        imageUrls.add(R.drawable.anime9);

        return imageUrls;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uploadPhotoAdapter.onDetached();
    }
}


