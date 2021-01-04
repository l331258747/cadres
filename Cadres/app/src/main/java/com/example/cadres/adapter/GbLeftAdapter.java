package com.example.cadres.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.beanDB.DBBmBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class GbLeftAdapter extends RecyclerView.Adapter<GbLeftAdapter.ViewHolder> {

    Context mContext;
    List<BmLeftBean> datas;

    public GbLeftAdapter(Context mContext, List<BmLeftBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_left, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final BmLeftBean data = datas.get(position);
        if (data == null) return;

        holder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        if(data.getSubset() == 1) //没有子集
            holder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        holder.ll_parent.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
        if (data.getId() == selectDeptDd){
            holder.ll_parent.setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_ffcea3));
        }

        holder.tv_title.setText(data.getName());

        holder.iv_no_women.setVisibility(View.GONE);
        if(TextUtils.equals(data.getIsNoWomen(),"1")){
            holder.iv_no_women.setVisibility(View.VISIBLE);
        }

        if(mOnItemClickListener != null){
            holder.ll_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private int selectDeptDd = 0;// 选中的位置
    public void setItemData(int selectDeptDd){
        this.selectDeptDd = selectDeptDd;
        notifyDataSetChanged();
    }

    public void setData(List<BmLeftBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setData(List<BmLeftBean> datas, int selectDeptDd) {
        this.datas = datas;
        this.selectDeptDd = selectDeptDd;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView iv_no_women;
        LinearLayout ll_parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            iv_no_women = itemView.findViewById(R.id.iv_no_women);
            ll_parent = itemView.findViewById(R.id.ll_parent);
        }
    }

    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
