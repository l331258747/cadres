package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBGwyFGDJ;
import com.example.cadres.beanDB.DBGwyFGZLDJ;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BmRightFgdjzlAdapter extends RecyclerView.Adapter<BmRightFgdjzlAdapter.ViewHolder> {

    Context mContext;
    List<DBGwyFGZLDJ> datas;

    public BmRightFgdjzlAdapter(Context mContext, List<DBGwyFGZLDJ> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_bm_gwy_fgdjzl, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBGwyFGZLDJ data = datas.get(position);
        if (data == null) return;

        holder.tv_hdzs_1.setText(data.getVerificationsg( )+ "");
        holder.tv_hdzs_2.setText(data.getVerificationsig( )+ "");
        holder.tv_hdzs_3.setText(data.getVerificationyej( )+ "");
        holder.tv_hdzs_4.setText(data.getVerificationssj( )+ "");

        holder.tv_spqk_1.setText(data.getActualsg( )+ "");
        holder.tv_spqk_2.setText(data.getActualsig( )+ "");
        holder.tv_spqk_3.setText(data.getActualyj( )+ "");
        holder.tv_spqk_4.setText(data.getActualej( )+ "");
        holder.tv_spqk_5.setText(data.getActualsj( )+ "");
        holder.tv_spqk_6.setText(data.getActualsij( )+ "");
        holder.tv_spqk_7.setText(data.getActualwuj( )+ "");

        holder.tv_cpqk_1.setText(data.getSurpasssg( )+ "");
        holder.tv_cpqk_2.setText(data.getSurpasssig( )+ "");
        holder.tv_cpqk_3.setText(data.getSurpassyej( )+ "");
        holder.tv_cpqk_4.setText(data.getSurpassssj( )+ "");

        holder.tv_kqqk_1.setText(data.getVacancysg( )+ "");
        holder.tv_kqqk_2.setText(data.getVacancysig( )+ "");
        holder.tv_kqqk_3.setText(data.getVacancyyej( )+ "");
        holder.tv_kqqk_4.setText(data.getVacancyssj( )+ "");

    }

    public void setData(List<DBGwyFGZLDJ> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_hdzs_1,tv_hdzs_2,tv_hdzs_3,tv_hdzs_4;
        TextView tv_spqk_1,tv_spqk_2,tv_spqk_3,tv_spqk_4,tv_spqk_5,tv_spqk_6,tv_spqk_7;
        TextView tv_cpqk_1,tv_cpqk_2,tv_cpqk_3,tv_cpqk_4;
        TextView tv_kqqk_1,tv_kqqk_2,tv_kqqk_3,tv_kqqk_4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_hdzs_1 = itemView.findViewById(R.id.tv_hdzs_1);
            tv_hdzs_2 = itemView.findViewById(R.id.tv_hdzs_2);
            tv_hdzs_3 = itemView.findViewById(R.id.tv_hdzs_3);
            tv_hdzs_4 = itemView.findViewById(R.id.tv_hdzs_4);

            tv_spqk_1 = itemView.findViewById(R.id.tv_spqk_1);
            tv_spqk_2 = itemView.findViewById(R.id.tv_spqk_2);
            tv_spqk_3 = itemView.findViewById(R.id.tv_spqk_3);
            tv_spqk_4 = itemView.findViewById(R.id.tv_spqk_4);
            tv_spqk_5 = itemView.findViewById(R.id.tv_spqk_5);
            tv_spqk_6 = itemView.findViewById(R.id.tv_spqk_6);
            tv_spqk_7 = itemView.findViewById(R.id.tv_spqk_7);

            tv_cpqk_1 = itemView.findViewById(R.id.tv_cpqk_1);
            tv_cpqk_2 = itemView.findViewById(R.id.tv_cpqk_2);
            tv_cpqk_3 = itemView.findViewById(R.id.tv_cpqk_3);
            tv_cpqk_4 = itemView.findViewById(R.id.tv_cpqk_4);

            tv_kqqk_1 = itemView.findViewById(R.id.tv_kqqk_1);
            tv_kqqk_2 = itemView.findViewById(R.id.tv_kqqk_2);
            tv_kqqk_3 = itemView.findViewById(R.id.tv_kqqk_3);
            tv_kqqk_4 = itemView.findViewById(R.id.tv_kqqk_4);

        }
    }
}
