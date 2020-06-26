package com.example.cadres.view.Gb;

import android.os.Bundle;

import com.example.cadres.R;
import com.example.cadres.adapter.GbNowAdapter;
import com.example.cadres.adapter.GbRankAdapter;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.bean.Gb.GbCadreNowPositionListBean;
import com.example.cadres.bean.Gb.GbCadreRankListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.beanDB.DBGbCadreRankListBean;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GbRankFragment extends BaseFragment {

    RecyclerView recyclerView;

    GbRankAdapter mAdapter;

    CommonDaoUtils<DBGbCadreRankListBean> dBGbDaoUtils;
    List<GbCadreRankListBean> datas;

    int baseId;

    private boolean isViewCreated;
    boolean isLoad = false;


    public static Fragment newInstance(int baseId) {
        GbRankFragment fragment = new GbRankFragment();
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
        return R.layout.fragment_gb_rank;
    }

    @Override
    public void initView() {
        initRecycler();
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbRankDaoUtils();

        if (getUserVisibleHint()) {
            getData(baseId);
        }
    }

    public List<DBGbCadreRankListBean> getDbList(int id) {
        List<DBGbCadreRankListBean> dbList = new ArrayList<>();
        String sql = "where BASE_ID = ?";
        String[] condition = new String[]{"" + id};
        dbList = dBGbDaoUtils.queryByNativeSql(sql, condition);
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public void getData(int id) {
        isLoad = true;

        datas = new ArrayList<>();
        List<DBGbCadreRankListBean> dbList = getDbList(id);
        if (dbList != null) {
            for (int i = 0; i < dbList.size(); i++) {
                DBGbCadreRankListBean item = dbList.get(i);
                datas.add(new GbCadreRankListBean(
                        item.getRankId(),
                        item.getBaseId(),
                        item.getCadreName(),
                        item.getState(),
                        item.getDutiesRank(),
                        item.getDutiesRankTime(),
                        item.getTreatmentRank(),
                        item.getTreatmentRankTime()
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
        mAdapter = new GbRankAdapter(activity, new ArrayList<GbCadreRankListBean>());
        recyclerView.setAdapter(mAdapter);
    }
}
