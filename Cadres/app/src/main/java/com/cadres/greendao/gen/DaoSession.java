package com.cadres.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

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
import com.example.cadres.beanDB.DbZcfgNoticeTypeBean;
import com.example.cadres.beanDB.Meizi;

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
import com.cadres.greendao.gen.DbZcfgNoticeTypeBeanDao;
import com.cadres.greendao.gen.MeiziDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dBBmBeanDaoConfig;
    private final DaoConfig dBBmExplainBeanDaoConfig;
    private final DaoConfig dBBmFinanceTypeBeanDaoConfig;
    private final DaoConfig dBBmOrgTypeBeanDaoConfig;
    private final DaoConfig dBGbBeanDaoConfig;
    private final DaoConfig dBGbCadreAwardPunishListDaoConfig;
    private final DaoConfig dBGbCadreDeptListBeanDaoConfig;
    private final DaoConfig dBGbCadreFamilyMemberListDaoConfig;
    private final DaoConfig dBGbCadreHistoryPositionListBeanDaoConfig;
    private final DaoConfig dBGbCadreNowPositionListBeanDaoConfig;
    private final DaoConfig dBGbCadreRankListBeanDaoConfig;
    private final DaoConfig dBGbCadreResumeListBeanDaoConfig;
    private final DaoConfig dBGbCadreTrainListBeanDaoConfig;
    private final DaoConfig dBSearchBeanDaoConfig;
    private final DaoConfig dBTyHjDaoConfig;
    private final DaoConfig dBTyHjListDaoConfig;
    private final DaoConfig dBTyZsNqgbDaoConfig;
    private final DaoConfig dBUserListBeanDaoConfig;
    private final DaoConfig dBYjjcCadreDaoConfig;
    private final DaoConfig dBYjjcMeetingDaoConfig;
    private final DaoConfig dBZcfgBeanDaoConfig;
    private final DaoConfig dbTyJgDaoConfig;
    private final DaoConfig dbTyZsDaoConfig;
    private final DaoConfig dbYjjcBeanDaoConfig;
    private final DaoConfig dbZcfgNoticeTypeBeanDaoConfig;
    private final DaoConfig meiziDaoConfig;

    private final DBBmBeanDao dBBmBeanDao;
    private final DBBmExplainBeanDao dBBmExplainBeanDao;
    private final DBBmFinanceTypeBeanDao dBBmFinanceTypeBeanDao;
    private final DBBmOrgTypeBeanDao dBBmOrgTypeBeanDao;
    private final DBGbBeanDao dBGbBeanDao;
    private final DBGbCadreAwardPunishListDao dBGbCadreAwardPunishListDao;
    private final DBGbCadreDeptListBeanDao dBGbCadreDeptListBeanDao;
    private final DBGbCadreFamilyMemberListDao dBGbCadreFamilyMemberListDao;
    private final DBGbCadreHistoryPositionListBeanDao dBGbCadreHistoryPositionListBeanDao;
    private final DBGbCadreNowPositionListBeanDao dBGbCadreNowPositionListBeanDao;
    private final DBGbCadreRankListBeanDao dBGbCadreRankListBeanDao;
    private final DBGbCadreResumeListBeanDao dBGbCadreResumeListBeanDao;
    private final DBGbCadreTrainListBeanDao dBGbCadreTrainListBeanDao;
    private final DBSearchBeanDao dBSearchBeanDao;
    private final DBTyHjDao dBTyHjDao;
    private final DBTyHjListDao dBTyHjListDao;
    private final DBTyZsNqgbDao dBTyZsNqgbDao;
    private final DBUserListBeanDao dBUserListBeanDao;
    private final DBYjjcCadreDao dBYjjcCadreDao;
    private final DBYjjcMeetingDao dBYjjcMeetingDao;
    private final DBZcfgBeanDao dBZcfgBeanDao;
    private final DbTyJgDao dbTyJgDao;
    private final DbTyZsDao dbTyZsDao;
    private final DbYjjcBeanDao dbYjjcBeanDao;
    private final DbZcfgNoticeTypeBeanDao dbZcfgNoticeTypeBeanDao;
    private final MeiziDao meiziDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dBBmBeanDaoConfig = daoConfigMap.get(DBBmBeanDao.class).clone();
        dBBmBeanDaoConfig.initIdentityScope(type);

        dBBmExplainBeanDaoConfig = daoConfigMap.get(DBBmExplainBeanDao.class).clone();
        dBBmExplainBeanDaoConfig.initIdentityScope(type);

        dBBmFinanceTypeBeanDaoConfig = daoConfigMap.get(DBBmFinanceTypeBeanDao.class).clone();
        dBBmFinanceTypeBeanDaoConfig.initIdentityScope(type);

        dBBmOrgTypeBeanDaoConfig = daoConfigMap.get(DBBmOrgTypeBeanDao.class).clone();
        dBBmOrgTypeBeanDaoConfig.initIdentityScope(type);

        dBGbBeanDaoConfig = daoConfigMap.get(DBGbBeanDao.class).clone();
        dBGbBeanDaoConfig.initIdentityScope(type);

        dBGbCadreAwardPunishListDaoConfig = daoConfigMap.get(DBGbCadreAwardPunishListDao.class).clone();
        dBGbCadreAwardPunishListDaoConfig.initIdentityScope(type);

        dBGbCadreDeptListBeanDaoConfig = daoConfigMap.get(DBGbCadreDeptListBeanDao.class).clone();
        dBGbCadreDeptListBeanDaoConfig.initIdentityScope(type);

        dBGbCadreFamilyMemberListDaoConfig = daoConfigMap.get(DBGbCadreFamilyMemberListDao.class).clone();
        dBGbCadreFamilyMemberListDaoConfig.initIdentityScope(type);

        dBGbCadreHistoryPositionListBeanDaoConfig = daoConfigMap.get(DBGbCadreHistoryPositionListBeanDao.class).clone();
        dBGbCadreHistoryPositionListBeanDaoConfig.initIdentityScope(type);

        dBGbCadreNowPositionListBeanDaoConfig = daoConfigMap.get(DBGbCadreNowPositionListBeanDao.class).clone();
        dBGbCadreNowPositionListBeanDaoConfig.initIdentityScope(type);

        dBGbCadreRankListBeanDaoConfig = daoConfigMap.get(DBGbCadreRankListBeanDao.class).clone();
        dBGbCadreRankListBeanDaoConfig.initIdentityScope(type);

        dBGbCadreResumeListBeanDaoConfig = daoConfigMap.get(DBGbCadreResumeListBeanDao.class).clone();
        dBGbCadreResumeListBeanDaoConfig.initIdentityScope(type);

        dBGbCadreTrainListBeanDaoConfig = daoConfigMap.get(DBGbCadreTrainListBeanDao.class).clone();
        dBGbCadreTrainListBeanDaoConfig.initIdentityScope(type);

        dBSearchBeanDaoConfig = daoConfigMap.get(DBSearchBeanDao.class).clone();
        dBSearchBeanDaoConfig.initIdentityScope(type);

        dBTyHjDaoConfig = daoConfigMap.get(DBTyHjDao.class).clone();
        dBTyHjDaoConfig.initIdentityScope(type);

        dBTyHjListDaoConfig = daoConfigMap.get(DBTyHjListDao.class).clone();
        dBTyHjListDaoConfig.initIdentityScope(type);

        dBTyZsNqgbDaoConfig = daoConfigMap.get(DBTyZsNqgbDao.class).clone();
        dBTyZsNqgbDaoConfig.initIdentityScope(type);

        dBUserListBeanDaoConfig = daoConfigMap.get(DBUserListBeanDao.class).clone();
        dBUserListBeanDaoConfig.initIdentityScope(type);

        dBYjjcCadreDaoConfig = daoConfigMap.get(DBYjjcCadreDao.class).clone();
        dBYjjcCadreDaoConfig.initIdentityScope(type);

        dBYjjcMeetingDaoConfig = daoConfigMap.get(DBYjjcMeetingDao.class).clone();
        dBYjjcMeetingDaoConfig.initIdentityScope(type);

        dBZcfgBeanDaoConfig = daoConfigMap.get(DBZcfgBeanDao.class).clone();
        dBZcfgBeanDaoConfig.initIdentityScope(type);

        dbTyJgDaoConfig = daoConfigMap.get(DbTyJgDao.class).clone();
        dbTyJgDaoConfig.initIdentityScope(type);

        dbTyZsDaoConfig = daoConfigMap.get(DbTyZsDao.class).clone();
        dbTyZsDaoConfig.initIdentityScope(type);

        dbYjjcBeanDaoConfig = daoConfigMap.get(DbYjjcBeanDao.class).clone();
        dbYjjcBeanDaoConfig.initIdentityScope(type);

        dbZcfgNoticeTypeBeanDaoConfig = daoConfigMap.get(DbZcfgNoticeTypeBeanDao.class).clone();
        dbZcfgNoticeTypeBeanDaoConfig.initIdentityScope(type);

        meiziDaoConfig = daoConfigMap.get(MeiziDao.class).clone();
        meiziDaoConfig.initIdentityScope(type);

        dBBmBeanDao = new DBBmBeanDao(dBBmBeanDaoConfig, this);
        dBBmExplainBeanDao = new DBBmExplainBeanDao(dBBmExplainBeanDaoConfig, this);
        dBBmFinanceTypeBeanDao = new DBBmFinanceTypeBeanDao(dBBmFinanceTypeBeanDaoConfig, this);
        dBBmOrgTypeBeanDao = new DBBmOrgTypeBeanDao(dBBmOrgTypeBeanDaoConfig, this);
        dBGbBeanDao = new DBGbBeanDao(dBGbBeanDaoConfig, this);
        dBGbCadreAwardPunishListDao = new DBGbCadreAwardPunishListDao(dBGbCadreAwardPunishListDaoConfig, this);
        dBGbCadreDeptListBeanDao = new DBGbCadreDeptListBeanDao(dBGbCadreDeptListBeanDaoConfig, this);
        dBGbCadreFamilyMemberListDao = new DBGbCadreFamilyMemberListDao(dBGbCadreFamilyMemberListDaoConfig, this);
        dBGbCadreHistoryPositionListBeanDao = new DBGbCadreHistoryPositionListBeanDao(dBGbCadreHistoryPositionListBeanDaoConfig, this);
        dBGbCadreNowPositionListBeanDao = new DBGbCadreNowPositionListBeanDao(dBGbCadreNowPositionListBeanDaoConfig, this);
        dBGbCadreRankListBeanDao = new DBGbCadreRankListBeanDao(dBGbCadreRankListBeanDaoConfig, this);
        dBGbCadreResumeListBeanDao = new DBGbCadreResumeListBeanDao(dBGbCadreResumeListBeanDaoConfig, this);
        dBGbCadreTrainListBeanDao = new DBGbCadreTrainListBeanDao(dBGbCadreTrainListBeanDaoConfig, this);
        dBSearchBeanDao = new DBSearchBeanDao(dBSearchBeanDaoConfig, this);
        dBTyHjDao = new DBTyHjDao(dBTyHjDaoConfig, this);
        dBTyHjListDao = new DBTyHjListDao(dBTyHjListDaoConfig, this);
        dBTyZsNqgbDao = new DBTyZsNqgbDao(dBTyZsNqgbDaoConfig, this);
        dBUserListBeanDao = new DBUserListBeanDao(dBUserListBeanDaoConfig, this);
        dBYjjcCadreDao = new DBYjjcCadreDao(dBYjjcCadreDaoConfig, this);
        dBYjjcMeetingDao = new DBYjjcMeetingDao(dBYjjcMeetingDaoConfig, this);
        dBZcfgBeanDao = new DBZcfgBeanDao(dBZcfgBeanDaoConfig, this);
        dbTyJgDao = new DbTyJgDao(dbTyJgDaoConfig, this);
        dbTyZsDao = new DbTyZsDao(dbTyZsDaoConfig, this);
        dbYjjcBeanDao = new DbYjjcBeanDao(dbYjjcBeanDaoConfig, this);
        dbZcfgNoticeTypeBeanDao = new DbZcfgNoticeTypeBeanDao(dbZcfgNoticeTypeBeanDaoConfig, this);
        meiziDao = new MeiziDao(meiziDaoConfig, this);

        registerDao(DBBmBean.class, dBBmBeanDao);
        registerDao(DBBmExplainBean.class, dBBmExplainBeanDao);
        registerDao(DBBmFinanceTypeBean.class, dBBmFinanceTypeBeanDao);
        registerDao(DBBmOrgTypeBean.class, dBBmOrgTypeBeanDao);
        registerDao(DBGbBean.class, dBGbBeanDao);
        registerDao(DBGbCadreAwardPunishList.class, dBGbCadreAwardPunishListDao);
        registerDao(DBGbCadreDeptListBean.class, dBGbCadreDeptListBeanDao);
        registerDao(DBGbCadreFamilyMemberList.class, dBGbCadreFamilyMemberListDao);
        registerDao(DBGbCadreHistoryPositionListBean.class, dBGbCadreHistoryPositionListBeanDao);
        registerDao(DBGbCadreNowPositionListBean.class, dBGbCadreNowPositionListBeanDao);
        registerDao(DBGbCadreRankListBean.class, dBGbCadreRankListBeanDao);
        registerDao(DBGbCadreResumeListBean.class, dBGbCadreResumeListBeanDao);
        registerDao(DBGbCadreTrainListBean.class, dBGbCadreTrainListBeanDao);
        registerDao(DBSearchBean.class, dBSearchBeanDao);
        registerDao(DBTyHj.class, dBTyHjDao);
        registerDao(DBTyHjList.class, dBTyHjListDao);
        registerDao(DBTyZsNqgb.class, dBTyZsNqgbDao);
        registerDao(DBUserListBean.class, dBUserListBeanDao);
        registerDao(DBYjjcCadre.class, dBYjjcCadreDao);
        registerDao(DBYjjcMeeting.class, dBYjjcMeetingDao);
        registerDao(DBZcfgBean.class, dBZcfgBeanDao);
        registerDao(DbTyJg.class, dbTyJgDao);
        registerDao(DbTyZs.class, dbTyZsDao);
        registerDao(DbYjjcBean.class, dbYjjcBeanDao);
        registerDao(DbZcfgNoticeTypeBean.class, dbZcfgNoticeTypeBeanDao);
        registerDao(Meizi.class, meiziDao);
    }
    
    public void clear() {
        dBBmBeanDaoConfig.clearIdentityScope();
        dBBmExplainBeanDaoConfig.clearIdentityScope();
        dBBmFinanceTypeBeanDaoConfig.clearIdentityScope();
        dBBmOrgTypeBeanDaoConfig.clearIdentityScope();
        dBGbBeanDaoConfig.clearIdentityScope();
        dBGbCadreAwardPunishListDaoConfig.clearIdentityScope();
        dBGbCadreDeptListBeanDaoConfig.clearIdentityScope();
        dBGbCadreFamilyMemberListDaoConfig.clearIdentityScope();
        dBGbCadreHistoryPositionListBeanDaoConfig.clearIdentityScope();
        dBGbCadreNowPositionListBeanDaoConfig.clearIdentityScope();
        dBGbCadreRankListBeanDaoConfig.clearIdentityScope();
        dBGbCadreResumeListBeanDaoConfig.clearIdentityScope();
        dBGbCadreTrainListBeanDaoConfig.clearIdentityScope();
        dBSearchBeanDaoConfig.clearIdentityScope();
        dBTyHjDaoConfig.clearIdentityScope();
        dBTyHjListDaoConfig.clearIdentityScope();
        dBTyZsNqgbDaoConfig.clearIdentityScope();
        dBUserListBeanDaoConfig.clearIdentityScope();
        dBYjjcCadreDaoConfig.clearIdentityScope();
        dBYjjcMeetingDaoConfig.clearIdentityScope();
        dBZcfgBeanDaoConfig.clearIdentityScope();
        dbTyJgDaoConfig.clearIdentityScope();
        dbTyZsDaoConfig.clearIdentityScope();
        dbYjjcBeanDaoConfig.clearIdentityScope();
        dbZcfgNoticeTypeBeanDaoConfig.clearIdentityScope();
        meiziDaoConfig.clearIdentityScope();
    }

    public DBBmBeanDao getDBBmBeanDao() {
        return dBBmBeanDao;
    }

    public DBBmExplainBeanDao getDBBmExplainBeanDao() {
        return dBBmExplainBeanDao;
    }

    public DBBmFinanceTypeBeanDao getDBBmFinanceTypeBeanDao() {
        return dBBmFinanceTypeBeanDao;
    }

    public DBBmOrgTypeBeanDao getDBBmOrgTypeBeanDao() {
        return dBBmOrgTypeBeanDao;
    }

    public DBGbBeanDao getDBGbBeanDao() {
        return dBGbBeanDao;
    }

    public DBGbCadreAwardPunishListDao getDBGbCadreAwardPunishListDao() {
        return dBGbCadreAwardPunishListDao;
    }

    public DBGbCadreDeptListBeanDao getDBGbCadreDeptListBeanDao() {
        return dBGbCadreDeptListBeanDao;
    }

    public DBGbCadreFamilyMemberListDao getDBGbCadreFamilyMemberListDao() {
        return dBGbCadreFamilyMemberListDao;
    }

    public DBGbCadreHistoryPositionListBeanDao getDBGbCadreHistoryPositionListBeanDao() {
        return dBGbCadreHistoryPositionListBeanDao;
    }

    public DBGbCadreNowPositionListBeanDao getDBGbCadreNowPositionListBeanDao() {
        return dBGbCadreNowPositionListBeanDao;
    }

    public DBGbCadreRankListBeanDao getDBGbCadreRankListBeanDao() {
        return dBGbCadreRankListBeanDao;
    }

    public DBGbCadreResumeListBeanDao getDBGbCadreResumeListBeanDao() {
        return dBGbCadreResumeListBeanDao;
    }

    public DBGbCadreTrainListBeanDao getDBGbCadreTrainListBeanDao() {
        return dBGbCadreTrainListBeanDao;
    }

    public DBSearchBeanDao getDBSearchBeanDao() {
        return dBSearchBeanDao;
    }

    public DBTyHjDao getDBTyHjDao() {
        return dBTyHjDao;
    }

    public DBTyHjListDao getDBTyHjListDao() {
        return dBTyHjListDao;
    }

    public DBTyZsNqgbDao getDBTyZsNqgbDao() {
        return dBTyZsNqgbDao;
    }

    public DBUserListBeanDao getDBUserListBeanDao() {
        return dBUserListBeanDao;
    }

    public DBYjjcCadreDao getDBYjjcCadreDao() {
        return dBYjjcCadreDao;
    }

    public DBYjjcMeetingDao getDBYjjcMeetingDao() {
        return dBYjjcMeetingDao;
    }

    public DBZcfgBeanDao getDBZcfgBeanDao() {
        return dBZcfgBeanDao;
    }

    public DbTyJgDao getDbTyJgDao() {
        return dbTyJgDao;
    }

    public DbTyZsDao getDbTyZsDao() {
        return dbTyZsDao;
    }

    public DbYjjcBeanDao getDbYjjcBeanDao() {
        return dbYjjcBeanDao;
    }

    public DbZcfgNoticeTypeBeanDao getDbZcfgNoticeTypeBeanDao() {
        return dbZcfgNoticeTypeBeanDao;
    }

    public MeiziDao getMeiziDao() {
        return meiziDao;
    }

}
