package com.example.cadres.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.constant.Constant;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.glide.GlideUtil;

import java.io.File;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class GbAdapterRight extends RecyclerView.Adapter<GbAdapterRight.ViewHolder> {

    Context mContext;
    List<DBGbBean> datas;
    String type;

    public GbAdapterRight(Context mContext, List<DBGbBean> datas,String type) {
        this.mContext = mContext;
        this.datas = datas;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb_list_right, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final DBGbBean data = datas.get(position);
        if (data == null) return;

        if(TextUtils.equals(type,"3") || TextUtils.equals(type,"4")){

        }else if(TextUtils.equals(type,"2")){

        }else {

        }

        holder.tv_xrzsj.setText(data.getCurrentPositionTime());

        holder.tv_zwjb.setText(data.getFunctionaryRankName());
        holder.tv_rzjsj.setText(data.getFunctionaryRankTime());

        holder.tv_sex.setText(data.getGender());
        holder.tv_place.setText(data.getNativePlace());
        holder.tv_csny.setText(data.getBirthdayAge());

        holder.tv_qrzwhcd.setText(data.getFullTimeEducation());
        holder.tv_zzwhcd.setText(data.getCurrentEducation());

        holder.tv_xrzwcc.setText(data.getCurrentRank());
        holder.tv_xrzwccsj.setText(data.getCurrentRankTime());
        holder.tv_qrzzy.setText(data.getFullTimeMajor());

        holder.tv_zzzy.setText(data.getCurrentMajor());
        holder.tv_poxm.setText(data.getSpouseName());
        holder.tv_pogzdw.setText(data.getSpouseWorkUnit());

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

    public void setData(List<DBGbBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout cl_parent;
        TextView tv_xrzsj,tv_zwjb,tv_rzjsj,tv_sex,tv_place,tv_csny,tv_qrzwhcd,tv_zzwhcd,tv_xrzwcc,tv_xrzwccsj,tv_qrzzy;
        TextView tv_zzzy,tv_poxm,tv_pogzdw;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_zzzy = itemView.findViewById(R.id.tv_zzzy);
            tv_poxm = itemView.findViewById(R.id.tv_poxm);
            tv_pogzdw = itemView.findViewById(R.id.tv_pogzdw);

            tv_xrzwcc = itemView.findViewById(R.id.tv_xrzwcc);
            tv_xrzwccsj = itemView.findViewById(R.id.tv_xrzwccsj);
            tv_qrzzy = itemView.findViewById(R.id.tv_qrzzy);

            cl_parent = itemView.findViewById(R.id.cl_parent);
            tv_xrzsj = itemView.findViewById(R.id.tv_xrzsj);

            tv_zwjb = itemView.findViewById(R.id.tv_zwjb);
            tv_rzjsj = itemView.findViewById(R.id.tv_rzjsj);

            tv_sex = itemView.findViewById(R.id.tv_sex);
            tv_place = itemView.findViewById(R.id.tv_place);
            tv_csny = itemView.findViewById(R.id.tv_csny);

            tv_qrzwhcd = itemView.findViewById(R.id.tv_qrzwhcd);
            tv_zzwhcd = itemView.findViewById(R.id.tv_zzwhcd);
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
