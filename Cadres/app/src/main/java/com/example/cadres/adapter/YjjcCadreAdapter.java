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
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreAdapter extends RecyclerView.Adapter<YjjcCadreAdapter.ViewHolder> {

    Context mContext;
    List<DBYjjcCadre> datas;

    public YjjcCadreAdapter(Context mContext, List<DBYjjcCadre> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_yjjc_cadre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder == null) return;
        final DBYjjcCadre data = datas.get(position);
        if (data == null) return;

        holder.tv_tip2.setText("");
        holder.tv_name.setText(data.getCadreName());
        holder.tv_csny.setText(data.getBirthday());
        holder.tv_rdsj.setText(data.getJoinPartyDate());
        holder.tv_xrzw.setText(data.getCurrentPosition());
        holder.tv_nrzw.setText(data.getAppointPositionName());

        holder.tv_nmzw.setText(data.getDismissPositionName());
        holder.tv_xrzsj.setText(data.getCurrentPositionTime());
        holder.tv_jg.setText(data.getNativePlace());
        holder.tv_whcd_qrz.setText(data.getFullTimeEducation());
        holder.tv_whcd_zz.setText(data.getCurrentEducation());
        holder.tv_thrs.setText(data.getTalkNumber() + "");

        holder.tv_tjrs.setText(data.getRecommendNumber() + "");
        holder.tv_pm.setText(data.getRanking() + "");
        holder.tv_yxp.setText(data.getValidTicket() + "");
        holder.tv_dp.setText(data.getGainVotes() + "");

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

        TextView tv_tip2,tv_name,tv_csny,tv_rdsj,tv_xrzw,tv_nrzw;
        TextView tv_nmzw,tv_xrzsj,tv_jg,tv_whcd_qrz,tv_whcd_zz,tv_thrs;
        TextView tv_tjrs,tv_pm,tv_yxp,tv_dp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_tip2 = itemView.findViewById(R.id.tv_tip2);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_csny = itemView.findViewById(R.id.tv_csny);
            tv_rdsj = itemView.findViewById(R.id.tv_rdsj);
            tv_xrzw = itemView.findViewById(R.id.tv_xrzw);
            tv_nrzw = itemView.findViewById(R.id.tv_nrzw);
            tv_nmzw = itemView.findViewById(R.id.tv_nmzw);
            tv_xrzsj = itemView.findViewById(R.id.tv_xrzsj);
            tv_jg = itemView.findViewById(R.id.tv_jg);
            tv_whcd_qrz = itemView.findViewById(R.id.tv_whcd_qrz);
            tv_whcd_zz = itemView.findViewById(R.id.tv_whcd_zz);
            tv_thrs = itemView.findViewById(R.id.tv_thrs);
            tv_tjrs = itemView.findViewById(R.id.tv_tjrs);
            tv_pm = itemView.findViewById(R.id.tv_pm);
            tv_yxp = itemView.findViewById(R.id.tv_yxp);
            tv_dp = itemView.findViewById(R.id.tv_dp);
        }
    }
}
