package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.bean.common.ListDialogBean;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by jinty on 2020/6/23.
 */

public class ListDialogAdapter2 extends RecyclerView.Adapter<ListDialogAdapter2.ViewHolder> {

    Context mContext;
    List<BmLeftBean> lists;

    public ListDialogAdapter2(Context context, List<BmLeftBean> lists) {
        mContext = context;
        this.lists = lists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_list_item2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder == null) return;
        final BmLeftBean item = lists.get(position);
        if (item == null) return;

        holder.tv_text.setText(item.getName());

        if(mOnItemClickListener != null){
            holder.tv_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }

        holder.tv_text.setBackgroundColor(ContextCompat.getColor(mContext, R.color.transparent));
        if (item.getId() == selectDeptDd){
            holder.tv_text.setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_01B7FF));
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    private int selectDeptDd = 0;// 选中的位置
    public void setItemData(int selectDeptDd){
        this.selectDeptDd = selectDeptDd;
        notifyDataSetChanged();
    }

    public void setData(List<BmLeftBean> datas) {
        this.lists = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_text;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_text = itemView.findViewById(R.id.tv_text);
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
