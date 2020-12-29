package com.example.cadres.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcCadre2;
import com.example.cadres.beanDB.DBYjjcCadre3;
import com.example.cadres.beanDB.DbYjjcCadreGrouping;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreAdapterRight2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    List<DBYjjcCadre2> datas;
    String type;

    private final int TYPE_CONTENT = 0;
    private final int TYPE_HEAD = 1;

    public YjjcCadreAdapterRight2(Context mContext, String type, List<DBYjjcCadre2> datas) {
        this.mContext = mContext;
        this.datas = datas;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case TYPE_CONTENT:
                ViewGroup vImage = (ViewGroup) mInflater.inflate(R.layout.item_yjjc_cadre, parent, false);
                return new ViewContentHolder(vImage);
            case TYPE_HEAD:
                ViewGroup vGroup = (ViewGroup) mInflater.inflate(R.layout.item_yjjc_cadre2, parent, false);
                return new ViewHeadHolder(vGroup);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if(datas.get(position).getType() == TYPE_CONTENT)
            return TYPE_CONTENT;
        if(datas.get(position).getType() == TYPE_HEAD)
            return TYPE_HEAD;
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBYjjcCadre2 data = datas.get(position);
        if (data == null) return;

        if(data.getType() == TYPE_CONTENT){
            ViewContentHolder vhImage = (ViewContentHolder) holder;
            //TextView tv_tip2,tv_name,tv_sex,tv_mz,tv_jg,tv_zzxl;
            vhImage.tv_sex.setText(data.getGender());
            vhImage.tv_mz.setText(data.getNation());
            vhImage.tv_jg.setText(data.getNativePlace());
            vhImage.tv_zzxl.setText(data.getCurrentEducation());

            //TextView tv_qrzxl,tv_zzzy,tv_qrzzy,tv_zzxw,tv_qrzxw,tv_zyjszw;
            vhImage.tv_qrzxl.setText(data.getFullTimeEducation());
            vhImage.tv_zzzy.setText(data.getCurrentMajor());
            vhImage.tv_qrzzy.setText(data.getFullTimeMajor());
//        holder.tv_zzxw.setText(data.getCurrentDegreeName());
//        holder.tv_qrzxw.setText(data.getFullTimeDegreeName());
            vhImage.tv_zyjszw.setText(data.getTechnicalTitle());

            //        TextView tv_csny,tv_gzsj,tv_rdsj,tv_rxzsj,tv_rxzjsj;
//        holder.tv_csny.setText(data.getBirthday() + (data.getAge() == 0?"":data.getAge()));
            vhImage.tv_csny.setText(data.getBirthdayAge());
            vhImage.tv_gzsj.setText(data.getWorkTime());
            vhImage.tv_rdsj.setText(data.getJoinPartyDate());
            vhImage.tv_rxzsj.setText(data.getCurrentPositionTime());
            vhImage.tv_rxzjsj.setText(data.getCurrentRankTime());

            //        TextView tv_thdytj_yxp,tv_thdytj_dps,tv_hytj_yxp,tv_hytj_dps;
            vhImage.tv_thdytj_yxp.setText(data.getTalkNumber() + "");
            vhImage.tv_thdytj_dps.setText(data.getTalkGainNumber() + "");
            vhImage.tv_hytj_yxp.setText(data.getRecommendNumber() + "");
            vhImage.tv_hytj_dps.setText(data.getRecommendGainNumber() + "");

            //        TextView tv_xrzw,tv_nrmzw,tv_jwyj,tv_zzbyj;
            vhImage.tv_jwyj.setText(data.getJwOpinion());
            vhImage.tv_zzbyj.setText(data.getZzbOpinion());

            //        TextView tv_cwhyj_yxp,tv_cwhyj_dps,tv_cwhyj_jg,tv_bz;
            vhImage.tv_cwhyj_yxp.setText(data.getValidTicket() + "");
            vhImage.tv_cwhyj_dps.setText(data.getGainVotes() + "");
            vhImage.tv_cwhyj_jg.setText(data.getCwhOpinion());
            vhImage.tv_bz.setText(data.getRemark());

            vhImage.line_bold.setVisibility(View.GONE);
            if(data.getVacantPosition().equals("1"))
                vhImage.line_bold.setVisibility(View.VISIBLE);

            vhImage.group_cwhyj.setVisibility(View.GONE);
            if(TextUtils.equals(type,"市委常委会议")){
                vhImage.group_cwhyj.setVisibility(View.VISIBLE);
            }

            if(mOnItemClickListener != null){
                vhImage.cl_parent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onClick(data.getBaseId());
                    }
                });
            }
        }else{
            ViewHeadHolder vhImage = (ViewHeadHolder) holder;
            if(TextUtils.isEmpty(data.getGroupingName())){
                vhImage.tv_fzName.setVisibility(View.GONE);
            }else{
                vhImage.tv_fzName.setVisibility(View.VISIBLE);
                vhImage.tv_fzName.setText("");
            }
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

//    public void setData(List<DBYjjcCadre2> datas) {
//        this.datas = datas;
//        notifyDataSetChanged();
//    }

    public void setData(List<DBYjjcCadre3> datas) {
        List<DBYjjcCadre2> list = new ArrayList<>();
        for (int i=0;i<datas.size();i++){
            DBYjjcCadre2 listHead = new DBYjjcCadre2();
            listHead.setType(TYPE_HEAD);
            listHead.setGroupingName(datas.get(i).getGroupingName());
            listHead.setGroupingId(datas.get(i).getGroupingId());
            list.add(listHead);

            for (int j=0;j<datas.get(i).getList().size();j++){
                DBYjjcCadre item = datas.get(i).getList().get(j);

                DBYjjcCadre2 listContent = new DBYjjcCadre2();
                listContent.setType(TYPE_CONTENT);

                listContent.setBaseId(item.getBaseId());

                listContent.setGender(item.getGender());
                listContent.setNation(item.getNation());
                listContent.setNativePlace(item.getNativePlace());
                listContent.setCurrentEducation(item.getCurrentEducation());

                listContent.setFullTimeEducation(item.getFullTimeEducation());
                listContent.setCurrentMajor(item.getCurrentMajor());
                listContent.setFullTimeMajor(item.getFullTimeMajor());
                listContent.setTechnicalTitle(item.getTechnicalTitle());

                listContent.setAge(item.getAge());
                listContent.setBirthday(item.getBirthday());
                listContent.setWorkTime(item.getWorkTime());
                listContent.setJoinPartyDate(item.getJoinPartyDate());
                listContent.setCurrentPositionTime(item.getCurrentPositionTime());
                listContent.setCurrentRankTime(item.getCurrentRankTime());

                listContent.setTalkNumber(item.getTalkNumber());
                listContent.setTalkGainNumber(item.getTalkGainNumber());
                listContent.setRecommendNumber(item.getRecommendNumber());
                listContent.setRecommendGainNumber(item.getRecommendGainNumber());

                listContent.setJwOpinion(item.getJwOpinion());
                listContent.setZzbOpinion(item.getZzbOpinion());
                listContent.setValidTicket(item.getValidTicket());
                listContent.setGainVotes(item.getGainVotes());
                listContent.setCwhOpinion(item.getCwhOpinion());
                listContent.setRemark(item.getRemark());

                listContent.setVacantPosition(item.getVacantPosition());

                list.add(listContent);
            }
        }
        this.datas = list;
        notifyDataSetChanged();
    }

    public class ViewContentHolder extends RecyclerView.ViewHolder {

        TextView tv_sex,tv_mz,tv_jg,tv_zzxl;
        TextView tv_qrzxl,tv_zzzy,tv_qrzzy,tv_zyjszw;
//        TextView tv_zzxw,tv_qrzxw;
        TextView tv_csny,tv_gzsj,tv_rdsj,tv_rxzsj,tv_rxzjsj;
        TextView tv_thdytj_yxp,tv_thdytj_dps,tv_hytj_yxp,tv_hytj_dps;
        TextView tv_jwyj,tv_zzbyj;
        TextView tv_cwhyj_yxp,tv_cwhyj_dps,tv_cwhyj_jg,tv_bz;
        ConstraintLayout cl_parent;
        Group group_cwhyj;
        View line_bold;

        public ViewContentHolder(@NonNull View itemView) {
            super(itemView);
            group_cwhyj = itemView.findViewById(R.id.group_cwhyj);
            line_bold = itemView.findViewById(R.id.line_bold);

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

    public class ViewHeadHolder extends RecyclerView.ViewHolder {
        public TextView tv_fzName;

        public ViewHeadHolder(View rootView) {
            super(rootView);
            tv_fzName = rootView.findViewById(R.id.tv_fzName);
        }

    }

    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int baseId);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
