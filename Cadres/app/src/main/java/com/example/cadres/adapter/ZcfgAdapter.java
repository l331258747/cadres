package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.zcfg.ZcfgBean;
import com.example.cadres.utils.glide.GlideUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ZcfgAdapter extends RecyclerView.Adapter<ZcfgAdapter.ViewHolder> {

    Context mContext;
    List<ZcfgBean.ZcfgBean2> datas;

    public ZcfgAdapter(Context mContext, List<ZcfgBean.ZcfgBean2> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_zcfg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final ZcfgBean.ZcfgBean2 data = datas.get(position);
        if (data == null) return;

        holder.tv_type.setText(data.getNoticeTypeName());
        holder.tv_title.setText(data.getNoticeTitle());

        GlideUtil.LoadDefaultImage(mContext, data.getTitleFileUrl(), holder.iv_img,R.mipmap.default_zcfg);

        if(mOnItemClickListener != null){
            holder.cl_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }

    }

    public void setData(List<ZcfgBean.ZcfgBean2> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void addData(List<ZcfgBean.ZcfgBean2> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_title,tv_type;
        ConstraintLayout cl_parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_img = itemView.findViewById(R.id.iv_img);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_type = itemView.findViewById(R.id.tv_type);
            cl_parent = itemView.findViewById(R.id.cl_parent);

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
