package com.example.cadres.view.search;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.SearchBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.widget.flowlayout.FlowLayout;
import com.example.cadres.widget.flowlayout.TagAdapter;
import com.example.cadres.widget.flowlayout.TagFlowLayout;
import com.jaygoo.widget.RangeSeekBar;

import java.text.DecimalFormat;
import java.util.List;

public class SearchActivity extends BaseActivity {

    EditText et_search;

    private TagFlowLayout fl_history;
    private TagFlowLayout fl_gblx, fl_bmlx, fl_zwjb,fl_xl,fl_xxlx,fl_gzjl,fl_xb,fl_dp;

    RangeSeekBar seekbar2;
    TextView progress2_tv;
    RangeSeekBar seekbar2_xrzjnx;
    TextView progress2_tv_xrzjnx;
    TextView tv_btn;

    SearchBean searchBean;


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

        initEdit();
        initFLHistory();
        initFLGblx();
        initFLBmlx();
        initCsn();
        initFLZwjb();
        initFLXl();
        initFLXxlx();
        initFLGzjl();
        initXrzjnx();
        initFLXb();
        initFLDp();

        tv_btn = findViewById(R.id.tv_btn);
        tv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchBean.clean();
                for (int index : fl_gblx.getSelectedList()) {
                    searchBean.getGblxLists().add(mVals_gblx[index]);
                }
                for (int index : fl_bmlx.getSelectedList()) {
                    searchBean.getBmlxLists().add(mVals_bmlx[index]);
                }
                for (int index : fl_zwjb.getSelectedList()) {
                    searchBean.getZwjbLists().add(mVals_zwjb[index]);
                }
                for (int index : fl_xl.getSelectedList()) {
                    searchBean.getXlLists().add(mVals_xl[index]);
                }
                for (int index : fl_xxlx.getSelectedList()) {
                    searchBean.getXxlxLists().add(mVals_xxlx[index]);
                }
                for (int index : fl_gzjl.getSelectedList()) {
                    searchBean.getGzjlLists().add(mVals_gzjl[index]);
                }
                for (int index : fl_xb.getSelectedList()) {
                    searchBean.getXbLists().add(mVals_xb[index]);
                }
                for (int index : fl_dp.getSelectedList()) {
                    searchBean.getDpLists().add(mVals_dp[index]);
                }
                searchBean.getCsnLists().add(csnMin + "");
                searchBean.getCsnLists().add(csnMax + "");
                searchBean.getXrzjnxLists().add(xrzjnxMin + "");
                searchBean.getXrzjnxLists().add(xrzjnxMax + "");

                Intent intent = new Intent(context,SearchDetailActivity.class);
                intent.putExtra("data",searchBean);
                startActivity(intent);
            }
        });

    }

    String[] mVals_dp = new String[]{"全部", "中共党员", "非中共党员", "民革", "民盟", "民建", "民进", "农工员", "致工党", "九三学社", "台盟", "无党派"};
    private void initFLDp() {
        fl_dp = findViewById(R.id.fl_dp);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_dp) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_dp, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_dp.setAdapter(adapter1);
    }

    String[] mVals_xb = new String[]{"全部", "男", "女"};
    private void initFLXb() {
        fl_xb = findViewById(R.id.fl_xb);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_xb) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xb, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_xb.setAdapter(adapter1);
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

    String[] mVals_gzjl = new String[]{"全部", "乡（街）党政正职经历", "区县（市）班子成员经历", "企业管理经历", "高校管理经历", "政法工作经历", "纪检监察经历"};
    private void initFLGzjl() {
        fl_gzjl = findViewById(R.id.fl_gzjl);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_gzjl) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_gzjl, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_gzjl.setAdapter(adapter1);
    }

    String[] mVals_xxlx = new String[]{"全部", "211", "985", "双一流"};
    private void initFLXxlx() {
        fl_xxlx = findViewById(R.id.fl_xxlx);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_xxlx) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xxlx, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_xxlx.setAdapter(adapter1);
    }

    String[] mVals_xl = new String[]{"全部", "小学", "初中", "中专/高中", "大专", "大学本科", "硕士研究生", "博士研究生"};
    private void initFLXl() {
        fl_xl = findViewById(R.id.fl_xl);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_xl) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_xl, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_xl.setAdapter(adapter1);
    }

    String[] mVals_zwjb = new String[]{"全部", "县处级正级", "县处级副级", "乡科级正职", "乡科级副职"};
    private void initFLZwjb() {
        fl_zwjb = findViewById(R.id.fl_zwjb);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_zwjb) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_zwjb, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_zwjb.setAdapter(adapter1);
    }

    String[] mVals_bmlx = new String[]{"全部", "党委班子", "党的纪律班子", "市委班子", "人大班子", "政协班子", "法检班子", "市政府班子", "企业", "其他"};
    private void initFLBmlx() {
        fl_bmlx = findViewById(R.id.fl_bmlx);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_bmlx) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_bmlx, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_bmlx.setAdapter(adapter1);
    }

    String[] mVals_gblx = new String[]{"全部", "市管干部", "市管后备干部", "县管领导干部", "县管非领导干部", "县管后备干部", "其他"};
    private void initFLGblx() {
        fl_gblx = findViewById(R.id.fl_gblx);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        TagAdapter adapter1 = new TagAdapter<String>(mVals_gblx) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_other, fl_gblx, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_gblx.setAdapter(adapter1);

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

                searchBean.setSearch(v.getText().toString());

                Intent intent = new Intent(context,SearchDetailActivity.class);
                intent.putExtra("data",searchBean);
                startActivity(intent);


                return false;
            }
        });
    }

    private void initFLHistory() {
        fl_history = $(R.id.fl_history);
        final LayoutInflater mInflater = LayoutInflater.from(activity);
        final List<String> lists = MySelfInfo.getInstance().getSearch();
        TagAdapter adapter1 = new TagAdapter<String>(lists) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_search, fl_history, false);
                tv.setText(s);
                return tv;
            }
        };
        fl_history.setAdapter(adapter1);
        fl_history.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                et_search.setText(lists.get(position));
                et_search.setSelection(et_search.getText().toString().length());
                MySelfInfo.getInstance().addSearch(lists.get(position));

                searchBean.setSearch(lists.get(position));

                Intent intent = new Intent(context,SearchDetailActivity.class);
                intent.putExtra("data",searchBean);
                startActivity(intent);

                return false;
            }
        });
    }

    @Override
    public void initData() {
        searchBean = new SearchBean();
    }
}
