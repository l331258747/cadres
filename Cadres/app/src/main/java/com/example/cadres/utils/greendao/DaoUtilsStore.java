package com.example.cadres.utils.greendao;


import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DBBmExplainBeanDao;
import com.cadres.greendao.gen.DBUserListBeanDao;
import com.cadres.greendao.gen.DBZcfgBeanDao;
import com.cadres.greendao.gen.MeiziDao;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
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
}