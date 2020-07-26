package com.example.cadres.utils.myData;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreFamilyMemberListDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbFamilyAdapter;
import com.example.cadres.adapter.GbFamilyAdapter2;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreFamilyMemberList;
import com.example.cadres.constant.Constant;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.glide.GlideUtil;
import com.example.cadres.utils.greendao.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GbDrawerData {

    LinearLayout pView;
    Context context;

    TextView tv_name,tv_sex,tv_sfzh,tv_csny,tv_mz,tv_sjhm,tv_jg,tv_csd,tv_zzmm;
    TextView tv_cjzzrq,tv_cjgzsj,tv_jkzk,tv_zyjszw,tv_sxzyjzc,tv_xlxw_qrz,tv_xlxw_zz,tv_byyxxjzy_qrz,tv_byyxxjzy_zz;
    TextView tv_gwydjsj,tv_rxzsj,tv_xrzw,tv_xrzwcc,tv_rxzwccsj,tv_xrzj,tv_rxzjsj,tv_rylb,tv_gllb,tv_zwlb,tv_lx,tv_jtzz,tv_bz;
    TextView tv_gzjl,tv_jlqk,tv_fmqd,tv_pxqk,tv_kcqk;
    ImageView iv_head,iv_head_tag;
    RecyclerView recycle_view_jtcy;

    GbFamilyAdapter2 mAdapter;

    public GbDrawerData(Context context, LinearLayout pView) {
        this.pView = pView;
        this.context = context;
    }

    public void initView(){
        tv_name = findViewById(R.id.tv_name);
        tv_sex = findViewById(R.id.tv_sex);
        tv_sfzh = findViewById(R.id.tv_sfzh);
        tv_csny = findViewById(R.id.tv_csny);
        tv_mz = findViewById(R.id.tv_mz);
        tv_sjhm = findViewById(R.id.tv_sjhm);
        tv_jg = findViewById(R.id.tv_jg);
        tv_csd = findViewById(R.id.tv_csd);
        tv_zzmm = findViewById(R.id.tv_zzmm);

        tv_cjzzrq = findViewById(R.id.tv_cjzzrq);
        tv_cjgzsj = findViewById(R.id.tv_cjgzsj);
        tv_jkzk = findViewById(R.id.tv_jkzk);
        tv_zyjszw = findViewById(R.id.tv_zyjszw);
        tv_sxzyjzc = findViewById(R.id.tv_sxzyjzc);
        tv_xlxw_qrz = findViewById(R.id.tv_xlxw_qrz);
        tv_xlxw_zz = findViewById(R.id.tv_xlxw_zz);
        tv_byyxxjzy_qrz = findViewById(R.id.tv_byyxxjzy_qrz);
        tv_byyxxjzy_zz = findViewById(R.id.tv_byyxxjzy_zz);

        tv_gwydjsj = findViewById(R.id.tv_gwydjsj);
        tv_rxzsj = findViewById(R.id.tv_rxzsj);
        tv_xrzw = findViewById(R.id.tv_xrzw);
        tv_xrzwcc = findViewById(R.id.tv_xrzwcc);
        tv_rxzwccsj = findViewById(R.id.tv_rxzwccsj);
        tv_xrzj = findViewById(R.id.tv_xrzj);
        tv_rxzjsj = findViewById(R.id.tv_rxzjsj);
        tv_rylb = findViewById(R.id.tv_rylb);
        tv_gllb = findViewById(R.id.tv_gllb);
        tv_zwlb = findViewById(R.id.tv_zwlb);
        tv_lx = findViewById(R.id.tv_lx);
        tv_jtzz = findViewById(R.id.tv_jtzz);
        tv_bz = findViewById(R.id.tv_bz);

        tv_gzjl = findViewById(R.id.tv_gzjl);
        tv_jlqk = findViewById(R.id.tv_jlqk);
        tv_fmqd = findViewById(R.id.tv_fmqd);
        tv_pxqk = findViewById(R.id.tv_pxqk);
        tv_kcqk = findViewById(R.id.tv_kcqk);

        recycle_view_jtcy = findViewById(R.id.recycle_view_jtcy);
        iv_head = findViewById(R.id.iv_head);
        iv_head_tag = findViewById(R.id.iv_head_tag);

        initRecycler();
    }

    //初始化recyclerview
    private void initRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycle_view_jtcy.setLayoutManager(linearLayoutManager);
        mAdapter = new GbFamilyAdapter2(context, new ArrayList<DBGbCadreFamilyMemberList>());
        recycle_view_jtcy.setAdapter(mAdapter);
        recycle_view_jtcy.setNestedScrollingEnabled(false);
    }

    private  <T extends View> T findViewById(@IdRes int id) {
        return pView.findViewById(id);
    }

    public void getData(int baseId) {
        DBGbBean data = getDbBean(baseId);
        if(data == null) return;

        tv_name.setText(data.getName());
        tv_sex.setText(data.getGender());
        tv_sfzh.setText(data.getIdCard());
        tv_csny.setText(data.getBirthdayAge());
        tv_mz.setText(data.getNation());
        tv_sjhm.setText(data.getPhoneNumber());
        tv_jg.setText(data.getNativePlaceReplenish());
        tv_csd.setText(data.getBirthplace());
        tv_zzmm.setText(data.getPoliticalOutlook());

        tv_cjzzrq.setText(data.getJoinPartyDate());
        tv_cjgzsj.setText(data.getWorkTime());
        tv_jkzk.setText(data.getHealth());
        tv_zyjszw.setText(data.getTechnicalTitle());
        tv_sxzyjzc.setText(data.getExpertise());
        tv_xlxw_qrz.setText(data.getFullTimeEducation());
        tv_xlxw_zz.setText(data.getCurrentEducation());
        tv_byyxxjzy_qrz.setText(data.getFullTimeSchoolMajor());
        tv_byyxxjzy_zz.setText(data.getCurrentSchoolMajor());

        tv_gwydjsj.setText(data.getFunctionaryRegisterTime());
        tv_rxzsj.setText(data.getCurrentPositionTime());
        tv_xrzw.setText(data.getCurrentPosition());
        tv_xrzwcc.setText(data.getCurrentRank());
        tv_rxzwccsj.setText(data.getCurrentRankTime());
        tv_xrzj.setText(data.getFunctionaryRankName());
        tv_rxzjsj.setText(data.getFunctionaryRankTime());
        tv_rylb.setText(data.getPersonnelType());
        tv_gllb.setText(data.getCadreType());
        tv_zwlb.setText(data.getPositionType());
        tv_lx.setText(data.getType());
        tv_jtzz.setText(data.getHomeAddress());
        tv_bz.setText(data.getRemark());

        tv_gzjl.setText(data.getCadreResume());
        tv_jlqk.setText(data.getCadreAward());
        tv_fmqd.setText(data.getCadrePunish());
        tv_pxqk.setText(data.getCadreTrain());
        tv_kcqk.setText(data.getPoliticalConstruction());


        GlideUtil.LoadImageFitCenter(context,
                FileUtil.getFolderPath(Constant.IMAGE_PATH + File.separator) + data.getPhotoFileName(),
                iv_head,R.mipmap.default_head);

        iv_head_tag.setVisibility(View.GONE);
        if(TextUtils.equals(data.getAffectedState(),"1")){
            iv_head_tag.setVisibility(View.VISIBLE);
            iv_head_tag.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.ic_punishment_red));
        }else if(TextUtils.equals(data.getAffectedState(),"2")){
            iv_head_tag.setVisibility(View.VISIBLE);
            iv_head_tag.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.ic_punishment_yellow));
        }

        List<DBGbCadreFamilyMemberList> list = getFamilys(baseId);
        if(list !=null){
            mAdapter.setData(list);
        }
    }

    private DBGbBean getDbBean(int id) {
        DBGbBean dbGbBean = null;
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.BaseId.eq(id));
        if(queryBuilder.count() != 0)
            dbGbBean = queryBuilder.unique();
        return dbGbBean;
    }

    private List<DBGbCadreFamilyMemberList> getFamilys(int id){
        DBGbCadreFamilyMemberListDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbCadreFamilyMemberListDao();
        QueryBuilder<DBGbCadreFamilyMemberList> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbCadreFamilyMemberListDao.Properties.BaseId.eq(id));
        return queryBuilder.list();
    }
}
