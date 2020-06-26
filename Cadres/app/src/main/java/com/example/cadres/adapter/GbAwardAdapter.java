package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.Gb.GbCadreAwardPunishList;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GbAwardAdapter extends RecyclerView.Adapter<GbAwardAdapter.ViewHolder> {

    Context mContext;
    List<GbCadreAwardPunishList> datas;

    public GbAwardAdapter(Context mContext, List<GbCadreAwardPunishList> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_award, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (holder == null) return;
        final GbCadreAwardPunishList data = datas.get(position);
        if (data == null) return;

        holder.tv_jclx.setText(data.getAwardPunishType());
        holder.tv_jcmc.setText(data.getAwardPunishName());
        holder.tv_pzsj.setText(data.getRatifyTime());
        holder.tv_jllx.setText(data.getAwardType());
        holder.tv_cflx.setText(data.getAwardPunishType());
        holder.tv_jcyy.setText(data.getAwardPunishReason());
        holder.tv_jcsm.setText(data.getAwardPunishExplain());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<GbCadreAwardPunishList> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_jclx,tv_jcmc,tv_pzsj,tv_jllx,tv_cflx,tv_jcyy,tv_jcsm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_jclx = itemView.findViewById(R.id.tv_jclx);
            tv_jcmc = itemView.findViewById(R.id.tv_jcmc);
            tv_pzsj = itemView.findViewById(R.id.tv_pzsj);
            tv_jllx = itemView.findViewById(R.id.tv_jllx);
            tv_cflx = itemView.findViewById(R.id.tv_cflx);
            tv_jcyy = itemView.findViewById(R.id.tv_jcyy);
            tv_jcsm = itemView.findViewById(R.id.tv_jcsm);
        }
    }
}
