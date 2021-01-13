package com.example.cadres.widget.treelistview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cadres.R;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.ViewHolder> implements TreeStateChangeListener {
    private final static int ITEM_STATE_CLOSE = 0;
    private final static int ITEM_STATE_OPEN = 1;
    private Context mContext;
    private List<TreeItem> mList;

    public TreeAdapter(Context context, List<TreeItem> list) {
        initList(list, 0);
        this.mList = new LinkedList<>();
        this.mContext = context;
        this.mList.addAll(list);
    }

    private void initList(List<TreeItem> list, int level) {
        if (list == null || list.size() <= 0) return;
        for (TreeItem item : list) {
            item.itemLevel = level;
            if (item.child != null && item.child.size() > 0) {
                initList(item.child, level + 1);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gb_left2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        if (viewHolder == null) return;
        final TreeItem treeItem = mList.get(i);
        if (treeItem == null) return;



        viewHolder.tv_title.setText(treeItem.title);

        viewHolder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        if(treeItem.getSubset() == 1) //没有子集
            viewHolder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        viewHolder.ll_parent.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
        if (treeItem.getId() == selectDeptDd){
            viewHolder.ll_parent.setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_ffcea3));
        }

        viewHolder.iv_no_women.setVisibility(View.GONE);
        if(TextUtils.equals(treeItem.getIsNoWomen(),"1")){
            viewHolder.iv_no_women.setVisibility(View.VISIBLE);
        }

        if (treeItem.child != null && treeItem.child.size() > 0) {
            viewHolder.tv_status.setVisibility(View.VISIBLE);
            if (treeItem.itemState == ITEM_STATE_OPEN) {
                viewHolder.tv_status.setImageResource(R.mipmap.ic_left_jian);
            } else {
                viewHolder.tv_status.setImageResource(R.mipmap.ic_left_jia);
            }
        } else {
            viewHolder.tv_status.setVisibility(View.INVISIBLE);
        }

        viewHolder.itemView.setOnClickListener(v -> {
            if (treeItem.itemState == ITEM_STATE_CLOSE) {
                onOpen(treeItem, viewHolder.getAdapterPosition());
            } else {
                onClose(treeItem, viewHolder.getAdapterPosition());
            }

            mOnItemClickListener.onClick(i,(treeItem.child == null || treeItem.child.size() == 0));
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onOpen(TreeItem treeItem, int position) {
        if (treeItem.child != null && treeItem.child.size() > 0) {
            mList.addAll(position + 1, treeItem.child);
            treeItem.itemState = ITEM_STATE_OPEN;
            notifyItemRangeInserted(position + 1, treeItem.child.size());
            notifyItemChanged(position);
        }
    }

    @Override
    public void onClose(TreeItem treeItem, int position) {
        if (treeItem.child != null && treeItem.child.size() > 0) {
            int nextSameOrHigherLevelNodePosition = mList.size() - 1;
            if (mList.size() > position + 1) {
                for (int i = position + 1; i < mList.size(); i++) {
                    if (mList.get(i).itemLevel <= mList.get(position).itemLevel) {
                        nextSameOrHigherLevelNodePosition = i - 1;
                        break;
                    }
                }
                closeChild(mList.get(position));
                if (nextSameOrHigherLevelNodePosition > position) {
                    mList.subList(position + 1, nextSameOrHigherLevelNodePosition + 1).clear();
                    treeItem.itemState = ITEM_STATE_CLOSE;
                    notifyItemRangeRemoved(position + 1, nextSameOrHigherLevelNodePosition - position);
                    notifyItemChanged(position);
                }
            }
        }
    }

    private void closeChild(TreeItem treeItem) {
        if (treeItem.child != null) {
            for (TreeItem child : treeItem.child) {
                child.itemState = ITEM_STATE_CLOSE;
                closeChild(child);
            }
        }
    }

    private int selectDeptDd = 0;// 选中的位置
    public void setItemData(int selectDeptDd){
        this.selectDeptDd = selectDeptDd;
        notifyDataSetChanged();
    }

    public void setData(List<TreeItem> datas) {
        this.mList = datas;
        notifyDataSetChanged();
    }

    public void setData(List<TreeItem> datas, int selectDeptDd) {
        this.mList = datas;
        this.selectDeptDd = selectDeptDd;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView iv_no_women;
        LinearLayout ll_parent;
        ImageView tv_status;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_no_women = itemView.findViewById(R.id.iv_no_women);
            ll_parent = itemView.findViewById(R.id.ll_parent);
            tv_status = itemView.findViewById(R.id.tv_status);
        }
    }

    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position,boolean isLeaf);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}