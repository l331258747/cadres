package com.example.cadres.view.Gb;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.constant.Constant;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.glide.GlideUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GbInfoFragment extends BaseFragment {

    TextView tv_xrzwjb,tv_qrzxl,tv_zzjyxl,tv_gblx,tv_rysf,tv_jtzz,
            tv_name,tv_csny,tv_rdsj,tv_jg,tv_xrzjsj,tv_qrzxw,tv_zzjyxw,tv_xrzsj,tv_zyjszw,
            tv_sex,tv_mz,tv_cjgzsj,tv_csd,tv_gwyzj,tv_qrzbyyxx,tv_zzjybyyxx,tv_xrzw,tv_sxzyjzc,
            tv_sfzh,tv_sjhm,tv_jkzk,tv_zzmm,tv_rgwyzjsj,tv_qrzzy,tv_zzjyzy;


    ImageView iv_head;

    private boolean isViewCreated;
    boolean isLoad = false;

    int baseId;

    DBGbBean data;
    CommonDaoUtils<DBGbBean> dBGbDaoUtils;

    public static Fragment newInstance(int baseId) {
        GbInfoFragment fragment = new GbInfoFragment();
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
        return R.layout.fragment_gb_info2;
    }

    @Override
    public void initView() {
        iv_head = $(R.id.iv_head);

        tv_qrzbyyxx = $(R.id.tv_qrzbyyxx);
        tv_zzjybyyxx = $(R.id.tv_zzjybyyxx);
        tv_qrzzy = $(R.id.tv_qrzzy);
        tv_zzjyzy = $(R.id.tv_zzjyzy);

        tv_qrzxl = $(R.id.tv_qrzxl);
        tv_zzjyxl = $(R.id.tv_zzjyxl);
        tv_xrzw = $(R.id.tv_xrzw);
        tv_xrzwjb = $(R.id.tv_xrzwjb);
        tv_rysf = $(R.id.tv_rysf);
        tv_jtzz = $(R.id.tv_jtzz);

        tv_name = $(R.id.tv_name);
        tv_mz = $(R.id.tv_mz);
        tv_rdsj = $(R.id.tv_rdsj);
        tv_zyjszw = $(R.id.tv_zyjszw);
        tv_qrzxw = $(R.id.tv_qrzxw);
        tv_zzjyxw = $(R.id.tv_zzjyxw);
        tv_xrzjsj = $(R.id.tv_xrzjsj);
        tv_sjhm = $(R.id.tv_sjhm);
        tv_gblx = $(R.id.tv_gblx);

        tv_sex = $(R.id.tv_sex);
        tv_jg = $(R.id.tv_jg);
        tv_cjgzsj = $(R.id.tv_cjgzsj);
        tv_sxzyjzc = $(R.id.tv_sxzyjzc);
        tv_xrzsj = $(R.id.tv_xrzsj);
        tv_gwyzj = $(R.id.tv_gwyzj);
        tv_zzmm = $(R.id.tv_zzmm);

        tv_csny = $(R.id.tv_csny);
        tv_csd = $(R.id.tv_csd);
        tv_jkzk = $(R.id.tv_jkzk);
        tv_rgwyzjsj = $(R.id.tv_rgwyzjsj);
        tv_sfzh = $(R.id.tv_sfzh);
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();

        if (getUserVisibleHint()) {
            getData(baseId);
        }
    }


    public DBGbBean getDbBean(int id) {
        List<DBGbBean> dbList = new ArrayList<>();
        String sql = "where BASE_ID = ?";
        String[] condition = new String[]{"" + id};
        dbList = dBGbDaoUtils.queryByNativeSql(sql, condition);
        LogUtil.e("数据库条数：" + dbList.size());
        if(dbList.size() == 0) return null;
        return dbList.get(0);
    }

    public void getData(int id) {
        isLoad = true;

        DBGbBean item = getDbBean(id);
        if (item != null) {
            data = item;
        }
        setView();
    }

    private void setView() {
        if(data != null){
            GlideUtil.LoadImageFitCenter(context,
                    FileUtil.getFolderPath(Constant.IMAGE_PATH + File.separator) + data.getPhotoFileName(),
                    iv_head,R.mipmap.default_head);
            tv_qrzxl.setText(data.getFullTimeEducation());
            tv_zzjyxl.setText(data.getCurrentEducation());
            tv_xrzw.setText(data.getCurrentPosition());
            tv_xrzwjb.setText(data.getCurrentRank());
            tv_rysf.setText(data.getPersonnelType());
            tv_jtzz.setText(data.getHomeAddress());

            tv_name.setText(data.getName());
            tv_mz.setText(data.getNation());
            tv_rdsj.setText(data.getJoinPartyDate());
            tv_zyjszw.setText(data.getTechnicalTitle());
            tv_qrzxw.setText(data.getFullTimeDegreeName());
            tv_zzjyxw.setText(data.getCurrentDegreeName());
            tv_xrzjsj.setText(data.getCurrentRankTime());
            tv_sjhm.setText(data.getPhoneNumber());
            tv_gblx.setText(data.getCadreType());

            tv_sex.setText(data.getGender());
            tv_jg.setText(data.getNativePlace());
            tv_cjgzsj.setText(data.getWorkTime());
            tv_sxzyjzc.setText(data.getExpertise());
            tv_xrzsj.setText(data.getCurrentRankTime());
            tv_gwyzj.setText(data.getFunctionaryRankName());
            tv_zzmm.setText(data.getPoliticalOutlook());

            tv_csny.setText(data.getBirthdayAge());
            tv_csd.setText(data.getBirthplace());
            tv_jkzk.setText(data.getHealth());
            tv_rgwyzjsj.setText(data.getFunctionaryRankTime());
            tv_sfzh.setText(data.getIdCard());


            tv_qrzbyyxx.setText(data.getFullTimeSchool());
            tv_zzjybyyxx.setText(data.getCurrentSchool());
            tv_qrzzy.setText(data.getFullTimeMajor());
            tv_zzjyzy.setText(data.getCurrentMajor());
        }
    }
}
