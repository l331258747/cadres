package com.example.cadres.view.Gb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GbActivity extends BaseActivity {

    Group group_View_top;
    TextView tv_top_title,tv_top_btn,tv_top_hdzs2,tv_top_sjpb2,tv_top_cpqk2,tv_top_kqqk2;
    View view_menu;
    EditText et_search;

    RecyclerView recyclerView;

    GbAdapter mAdapter;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<GbBean.GbBean2> datas;


    @Override
    public int getLayoutId() {
        return R.layout.activity_gb;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("干部名册");

        et_search = findViewById(R.id.et_search);

        group_View_top = findViewById(R.id.group_View_top);
        tv_top_title = findViewById(R.id.tv_top_title);
        tv_top_btn = findViewById(R.id.tv_top_btn);
        tv_top_hdzs2 = findViewById(R.id.tv_top_hdzs2);
        tv_top_sjpb2 = findViewById(R.id.tv_top_sjpb2);
        tv_top_cpqk2 = findViewById(R.id.tv_top_cpqk2);
        tv_top_kqqk2 = findViewById(R.id.tv_top_kqqk2);
        view_menu = findViewById(R.id.view_menu);

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
        dBGbDaoUtils = _Store.getGbDaoUtils();

        mAdapter.setData(getData(""));
    }

    public List<DBGbBean> getDbList(String key) {
        List<DBGbBean> dbList = new ArrayList<>();
        if(!TextUtils.isEmpty(key)){
            String sql = "where NAME like ?";
            String[] condition = new String[]{"%" + key + "%"};
            dbList = dBGbDaoUtils.queryByNativeSql(sql, condition);
        }else{
            dbList = dBGbDaoUtils.queryAll();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }


    public List<GbBean.GbBean2> getData(String key) {
        datas = new ArrayList<>();
        List<DBGbBean> dbList = getDbList(key);
        if (dbList != null) {
            for (int i = 0; i < dbList.size(); i++) {
                DBGbBean item = dbList.get(i);
                datas.add(new GbBean.GbBean2(
                        item.getBaseId(),
                        item.getName(),
                        item.getPhotoFileName(),
                        item.getGender(),
                        item.getIdCard(),
                        item.getBirthday(),
                        item.getAge(),
                        item.getNation(),
                        item.getPoliticalOutlook(),
                        item.getJoinPartyDate(),
                        item.getNativePlace(),
                        item.getBirthplace(),
                        item.getWorkTime(),
                        item.getPersonnelRelationsDeptId(),
                        item.getPersonnelRelationsDeptName(),
                        item.getEnterUnitTime(),
                        item.getCurrentRank(),
                        item.getCurrentRankTime(),
                        item.getHealth(),
                        item.getFunctionaryRankId(),
                        item.getFunctionaryRankName(),
                        item.getFunctionaryRankTime(),
                        item.getCadreType(),
                        item.getCurrentPosition(),
                        item.getCurrentPositionTime(),
                        item.getPersonnelType(),
                        item.getTechnicalTitle(),
                        item.getExpertise(),
                        item.getFullTimeEducation(),
                        item.getFullTimeSchool(),
                        item.getFullTimeDegreeId(),
                        item.getFullTimeDegreeName(),
                        item.getFullTimeSchoolType(),
                        item.getCurrentEducation(),
                        item.getCurrentDegreeId(),
                        item.getCurrentDegreeName(),
                        item.getCurrentSchool(),
                        item.getCurrentSchoolType(),
                        item.getWorkPhone(),
                        item.getPhoneNumber(),
                        item.getHomeAddress(),
                        item.getResponsibilities()
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
        mAdapter = new GbAdapter(activity, new ArrayList<GbBean.GbBean2>());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new GbAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(context,GbDetailActivity.class);
                intent.putExtra("ID", datas.get(pos).getBaseId());
                startActivity(intent);
            }
        });
    }
}
