package com.example.cadres.adapter;

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
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.utils.AppUtils;
import com.example.cadres.widget.treelistview.TreeAdapter;
import com.example.cadres.widget.treelistview.TreeItem;
import com.example.cadres.widget.treelistview.TreeStateChangeListener;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by jinty on 2020/6/23.
 */

public class ListDialogAdapter22 extends RecyclerView.Adapter<ListDialogAdapter22.ViewHolder> implements TreeStateChangeListener {
    private final static int ITEM_STATE_CLOSE = 0;
    private final static int ITEM_STATE_OPEN = 1;
    private Context mContext;
    private List<TreeItem> mList;

    public ListDialogAdapter22(Context context, List<TreeItem> list) {
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_list_item22, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListDialogAdapter22.ViewHolder viewHolder, int i) {
        if (viewHolder == null) return;
        final TreeItem treeItem = mList.get(i);
        if (treeItem == null) return;

        viewHolder.tv_title.setText(treeItem.title);

        viewHolder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        if(treeItem.getSubset() == 1) //没有子集
            viewHolder.tv_title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        viewHolder.ll_parent.setBackgroundColor(ContextCompat.getColor(mContext, R.color.transparent));
        if (treeItem.getId() == selectDeptDd){
            viewHolder.ll_parent.setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_01B7FF));
        }

        if (treeItem.child != null && treeItem.child.size() > 0) {
            viewHolder.tv_status.setVisibility(View.VISIBLE);
            if (treeItem.itemState == ITEM_STATE_OPEN) {
                viewHolder.tv_status.setImageResource(R.mipmap.ic_left_jian2);
            } else {
                viewHolder.tv_status.setImageResource(R.mipmap.ic_left_jia2);
            }
        } else {
            viewHolder.tv_status.setVisibility(View.INVISIBLE);
        }

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) viewHolder.tv_status.getLayoutParams();
        lp.leftMargin = AppUtils.dip2px(10) + treeItem.itemLevel * AppUtils.dip2px(10) ;
        viewHolder.tv_status.setLayoutParams(lp);

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
        if(mList!=null && mList.size() > 0)
            onOpen(mList.get(0),0);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        LinearLayout ll_parent;
        ImageView tv_status;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
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
