package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.Gb.GbCadreRankListBean;
import com.example.cadres.beanDB.DBGbCadreRankListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GbRankAdapter extends RecyclerView.Adapter<GbRankAdapter.ViewHolder> {

    Context mContext;
    List<DBGbCadreRankListBean> datas;

    public GbRankAdapter(Context mContext, List<DBGbCadreRankListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_rank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (holder == null) return;
        final DBGbCadreRankListBean data = datas.get(position);
        if (data == null) return;

        holder.tv_zt.setText(data.getState());
        holder.tv_zwjb.setText(data.getDutiesRank());
        holder.tv_pzsj.setText(data.getDutiesRankTime());
        holder.tv_xsdyjb.setText(data.getTreatmentRank());
        holder.tv_xsdyjbsj.setText(data.getTreatmentRankTime());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<DBGbCadreRankListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_zt,tv_zwjb,tv_pzsj,tv_xsdyjb,tv_xsdyjbsj;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_zt = itemView.findViewById(R.id.tv_zt);
            tv_zwjb = itemView.findViewById(R.id.tv_zwjb);
            tv_pzsj = itemView.findViewById(R.id.tv_pzsj);
            tv_xsdyjb = itemView.findViewById(R.id.tv_xsdyjb);
            tv_xsdyjbsj = itemView.findViewById(R.id.tv_xsdyjbsj);
        }
    }
}
