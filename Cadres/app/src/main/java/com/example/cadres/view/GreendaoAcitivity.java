package com.example.cadres.view;

import android.view.View;

import com.cadres.greendao.gen.MeiziDao;
import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.beanDB.Meizi;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.util.ArrayList;
import java.util.List;

public class GreendaoAcitivity extends BaseActivity implements View.OnClickListener {
    CommonDaoUtils<Meizi> meiziDaoUtils;

    @Override
    public int getLayoutId() {
        return R.layout.activity_greendao;
    }

    @Override
    public void initView() {

        findViewById(R.id.btn_insert_one).setOnClickListener(this);
        findViewById(R.id.btn_insert_many).setOnClickListener(this);
        findViewById(R.id.btn_alter).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_delete_all).setOnClickListener(this);
        findViewById(R.id.btn_check_one).setOnClickListener(this);
        findViewById(R.id.btn_check_all).setOnClickListener(this);
        findViewById(R.id.btn_query_native_sql).setOnClickListener(this);
        findViewById(R.id.btn_query_builder).setOnClickListener(this);

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        meiziDaoUtils = _Store.getMeiziDaoUtils();
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_insert_one:
                meiziDaoUtils.insert(new Meizi(null, "Google",
                        "http://7xi8d6.48096_n.jpg"));
                break;

            case R.id.btn_insert_many:
                List<Meizi> meiziList = new ArrayList<>();
                meiziList.add(new Meizi(null, "HuaWei",
                        "http://7xi8d648096_n.jpg"));
                meiziList.add(new Meizi(null, "Apple",
                        "http://7xi8d648096_n.jpg"));
                meiziList.add(new Meizi(null, "MIUI",
                        "http://7xi8d648096_n.jpg"));
                meiziDaoUtils.insertMulti(meiziList);
                break;

            case R.id.btn_alter:
                Meizi meizi = new Meizi();
                meizi.set_id(123l);
                meizi.setSource("BAIDU");
                meizi.setUrl("http://baidu.jpg");
                meiziDaoUtils.update(meizi);
                break;

            case R.id.btn_delete:
                Meizi meizi1 = new Meizi();
                meizi1.set_id(1002l);
                meiziDaoUtils.delete(meizi1);
                break;

            case R.id.btn_delete_all:
                meiziDaoUtils.deleteAll();
                break;

            case R.id.btn_check_one:
                LogUtil.e( meiziDaoUtils.queryById(1002l).toString());
                break;

            case R.id.btn_check_all:
                List<Meizi> meiziList1 = meiziDaoUtils.queryAll();
                for (Meizi meizi2 : meiziList1) {
                    LogUtil.e( meizi2.toString());
                }
                break;

            case R.id.btn_query_native_sql:
                String sql = "where _id > ?";
                String[] condition = new String[]{"2"};
                List<Meizi> meiziList2 = meiziDaoUtils.queryByNativeSql(sql, condition);
                for (Meizi meizi2 : meiziList2) {
                    LogUtil.e(  meizi2.toString());
                }
                break;

            case R.id.btn_query_builder:
                List<Meizi> meiziList3 = meiziDaoUtils.queryByQueryBuilder(MeiziDao.Properties._id.eq(10));
                for (Meizi meizi2 : meiziList3) {
                    LogUtil.e( meizi2.toString());
                }
                break;
        }
}

    @Override
    public void initData() {

    }
}