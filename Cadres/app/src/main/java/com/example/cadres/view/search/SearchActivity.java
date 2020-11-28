package com.example.cadres.view.search;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cadres.greendao.gen.DBSearchBeanDao;
import com.example.cadres.R;
import com.example.cadres.base.ActivityCollect;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.SearchDetailBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.search.SysDictDataBean;
import com.example.cadres.bean.search.ZzbFunctionaryRankBean;
import com.example.cadres.beanDB.DBSearchBean;
import com.example.cadres.dialog.DefaultDialog;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.widget.flowlayout.FlowLayout;
import com.example.cadres.widget.flowlayout.TagAdapter;
import com.example.cadres.widget.flowlayout.TagFlowLayout;
import com.jaygoo.widget.RangeSeekBar;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.Group;

public class SearchActivity extends BaseActivity {

    EditText et_search;

//    private TagFlowLayout fl_history;
    private TagFlowLayout fl_cy;
    private TagFlowLayout fl_lx,fl_gllb, fl_bmlb, fl_xb,
            fl_dp,fl_xrzwcc,
            fl_xl,fl_xllx,fl_xxlx,
            fl_gzjl,fl_xrzjlx, fl_xrzj;
    TextView tv_xrzj;

    RangeSeekBar seekbar2;
    TextView progress2_tv;
    RangeSeekBar seekbar2_xrzjnx;
    TextView progress2_tv_xrzjnx;
    RangeSeekBar seekbar2_xrzwccnx;
    TextView progress2_tv_xrzwccnx;
    RangeSeekBar seekbar2_rxznx;
    TextView progress2_tv_rxznx;
    TextView tv_btn;

    SearchDetailBean searchDetailBean;

//    Group group_history;

    private DecimalFormat df = new DecimalFormat("0");

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {

        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("大数据选人");

        getDbData();
        if(dbSearchBean == null){
            new DefaultDialog(context).setContent("未获取到搜索数据，请重新下载数据").setSubmitListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCollect.getAppCollect().finishAllNotHome();
                }
            }).show();
            return;
        }

        initSearchData();

        initEdit();
