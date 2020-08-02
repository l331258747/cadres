package com.example.cadres.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.utils.StringUtils;

public class DefaultDialog extends Dialog {

    Context mContext;

    TextView btn_cancel,btn_submit,tv_content,tv_title;

    public DefaultDialog(Context context) {
        super(context, R.style.mdialog);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dialog_default, null);
        this.setContentView(layout);

        btn_cancel = layout.findViewById(R.id.btn_cancel);
        btn_submit = layout.findViewById(R.id.btn_submit);
        tv_content = layout.findViewById(R.id.tv_content);
        tv_title = layout.findViewById(R.id.tv_title);

        tv_content.setMovementMethod(ScrollingMovementMethod.getInstance());

        if(!TextUtils.isEmpty(title))
            tv_title.setText(title);

        if(!TextUtils.isEmpty(content))
            tv_content.setText(content);

        if(!TextUtils.isEmpty(contentHtml))
            StringUtils.setHtml(tv_content,contentHtml);

        if(gravity != -1)
            tv_content.setGravity(gravity);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(submitListener != null){
                    submitListener.onClick(view);
                }
                dismiss();
            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cancelListener != null){
                    cancelListener.onClick(view);
                }
                dismiss();
            }
        });


    }

    String title;
    public DefaultDialog setTitle(String title){
        this.title = title;
        return this;
    }

    String content;
    public DefaultDialog setContent(String content){
        this.content = content;
        return this;
    }

    String contentHtml;
    public DefaultDialog setContentHtml(String contentHtml){
        this.contentHtml = contentHtml;
        return this;
    }

    View.OnClickListener submitListener;
    public DefaultDialog setSubmitListener(View.OnClickListener submitListener){
        this.submitListener = submitListener;
        return this;
    }

    View.OnClickListener cancelListener;
    public DefaultDialog setCancelListener(View.OnClickListener cancelListener){
        this.cancelListener = cancelListener;
        return this;
    }

    int gravity = -1;
    public DefaultDialog setContentGravity(int gravity){
        this.gravity = gravity;
        return this;
    }
}
