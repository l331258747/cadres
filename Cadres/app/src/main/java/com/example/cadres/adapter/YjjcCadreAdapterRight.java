package com.example.cadres.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBYjjcCadre;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreAdapterRight extends RecyclerView.Adapter<YjjcCadreAdapterRight.ViewHolder> {

    Context mContext;
    List<DBYjjcCadre> datas;
    String type;

    public YjjcCadreAdapterRight(Context mContext,String type,List<DBYjjcCadre> datas) {
        this.mContext = mContext;
        this.datas = datas;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_yjjc_cadre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBYjjcCadre data = datas.get(position);
        if (data == null) return;

        //TextView tv_tip2,tv_name,tv_sex,tv_mz,tv_jg,tv_zzxl;
        holder.tv_sex.setText(data.getGender());
        holder.tv_mz.setText(data.getNation());
        holder.tv_jg.setText(data.getNativePlace());
        holder.tv_zzxl.setText(data.getCurrentEducation());

        //TextView tv_qrzxl,tv_zzzy,tv_qrzzy,tv_zzxw,tv_qrzxw,tv_zyjszw;
        holder.tv_qrzxl.setText(data.getFullTimeEducation());
        holder.tv_zzzy.setText(data.getCurrentMajor());
        holder.tv_qrzzy.setText(data.getFullTimeMajor());
//        holder.tv_zzxw.setText(data.getCurrentDegreeName());
//        holder.tv_qrzxw.setText(data.getFullTimeDegreeName());
        holder.tv_zyjszw.setText(data.getTechnicalTitle());

        //        TextView tv_csny,tv_gzsj,tv_rdsj,tv_rxzsj,tv_rxzjsj;
//        holder.tv_csny.setText(data.getBirthday() + (data.getAge() == 0?"":data.getAge()));
        holder.tv_csny.setText(data.getBirthdayAge());
        holder.tv_gzsj.setText(data.getWorkTime());
        holder.tv_rdsj.setText(data.getJoinPartyDate());
        holder.tv_rxzsj.setText(data.getCurrentPositionTime());
        holder.tv_rxzjsj.setText(data.getCurrentRankTime());

        //        TextView tv_thdytj_yxp,tv_thdytj_dps,tv_hytj_yxp,tv_hytj_dps;
        holder.tv_thdytj_yxp.setText(data.getTalkNumber() + "");
        holder.tv_thdytj_dps.setText(data.getTalkGainNumber() + "");
        holder.tv_hytj_yxp.setText(data.getRecommendNumber() + "");
        holder.tv_hytj_dps.setText(data.getRecommendGainNumber() + "");

        //        TextView tv_xrzw,tv_nrmzw,tv_jwyj,tv_zzbyj;
        holder.tv_jwyj.setText(data.getJwOpinion());
        holder.tv_zzbyj.setText(data.getZzbOpinion());

        //        TextView tv_cwhyj_yxp,tv_cwhyj_dps,tv_cwhyj_jg,tv_bz;
        holder.tv_cwhyj_yxp.setText(data.getValidTicket() + "");
        holder.tv_cwhyj_dps.setText(data.getGainVotes() + "");
        holder.tv_cwhyj_jg.setText(data.getCwhOpinion());
        holder.tv_bz.setText(data.getRemark());

        holder.group_cwhyj.setVisibility(View.GONE);
        if(TextUtils.equals(type,"市委常委会议")){
            holder.group_cwhyj.setVisibility(View.VISIBLE);
        }

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

        TextView tv_sex,tv_mz,tv_jg,tv_zzxl;
        TextView tv_qrzxl,tv_zzzy,tv_qrzzy,tv_zyjszw;
//        TextView tv_zzxw,tv_qrzxw;
        TextView tv_csny,tv_gzsj,tv_rdsj,tv_rxzsj,tv_rxzjsj;
        TextView tv_thdytj_yxp,tv_thdytj_dps,tv_hytj_yxp,tv_hytj_dps;
        TextView tv_jwyj,tv_zzbyj;
        TextView tv_cwhyj_yxp,tv_cwhyj_dps,tv_cwhyj_jg,tv_bz;
        ConstraintLayout cl_parent;
        Group group_cwhyj;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            group_cwhyj = itemView.findViewById(R.id.group_cwhyj);

            tv_cwhyj_yxp = itemView.findViewById(R.id.tv_cwhyj_yxp);
            tv_cwhyj_dps = itemView.findViewById(R.id.tv_cwhyj_dps);
            tv_cwhyj_jg = itemView.findViewById(R.id.tv_cwhyj_jg);
            tv_bz = itemView.findViewById(R.id.tv_bz);

            tv_jwyj = itemView.findViewById(R.id.tv_jwyj);
            tv_zzbyj = itemView.findViewById(R.id.tv_zzbyj);

            cl_parent = itemView.findViewById(R.id.cl_parent);

            tv_sex = itemView.findViewById(R.id.tv_sex);
            tv_mz = itemView.findViewById(R.id.tv_mz);
            tv_jg = itemView.findViewById(R.id.tv_jg);
            tv_zzxl = itemView.findViewById(R.id.tv_zzxl);

            tv_qrzxl = itemView.findViewById(R.id.tv_qrzxl);
            tv_zzzy = itemView.findViewById(R.id.tv_zzzy);
            tv_qrzzy = itemView.findViewById(R.id.tv_qrzzy);
//            tv_zzxw = itemView.findViewById(R.id.tv_zzxw);
//            tv_qrzxw = itemView.findViewById(R.id.tv_qrzxw);
            tv_zyjszw = itemView.findViewById(R.id.tv_zyjszw);

            tv_csny = itemView.findViewById(R.id.tv_csny);
            tv_gzsj = itemView.findViewById(R.id.tv_gzsj);
            tv_rdsj = itemView.findViewById(R.id.tv_rdsj);
            tv_rxzsj = itemView.findViewById(R.id.tv_rxzsj);
            tv_rxzjsj = itemView.findViewById(R.id.tv_rxzjsj);

            tv_thdytj_yxp = itemView.findViewById(R.id.tv_thdytj_yxp);
            tv_thdytj_dps = itemView.findViewById(R.id.tv_thdytj_dps);
            tv_hytj_yxp = itemView.findViewById(R.id.tv_hytj_yxp);
            tv_hytj_dps = itemView.findViewById(R.id.tv_hytj_dps);
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
