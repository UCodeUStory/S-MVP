package com.wangpos.s_mvp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.adapter.RecyclerAdapter;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.ui.asynctask.AsyncTaskActivity;
import com.wangpos.s_mvp.ui.retrofit.RetrofitSampleActivity;
import com.wangpos.s_mvp.ui.synctask.SyncTaskActivity;
import com.wangpos.s_mvp.ui.welcome.WelcomeActivity;
import com.wangpos.s_mvp.ui.wxnews.WXNewsActivity;
import com.wangpos.s_mvp.widget.TimeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyue on 2018/6/24.
 *
 * 添加移出动画，
 * 修改样式颜色
 * 添加详情演示
 */

public class MainActivity extends BaseActivity implements  RecyclerAdapter.OnClickListener{


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        List<TimeModel> datas = new ArrayList<>();
        initDatas(datas);
        RecyclerAdapter adapter = new RecyclerAdapter(datas,this);
        adapter.setmOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }



    private void initDatas(List<TimeModel> datas) {
        datas.add(new TimeModel("2017/10/11","创建S-MVP项目，目的打造一个更加清晰、易于维护、易于测试、提高开发效率的架构"));
        datas.add(new TimeModel("2017/12/1","引入谷歌MVP Contracts思想，接口统一化封装,减少类的创建"));
        datas.add(new TimeModel("2017/12/12","引入AOP插件，跟优雅的监听和维护项目"));
        datas.add(new TimeModel("2017/12/27","封装SmartTask添加多个网络请求顺序处理"));
        datas.add(new TimeModel("2018/2/10","添加LifeCycle实现业务分离"));
        datas.add(new TimeModel("2018/3/2","添加插件化框架，实现轻量级View的注入"));
        datas.add(new TimeModel("2018/5/2","添加AOP切片，实现日志和缓存的代理，编译后期维护和修改"));
        datas.add(new TimeModel("2018/5/5","封装SmartTask添加多个网络异步请求，监听全部执行完成"));
        datas.add(new TimeModel("2018/7/3","添加Retrofit框架"));
        datas.add(new TimeModel("2018/7/6","添加RxJava框架"));



    }

    @Override
    public void onClick(View view, int position) {

        switch (position){
            case 0:
                break;
            case 3:
                launch(SyncTaskActivity.class);
                break;
            case 4:
                launch(WelcomeActivity.class);
                break;
            case 7:
                launch(AsyncTaskActivity.class);
                break;
            case 8:
                launch(RetrofitSampleActivity.class);
                break;
            case 9:
                launch(WXNewsActivity.class);
                break;
        }

    }
}
