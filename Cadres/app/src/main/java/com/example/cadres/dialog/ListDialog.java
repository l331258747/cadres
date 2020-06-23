package com.example.cadres.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.bean.common.ListDialogBean;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by jinty on 2020/6/23.
 */

public class ListDialog extends AlertDialog {

    Context mContext;
    RelativeLayout layoutParent;
    RecyclerView recyclerView;
    List<ListDialogBean> lists;
    ListDialogAdapter.OnItemClickListener onItemClickListener;

    public ListDialog(Context context, List<ListDialogBean> lists) {

        super(context);

        mContext = context;

        this.lists = lists;
    }

    public ListDialog setItemClickListener(ListDialogAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
        return this;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dialog_list, null);
        this.setContentView(layout);

        layoutParent = layout.findViewById(R.id.layout_parent);
        recyclerView = layout.findViewById(R.id.recycle_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        ListDialogAdapter adapter = new ListDialogAdapter(mContext, lists);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);

        layoutParent.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop,
                                       int oldRight, int oldBottom) {
                int contentHeight = layoutParent.getHeight();
                int needHeight = 500;
                if (contentHeight > needHeight) {
                    //注意：这里的 LayoutParams 必须是 FrameLayout的！！
                    layoutParent.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                            needHeight));
                }
            }
        });

    }

    public interface DialogCallBack {
        void exectEvent(DialogInterface alterDialog);
    }
}
