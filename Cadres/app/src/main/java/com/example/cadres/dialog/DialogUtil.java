package com.example.cadres.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * Created by LGQ
 * Time: 2018/9/26
 * Function:
 */

public class DialogUtil {

    private static DialogUtil instance = null;

    public static DialogUtil getInstance() {
        if (instance == null) {
            instance = new DialogUtil();
        }
        return instance;
    }

    private DialogUtil() {
    }


    public AlertDialog getDefaultDialog(Context context, String title, String content, String positiveName, final DialogCallBack callBack) {
        AlertDialog alterDialog = new AlertDialog.Builder(context)
                .setMessage(content)
                .setPositiveButton(positiveName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (callBack == null) {
                            dialog.cancel();
                        } else {
                            callBack.exectEvent(dialog);
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();

        return alterDialog;
    }

    public AlertDialog getDefaultDialog(Context context, String content) {
        return this.getDefaultDialog(context, "提示", content, "确定", null);
    }

    public AlertDialog getDefaultDialog(Context context, String content, final DialogCallBack callBack) {
        return this.getDefaultDialog(context, "提示", content, "确定", callBack);
    }

    public AlertDialog getDefaultDialog(Context context, String content, String positiveName, final DialogCallBack callBack) {
        return this.getDefaultDialog(context, "提示", content, positiveName, callBack);
    }

    public AlertDialog getListDialog(Context context, String[] items, final DialogListCallBack callBack) {
        AlertDialog alterDialog = new AlertDialog.Builder(context)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callBack.exectEvent(dialog, which);
                        dialog.dismiss();
                    }
                }).create();
        return alterDialog;
    }


    public interface DialogCallBack {
        void exectEvent(DialogInterface alterDialog);
    }

    public interface DialogListCallBack {
        void exectEvent(DialogInterface alterDialog, int which);
    }


}
