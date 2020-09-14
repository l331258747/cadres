package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBGwyZHGL;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class BmRightZhAdapter extends RecyclerView.Adapter<BmRightZhAdapter.ViewHolder> {

    Context mContext;
    List<DBGwyZHGL> datas;

    public BmRightZhAdapter(Context mContext, List<DBGwyZHGL> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_bm_gwy_zh, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBGwyZHGL data = datas.get(position);
        if (data == null) return;

        holder.tv_hdzs_1.setText(data.getVerificationed() + "");
        holder.tv_hdzs_2.setText(data.getVerificationsd() + "");
        holder.tv_hdzs_3.setText(data.getVerificationsid() + "");
        holder.tv_hdzs_4.setText(data.getVerificationyez() + "");
        holder.tv_hdzs_5.setText(data.getVerificationssz() + "");

        holder.tv_spqk_1.setText(data.getActualed() + "");
        holder.tv_spqk_2.setText(data.getActualsd() + "");
        holder.tv_spqk_3.setText(data.getActualsid() + "");
        holder.tv_spqk_4.setText(data.getActualyz() + "");
        holder.tv_spqk_5.setText(data.getActualez() + "");
        holder.tv_spqk_6.setText(data.getActualsz() + "");
        holder.tv_spqk_7.setText(data.getActualsiz() + "");
        holder.tv_spqk_8.setText(data.getActualyk() + "");
        holder.tv_spqk_9.setText(data.getActualek() + "");

        holder.tv_cpqk_1.setText(data.getSurpassed( )+ "");
        holder.tv_cpqk_2.setText(data.getSurpasssd( )+ "");
        holder.tv_cpqk_3.setText(data.getSurpasssid( )+ "");
        holder.tv_cpqk_4.setText(data.getSurpassyez( )+ "");
        holder.tv_cpqk_5.setText(data.getSurpassssz( )+ "");

        holder.tv_kqqk_1.setText(data.getVacancyed( )+ "");
        holder.tv_kqqk_2.setText(data.getVacancysd( )+ "");
        holder.tv_kqqk_3.setText(data.getVacancysid( )+ "");
        holder.tv_kqqk_4.setText(data.getVacancyyez( )+ "");
        holder.tv_kqqk_5.setText(data.getVacancyssz( )+ "");

    }

    public void setData(List<DBGwyZHGL> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_hdzs_1,tv_hdzs_2,tv_hdzs_3,tv_hdzs_4,tv_hdzs_5;
        TextView tv_spqk_1,tv_spqk_2,tv_spqk_3,tv_spqk_4,tv_spqk_5,tv_spqk_6,tv_spqk_7,tv_spqk_8,tv_spqk_9;
        TextView tv_cpqk_1,tv_cpqk_2,tv_cpqk_3,tv_cpqk_4,tv_cpqk_5;
        TextView tv_kqqk_1,tv_kqqk_2,tv_kqqk_3,tv_kqqk_4,tv_kqqk_5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_hdzs_1 = itemView.findViewById(R.id.tv_hdzs_1);
            tv_hdzs_2 = itemView.findViewById(R.id.tv_hdzs_2);
            tv_hdzs_3 = itemView.findViewById(R.id.tv_hdzs_3);
            tv_hdzs_4 = itemView.findViewById(R.id.tv_hdzs_4);
            tv_hdzs_5 = itemView.findViewById(R.id.tv_hdzs_5);

            tv_spqk_1 = itemView.findViewById(R.id.tv_spqk_1);
            tv_spqk_2 = itemView.findViewById(R.id.tv_spqk_2);
            tv_spqk_3 = itemView.findViewById(R.id.tv_spqk_3);
            tv_spqk_4 = itemView.findViewById(R.id.tv_spqk_4);
            tv_spqk_5 = itemView.findViewById(R.id.tv_spqk_5);
            tv_spqk_6 = itemView.findViewById(R.id.tv_spqk_6);
            tv_spqk_7 = itemView.findViewById(R.id.tv_spqk_7);
            tv_spqk_8 = itemView.findViewById(R.id.tv_spqk_8);
            tv_spqk_9 = itemView.findViewById(R.id.tv_spqk_9);

            tv_cpqk_1 = itemView.findViewById(R.id.tv_cpqk_1);
            tv_cpqk_2 = itemView.findViewById(R.id.tv_cpqk_2);
            tv_cpqk_3 = itemView.findViewById(R.id.tv_cpqk_3);
            tv_cpqk_4 = itemView.findViewById(R.id.tv_cpqk_4);
            tv_cpqk_5 = itemView.findViewById(R.id.tv_cpqk_5);

            tv_kqqk_1 = itemView.findViewById(R.id.tv_kqqk_1);
            tv_kqqk_2 = itemView.findViewById(R.id.tv_kqqk_2);
            tv_kqqk_3 = itemView.findViewById(R.id.tv_kqqk_3);
            tv_kqqk_4 = itemView.findViewById(R.id.tv_kqqk_4);
            tv_kqqk_5 = itemView.findViewById(R.id.tv_kqqk_5);

        }
    }
}
