package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBGwyJWJS;
import com.example.cadres.beanDB.DBGwyZQ;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BmRightJwjsAdapter extends RecyclerView.Adapter<BmRightJwjsAdapter.ViewHolder> {

    Context mContext;
    List<DBGwyJWJS> datas;

    public BmRightJwjsAdapter(Context mContext, List<DBGwyJWJS> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_bm_gwy_jwjs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBGwyJWJS data = datas.get(position);
        if (data == null) return;

        holder.tv_hdzs_1.setText(data.getVerificationez( )+ "");
        holder.tv_hdzs_2.setText(data.getVerificationsz( )+ "");
        holder.tv_hdzs_3.setText(data.getVerificationsiz( )+ "");

        holder.tv_spqk_1.setText(data.getActualez( )+ "");
        holder.tv_spqk_2.setText(data.getActualsz( )+ "");
        holder.tv_spqk_3.setText(data.getActualsz( )+ "");
        holder.tv_spqk_4.setText(data.getActualyg( )+ "");
        holder.tv_spqk_5.setText(data.getActualeg( )+ "");
        holder.tv_spqk_6.setText(data.getActualsg( )+ "");
        holder.tv_spqk_7.setText(data.getActualsig( )+ "");
        holder.tv_spqk_8.setText(data.getActualjsy( )+ "");

        holder.tv_cpqk_1.setText(data.getSurpassez( )+ "");
        holder.tv_cpqk_2.setText(data.getSurpasssz( )+ "");
        holder.tv_cpqk_3.setText(data.getSurpasssiz( )+ "");

        holder.tv_kqqk_1.setText(data.getVacancyez( )+ "");
        holder.tv_kqqk_2.setText(data.getVacancysz( )+ "");
        holder.tv_kqqk_3.setText(data.getVacancysiz( )+ "");

    }

    public void setData(List<DBGwyJWJS> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_hdzs_1,tv_hdzs_2,tv_hdzs_3;
        TextView tv_spqk_1,tv_spqk_2,tv_spqk_3,tv_spqk_4,tv_spqk_5,tv_spqk_6,tv_spqk_7,tv_spqk_8;
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

            tv_cpqk_1 = itemView.findViewById(R.id.tv_cpqk_1);
            tv_cpqk_2 = itemView.findViewById(R.id.tv_cpqk_2);
            tv_cpqk_3 = itemView.findViewById(R.id.tv_cpqk_3);

            tv_kqqk_1 = itemView.findViewById(R.id.tv_kqqk_1);
            tv_kqqk_2 = itemView.findViewById(R.id.tv_kqqk_2);
            tv_kqqk_3 = itemView.findViewById(R.id.tv_kqqk_3);

        }
    }
}
