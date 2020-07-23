package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBYjjcCadre;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreLeftAdapter extends RecyclerView.Adapter<YjjcCadreLeftAdapter.ViewHolder> {

    Context mContext;
    List<DBYjjcCadre> datas;

    public YjjcCadreLeftAdapter(Context mContext, List<DBYjjcCadre> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_yjjc_cadre_left, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBYjjcCadre data = datas.get(position);
        if (data == null) return;

        //TextView tv_tip2,tv_name,tv_sex,tv_mz,tv_jg,tv_zzxl;
        holder.tv_tip2.setText("");
        holder.tv_name.setText(data.getCadreName());
        holder.tv_xrzw.setText(data.getCurrentPosition());
        holder.tv_nrmzw.setText(data.getAspiringPosition());

        if(mOnItemClickListener != null){
            holder.cl_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<DBYjjcCadre> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_tip2,tv_name,tv_xrzw,tv_nrmzw;
        ConstraintLayout cl_parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nrmzw = itemView.findViewById(R.id.tv_nrmzw);

            cl_parent = itemView.findViewById(R.id.cl_parent);

            tv_tip2 = itemView.findViewById(R.id.tv_tip2);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_xrzw = itemView.findViewById(R.id.tv_xrzw);

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
