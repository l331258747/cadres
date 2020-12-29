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

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreLeftAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    List<DBYjjcCadre2> datas;

    private final int TYPE_CONTENT = 0;
    private final int TYPE_HEAD = 1;


    public YjjcCadreLeftAdapter2(Context mContext, List<DBYjjcCadre2> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case TYPE_CONTENT:
                ViewGroup vImage = (ViewGroup) mInflater.inflate(R.layout.item_yjjc_cadre_left, parent, false);
                return new ViewContentHolder(vImage);
            case TYPE_HEAD:
                ViewGroup vGroup = (ViewGroup) mInflater.inflate(R.layout.item_yjjc_cadre_left2, parent, false);
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
            vhImage.tv_tip2.setText("");
            vhImage.tv_name.setText(data.getCadreName());
            vhImage.tv_xrzw.setText(data.getCurrentPosition());
            vhImage.tv_nrmzw.setText(data.getAspiringPosition());
            vhImage.tv_xh.setText(data.getRankingStr());

            vhImage.line_bold.setVisibility(View.GONE);
            if(data.getVacantPosition().equals("1"))
                vhImage.line_bold.setVisibility(View.VISIBLE);

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
                vhImage.tv_fzName.setText(data.getGroupingName());
            }
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

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
                listContent.setCadreName(item.getCadreName());
                listContent.setCurrentPosition(item.getCurrentPosition());
                listContent.setAspiringPosition(item.getAspiringPosition());
                listContent.setRanking(item.getRanking());
                listContent.setVacantPosition(item.getVacantPosition());
                list.add(listContent);
            }
        }
        this.datas = list;
        notifyDataSetChanged();
    }

    public class ViewContentHolder extends RecyclerView.ViewHolder {

        TextView tv_tip2,tv_name,tv_xrzw,tv_nrmzw,tv_xh;
        ConstraintLayout cl_parent;
        View line_bold;

        public ViewContentHolder(@NonNull View itemView) {
            super(itemView);

            tv_nrmzw = itemView.findViewById(R.id.tv_nrmzw);
            line_bold = itemView.findViewById(R.id.line_bold);

            cl_parent = itemView.findViewById(R.id.cl_parent);

            tv_tip2 = itemView.findViewById(R.id.tv_tip2);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_xrzw = itemView.findViewById(R.id.tv_xrzw);
            tv_xh = itemView.findViewById(R.id.tv_xh);

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
