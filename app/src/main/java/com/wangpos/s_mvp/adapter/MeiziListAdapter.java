package com.wangpos.s_mvp.adapter;

/**
 * Created by qiyue on 2018/7/10.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.bean.MeiziResult;
import com.wangpos.s_mvp.bean.MeiziResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.wangpos.s_mvp.bean.MeiziResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean.ListBean;
import com.wangpos.s_mvp.bean.OtherBean;
import com.wangpos.s_mvp.utils.GlideUtils;
import com.wangpos.s_mvp.widget.FitXYImageView;

import java.util.ArrayList;
import java.util.List;


public class MeiziListAdapter extends RecyclerView.Adapter {

    /**
     * 针对多级参数合并的问题，创建两个集合是很好的解决方式
     */
    private List<OtherBean> otherBeanList = new ArrayList<>();
    private List<ListBean> listBeans = new ArrayList<>();
    private Context context;

    private OnImageClickListener mOnImageClickListener;

    public MeiziListAdapter(ArrayList<ContentlistBean> mList, Context context) {
        this.context = context;

        initDatas(mList);
    }

    private void initDatas(List<ContentlistBean> mList) {
        for (ContentlistBean data:mList) {
            //只需要创建一个,减少内存开销
            OtherBean otherBean =  new OtherBean(data.getTitle(),data.getCt(),data.getTypeName());
            for (ListBean listBean:data.getList()) {
                //多个引用指向一个 对象
                listBeans.add(listBean);
                otherBeanList.add(otherBean);
            }

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture_grid, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;

            GlideUtils.loadImage(context,listBeans.get(position).getMiddle(),viewHolder.iv_picture);
            viewHolder.tv_title.setText(otherBeanList.get(position).title);
        }
    }



    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public void setDatas(List<ContentlistBean> datas) {
        initDatas(datas);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FitXYImageView iv_picture;
        TextView tv_title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            iv_picture = (FitXYImageView)itemView.findViewById(R.id.iv_picture);
            iv_picture.setOriginalSize(50, 50);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
//            InjectView.bind(itemView);


        }

        @Override
        public void onClick(View v) {
            if (mOnImageClickListener != null) {
                mOnImageClickListener.onImageClick(v, this.getPosition());
            }
        }
    }

    public void setOnImageClickListener(OnImageClickListener onItemClickListener) {
        this.mOnImageClickListener = onItemClickListener;
    }

    /**
     * 点击条目图片接口
     */
    public interface OnImageClickListener {
        void onImageClick(View view, int position);
    }
}
