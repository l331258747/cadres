package com.example.cadres.view.zcfg;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.adapter.ZcfgAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.bean.zcfg.ZcfgBean;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ZcfgActivity extends BaseActivity implements View.OnClickListener {

    EditText et_search;
    TextView tv_screen;
    RecyclerView recyclerView;

    ZcfgAdapter mAdapter;
    CommonDaoUtils<DBZcfgBean> dBZcfgDaoUtils;
    List<ZcfgBean.ZcfgBean2> datas;

    int type = 0;//0全部，4重要文件，5付律法规
    String key = "";

    List<ListDialogBean> dialogDatas;

    @Override
    public int getLayoutId() {
        return R.layout.activity_zcfg;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("政策法规");

        et_search = findViewById(R.id.et_search);
        tv_screen = findViewById(R.id.tv_screen);

        tv_screen.setOnClickListener(this);

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    key = et_search.getText().toString().trim();
                    type = 0;
                    tv_screen.setText("全部");
                    mAdapter.setData(getData());
                    return true;
                }
                return false;
            }
        });

        initRecycler();
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBZcfgDaoUtils = _Store.getZcfgDaoUtils();

        dialogDatas = new ArrayList<>();
        dialogDatas.add(new ListDialogBean(0,"全部"));
        dialogDatas.add(new ListDialogBean(4,"重要文件"));
        dialogDatas.add(new ListDialogBean(5,"付律法规"));

        mAdapter.setData(getData());
    }

    public List<DBZcfgBean> getDbListByType() {
        List<DBZcfgBean> dbList = new ArrayList<>();
        if(!TextUtils.isEmpty(key)){
            String sql = "where NOTICE_TITLE like ?";
            String[] condition = new String[]{"%" + key + "%"};
            dbList = dBZcfgDaoUtils.queryByNativeSql(sql, condition);
        }else{
            if (type == 0) {
                dbList = dBZcfgDaoUtils.queryAll();
            } else {
                String sql = "where NOTICE_TYPE = ?";
                String[] condition = new String[]{"" + type};
                dbList = dBZcfgDaoUtils.queryByNativeSql(sql, condition);
            }
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public List<ZcfgBean.ZcfgBean2> getData() {
        datas = new ArrayList<>();
        List<DBZcfgBean> dbList = getDbListByType();
        if (dbList != null) {
            for (int i = 0; i < dbList.size(); i++) {
                DBZcfgBean item = dbList.get(i);
                datas.add(new ZcfgBean.ZcfgBean2(
                        item.getSearchValue(),
                        item.getCreateBy(),
                        item.getCreateTime(),
                        item.getUpdateBy(),
                        item.getUpdateTime(),
                        item.getRemark(),
                        item.getDeptCode(),
                        item.getNoticeId(),
                        item.getNoticeTitle(),
                        item.getNoticeType(),
                        item.getNoticeTypeName(),
                        item.getNoticeContent(),
                        item.getStatus(),
                        item.getStatusName(),
                        item.getTitleFileUrl()
                ));
            }
        }
        return datas;
    }

    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new ZcfgAdapter(activity, new ArrayList<ZcfgBean.ZcfgBean2>());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ZcfgAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                String content = datas.get(pos).getNoticeContent();
                if (TextUtils.isEmpty(content)) {
                    ToastUtil.showShortToast(context, "详情没有数据");
                    return;
                }
                Intent intent = new Intent(context, ZcfgDetailActivity.class);
                intent.putExtra("content", content);
                intent.putExtra("title",datas.get(pos).getNoticeTitleStr());
                startActivity(intent);
            }
        });

    }

    ListDialog listDialog;
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_screen:
                if(listDialog == null){
                    listDialog = new ListDialog(context, dialogDatas);
                    listDialog.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            type = dialogDatas.get(position).getId();
                            tv_screen.setText(dialogDatas.get(position).getName());
                            mAdapter.setData(getData());
                            key = "";
                            et_search.setText("");
                            listDialog.dismiss();
                        }
                    });
                }
                listDialog.show();

                break;

        }
    }
}