//        initFLHistory();
        initFLCyss();

        initFLLx();
        initFLGllb();
        initFLBmlb();
        initFLXb();
        initCsn();

        initFLDp();
        initRxznx();
        initFLXrzwcc();
        initXrzwccnx();

        initFLXl();
        initFLXllx();
        initFLXxlx();

        initFLGzjl();
        initFLXrzjlx();
        initFLXrzj();
        initXrzjnx();

        tv_btn = findViewById(R.id.tv_btn);
        tv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSearchDetail();
            }
        });
    }

    public void goSearchDetail(){
        searchDetailBean.clean();

        if(!TextUtils.isEmpty(et_search.getText().toString())){
            searchDetailBean.setSearch(et_search.getText().toString());
        }
        for (int index : fl_lx.getSelectedList()) {
            searchDetailBean.getLxLists().add(mVals_lx.get(index).getDictValue());
        }
        for (int index : fl_gllb.getSelectedList()) {
            searchDetailBean.getGllbLists().add(mVals_gllb.get(index).getDictLabel());
        }
        for (int index : fl_bmlb.getSelectedList()) {
            searchDetailBean.getBmlbLists().add(mVals_bmlb.get(index).getDictLabel());
        }
        for (int index : fl_xb.getSelectedList()) {
            searchDetailBean.getXbLists().add(mVals_xb.get(index).getDictLabel());
        }
        for (int index : fl_dp.getSelectedList()) {
            searchDetailBean.getDpLists().add(mVals_dp.get(index).getDictLabel());
        }
        for (int index : fl_xrzwcc.getSelectedList()) {
            searchDetailBean.getXrzwccLists().add(mVals_xrzwcc.get(index).getDictLabel());
        }
        for (int index : fl_xl.getSelectedList()) {
            searchDetailBean.getXlLists().add(mVals_xl.get(index).getDictLabel());
        }
        for (int index : fl_xllx.getSelectedList()) {
            searchDetailBean.getXllxLists().add(mVals_xllx[index]);
        }
        for (int index : fl_xxlx.getSelectedList()) {
            searchDetailBean.getXxlxLists().add(mVals_xxlx.get(index).getDictLabel());
        }
        for (int index : fl_gzjl.getSelectedList()) {
            searchDetailBean.getGzjlLists().add(mVals_gzjl.get(index).getDictLabel());
        }

        for (int index : fl_xrzjlx.getSelectedList()) {
            searchDetailBean.getXrzjlxLists().add(mVals_xrzjlx.get(index).getFunctionaryRankName());
        }
        for (int index : fl_xrzj.getSelectedList()) {
            searchDetailBean.getXrzjLists().add(mVals_xrzj.get(index).getFunctionaryRankName());
        }

        List<String> listNl = new ArrayList<>();//出身年
        listNl.add(csnMin + "");
        listNl.add(csnMax + "");
        searchDetailBean.getCsnLists().addAll(listNl);
        List<String> listRz = new ArrayList<>();//任现职级年限
        listRz.add(xrzjnxMin + "");
        listRz.add(xrzjnxMax + "");
        searchDetailBean.getXrzjnxLists().addAll(listRz);
        List<String> listCc = new ArrayList<>();//任现职务层次年限
        listCc.add(xrzwccnxMin + "");
        listCc.add(xrzwccnxMax + "");
        searchDetailBean.getXrzwccnxLists().addAll(listCc);
        List<String> listRxz = new ArrayList<>();//任现职年限
        listRxz.add(rxznxMin + "");
        listRxz.add(rxznxMax + "");
        searchDetailBean.getRxznxLists().addAll(listRxz);

        goDetailActivity(searchDetailBean);
    }

    List<SysDictDataBean> mVals_lx;
    private void initFLLx() {
        fl_lx= findViewById(R.id.fl_lx);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_lx) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_lx, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_lx.setAdapter(adapter1);
    }

    String[] mVals_xllx;
    private void initFLXllx() {
        fl_xllx = findViewById(R.id.fl_xllx);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_xllx) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xllx, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_xllx.setAdapter(adapter1);
    }

    List<SysDictDataBean> mVals_cyss;
    private void initFLCyss() {
        fl_cy = findViewById(R.id.fl_cy);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_cyss) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_cyss, fl_cy, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_cy.setAdapter(adapter1);
        fl_cy.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                searchDetailBean.clean();
                if(mVals_cyss.get(position).getType() == 0){
                    searchDetailBean.setCyssGd(mVals_cyss.get(position).getDictLabel());
                }else if(mVals_cyss.get(position).getType() == 1){
                    searchDetailBean.setCyssZwlx(mVals_cyss.get(position).getDictLabel());
                }else if(mVals_cyss.get(position).getType() == 2){
                    searchDetailBean.setCyssZwbqlx(mVals_cyss.get(position).getDictLabel());
                }
                goDetailActivity(searchDetailBean);
                return false;
            }
        });
    }

    List<SysDictDataBean> mVals_dp;
    private void initFLDp() {
        fl_dp = findViewById(R.id.fl_dp);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_dp) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_dp, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_dp.setAdapter(adapter1);
    }


    List<SysDictDataBean> mVals_xrzwcc;
    private void initFLXrzwcc(){
        fl_xrzwcc = findViewById(R.id.fl_xrzwcc);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_xrzwcc) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xrzwcc, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_xrzwcc.setAdapter(adapter1);
    }

    List<SysDictDataBean> mVals_xb;
    private void initFLXb() {
        fl_xb = findViewById(R.id.fl_xb);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_xb) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xb, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_xb.setAdapter(adapter1);
    }

    List<SysDictDataBean> mVals_gzjl;
    private void initFLGzjl() {
        fl_gzjl = findViewById(R.id.fl_gzjl);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_gzjl) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_gzjl, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_gzjl.setAdapter(adapter1);
    }

    List<SysDictDataBean> mVals_xxlx;
    private void initFLXxlx() {
        fl_xxlx = findViewById(R.id.fl_xxlx);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_xxlx) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xxlx, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_xxlx.setAdapter(adapter1);
    }

    List<SysDictDataBean> mVals_xl;
    private void initFLXl() {
        fl_xl = findViewById(R.id.fl_xl);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_xl) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xl, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_xl.setAdapter(adapter1);
    }

    private void initFLXrzj() {
        tv_xrzj = findViewById(R.id.tv_xrzj);
        tv_xrzj.setVisibility(View.GONE);
        fl_xrzj = findViewById(R.id.fl_xrzj);
        fl_xrzj.setVisibility(View.GONE);
    }

    private void setFLXrzjNone() {
        tv_xrzj = findViewById(R.id.tv_xrzj);
        tv_xrzj.setVisibility(View.GONE);
        fl_xrzj = findViewById(R.id.fl_xrzj);
        fl_xrzj.setVisibility(View.GONE);
        mVals_xrzj = new ArrayList<>();
    }
    private void setFLXrzj(List<ZzbFunctionaryRankBean> mVals_xrzj) {
        tv_xrzj = findViewById(R.id.tv_xrzj);
        tv_xrzj.setVisibility(View.VISIBLE);
        fl_xrzj = findViewById(R.id.fl_xrzj);
        fl_xrzj.setVisibility(View.VISIBLE);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<ZzbFunctionaryRankBean>(mVals_xrzj) {
            @Override
            public View getView(FlowLayout parent, int position, ZzbFunctionaryRankBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xrzj, false);
                tv.setText(s.getFunctionaryRankName());
                return tv;
            }
        };
        fl_xrzj.setAdapter(adapter1);
    }

    List<ZzbFunctionaryRankBean> mVals_xrzjlx;
    private void initFLXrzjlx(){
        fl_xrzjlx = findViewById(R.id.fl_xrzjlx);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<ZzbFunctionaryRankBean>(mVals_xrzjlx) {
            @Override
            public View getView(FlowLayout parent, int position, ZzbFunctionaryRankBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xrzjlx, false);
                tv.setText(s.getFunctionaryRankName());
                return tv;
            }
        };
        fl_xrzjlx.setAdapter(adapter1);
        fl_xrzjlx.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                if(fl_xrzjlx.getSelectedList().size() == 0){
                    setFLXrzjNone();
                }else{
                    setFLXrzj(getXrzjData(mVals_xrzjlx.get(position).getFunctionaryRankId()));
                }
                return false;
            }
        });

    }


    List<SysDictDataBean> mVals_bmlb;
    private void initFLBmlb() {
        fl_bmlb = findViewById(R.id.fl_bmlb);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_bmlb) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_bmlb, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_bmlb.setAdapter(adapter1);
    }

    List<SysDictDataBean> mVals_gllb;
    private void initFLGllb() {
        fl_gllb = findViewById(R.id.fl_gllb);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<SysDictDataBean>(mVals_gllb) {
            @Override
            public View getView(FlowLayout parent, int position, SysDictDataBean s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_gllb, false);
                tv.setText(s.getDictLabel());
                return tv;
            }
        };
        fl_gllb.setAdapter(adapter1);
    }

    int csnMin = 1950;
    int csnMax = 2000;
    private void initCsn() {
        seekbar2 = findViewById(R.id.seekbar2);
        progress2_tv = findViewById(R.id.progress2_tv);
        seekbar2.setRange(csnMin, csnMax);//设置范围
        seekbar2.setValue(csnMin, csnMax);//设置初始值
        progress2_tv.setText(df.format(csnMin) + "年 - " + df.format(csnMax) + "年");
        seekbar2.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                if (isFromUser) {
                    csnMax = (int) max;
                    csnMin = (int) min;
                    progress2_tv.setText(df.format(csnMin) + "年 - " + df.format(csnMax) + "年");
                    seekbar2.setLeftProgressDescription(df.format(csnMin));
                    seekbar2.setRightProgressDescription(df.format(csnMax));
                }
            }
        });
    }

    int xrzjnxMin = 0;
    int xrzjnxMax = 20;
    private void initXrzjnx() {
        seekbar2_xrzjnx = findViewById(R.id.seekbar2_xrzjnx);
        progress2_tv_xrzjnx = findViewById(R.id.progress2_tv_xrzjnx);
        seekbar2_xrzjnx.setRange(xrzjnxMin, xrzjnxMax);//设置范围
        seekbar2_xrzjnx.setValue(xrzjnxMin, xrzjnxMax);//设置初始值
        progress2_tv_xrzjnx.setText(df.format(xrzjnxMin) + "年 - " + df.format(xrzjnxMax) + "年");
        seekbar2_xrzjnx.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                if (isFromUser) {
                    xrzjnxMin = (int) min;
                    xrzjnxMax = (int) max;
                    progress2_tv_xrzjnx.setText(df.format(xrzjnxMin) + "年 - " + df.format(xrzjnxMax) + "年");
                    seekbar2_xrzjnx.setLeftProgressDescription(df.format(xrzjnxMin));
                    seekbar2_xrzjnx.setRightProgressDescription(df.format(xrzjnxMax));
                }
            }
        });
    }

    int xrzwccnxMin = 0;
    int xrzwccnxMax = 20;
    private void initXrzwccnx(){
        seekbar2_xrzwccnx = findViewById(R.id.seekbar2_xrzwccnx);
        progress2_tv_xrzwccnx = findViewById(R.id.progress2_tv_xrzwccnx);
        seekbar2_xrzwccnx.setRange(xrzwccnxMin, xrzwccnxMax);//设置范围
        seekbar2_xrzwccnx.setValue(xrzwccnxMin, xrzwccnxMax);//设置初始值
        progress2_tv_xrzwccnx.setText(df.format(xrzwccnxMin) + "年 - " + df.format(xrzwccnxMax) + "年");
        seekbar2_xrzwccnx.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                if (isFromUser) {
                    xrzwccnxMin = (int) min;
                    xrzwccnxMax = (int) max;
                    progress2_tv_xrzwccnx.setText(df.format(xrzwccnxMin) + "年 - " + df.format(xrzwccnxMax) + "年");
                    seekbar2_xrzwccnx.setLeftProgressDescription(df.format(xrzwccnxMin));
                    seekbar2_xrzwccnx.setRightProgressDescription(df.format(xrzwccnxMax));
                }
            }
        });
    }

    int rxznxMin = 0;
    int rxznxMax = 20;
    private void initRxznx() {
        seekbar2_rxznx = findViewById(R.id.seekbar2_rxznx);
        progress2_tv_rxznx = findViewById(R.id.progress2_tv_rxznx);
        seekbar2_rxznx.setRange(rxznxMin, rxznxMax);//设置范围
        seekbar2_rxznx.setValue(rxznxMin, rxznxMax);//设置初始值
        progress2_tv_rxznx.setText(df.format(rxznxMin) + "年 - " + df.format(rxznxMax) + "年");
        seekbar2_rxznx.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                if (isFromUser) {
                    rxznxMin = (int) min;
                    rxznxMax = (int) max;
                    progress2_tv_rxznx.setText(df.format(rxznxMin) + "年 - " + df.format(rxznxMax) + "年");
                    seekbar2_rxznx.setLeftProgressDescription(df.format(rxznxMin));
                    seekbar2_rxznx.setRightProgressDescription(df.format(rxznxMax));
                }
            }
        });
    }

    private void initEdit() {
        et_search = findViewById(R.id.et_search);
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/

                if (actionId != EditorInfo.IME_ACTION_SEARCH) return true;

                if (TextUtils.isEmpty(v.getText().toString()))
                    return true;

                MySelfInfo.getInstance().addSearch(v.getText().toString());

//                searchDetailBean.clean();
//                searchDetailBean.setSearch(v.getText().toString());
//
//                goDetailActivity(searchDetailBean);

                goSearchDetail();

                return false;
            }
        });
    }

