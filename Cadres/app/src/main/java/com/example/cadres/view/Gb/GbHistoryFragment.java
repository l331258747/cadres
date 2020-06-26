package com.example.cadres.view.Gb;

import android.os.Bundle;

import com.example.cadres.R;
import com.example.cadres.adapter.GbHistoryAdapter;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.bean.Gb.GbCadreHistoryPositionListBean;
import com.example.cadres.beanDB.DBGbCadreHistoryPositionListBean;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GbHistoryFragment extends BaseFragment {

    RecyclerView recyclerView;

    GbHistoryAdapter mAdapter;

    CommonDaoUtils<DBGbCadreHistoryPositionListBean> dBGbDaoUtils;
    List<GbCadreHistoryPositionListBean> datas;

    int baseId;

    private boolean isViewCreated;
    boolean isLoad = false;


    public static Fragment newInstance(int baseId) {
        GbHistoryFragment fragment = new GbHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ID", baseId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            baseId = bundle.getInt("ID");
        }
        isViewCreated = true;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);//比oncreate先执行
        if (isVisibleToUser && isViewCreated && !isLoad) {
            getData(baseId);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gb_history;
    }

    @Override
    public void initView() {
        initRecycler();
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbHistoryDaoUtils();

        if (getUserVisibleHint()) {
            getData(baseId);
        }
    }

    public List<DBGbCadreHistoryPositionListBean> getDbList(int id) {
        List<DBGbCadreHistoryPositionListBean> dbList = new ArrayList<>();
        String sql = "where BASE_ID = ?";
        String[] condition = new String[]{"" + id};
        dbList = dBGbDaoUtils.queryByNativeSql(sql, condition);
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public void getData(int id) {
        isLoad = true;

        datas = new ArrayList<>();
        List<DBGbCadreHistoryPositionListBean> dbList = getDbList(id);
        if (dbList != null) {
            for (int i = 0; i < dbList.size(); i++) {
                DBGbCadreHistoryPositionListBean item = dbList.get(i);
                datas.add(new GbCadreHistoryPositionListBean(
                        item.getPositionId(),
                        item.getDeptId(),
                        item.getDeptName(),
                        item.getBaseId(),
                        item.getCadreName(),
                        item.getDutiesRank(),
                        item.getPosition(),
                        item.getPositionTitle(),
                        item.getPositionTitleName(),
                        item.getLeaveTime(),
                        item.getLeaveReason(),
                        item.getLeaveFileNumber(),
                        item.getVacantPosition()
                ));
            }
        }

        mAdapter.setData(datas);
    }


    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GbHistoryAdapter(activity, new ArrayList<GbCadreHistoryPositionListBean>());
        recyclerView.setAdapter(mAdapter);
    }
}