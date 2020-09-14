package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBGwyFGDJ;
import com.example.cadres.beanDB.DBGwyJWJS;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BmRightFgdjAdapter extends RecyclerView.Adapter<BmRightFgdjAdapter.ViewHolder> {

    Context mContext;
    List<DBGwyFGDJ> datas;

    public BmRightFgdjAdapter(Context mContext, List<DBGwyFGDJ> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_bm_gwy_fgdj, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBGwyFGDJ data = datas.get(position);
        if (data == null) return;

        holder.tv_hdzs_1.setText(data.getVerificationsg( )+ "");
        holder.tv_hdzs_2.setText(data.getVerificationsig( )+ "");

        holder.tv_spqk_1.setText(data.getActualsg( )+ "");
        holder.tv_spqk_2.setText(data.getActualsig( )+ "");
        holder.tv_spqk_3.setText(data.getActualyj( )+ "");
        holder.tv_spqk_4.setText(data.getActualej( )+ "");
        holder.tv_spqk_5.setText(data.getActualsj( )+ "");
        holder.tv_spqk_6.setText(data.getActualsij( )+ "");
        holder.tv_spqk_7.setText(data.getActualwuj( )+ "");

        holder.tv_cpqk_1.setText(data.getSurpasssg( )+ "");
        holder.tv_cpqk_2.setText(data.getSurpasssig( )+ "");

        holder.tv_kqqk_1.setText(data.getVacancysg( )+ "");
        holder.tv_kqqk_2.setText(data.getVacancysig( )+ "");

    }

    public void setData(List<DBGwyFGDJ> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_hdzs_1,tv_hdzs_2;
        TextView tv_spqk_1,tv_spqk_2,tv_spqk_3,tv_spqk_4,tv_spqk_5,tv_spqk_6,tv_spqk_7;
        TextView tv_cpqk_1,tv_cpqk_2;
        TextView tv_kqqk_1,tv_kqqk_2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_hdzs_1 = itemView.findViewById(R.id.tv_hdzs_1);
            tv_hdzs_2 = itemView.findViewById(R.id.tv_hdzs_2);

            tv_spqk_1 = itemView.findViewById(R.id.tv_spqk_1);
            tv_spqk_2 = itemView.findViewById(R.id.tv_spqk_2);
            tv_spqk_3 = itemView.findViewById(R.id.tv_spqk_3);
            tv_spqk_4 = itemView.findViewById(R.id.tv_spqk_4);
            tv_spqk_5 = itemView.findViewById(R.id.tv_spqk_5);
            tv_spqk_6 = itemView.findViewById(R.id.tv_spqk_6);
            tv_spqk_7 = itemView.findViewById(R.id.tv_spqk_7);

            tv_cpqk_1 = itemView.findViewById(R.id.tv_cpqk_1);
            tv_cpqk_2 = itemView.findViewById(R.id.tv_cpqk_2);

            tv_kqqk_1 = itemView.findViewById(R.id.tv_kqqk_1);
            tv_kqqk_2 = itemView.findViewById(R.id.tv_kqqk_2);

        }
    }
}
