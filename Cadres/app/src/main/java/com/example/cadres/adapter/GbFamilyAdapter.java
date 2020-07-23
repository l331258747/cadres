package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.Gb.GbCadreFamilyMemberList;
import com.example.cadres.beanDB.DBGbCadreFamilyMemberList;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GbFamilyAdapter extends RecyclerView.Adapter<GbFamilyAdapter.ViewHolder> {

    Context mContext;
    List<DBGbCadreFamilyMemberList> datas;

    public GbFamilyAdapter(Context mContext, List<DBGbCadreFamilyMemberList> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_family, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (holder == null) return;
        final DBGbCadreFamilyMemberList data = datas.get(position);
        if (data == null) return;

        holder.tv_cw.setText(data.getAppellation());
        holder.tv_xm.setText(data.getName());
        holder.tv_csny.setText(data.getBirthday());
        holder.tv_zzmm.setText(data.getPoliticalOutlook());
        holder.tv_gzdwjzw.setText(data.getWorkUnit());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<DBGbCadreFamilyMemberList> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_cw,tv_xm,tv_csny,tv_zzmm,tv_gzdwjzw;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_cw = itemView.findViewById(R.id.tv_cw);
            tv_xm = itemView.findViewById(R.id.tv_xm);
            tv_csny = itemView.findViewById(R.id.tv_csny);
            tv_zzmm = itemView.findViewById(R.id.tv_zzmm);
            tv_gzdwjzw = itemView.findViewById(R.id.tv_gzdwjzw);
        }
    }
}
