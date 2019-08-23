package com.wangpos.s_mvp.ui.asynctask;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.adapter.DisplayPhotoAdapter;
import com.wangpos.s_mvp.adapter.UploadPhotoAdapter;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.util.ToastUtil;
import com.wangpos.s_mvp.ui.welcome.BodyView;
import com.wangpos.s_mvp.ui.welcome.HeaderView;
import com.wangpos.s_mvp.ui.welcome.MenuView;

import java.util.ArrayList;
import java.util.List;

/**
 * 性感妹子图http://m.xxxiao.com
 */
public class AsyncTaskActivity extends BaseActivity {
    @$(R.id.recyclerView)
    public RecyclerView recyclerView;

    @$(R.id.tv_finish)
    public TextView tvFinish;


    @Override
    public int getLayoutId() {
        return R.layout.activity_async_task;
    }

    @Override
    public void initView() {

        SmartTaskManager.as().put("asloadImage",2).toEnd(()->{
            Toast.makeText(this,"loadFinish",Toast.LENGTH_SHORT).show();
            tvFinish.setVisibility(View.VISIBLE);
        });

        SmartTaskManager.as().getAsyncTask("asloadImage").onFinish();



//        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
//        displayAdapter = new DisplayPhotoAdapter(getDatas(),getApplicationContext());
//        recyclerView.setAdapter(displayAdapter);
//        new Handler().postDelayed(
//                () -> {
//                    Toast.makeText(this,"8秒以后",Toast.LENGTH_SHORT).show();
//                    SmartTaskManager.as().getAsyncTask("asloadImage").onFinish();
//                    SmartTaskManager.as().getAsyncTask("asloadImage").onFinish();
//                    SmartTaskManager.as().getAsyncTask("asloadImage").onFinish();
//                }, 8000);

    }


    public DisplayPhotoAdapter displayAdapter;


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
//        displayAdapter.onDetached();
        SmartTaskManager.as().remove("asloadImage");
    }
}
