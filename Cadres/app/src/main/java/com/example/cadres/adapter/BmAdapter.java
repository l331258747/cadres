package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.beanDB.DBBmBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class BmAdapter extends RecyclerView.Adapter<BmAdapter.ViewHolder> {

    Context mContext;
    List<DBBmBean> datas;

    public BmAdapter(Context mContext, List<DBBmBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_bm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBBmBean data = datas.get(position);
        if (data == null) return;

        holder.tv_dwmc.setText(data.getDeptName());
        holder.tv_hdzs_zz.setText(data.getApprovedPositionStr());
        holder.tv_hdzs_fz.setText(data.getApprovedDeputyStr());
        holder.tv_hdzs_qt.setText(data.getApprovedOtherStr());
        holder.tv_spqk_zz.setText(data.getActualPositionStr());
        holder.tv_spqk_fz.setText(data.getActualDeputyStr());
        holder.tv_spqk_qt.setText(data.getActualOtherStr());
        holder.tv_cpqk.setText(data.getOvermatchStr());
        holder.tv_kqqk.setText(data.getMismatchStr());

        if(mOnItemClickListener != null){
            holder.cl_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    public void setData(List<DBBmBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_dwmc,tv_hdzs_zz,tv_hdzs_fz,tv_hdzs_qt,tv_spqk_zz,tv_spqk_fz,tv_spqk_qt,tv_cpqk,tv_kqqk;
        ConstraintLayout cl_parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_dwmc = itemView.findViewById(R.id.tv_dwmc);
            tv_hdzs_zz = itemView.findViewById(R.id.tv_hdzs_zz);
            tv_hdzs_fz = itemView.findViewById(R.id.tv_hdzs_fz);
            tv_hdzs_qt = itemView.findViewById(R.id.tv_hdzs_qt);
            tv_spqk_zz = itemView.findViewById(R.id.tv_spqk_zz);
            tv_spqk_fz = itemView.findViewById(R.id.tv_spqk_fz);
            tv_spqk_qt = itemView.findViewById(R.id.tv_spqk_qt);
            tv_cpqk = itemView.findViewById(R.id.tv_cpqk);
            tv_kqqk = itemView.findViewById(R.id.tv_kqqk);
            cl_parent = itemView.findViewById(R.id.cl_parent);

        }
    }

    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
