package com.example.cadres.utils.greendao;


import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DBBmExplainBeanDao;
import com.cadres.greendao.gen.DBBmFinanceTypeBeanDao;
import com.cadres.greendao.gen.DBBmOrgTypeBeanDao;
import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreAwardPunishListDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.cadres.greendao.gen.DBGbCadreFamilyMemberListDao;
import com.cadres.greendao.gen.DBGbCadreHistoryPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreNowPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreRankListBeanDao;
import com.cadres.greendao.gen.DBGbCadreResumeListBeanDao;
import com.cadres.greendao.gen.DBGbCadreTrainListBeanDao;
import com.cadres.greendao.gen.DBGwyDWLBDao;
import com.cadres.greendao.gen.DBGwyFGDJDao;
import com.cadres.greendao.gen.DBGwyFGZLDJDao;
import com.cadres.greendao.gen.DBGwyJWJSDao;
import com.cadres.greendao.gen.DBGwyZHGLDao;
import com.cadres.greendao.gen.DBGwyZQDao;
import com.cadres.greendao.gen.DBSearchBeanDao;
import com.cadres.greendao.gen.DBTyHjDao;
import com.cadres.greendao.gen.DBTyHjListDao;
import com.cadres.greendao.gen.DBTyZsNqgbDao;
import com.cadres.greendao.gen.DBUserListBeanDao;
import com.cadres.greendao.gen.DBYjjcCadreDao;
import com.cadres.greendao.gen.DBYjjcMeetingDao;
import com.cadres.greendao.gen.DBZcfgBeanDao;
import com.cadres.greendao.gen.DbTyJgDao;
import com.cadres.greendao.gen.DbTyZsDao;
import com.cadres.greendao.gen.DbYjjcBeanDao;
import com.cadres.greendao.gen.DbYjjcCadreGroupingDao;
import com.cadres.greendao.gen.DbZcfgNoticeTypeBeanDao;
import com.cadres.greendao.gen.MeiziDao;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
import com.example.cadres.beanDB.DBBmFinanceTypeBean;
import com.example.cadres.beanDB.DBBmOrgTypeBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreAwardPunishList;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreFamilyMemberList;
import com.example.cadres.beanDB.DBGbCadreHistoryPositionListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.beanDB.DBGbCadreRankListBean;
import com.example.cadres.beanDB.DBGbCadreResumeListBean;
import com.example.cadres.beanDB.DBGbCadreTrainListBean;
import com.example.cadres.beanDB.DBGwyDWLB;
import com.example.cadres.beanDB.DBGwyFGDJ;
import com.example.cadres.beanDB.DBGwyFGZLDJ;
import com.example.cadres.beanDB.DBGwyJWJS;
import com.example.cadres.beanDB.DBGwyZHGL;
import com.example.cadres.beanDB.DBGwyZQ;
import com.example.cadres.beanDB.DBSearchBean;
import com.example.cadres.beanDB.DBTyHj;
import com.example.cadres.beanDB.DBTyHjList;
import com.example.cadres.beanDB.DBTyZsNqgb;
import com.example.cadres.beanDB.DBUserListBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.beanDB.DbTyJg;
import com.example.cadres.beanDB.DbTyZs;
import com.example.cadres.beanDB.DbYjjcBean;
import com.example.cadres.beanDB.DbYjjcCadreGrouping;
import com.example.cadres.beanDB.DbZcfgNoticeTypeBean;
import com.example.cadres.beanDB.Meizi;

/**
 * 存放DaoUtils
 */
public class DaoUtilsStore {
    private volatile static DaoUtilsStore instance = new DaoUtilsStore();
    private CommonDaoUtils<Meizi> meiziDaoUtils;

    private CommonDaoUtils<DBUserListBean> userListDaoUtils;

    private CommonDaoUtils<DBZcfgBean> zcfgDaoUtils;
    private CommonDaoUtils<DbZcfgNoticeTypeBean> zcfgNoticeDaoUtils;

