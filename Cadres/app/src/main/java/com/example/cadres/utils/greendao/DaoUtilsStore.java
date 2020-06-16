package com.example.cadres.utils.greendao;


import com.cadres.greendao.gen.MeiziDao;
import com.example.cadres.bean.allData.Meizi;

/**
 * 存放DaoUtils
 */
public class DaoUtilsStore
{
    private volatile static DaoUtilsStore instance = new DaoUtilsStore();
    private CommonDaoUtils<Meizi> meiziDaoUtils;

    public static DaoUtilsStore getInstance()
    {
        return instance;
    }

    private DaoUtilsStore()
    {
        DaoManager mManager = DaoManager.getInstance();
        MeiziDao _MeiziDao = mManager.getDaoSession().getMeiziDao();
        meiziDaoUtils = new CommonDaoUtils(Meizi.class, _MeiziDao);

    }

    public CommonDaoUtils<Meizi> getMeiziDaoUtils()
    {
        return meiziDaoUtils;
    }

}