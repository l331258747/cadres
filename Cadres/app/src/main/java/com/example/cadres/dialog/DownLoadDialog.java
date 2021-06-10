package com.example.cadres.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter33;
import com.example.cadres.utils.StringUtils;

public class DownLoadDialog extends Dialog {

    Context mContext;

    TextView btn_cancel,btn_submit,tv_content,tv_title;

    LinearLayout ll_check;
    ImageView iv_check;

    boolean isCheck = false;

    public DownLoadDialog(Context context) {
        super(context, R.style.mdialog);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dialog_down_load, null);
        this.setContentView(layout);

        btn_cancel = layout.findViewById(R.id.btn_cancel);
        btn_submit = layout.findViewById(R.id.btn_submit);
        tv_content = layout.findViewById(R.id.tv_content);
        tv_title = layout.findViewById(R.id.tv_title);

        ll_check = layout.findViewById(R.id.ll_check);
        iv_check = layout.findViewById(R.id.iv_check);

        iv_check.setImageResource(isCheck?R.mipmap.ic_check:R.mipmap.ic_check_un);
        tv_content.setMovementMethod(ScrollingMovementMethod.getInstance());

        if(!TextUtils.isEmpty(title))
            tv_title.setText(title);

        if(!TextUtils.isEmpty(content))
            tv_content.setText(content);

        ll_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCheck = !isCheck;
                iv_check.setImageResource(isCheck?R.mipmap.ic_check:R.mipmap.ic_check_un);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onClick(isCheck);
                }
                dismiss();
            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


    }

    String title;
    public DownLoadDialog setTitle(String title){
        this.title = title;
        return this;
    }

    String content;
    public DownLoadDialog setContent(String content){
        this.content = content;
        return this;
    }


    public interface OnItemClickListener {
        void onClick(boolean isCheck);
    }

    OnItemClickListener mOnItemClickListener;
    public DownLoadDialog setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }

}
