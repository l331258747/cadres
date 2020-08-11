package com.example.cadres.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        holder.tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        holder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));

        if(data.getParentId() == 0){
            holder.tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            holder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }else if(!TextUtils.equals(data.getIdType(), "1")){//真实部门
            holder.tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            holder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }

        if(data.getSubset() == 0){//没有子集
            holder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }

        holder.tv_title.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
        if (data.getId() == selectDeptDd){
            holder.tv_title.setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_ffcea3));
        }

        holder.tv_title.setText(data.getName());

        if(mOnItemClickListener != null){
            holder.tv_title.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
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