    private CommonDaoUtils<DBBmBean> bmDaoUtils;
    private CommonDaoUtils<DBBmExplainBean> bmExplainDaoUtils;
    private CommonDaoUtils<DBBmOrgTypeBean> bmOrgDaoUtils;
    private CommonDaoUtils<DBBmFinanceTypeBean> bmFinanceDaoUtils;

    private CommonDaoUtils<DBGbBean> gbDaoUtils;
    private CommonDaoUtils<DBGbCadreAwardPunishList> gbAwardDaoUtils;
    private CommonDaoUtils<DBGbCadreDeptListBean> gbDeptDaoUtils;
    private CommonDaoUtils<DBGbCadreFamilyMemberList> gbFamilyDaoUtils;
    private CommonDaoUtils<DBGbCadreHistoryPositionListBean> gbHistoryDaoUtils;
    private CommonDaoUtils<DBGbCadreNowPositionListBean> gbNowDaoUtils;
    private CommonDaoUtils<DBGbCadreRankListBean> gbRankDaoUtils;
    private CommonDaoUtils<DBGbCadreResumeListBean> gbResumeDaoUtils;
    private CommonDaoUtils<DBGbCadreTrainListBean> gbTrainDaoUtils;


    private CommonDaoUtils<DbYjjcBean> yjjcDaoUtils;
    private CommonDaoUtils<DBYjjcCadre> yjjcCadreDaoUtils;
    private CommonDaoUtils<DBYjjcMeeting> yjjcMeetingDaoUtils;
    private CommonDaoUtils<DbYjjcCadreGrouping> yjjcCadreGroupingDaoUtils;

    private CommonDaoUtils<DBTyHj> tyHjDaoUtils;
    private CommonDaoUtils<DbTyJg> tyJgDaoUtils;
    private CommonDaoUtils<DbTyZs> tyZsDaoUtils;
    private CommonDaoUtils<DBTyZsNqgb> tyZsQngbDaoUtils;
    private CommonDaoUtils<DBTyHjList> tyHjListDaoUtils;

    private CommonDaoUtils<DBSearchBean> saerchDaoUtils;

    private CommonDaoUtils<DBGwyDWLB> gwyDWLBDaoUtils;
    private CommonDaoUtils<DBGwyFGDJ> gwyFGDJDaoUtils;
    private CommonDaoUtils<DBGwyFGZLDJ> gwyFGZLDJDaoUtils;
    private CommonDaoUtils<DBGwyJWJS> gwyJWJSDaoUtils;
    private CommonDaoUtils<DBGwyZHGL> gwyZHGLDaoUtils;
    private CommonDaoUtils<DBGwyZQ> gwyZQDaoUtils;

    public static DaoUtilsStore getInstance() {
        return instance;
    }

