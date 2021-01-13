package com.example.cadres.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter2;
import com.example.cadres.adapter.ListDialogAdapter22;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.utils.AppUtils;
import com.example.cadres.widget.treelistview.TreeItem;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by jinty on 2020/6/23.
 */

public class ListDialog22 extends Dialog {

    Context mContext;
    RecyclerView recyclerView;
    List<TreeItem> bmLeftBeans2;
    LinearLayout layout_parent;
    ListDialogAdapter22.OnItemClickListener onItemClickListener;

    ListDialogAdapter22 adapter;

    EditText et_left_search;

    public ListDialog22(Context context, List<TreeItem> bmLeftBeans2) {

        super(context,R.style.mdialog);

        mContext = context;

        this.bmLeftBeans2 = bmLeftBeans2;
    }

    public ListDialog22 setItemClickListener(ListDialogAdapter22.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
        return this;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dialog_list2, null);
        this.setContentView(layout);

        recyclerView = layout.findViewById(R.id.recycle_view);
        layout_parent = layout.findViewById(R.id.layout_parent);
        et_left_search = layout.findViewById(R.id.et_left_search);
        initLeftSearch();

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        adapter = new ListDialogAdapter22(mContext, new ArrayList<>());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);

        adapter.setData(bmLeftBeans2);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = AppUtils.dip2px(300);
        params.height = AppUtils.dip2px(500); ;
        getWindow().setAttributes(params);

    }

    TextView.OnEditorActionListener onEditorActionListener;
    public ListDialog22 setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener){
        this.onEditorActionListener = onEditorActionListener;
        return this;
    }

    TextWatcher textWatcher;
    public ListDialog22 addTextChangedListener(TextWatcher textWatcher){
        this.textWatcher = textWatcher;
        return this;
    }

    private void initLeftSearch() {
        et_left_search.setOnEditorActionListener(onEditorActionListener);

        et_left_search.addTextChangedListener(textWatcher);
    }

    public ListDialogAdapter22 getAdapter(){
        return adapter;
    }

    public EditText getEt_left_search() {
        return et_left_search;
    }

    public void show(){
        super.show();
    }
}
