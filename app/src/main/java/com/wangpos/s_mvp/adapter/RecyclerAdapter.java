package com.wangpos.s_mvp.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.widget.TimeMarker;
import com.wangpos.s_mvp.widget.TimeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * create qiyue
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<TimeModel> datas = new ArrayList<>();
    private Context context;


    public void setmOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    private OnClickListener mOnClickListener;

    public RecyclerAdapter(List<TimeModel> datas, Context context){
        this.datas = datas;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.time_line_item,null)
        ,parent.getContext(),viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        initItemStyle(holder, position);


        holder.tvLeftTime.setText(datas.get(position).time);

        holder.tvLeftContent.setText(datas.get(position).content);
        holder.tvRightTime.setText(datas.get(position).time);
        holder.tvRightContent.setText(datas.get(position).content);
    }

    private void initItemStyle(ViewHolder holder, int position) {
        if(position %2==0){
            holder.mRlyLeftCard.setVisibility(View.VISIBLE);
            holder.mRlyRightCard.setVisibility(View.INVISIBLE);
            int styleIndex = position/2;

            Log.i("info","styleIndex="+styleIndex);

            Log.i("info","position="+position);
            int index = styleIndex%4;
            switch (index){
                case 0:
                    holder.tvLeftTime.setTextColor(getColor(R.color.l1_time));
                    holder.tvLeftContent.setTextColor(getColor(R.color.l1_content));
                    holder.mleftBackground.setBackgroundResource(R.drawable.l1);
                    break;
                case 1:
                    holder.tvLeftTime.setTextColor(getColor(R.color.l1_time));
                    holder.tvLeftContent.setTextColor(getColor(R.color.l1_content));
                    holder.mleftBackground.setBackgroundResource(R.drawable.l2);
                    break;
                case 2:
                    holder.tvLeftTime.setTextColor(getColor(R.color.l2_time));
                    holder.tvLeftContent.setTextColor(getColor(R.color.l2_content));
                    holder.mleftBackground.setBackgroundResource(R.drawable.l3);
                    break;
                case 3:
                    holder.mleftBackground.setBackgroundResource(R.drawable.left);
                    break;



            }
//            TranslateAnimation animation = new TranslateAnimation(500.0f, 0.0f, 0.0f, 0.0f);
//            animation.setFillAfter(true);
//            animation.setDuration(800);
//            holder.mleftBackground.startAnimation(animation);

        }else{
            holder.mRlyRightCard.setVisibility(View.VISIBLE);
            holder.mRlyLeftCard.setVisibility(View.INVISIBLE);
            int styleIndex = (position+1)/2;
            styleIndex = styleIndex%3;
            switch (styleIndex){
                case 1:
                    holder.tvRightTime.setTextColor(getColor(R.color.r1_time));
                    holder.tvRightContent.setTextColor(getColor(R.color.r1_content));
                    holder.mRightBackground.setBackgroundResource(R.drawable.r1);
                    break;
                case 2:
                    holder.tvRightTime.setTextColor(getColor(R.color.r1_time));
                    holder.tvRightContent.setTextColor(getColor(R.color.r1_content));
                    holder.mRightBackground.setBackgroundResource(R.drawable.r2);
                    break;
                case 0:
                    holder.tvRightTime.setTextColor(getColor(R.color.r1_time));
                    holder.tvRightContent.setTextColor(getColor(R.color.r1_content));
                    holder.mRightBackground.setBackgroundResource(R.drawable.r3);
                    break;
                case 3:
                    holder.tvRightTime.setTextColor(getColor(R.color.r4_time));
                    holder.tvRightContent.setTextColor(getColor(R.color.r4_content));
                    holder.mRightBackground.setBackgroundResource(R.drawable.r4);
                    break;
                default:
//                    holder.tvRightTime.setTextColor(getColor(R.color.r1_time));
//                    holder.tvRightContent.setTextColor(getColor(R.color.r1_content));
//                    holder.mRightBackground.setBackgroundResource(R.drawable.right);
                    break;
            }
//            TranslateAnimation animation = new TranslateAnimation(-1000.0f, 0.0f, 0.0f, 0.0f);
//            animation.setFillAfter(true);
//            animation.setDuration(800);
//            holder.mRightBackground.startAnimation(animation);
        }
    }

    private int getColor(@ColorRes int colorId) {
        return context.getResources().getColor(colorId);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public RelativeLayout mRlyLeftCard;

        public RelativeLayout mRlyRightCard;

        public LinearLayout mleftBackground;

        public LinearLayout mRightBackground;

        public TextView tvLeftTime;

        public TextView tvLeftContent;

        public TextView tvRightTime;

        public TextView tvRightContent;

        public ViewHolder(View itemView, Context context, int itemType) {
            super(itemView);
            TimeMarker timeMarker = (TimeMarker)itemView.findViewById(R.id.time);
            mRlyLeftCard = (RelativeLayout)itemView.findViewById(R.id.rly_left);
            mRlyRightCard = (RelativeLayout)itemView.findViewById(R.id.rly_right);
            mleftBackground = (LinearLayout)itemView.findViewById(R.id.lly_left);
            mRightBackground = (LinearLayout)itemView.findViewById(R.id.lly_right);
            tvLeftTime = (TextView)itemView.findViewById(R.id.tv_left_time);
            tvLeftContent = (TextView)itemView.findViewById(R.id.tv_left_content);
            tvRightTime = (TextView)itemView.findViewById(R.id.tv_right_time);
            tvRightContent = (TextView)itemView.findViewById(R.id.tv_right_content);

            if (itemType==ItemType.AT_ROM){
                timeMarker.setmStartLine(null);
                timeMarker.setmEndLine(null);
            }
            if (itemType==ItemType.START){
                timeMarker.setmStartLine(null);
            }
            if (itemType==ItemType.END){
                timeMarker.setmEndLine(null);
            }
            if (itemType==ItemType.NORMAL){
            }

            mleftBackground.setOnClickListener(this);
            mRightBackground.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onClick(v,getPosition());
        }
    }

    @Override
    public int getItemViewType(int position) {
        int size = datas.size() -1;
        if (size==0){
            return ItemType.AT_ROM;
        }else if(position==0){
            return ItemType.START;
        }else if(position == size){
            return ItemType.END;
        }else{
            return ItemType.NORMAL;
        }

    }

    public interface OnClickListener{

        public void onClick(View view, int position);

    }
}
