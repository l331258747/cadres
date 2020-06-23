package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.common.ListDialogBean;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by jinty on 2020/6/23.
 */

public class ListDialogAdapter extends RecyclerView.Adapter<ListDialogAdapter.ViewHolder> {

    Context mContext;
    List<ListDialogBean> lists;

    public ListDialogAdapter(Context context, List<ListDialogBean> lists) {
        mContext = context;
        this.lists = lists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder == null) return;
        final ListDialogBean item = lists.get(position);
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
    }

    @Override
    public int getItemCount() {
        return lists.size();
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
