package com.wangpos.s_mvp.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.utils.GlideUtils;
import com.wangpos.s_mvp.widget.SWImageView;
import com.wangpos.s_mvp.widget.TimeMarker;
import com.wangpos.s_mvp.widget.TimeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * create qiyue
 */
public class WXListAdapter extends RecyclerView.Adapter<WXListAdapter.ViewHolder> {


    private List<WXNewsResult.ResultBean.ListBean> datas = new ArrayList<>();
    private Context context;

    public void setmOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    private OnClickListener mOnClickListener;

    public WXListAdapter(List<WXNewsResult.ResultBean.ListBean> datas, Context context){
        this.datas = datas;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item,null)
        ,parent.getContext(),viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvTitle.setText(datas.get(position).getTitle());
        holder.tvSource.setText(datas.get(position).getSource());
        GlideUtils.displayNoPlace(holder.swImageView,datas.get(position).getFirstImg());

    }


    private int getColor(@ColorRes int colorId) {
        return context.getResources().getColor(colorId);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setDatas(List<WXNewsResult.ResultBean.ListBean> datas) {
        this.datas = datas;
    }

    public List<WXNewsResult.ResultBean.ListBean>  getDatas(){
        return this.datas;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvTitle;
        public TextView tvSource;
        public ImageView swImageView;

        public ViewHolder(View itemView, Context context, int itemType) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_title);
            tvSource = (TextView)itemView.findViewById(R.id.tv_source);
            swImageView = (ImageView)itemView.findViewById(R.id.swi_content);



            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onClick(v,getPosition());
        }
    }



    public interface OnClickListener{

        public void onClick(View view, int position);

    }
}
