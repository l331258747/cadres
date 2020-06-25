package com.example.cadres.utils.greendao;


import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DBBmExplainBeanDao;
import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreAwardPunishListDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.cadres.greendao.gen.DBGbCadreFamilyMemberListDao;
import com.cadres.greendao.gen.DBGbCadreHistoryPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreNowPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreRankListBeanDao;
import com.cadres.greendao.gen.DBGbCadreResumeListBeanDao;
import com.cadres.greendao.gen.DBGbCadreTrainListBeanDao;
import com.cadres.greendao.gen.DBUserListBeanDao;
import com.cadres.greendao.gen.DBZcfgBeanDao;
import com.cadres.greendao.gen.MeiziDao;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreAwardPunishList;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreFamilyMemberList;
import com.example.cadres.beanDB.DBGbCadreHistoryPositionListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.beanDB.DBGbCadreRankListBean;
import com.example.cadres.beanDB.DBGbCadreResumeListBean;
import com.example.cadres.beanDB.DBGbCadreTrainListBean;
import com.example.cadres.beanDB.DBUserListBean;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.beanDB.Meizi;

/**
 * 存放DaoUtils
 */
public class DaoUtilsStore {
    private volatile static DaoUtilsStore instance = new DaoUtilsStore();
    private CommonDaoUtils<Meizi> meiziDaoUtils;

    private CommonDaoUtils<DBUserListBean> userListDaoUtils;

    private CommonDaoUtils<DBZcfgBean> zcfgDaoUtils;

    private CommonDaoUtils<DBBmBean> bmDaoUtils;
    private CommonDaoUtils<DBBmExplainBean> bmExplainDaoUtils;

    private CommonDaoUtils<DBGbBean> gbDaoUtils;
    private CommonDaoUtils<DBGbCadreAwardPunishList> gbAwardDaoUtils;
    private CommonDaoUtils<DBGbCadreDeptListBean> gbDeptDaoUtils;
    private CommonDaoUtils<DBGbCadreFamilyMemberList> gbFamilyDaoUtils;
    private CommonDaoUtils<DBGbCadreHistoryPositionListBean> gbHistoryDaoUtils;
    private CommonDaoUtils<DBGbCadreNowPositionListBean> gbNowDaoUtils;
    private CommonDaoUtils<DBGbCadreRankListBean> gbRankDaoUtils;
    private CommonDaoUtils<DBGbCadreResumeListBean> gbResumeDaoUtils;
    private CommonDaoUtils<DBGbCadreTrainListBean> gbTrainDaoUtils;


    public static DaoUtilsStore getInstance() {
        return instance;
    }

