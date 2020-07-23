package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.Gb.GbCadreTrainListBean;
import com.example.cadres.beanDB.DBGbCadreTrainListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GbTrainAdapter extends RecyclerView.Adapter<GbTrainAdapter.ViewHolder> {

    Context mContext;
    List<DBGbCadreTrainListBean> datas;

    public GbTrainAdapter(Context mContext, List<DBGbCadreTrainListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_train, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (holder == null) return;
        final DBGbCadreTrainListBean data = datas.get(position);
        if (data == null) return;

        holder.tv_kssj.setText(data.getStartTime());
        holder.tv_jssj.setText(data.getEndTime());
//        holder.tv_pxts.setText(data.getPositionTitleName());//TODO
        holder.tv_pxb.setText(data.getTrainingCourse());
        holder.tv_pxjb.setText(data.getTrainLevel());
        holder.tv_pxlb.setText(data.getTrainType());
        holder.tv_pxjg.setText(data.getTrainOrganization());
        holder.tv_pxfs.setText(data.getTrainMode());
        holder.tv_pxnr.setText(data.getTrainContent());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<DBGbCadreTrainListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_kssj,tv_jssj,tv_pxts,tv_pxb,tv_pxjb,tv_pxlb,tv_pxjg,tv_pxfs,tv_pxnr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_kssj = itemView.findViewById(R.id.tv_kssj);
            tv_jssj = itemView.findViewById(R.id.tv_jssj);
            tv_pxts = itemView.findViewById(R.id.tv_pxts);
            tv_pxb = itemView.findViewById(R.id.tv_pxb);
            tv_pxjb = itemView.findViewById(R.id.tv_pxjb);
            tv_pxlb = itemView.findViewById(R.id.tv_pxlb);
            tv_pxjg = itemView.findViewById(R.id.tv_pxjg);
            tv_pxfs = itemView.findViewById(R.id.tv_pxfs);
            tv_pxnr = itemView.findViewById(R.id.tv_pxnr);
        }
    }
}
