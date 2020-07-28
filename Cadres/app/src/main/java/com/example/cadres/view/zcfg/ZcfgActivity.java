package com.example.cadres.view.zcfg;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cadres.greendao.gen.DBZcfgBeanDao;
import com.cadres.greendao.gen.DbZcfgNoticeTypeBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.adapter.ZcfgAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.beanDB.DbZcfgNoticeTypeBean;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import org.greenrobot.greendao.query.QueryBuilder;

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
    List<DBZcfgBean> datas;

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
                    type = "";
                    tv_screen.setText("全部");
                    key = et_search.getText().toString().trim();
                    getData();
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

        getDbOrgNoticeData();
        getData();
    }

    public List<DBZcfgBean> getDbListByType(String key) {
        List<DBZcfgBean> dbList = new ArrayList<>();
        DBZcfgBeanDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBZcfgBeanDao();
        QueryBuilder<DBZcfgBean> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            queryBuilder.where(DBZcfgBeanDao.Properties.NoticeTitle.like("%" + key + "%"));
            dbList = queryBuilder.list();
        }else{
            if(!TextUtils.isEmpty(type))
                queryBuilder.where(DBZcfgBeanDao.Properties.NoticeType.eq(type));
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public void getData() {
        datas = new ArrayList<>();
        List<DBZcfgBean> dbList = getDbListByType(key);
        if (dbList != null) {
            datas = dbList;
        }
        mAdapter.setData(datas);
    }

    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new ZcfgAdapter(activity, new ArrayList<DBZcfgBean>());
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
    List<ListDialogBean> dialogDatas;
    String key = "";
    String type = "";

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_screen:
                if(listDialog == null){
                    listDialog = new ListDialog(context, dialogDatas);
                    listDialog.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            type = dialogDatas.get(position).getsId();
                            tv_screen.setText(dialogDatas.get(position).getName());
                            key = "";
                            et_search.setText("");
                            getData();
                            listDialog.dismiss();
                        }
                    });
                }
                listDialog.show();

                break;

        }
    }

    public void getDbOrgNoticeData(){
        DbZcfgNoticeTypeBeanDao dbBmOrgTypeBeanDao = DaoManager.getInstance().getDaoSession().getDbZcfgNoticeTypeBeanDao();
        QueryBuilder<DbZcfgNoticeTypeBean> queryBuilder = dbBmOrgTypeBeanDao.queryBuilder();
        List<DbZcfgNoticeTypeBean> orgs = queryBuilder.list();

        dialogDatas = new ArrayList<>();
        dialogDatas.add(new ListDialogBean("","全部"));
        for (int i=0;i<orgs.size();i++){
            dialogDatas.add(new ListDialogBean(orgs.get(i).getDictValue(),orgs.get(i).getDictLabel()));
        }
    }
}