    private DaoUtilsStore() {
        DaoManager mManager = DaoManager.getInstance();

        MeiziDao _MeiziDao = mManager.getDaoSession().getMeiziDao();
        meiziDaoUtils = new CommonDaoUtils(Meizi.class, _MeiziDao);

        DBUserListBeanDao _UserListBeanDao = mManager.getDaoSession().getDBUserListBeanDao();
        userListDaoUtils = new CommonDaoUtils(DBUserListBean.class, _UserListBeanDao);


        DBZcfgBeanDao _DBZcfgBeanDao = mManager.getDaoSession().getDBZcfgBeanDao();
        zcfgDaoUtils = new CommonDaoUtils(DBZcfgBean.class, _DBZcfgBeanDao);


        DBBmBeanDao _DBBmBeanDao = mManager.getDaoSession().getDBBmBeanDao();
        bmDaoUtils = new CommonDaoUtils(DBBmBean.class, _DBBmBeanDao);
        DBBmExplainBeanDao _DBBmExplainBeanDao = mManager.getDaoSession().getDBBmExplainBeanDao();
        bmExplainDaoUtils = new CommonDaoUtils(DBBmExplainBean.class, _DBBmExplainBeanDao);


        DBGbBeanDao _DBGbBeanDao = mManager.getDaoSession().getDBGbBeanDao();
        gbDaoUtils = new CommonDaoUtils(DBGbBean.class, _DBGbBeanDao);
        DBGbCadreAwardPunishListDao _DBGbCadreAwardPunishListDao = mManager.getDaoSession().getDBGbCadreAwardPunishListDao();
        gbAwardDaoUtils = new CommonDaoUtils(DBGbCadreAwardPunishList.class, _DBGbCadreAwardPunishListDao);
        DBGbCadreDeptListBeanDao _DBGbCadreDeptListBeanDao = mManager.getDaoSession().getDBGbCadreDeptListBeanDao();
        gbDeptDaoUtils = new CommonDaoUtils(DBGbCadreDeptListBean.class, _DBGbCadreDeptListBeanDao);
        DBGbCadreFamilyMemberListDao _DBGbCadreFamilyMemberListDao = mManager.getDaoSession().getDBGbCadreFamilyMemberListDao();
        gbFamilyDaoUtils = new CommonDaoUtils(DBGbCadreFamilyMemberList.class, _DBGbCadreFamilyMemberListDao);
        DBGbCadreHistoryPositionListBeanDao _DBGbCadreHistoryPositionListBeanDao = mManager.getDaoSession().getDBGbCadreHistoryPositionListBeanDao();
        gbHistoryDaoUtils = new CommonDaoUtils(DBGbCadreHistoryPositionListBean.class, _DBGbCadreHistoryPositionListBeanDao);
        DBGbCadreNowPositionListBeanDao _DBGbCadreNowPositionListBeanDao = mManager.getDaoSession().getDBGbCadreNowPositionListBeanDao();
        gbNowDaoUtils = new CommonDaoUtils(DBGbCadreNowPositionListBean.class, _DBGbCadreNowPositionListBeanDao);
        DBGbCadreRankListBeanDao _DBGbCadreRankListBeanDao = mManager.getDaoSession().getDBGbCadreRankListBeanDao();
        gbRankDaoUtils = new CommonDaoUtils(DBGbCadreRankListBean.class, _DBGbCadreRankListBeanDao);
        DBGbCadreResumeListBeanDao _DBGbCadreResumeListBeanDao = mManager.getDaoSession().getDBGbCadreResumeListBeanDao();
        gbResumeDaoUtils = new CommonDaoUtils(DBGbCadreResumeListBean.class, _DBGbCadreResumeListBeanDao);
        DBGbCadreTrainListBeanDao _DBGbCadreTrainListBeanDao = mManager.getDaoSession().getDBGbCadreTrainListBeanDao();
        gbTrainDaoUtils = new CommonDaoUtils(DBGbCadreTrainListBean.class, _DBGbCadreTrainListBeanDao);
    }

    public CommonDaoUtils<Meizi> getMeiziDaoUtils() {
        return meiziDaoUtils;
    }

    public CommonDaoUtils<DBUserListBean> getUserListDaoUtils() {
        return userListDaoUtils;
    }

    public CommonDaoUtils<DBZcfgBean> getZcfgDaoUtils() {
        return zcfgDaoUtils;
    }

    public CommonDaoUtils<DBBmBean> getBmDaoUtils() {
        return bmDaoUtils;
    }

    public CommonDaoUtils<DBBmExplainBean> getBmExplainDaoUtils() {
        return bmExplainDaoUtils;
    }

    public CommonDaoUtils<DBGbBean> getGbDaoUtils() {
        return gbDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreAwardPunishList> getGbAwardDaoUtils() {
        return gbAwardDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreDeptListBean> getGbDeptDaoUtils() {
        return gbDeptDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreFamilyMemberList> getGbFamilyDaoUtils() {
        return gbFamilyDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreHistoryPositionListBean> getGbHistoryDaoUtils() {
        return gbHistoryDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreNowPositionListBean> getGbNowDaoUtils() {
        return gbNowDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreRankListBean> getGbRankDaoUtils() {
        return gbRankDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreResumeListBean> getGbResumeDaoUtils() {
        return gbResumeDaoUtils;
    }

    public CommonDaoUtils<DBGbCadreTrainListBean> getGbTrainDaoUtils() {
        return gbTrainDaoUtils;
    }
}