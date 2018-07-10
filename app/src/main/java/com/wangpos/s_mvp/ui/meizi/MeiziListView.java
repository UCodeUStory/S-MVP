package com.wangpos.s_mvp.ui.meizi;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.wangpos.s_mvp.adapter.MeiziListAdapter;
import com.wangpos.s_mvp.adapter.WXListAdapter;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.widget.LifeRecyclerView;
import com.wangpos.s_mvp.bean.MeiziResult;

import java.util.ArrayList;

/**
 * Created by qiyue on 2018/7/10.
 */

public class MeiziListView extends LifeRecyclerView<MeiziPresenter> implements MeiziContract.View {

    private MeiziListAdapter adapter;

    public MeiziListView(Context context) {
        super(context);
    }

    public MeiziListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeiziListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public int getPage() {
        return 1;
    }

    @Override
    public String getType() {
        return "4009";
    }

    @Override
    public void onFindPictureSuccess(MeiziResult meiziResult) {
        adapter.setDatas(meiziResult.getShowapi_res_body().getPagebean().getContentlist());
        adapter.notifyDataSetChanged();
        setAdapter(adapter);
    }

    @Override
    public void OnError(String msg) {
        toast(msg);
    }



    @Override
    public void ON_CREATE() {
        super.ON_CREATE();
        InjectView.bind(this);

        StaggeredGridLayoutManager mGridViewLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        setLayoutManager(mGridViewLayoutManager);
        adapter = new MeiziListAdapter(new ArrayList<>(),getContext());
//        adapter.setmOnClickListener(this);
        mPresenter.onAttachedView(this);
//        mPresenter.onFindWXNews();
        mPresenter.findPicture();


    }


    @Override
    public void ON_DESTROY() {
        super.ON_DESTROY();
        InjectView.unbind(this);
        mPresenter.onDetached();
    }
}
