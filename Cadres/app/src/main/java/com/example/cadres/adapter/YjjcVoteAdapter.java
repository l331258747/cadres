package com.example.cadres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.bean.yjjc.YjjcVoteListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcVoteAdapter extends RecyclerView.Adapter<YjjcVoteAdapter.ViewHolder> {

    Context mContext;
    List<YjjcVoteListBean> datas;

    public YjjcVoteAdapter(Context mContext, List<YjjcVoteListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_yjjc_vote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        if (holder == null) return;
        final YjjcVoteListBean data = datas.get(position);
        if (data == null) return;

        holder.tv_name.setText(data.getCadreName());
        holder.tv_xrzw.setText(data.getCurrentPosition());
        holder.tv_xrzsj.setText(data.getCurrentPositionTime());
        holder.tv_nmtmzw.setText(data.getAspiringPosition());

        holder.tv_ty.setBackgroundResource(R.drawable.shape_eb8b49_r40);
        holder.tv_ty.setTextColor(ContextCompat.getColor(mContext,R.color.white));

        holder.tv_xh.setText(data.getRankingStr());

        if(isOver){
            holder.group_tpjg.setVisibility(View.GONE);
            holder.tv_tpjg.setVisibility(View.VISIBLE);

            if(data.getVoteResultInt() == 1){
                holder.tv_tpjg.setText("同意");
            } else if(data.getVoteResultInt() == 2){
                holder.tv_tpjg.setText("不同意");
            } else if(data.getVoteResultInt() == 3){
                holder.tv_tpjg.setText("弃权");
            } else{
                holder.tv_tpjg.setText("");
            }

        }else{
            clean(holder);

            //默认同意
            holder.tv_ty.setBackgroundResource(R.drawable.shape_eb8b49_r40);
            holder.tv_ty.setTextColor(ContextCompat.getColor(mContext,R.color.white));

            holder.group_tpjg.setVisibility(View.VISIBLE);
            holder.tv_tpjg.setVisibility(View.GONE);

            holder.tv_ty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.setMyVote(1);
                    clean(holder);
                    holder.tv_ty.setBackgroundResource(R.drawable.shape_eb8b49_r40);
                    holder.tv_ty.setTextColor(ContextCompat.getColor(mContext,R.color.white));
                }
            });

            holder.tv_bty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.setMyVote(2);
                    clean(holder);
                    holder.tv_bty.setBackgroundResource(R.drawable.shape_eb8b49_r40);
                    holder.tv_bty.setTextColor(ContextCompat.getColor(mContext,R.color.white));
                }
            });

            holder.tv_qq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.setMyVote(3);
                    clean(holder);
                    holder.tv_qq.setBackgroundResource(R.drawable.shape_eb8b49_r40);
                    holder.tv_qq.setTextColor(ContextCompat.getColor(mContext,R.color.white));
                }
            });

        }
    }

    public void clean(ViewHolder holder){
        holder.tv_ty.setBackgroundResource(R.drawable.shape_00_eb8b49_r40);
        holder.tv_bty.setBackgroundResource(R.drawable.shape_00_eb8b49_r40);
        holder.tv_qq.setBackgroundResource(R.drawable.shape_00_eb8b49_r40);
        holder.tv_ty.setTextColor(ContextCompat.getColor(mContext,R.color.color_eb8b49));
        holder.tv_bty.setTextColor(ContextCompat.getColor(mContext,R.color.color_eb8b49));
        holder.tv_qq.setTextColor(ContextCompat.getColor(mContext,R.color.color_eb8b49));
    }

    boolean isOver;

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<YjjcVoteListBean> datas,boolean isOver) {
        this.datas = datas;
        this.isOver = isOver;
        notifyDataSetChanged();
    }

    public List<YjjcVoteListBean> getData(){
        return this.datas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_xrzw,tv_ty,tv_bty,tv_qq,tv_tpjg,tv_xrzsj,tv_nmtmzw,tv_xh;
        Group group_tpjg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_xh = itemView.findViewById(R.id.tv_xh);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_xrzw = itemView.findViewById(R.id.tv_xrzw);
            tv_xrzsj = itemView.findViewById(R.id.tv_xrzsj);
            tv_nmtmzw = itemView.findViewById(R.id.tv_nmtmzw);
            tv_ty = itemView.findViewById(R.id.tv_ty);
            tv_bty = itemView.findViewById(R.id.tv_bty);
            tv_qq = itemView.findViewById(R.id.tv_qq);
            tv_tpjg = itemView.findViewById(R.id.tv_tpjg);
            group_tpjg = itemView.findViewById(R.id.group_tpjg);
        }
    }
}