//    private void initFLHistory() {
//        group_history = $(R.id.group_history);
//
//        fl_history = $(R.id.fl_history);
//        final LayoutInflater mInflater = LayoutInflater.from(activity);
//        final List<String> lists = MySelfInfo.getInstance().getSearch();
//
//        if(lists == null || lists.size() == 0){
//            group_history.setVisibility(View.GONE);
//        }else{
//            group_history.setVisibility(View.VISIBLE);
//        }
//
//        TagAdapter adapter1 = new TagAdapter<String>(lists) {
//            @Override
//            public View getView(FlowLayout parent, int position, String s) {
//                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_search, fl_history, false);
//                tv.setText(s);
//                return tv;
//            }
//        };
//        fl_history.setAdapter(adapter1);
//        fl_history.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
//            @Override
//            public boolean onTagClick(View view, int position, FlowLayout parent) {
//                et_search.setText(lists.get(position));
//                et_search.setSelection(et_search.getText().toString().length());
//                MySelfInfo.getInstance().addSearch(lists.get(position));
//
//                searchDetailBean.clean();
//                searchDetailBean.setSearch(lists.get(position));
//
//                goDetailActivity(searchDetailBean);
//
//                return false;
//            }
//        });
//    }

    private void goDetailActivity(SearchDetailBean searchDetailBean){
        Intent intent = new Intent(context,SearchDetailActivity.class);
        intent.putExtra("data", searchDetailBean);
        startActivity(intent);
    }

    @Override
    public void initData() {
        searchDetailBean = new SearchDetailBean();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        initFLHistory();
//    }

    DBSearchBean dbSearchBean;
    public void getDbData(){
        DBSearchBeanDao dbDao = DaoManager.getInstance().getDaoSession().getDBSearchBeanDao();
        QueryBuilder<DBSearchBean> queryBuilder = dbDao.queryBuilder();
        if(queryBuilder.count() != 0)
            dbSearchBean = queryBuilder.unique();
    }

    private void initSearchData() {
        mVals_gllb = dbSearchBean.getCadreTypesList();
        mVals_bmlb = dbSearchBean.getOrgTypesList();
        mVals_xb = dbSearchBean.getUserSexTypesList();
        mVals_dp = dbSearchBean.getPoliticalOutlookTypesList();
        mVals_xrzwcc = dbSearchBean.getCurrenRankTypesList();
        mVals_xl = dbSearchBean.getEducationTypesList();
        mVals_xllx = new String[]{"全日制", "在职教育"};
        mVals_lx = dbSearchBean.getLxList();
        mVals_xxlx = dbSearchBean.getSchoolTypesList();
        mVals_gzjl = dbSearchBean.getWorkExperienceTypesList();
        mVals_xrzjlx = dbSearchBean.getFunctionaryRankParentTypesList();
        initSearchCyssData();
    }

    private void initSearchCyssData() {
        mVals_cyss = new ArrayList<>();
        List<SysDictDataBean> cyss_gd = dbSearchBean.getCyssGdList();//固定类型
        List<SysDictDataBean> cyss_zwlx = dbSearchBean.getOftenSearchPostTypesList();//职务类型
        for (SysDictDataBean item : cyss_zwlx)
            item.setType(1);
        List<SysDictDataBean> cyss_zwbqlx = dbSearchBean.getOftenSearchPostLabelTypesList();//职务标签类型
        for (SysDictDataBean item : cyss_zwbqlx)
            item.setType(2);
        mVals_cyss.addAll(cyss_gd);
        mVals_cyss.addAll(cyss_zwlx);
        mVals_cyss.addAll(cyss_zwbqlx);
    }

    List<ZzbFunctionaryRankBean> mVals_xrzj;
    private List<ZzbFunctionaryRankBean> getXrzjData(int id){
        mVals_xrzj = new ArrayList<>();
        for (int i=0;i<dbSearchBean.getFunctionaryRankTypesList().size();i++){
            ZzbFunctionaryRankBean item = dbSearchBean.getFunctionaryRankTypesList().get(i);
            if(item.getParentId() == id)
                mVals_xrzj.add(item);
        }
        return mVals_xrzj;
    }
}
