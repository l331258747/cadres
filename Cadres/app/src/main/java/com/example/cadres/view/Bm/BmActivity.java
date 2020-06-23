package com.example.cadres.view.Bm;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.BmAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BmActivity extends BaseActivity {

    EditText et_search;
    RecyclerView recyclerView;

    BmAdapter mAdapter;

    CommonDaoUtils<DBBmBean> dBBmDaoUtils;
    List<BmBean.BmBean2> datas;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bm;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("干部名册");

        et_search = findViewById(R.id.et_search);

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String key = et_search.getText().toString().trim();
                    mAdapter.setData(getData(key));
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
        dBBmDaoUtils = _Store.getBmDaoUtils();

        mAdapter.setData(getData(""));
    }

    public List<DBBmBean> getDbList(String key) {
        List<DBBmBean> dbList = new ArrayList<>();
        if(!TextUtils.isEmpty(key)){
            String sql = "where DEPT_NAME like ?";
            String[] condition = new String[]{"%" + key + "%"};
            dbList = dBBmDaoUtils.queryByNativeSql(sql, condition);
        }else{
            dbList = dBBmDaoUtils.queryAll();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public List<BmBean.BmBean2> getData(String key) {
        datas = new ArrayList<>();
        List<DBBmBean> dbList = getDbList(key);
        if (dbList != null) {
            for (int i = 0; i < dbList.size(); i++) {
                DBBmBean item = dbList.get(i);
                datas.add(new BmBean.BmBean2(
                        item.getDeptId(),
                        item.getParentId(),
                        item.getDeptName(),
                        item.getDzzName(),
                        item.getOrgCode(),
                        item.getOrgType(),
                        item.getOrgTypeName(),
                        item.getFinanceType(),
                        item.getFinanceTypeName(),
                        item.getSimpleName(),
                        item.getOrderNum(),
                        item.getDeptType(),
                        item.getDeptTypeName(),
                        item.getDelFlag(),
                        item.getParentName(),
                        item.getVerification(),
                        item.getActual(),
                        item.getOvermatch(),
                        item.getMismatch(),
                        item.getApprovedPosition(),
                        item.getApprovedDeputy(),
                        item.getApprovedOther(),
                        item.getActualPosition(),
                        item.getActualDeputy(),
                        item.getActualOther()
                ));
            }
        }
        return datas;
    }


    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new BmAdapter(activity, new ArrayList<BmBean.BmBean2>());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BmAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
//                String content = datas.get(pos).getNoticeContent();
//                if (TextUtils.isEmpty(content)) {
//                    ToastUtil.showShortToast(context, "详情没有数据");
//                    return;
//                }
//                Intent intent = new Intent(context, ZcfgDetailActivity.class);
//                intent.putExtra("content", content);
//                startActivity(intent);
            }
        });
    }
}
