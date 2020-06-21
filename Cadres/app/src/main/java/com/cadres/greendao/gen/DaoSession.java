package com.cadres.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.cadres.beanDB.DBUserListBean;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.beanDB.Meizi;

import com.cadres.greendao.gen.DBUserListBeanDao;
import com.cadres.greendao.gen.DBZcfgBeanDao;
import com.cadres.greendao.gen.MeiziDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dBUserListBeanDaoConfig;
    private final DaoConfig dBZcfgBeanDaoConfig;
    private final DaoConfig meiziDaoConfig;

    private final DBUserListBeanDao dBUserListBeanDao;
    private final DBZcfgBeanDao dBZcfgBeanDao;
    private final MeiziDao meiziDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dBUserListBeanDaoConfig = daoConfigMap.get(DBUserListBeanDao.class).clone();
        dBUserListBeanDaoConfig.initIdentityScope(type);

        dBZcfgBeanDaoConfig = daoConfigMap.get(DBZcfgBeanDao.class).clone();
        dBZcfgBeanDaoConfig.initIdentityScope(type);

        meiziDaoConfig = daoConfigMap.get(MeiziDao.class).clone();
        meiziDaoConfig.initIdentityScope(type);

        dBUserListBeanDao = new DBUserListBeanDao(dBUserListBeanDaoConfig, this);
        dBZcfgBeanDao = new DBZcfgBeanDao(dBZcfgBeanDaoConfig, this);
        meiziDao = new MeiziDao(meiziDaoConfig, this);

        registerDao(DBUserListBean.class, dBUserListBeanDao);
        registerDao(DBZcfgBean.class, dBZcfgBeanDao);
        registerDao(Meizi.class, meiziDao);
    }
    
    public void clear() {
        dBUserListBeanDaoConfig.clearIdentityScope();
        dBZcfgBeanDaoConfig.clearIdentityScope();
        meiziDaoConfig.clearIdentityScope();
    }

    public DBUserListBeanDao getDBUserListBeanDao() {
        return dBUserListBeanDao;
    }

    public DBZcfgBeanDao getDBZcfgBeanDao() {
        return dBZcfgBeanDao;
    }

    public MeiziDao getMeiziDao() {
        return meiziDao;
    }

}
