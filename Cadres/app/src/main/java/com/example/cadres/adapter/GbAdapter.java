package com.example.cadres.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.constant.Constant;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.glide.GlideUtil;

import java.io.File;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class GbAdapter extends RecyclerView.Adapter<GbAdapter.ViewHolder> {

    Context mContext;
    List<GbBean.GbBean2> datas;

    public GbAdapter(Context mContext, List<GbBean.GbBean2> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_gb, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder == null) return;
        final GbBean.GbBean2 data = datas.get(position);
        if (data == null) return;

        GlideUtil.LoadImageFitCenter(mContext,
                FileUtil.getFOlderPath(Constant.IMAGE_PATH + File.separator) + data.getPhotoFileName(),
                holder.iv_head,R.mipmap.default_head);
        holder.tv_name.setText(data.getName());
        holder.tv_xrzw.setText(data.getCurrentPosition());
        holder.tv_xrzsj.setText(data.getCurrentRankTime());

        holder.tv_zwjb.setText(data.getCurrentRank());
        holder.tv_rzjsj.setText(data.getFunctionaryRankTime());

        holder.tv_sex.setText(data.getGender());
        holder.tv_place.setText(data.getNativePlace());
        holder.tv_csny.setText(data.getBirthday());

        holder.tv_qrzwhcd.setText(data.getFullTimeEducation());
        holder.tv_zzwhcd.setText(data.getCurrentEducation());

        holder.tv_head_tag.setVisibility(View.GONE);
        holder.iv_head_tag.setVisibility(View.GONE);
        if(TextUtils.equals(data.getAffectedState(),"1")){
            holder.tv_head_tag.setVisibility(View.VISIBLE);
            holder.iv_head_tag.setVisibility(View.VISIBLE);
            holder.tv_head_tag.setText("该干部正在惩罚影响期内");
            holder.iv_head_tag.setImageDrawable(ContextCompat.getDrawable(mContext,R.mipmap.ic_punishment_red));
        }else if(TextUtils.equals(data.getAffectedState(),"2")){
            holder.tv_head_tag.setVisibility(View.VISIBLE);
            holder.iv_head_tag.setVisibility(View.VISIBLE);
            holder.tv_head_tag.setText("该干部受过惩罚");
            holder.iv_head_tag.setImageDrawable(ContextCompat.getDrawable(mContext,R.mipmap.ic_punishment_yellow));
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

    public void setData(List<GbBean.GbBean2> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout cl_parent;
        ImageView iv_head,iv_head_tag;
        TextView tv_name,tv_xrzw,tv_xrzsj,tv_zwjb,tv_rzjsj,tv_sex,tv_place,tv_csny,tv_qrzwhcd,tv_zzwhcd,tv_head_tag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cl_parent = itemView.findViewById(R.id.cl_parent);
            iv_head = itemView.findViewById(R.id.iv_head);
            iv_head_tag = itemView.findViewById(R.id.iv_head_tag);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_xrzw = itemView.findViewById(R.id.tv_xrzw);
            tv_xrzsj = itemView.findViewById(R.id.tv_xrzsj);

            tv_zwjb = itemView.findViewById(R.id.tv_zwjb);
            tv_rzjsj = itemView.findViewById(R.id.tv_rzjsj);

            tv_sex = itemView.findViewById(R.id.tv_sex);
            tv_place = itemView.findViewById(R.id.tv_place);
            tv_csny = itemView.findViewById(R.id.tv_csny);

            tv_qrzwhcd = itemView.findViewById(R.id.tv_qrzwhcd);
            tv_zzwhcd = itemView.findViewById(R.id.tv_zzwhcd);
            tv_head_tag = itemView.findViewById(R.id.tv_head_tag);
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
