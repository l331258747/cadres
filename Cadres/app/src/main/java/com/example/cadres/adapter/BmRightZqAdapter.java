package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBGwyZHGL;
import com.example.cadres.beanDB.DBGwyZQ;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BmRightZqAdapter extends RecyclerView.Adapter<BmRightZqAdapter.ViewHolder> {

    Context mContext;
    List<DBGwyZQ> datas;

    public BmRightZqAdapter(Context mContext, List<DBGwyZQ> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_bm_gwy_zq, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBGwyZQ data = datas.get(position);
        if (data == null) return;

        holder.tv_hdzs_1.setText(data.getVerificationeg( )+ "");
        holder.tv_hdzs_2.setText(data.getVerificationsg( )+ "");
        holder.tv_hdzs_3.setText(data.getVerificationsig( )+ "");

        holder.tv_spqk_1.setText(data.getActualeg( )+ "");
        holder.tv_spqk_2.setText(data.getActualsg( )+ "");
        holder.tv_spqk_3.setText(data.getActualsig( )+ "");
        holder.tv_spqk_4.setText(data.getActualyb( )+ "");
        holder.tv_spqk_5.setText(data.getActualeb( )+ "");
        holder.tv_spqk_6.setText(data.getActualsb( )+ "");
        holder.tv_spqk_7.setText(data.getActualsib( )+ "");
        holder.tv_spqk_8.setText(data.getActualyx( )+ "");
        holder.tv_spqk_9.setText(data.getActualex( )+ "");

        holder.tv_cpqk_1.setText(data.getSurpasseg( )+ "");
        holder.tv_cpqk_2.setText(data.getSurpasssg( )+ "");
        holder.tv_cpqk_3.setText(data.getSurpasssig( )+ "");

        holder.tv_kqqk_1.setText(data.getVacancyeg( )+ "");
        holder.tv_kqqk_2.setText(data.getVacancysg( )+ "");
        holder.tv_kqqk_3.setText(data.getVacancysig( )+ "");

    }

    public void setData(List<DBGwyZQ> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_hdzs_1,tv_hdzs_2,tv_hdzs_3;
        TextView tv_spqk_1,tv_spqk_2,tv_spqk_3,tv_spqk_4,tv_spqk_5,tv_spqk_6,tv_spqk_7,tv_spqk_8,tv_spqk_9;
        TextView tv_cpqk_1,tv_cpqk_2,tv_cpqk_3;
        TextView tv_kqqk_1,tv_kqqk_2,tv_kqqk_3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_hdzs_1 = itemView.findViewById(R.id.tv_hdzs_1);
            tv_hdzs_2 = itemView.findViewById(R.id.tv_hdzs_2);
            tv_hdzs_3 = itemView.findViewById(R.id.tv_hdzs_3);

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

            tv_kqqk_1 = itemView.findViewById(R.id.tv_kqqk_1);
            tv_kqqk_2 = itemView.findViewById(R.id.tv_kqqk_2);
            tv_kqqk_3 = itemView.findViewById(R.id.tv_kqqk_3);

        }
    }
}
