package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.Gb.GbCadreResumeListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GbResumeAdapter extends RecyclerView.Adapter<GbResumeAdapter.ViewHolder> {

    Context mContext;
    List<GbCadreResumeListBean> datas;

    public GbResumeAdapter(Context mContext, List<GbCadreResumeListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_resume, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder == null) return;
        final GbCadreResumeListBean data = datas.get(position);
        if (data == null) return;

        holder.tv_start_time.setText(data.getWorkStartTime());
        holder.tv_end_time.setText(data.getWorkEndTime());
        holder.tv_lx.setText(data.getWorkType());
        holder.tv_nr.setText(data.getWorkDescribe());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<GbCadreResumeListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_start_time,tv_end_time,tv_lx,tv_nr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_start_time = itemView.findViewById(R.id.tv_start_time);
            tv_end_time = itemView.findViewById(R.id.tv_end_time);
            tv_lx = itemView.findViewById(R.id.tv_lx);
            tv_nr = itemView.findViewById(R.id.tv_nr);
        }
    }
}
