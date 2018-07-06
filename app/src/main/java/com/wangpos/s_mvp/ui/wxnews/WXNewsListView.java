package com.wangpos.s_mvp.ui.wxnews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wangpos.s_mvp.adapter.WXListAdapter;
import com.wangpos.s_mvp.base.WebViewActivity;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.widget.LifeRecyclerView;
import com.wangpos.s_mvp.bean.WXNewsResult;

import java.util.ArrayList;

/**
 * Created by qiyue on 2018/7/6.
 */

public class WXNewsListView extends LifeRecyclerView<WXNewsPresenter> implements WXNewsContract.View,WXListAdapter.OnClickListener{

    private WXListAdapter adapter;
    public WXNewsListView(Context context) {
        super(context);
    }

    public WXNewsListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WXNewsListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    public void ON_CREATE() {
        super.ON_CREATE();
        InjectView.bind(this);
        setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WXListAdapter(new ArrayList<>(),getContext());
        adapter.setmOnClickListener(this);
        mPresenter.onAttachedView(this);
//        mPresenter.onFindWXNews();
        mPresenter.findWXNewsByRXJava();


    }


    @Override
    public void ON_DESTROY() {
        super.ON_DESTROY();
        InjectView.unbind(this);
        mPresenter.onDetached();
    }

    @Override
    public int getPage() {
        return 1;
    }

    @Override
    public int getPageSize() {
        return 20;
    }

    @Override
    public void OnFindNewsResults(WXNewsResult wxNewsResult) {

        Log.i("info","wxNewsResult="+wxNewsResult.getResult().getList().size());
        adapter.setDatas(wxNewsResult.getResult().getList());
        adapter.notifyDataSetChanged();
        setAdapter(adapter);

    }

    @Override
    public void OnError(String msg) {

    }

    @Override
    public void onClick(View view, int position) {
        WXNewsResult.ResultBean.ListBean data = adapter.getDatas().get(position);

        Intent detailIntent = new Intent(getContext(), WebViewActivity.class);
        detailIntent.putExtra(WebViewActivity.EXTRA_URL,data.getUrl());
        getContext().startActivity(detailIntent);

    }
}
