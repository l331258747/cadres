package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.Gb.GbCadreHistoryPositionListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GbHistoryAdapter extends RecyclerView.Adapter<GbHistoryAdapter.ViewHolder> {

    Context mContext;
    List<GbCadreHistoryPositionListBean> datas;

    public GbHistoryAdapter(Context mContext, List<GbCadreHistoryPositionListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (holder == null) return;
        final GbCadreHistoryPositionListBean data = datas.get(position);
        if (data == null) return;

        holder.tv_zwdw.setText(data.getDeptName());
        holder.tv_rzqk.setText(data.getPosition());
        holder.tv_zwmc.setText(data.getPositionTitleName());
        holder.tv_mzyy.setText(data.getLeaveReason());
        holder.tv_mzsj.setText(data.getLeaveTime());
        holder.tv_mzwh.setText(data.getLeaveFileNumber());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<GbCadreHistoryPositionListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_zwdw,tv_rzqk,tv_zwmc,tv_mzyy,tv_mzsj,tv_mzwh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_zwdw = itemView.findViewById(R.id.tv_zwdw);
            tv_rzqk = itemView.findViewById(R.id.tv_rzqk);
            tv_zwmc = itemView.findViewById(R.id.tv_zwmc);
            tv_mzyy = itemView.findViewById(R.id.tv_mzyy);
            tv_mzsj = itemView.findViewById(R.id.tv_mzsj);
            tv_mzwh = itemView.findViewById(R.id.tv_mzwh);
        }
    }
}
