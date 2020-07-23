package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GbNowAdapter extends RecyclerView.Adapter<GbNowAdapter.ViewHolder> {

    Context mContext;
    List<DBGbCadreNowPositionListBean> datas;

    public GbNowAdapter(Context mContext, List<DBGbCadreNowPositionListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_now, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (holder == null) return;
        final DBGbCadreNowPositionListBean data = datas.get(position);
        if (data == null) return;

        holder.tv_zwdw.setText(data.getDeptName());
        holder.tv_rzqk.setText(data.getPosition());
        holder.tv_zwmc.setText(data.getPositionTitleName());
        holder.tv_rzyy.setText(data.getPositionReason());
        holder.tv_rzsj.setText(data.getPositionTime());
        holder.tv_rzwh.setText(data.getPositionFileNumber());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<DBGbCadreNowPositionListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_zwdw,tv_rzqk,tv_zwmc,tv_rzyy,tv_rzsj,tv_rzwh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_zwdw = itemView.findViewById(R.id.tv_zwdw);
            tv_rzqk = itemView.findViewById(R.id.tv_rzqk);
            tv_zwmc = itemView.findViewById(R.id.tv_zwmc);
            tv_rzyy = itemView.findViewById(R.id.tv_rzyy);
            tv_rzsj = itemView.findViewById(R.id.tv_rzsj);
            tv_rzwh = itemView.findViewById(R.id.tv_rzwh);
        }
    }
}