    private DaoUtilsStore() {
        DaoManager mManager = DaoManager.getInstance();

        DBGwyDWLBDao _DBGwyDWLBDao = mManager.getDaoSession().getDBGwyDWLBDao();
        gwyDWLBDaoUtils = new CommonDaoUtils(DBGwyDWLB.class, _DBGwyDWLBDao);
        DBGwyFGDJDao _DBGwyFGDJDao = mManager.getDaoSession().getDBGwyFGDJDao();
        gwyFGDJDaoUtils = new CommonDaoUtils(DBGwyFGDJ.class, _DBGwyFGDJDao);
        DBGwyFGZLDJDao _DBGwyFGZLDJDao = mManager.getDaoSession().getDBGwyFGZLDJDao();
        gwyFGZLDJDaoUtils = new CommonDaoUtils(DBGwyFGZLDJ.class, _DBGwyFGZLDJDao);
        DBGwyJWJSDao _DBGwyJWJSDao = mManager.getDaoSession().getDBGwyJWJSDao();
        gwyJWJSDaoUtils = new CommonDaoUtils(DBGwyJWJS.class, _DBGwyJWJSDao);
        DBGwyZHGLDao _DBGwyZHGLDao = mManager.getDaoSession().getDBGwyZHGLDao();
        gwyZHGLDaoUtils = new CommonDaoUtils(DBGwyZHGL.class, _DBGwyZHGLDao);
        DBGwyZQDao _DBGwyZQDao = mManager.getDaoSession().getDBGwyZQDao();
        gwyZQDaoUtils = new CommonDaoUtils(DBGwyZQ.class, _DBGwyZQDao);

        DBSearchBeanDao _DBSearchBeanDao = mManager.getDaoSession().getDBSearchBeanDao();
        saerchDaoUtils = new CommonDaoUtils(DBSearchBean.class, _DBSearchBeanDao);

        DBTyHjDao _DBTyHjDao = mManager.getDaoSession().getDBTyHjDao();
        tyHjDaoUtils = new CommonDaoUtils(DBTyHj.class, _DBTyHjDao);
        DBTyHjListDao _DBTyHjListDao = mManager.getDaoSession().getDBTyHjListDao();
        tyHjListDaoUtils = new CommonDaoUtils(DBTyHjList.class, _DBTyHjListDao);
        DbTyJgDao _DbTyJgDao = mManager.getDaoSession().getDbTyJgDao();
        tyJgDaoUtils = new CommonDaoUtils(DbTyJg.class, _DbTyJgDao);
        DbTyZsDao _DbTyZsDao = mManager.getDaoSession().getDbTyZsDao();
        tyZsDaoUtils = new CommonDaoUtils(DbTyZs.class, _DbTyZsDao);
        DBTyZsNqgbDao _DBTyZsNqgbDao = mManager.getDaoSession().getDBTyZsNqgbDao();
        tyZsQngbDaoUtils = new CommonDaoUtils(DBTyZsNqgb.class, _DBTyZsNqgbDao);

        MeiziDao _MeiziDao = mManager.getDaoSession().getMeiziDao();
        meiziDaoUtils = new CommonDaoUtils(Meizi.class, _MeiziDao);

        DBUserListBeanDao _UserListBeanDao = mManager.getDaoSession().getDBUserListBeanDao();
        userListDaoUtils = new CommonDaoUtils(DBUserListBean.class, _UserListBeanDao);


        DBZcfgBeanDao _DBZcfgBeanDao = mManager.getDaoSession().getDBZcfgBeanDao();
        zcfgDaoUtils = new CommonDaoUtils(DBZcfgBean.class, _DBZcfgBeanDao);
        DbZcfgNoticeTypeBeanDao _DbZcfgNoticeTypeBeanDao = mManager.getDaoSession().getDbZcfgNoticeTypeBeanDao();
        zcfgNoticeDaoUtils = new CommonDaoUtils(DbZcfgNoticeTypeBean.class, _DbZcfgNoticeTypeBeanDao);

        DBBmBeanDao _DBBmBeanDao = mManager.getDaoSession().getDBBmBeanDao();
        bmDaoUtils = new CommonDaoUtils(DBBmBean.class, _DBBmBeanDao);
        DBBmExplainBeanDao _DBBmExplainBeanDao = mManager.getDaoSession().getDBBmExplainBeanDao();
        bmExplainDaoUtils = new CommonDaoUtils(DBBmExplainBean.class, _DBBmExplainBeanDao);

        DBBmOrgTypeBeanDao _DBBmOrgTypeBeanDao = mManager.getDaoSession().getDBBmOrgTypeBeanDao();
        bmOrgDaoUtils = new CommonDaoUtils(DBBmOrgTypeBean.class, _DBBmOrgTypeBeanDao);
        DBBmFinanceTypeBeanDao _DBBmFinanceTypeBeanDao = mManager.getDaoSession().getDBBmFinanceTypeBeanDao();
        bmFinanceDaoUtils = new CommonDaoUtils(DBBmFinanceTypeBean.class, _DBBmFinanceTypeBeanDao);

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

        DbYjjcBeanDao _DbYjjcBeanDao = mManager.getDaoSession().getDbYjjcBeanDao();
        yjjcDaoUtils = new CommonDaoUtils(DbYjjcBean.class, _DbYjjcBeanDao);
        DBYjjcCadreDao _DBYjjcCadreDao = mManager.getDaoSession().getDBYjjcCadreDao();
        yjjcCadreDaoUtils = new CommonDaoUtils(DBYjjcCadre.class, _DBYjjcCadreDao);
        DbYjjcCadreGroupingDao _DbYjjcCadreGroupingDao = mManager.getDaoSession().getDbYjjcCadreGroupingDao();
        yjjcCadreGroupingDaoUtils = new CommonDaoUtils(DbYjjcCadreGrouping.class, _DbYjjcCadreGroupingDao);
        DBYjjcMeetingDao _DBYjjcMeetingDao = mManager.getDaoSession().getDBYjjcMeetingDao();
        yjjcMeetingDaoUtils = new CommonDaoUtils(DBYjjcMeeting.class, _DBYjjcMeetingDao);
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

    public CommonDaoUtils<DbZcfgNoticeTypeBean> getZcfgNoticeDaoUtils() {
        return zcfgNoticeDaoUtils;
    }

    public CommonDaoUtils<DBBmBean> getBmDaoUtils() {
        return bmDaoUtils;
    }

    public CommonDaoUtils<DBBmOrgTypeBean> getBmOrgDaoUtils() {
        return bmOrgDaoUtils;
    }

    public CommonDaoUtils<DBBmFinanceTypeBean> getBmFinanceDaoUtils() {
        return bmFinanceDaoUtils;
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

    public CommonDaoUtils<DbYjjcBean> getYjjcDaoUtils() {
        return yjjcDaoUtils;
    }

    public CommonDaoUtils<DBYjjcCadre> getYjjcCadreDaoUtils() {
        return yjjcCadreDaoUtils;
    }

    public CommonDaoUtils<DbYjjcCadreGrouping> getYjjcCadreGroupingDaoUtils() {
        return yjjcCadreGroupingDaoUtils;
    }

    public CommonDaoUtils<DBYjjcMeeting> getYjjcMeetingDaoUtils() {
        return yjjcMeetingDaoUtils;
    }

    public CommonDaoUtils<DBTyHj> getTyHjDaoUtils() {
        return tyHjDaoUtils;
    }

    public CommonDaoUtils<DbTyJg> getTyJgDaoUtils() {
        return tyJgDaoUtils;
    }

    public CommonDaoUtils<DbTyZs> getTyZsDaoUtils() {
        return tyZsDaoUtils;
    }

    public CommonDaoUtils<DBTyZsNqgb> getTyZsQngbDaoUtils() {
        return tyZsQngbDaoUtils;
    }

    public CommonDaoUtils<DBTyHjList> getTyHjListDaoUtils() {
        return tyHjListDaoUtils;
    }

    public CommonDaoUtils<DBSearchBean> getSaerchDaoUtils() {
        return saerchDaoUtils;
    }

    public CommonDaoUtils<DBGwyDWLB> getGwyDWLBDaoUtils() {
        return gwyDWLBDaoUtils;
    }

    public CommonDaoUtils<DBGwyFGDJ> getGwyFGDJDaoUtils() {
        return gwyFGDJDaoUtils;
    }

    public CommonDaoUtils<DBGwyFGZLDJ> getGwyFGZLDJDaoUtils() {
        return gwyFGZLDJDaoUtils;
    }

    public CommonDaoUtils<DBGwyJWJS> getGwyJWJSDaoUtils() {
        return gwyJWJSDaoUtils;
    }

    public CommonDaoUtils<DBGwyZHGL> getGwyZHGLDaoUtils() {
        return gwyZHGLDaoUtils;
    }

    public CommonDaoUtils<DBGwyZQ> getGwyZQDaoUtils() {
        return gwyZQDaoUtils;
    }
}