package com.cadres.greendao.gen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.identityscope.IdentityScopeType;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * Master of DAO (schema version 1): knows all DAOs.
 */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(Database db, boolean ifNotExists) {
        DBBmBeanDao.createTable(db, ifNotExists);
        DBBmExplainBeanDao.createTable(db, ifNotExists);
        DBBmFinanceTypeBeanDao.createTable(db, ifNotExists);
        DBBmOrgTypeBeanDao.createTable(db, ifNotExists);
        DBGbBeanDao.createTable(db, ifNotExists);
        DBGbCadreAwardPunishListDao.createTable(db, ifNotExists);
        DBGbCadreDeptListBeanDao.createTable(db, ifNotExists);
        DBGbCadreFamilyMemberListDao.createTable(db, ifNotExists);
        DBGbCadreHistoryPositionListBeanDao.createTable(db, ifNotExists);
        DBGbCadreNowPositionListBeanDao.createTable(db, ifNotExists);
        DBGbCadreRankListBeanDao.createTable(db, ifNotExists);
        DBGbCadreResumeListBeanDao.createTable(db, ifNotExists);
        DBGbCadreTrainListBeanDao.createTable(db, ifNotExists);
        DBTyHjDao.createTable(db, ifNotExists);
        DBTyHjListDao.createTable(db, ifNotExists);
        DBUserListBeanDao.createTable(db, ifNotExists);
        DBYjjcCadreDao.createTable(db, ifNotExists);
        DBYjjcMeetingDao.createTable(db, ifNotExists);
        DBZcfgBeanDao.createTable(db, ifNotExists);
        DbTyJgDao.createTable(db, ifNotExists);
        DbTyZsDao.createTable(db, ifNotExists);
        DbYjjcBeanDao.createTable(db, ifNotExists);
        MeiziDao.createTable(db, ifNotExists);
    }

    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(Database db, boolean ifExists) {
        DBBmBeanDao.dropTable(db, ifExists);
        DBBmExplainBeanDao.dropTable(db, ifExists);
        DBBmFinanceTypeBeanDao.dropTable(db, ifExists);
        DBBmOrgTypeBeanDao.dropTable(db, ifExists);
        DBGbBeanDao.dropTable(db, ifExists);
        DBGbCadreAwardPunishListDao.dropTable(db, ifExists);
        DBGbCadreDeptListBeanDao.dropTable(db, ifExists);
        DBGbCadreFamilyMemberListDao.dropTable(db, ifExists);
        DBGbCadreHistoryPositionListBeanDao.dropTable(db, ifExists);
        DBGbCadreNowPositionListBeanDao.dropTable(db, ifExists);
        DBGbCadreRankListBeanDao.dropTable(db, ifExists);
        DBGbCadreResumeListBeanDao.dropTable(db, ifExists);
        DBGbCadreTrainListBeanDao.dropTable(db, ifExists);
        DBTyHjDao.dropTable(db, ifExists);
        DBTyHjListDao.dropTable(db, ifExists);
        DBUserListBeanDao.dropTable(db, ifExists);
        DBYjjcCadreDao.dropTable(db, ifExists);
        DBYjjcMeetingDao.dropTable(db, ifExists);
        DBZcfgBeanDao.dropTable(db, ifExists);
        DbTyJgDao.dropTable(db, ifExists);
        DbTyZsDao.dropTable(db, ifExists);
        DbYjjcBeanDao.dropTable(db, ifExists);
        MeiziDao.dropTable(db, ifExists);
    }

    /**
     * WARNING: Drops all table on Upgrade! Use only during development.
     * Convenience method using a {@link DevOpenHelper}.
     */
    public static DaoSession newDevSession(Context context, String name) {
        Database db = new DevOpenHelper(context, name).getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

    public DaoMaster(SQLiteDatabase db) {
        this(new StandardDatabase(db));
    }

    public DaoMaster(Database db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(DBBmBeanDao.class);
        registerDaoClass(DBBmExplainBeanDao.class);
        registerDaoClass(DBBmFinanceTypeBeanDao.class);
        registerDaoClass(DBBmOrgTypeBeanDao.class);
        registerDaoClass(DBGbBeanDao.class);
        registerDaoClass(DBGbCadreAwardPunishListDao.class);
        registerDaoClass(DBGbCadreDeptListBeanDao.class);
        registerDaoClass(DBGbCadreFamilyMemberListDao.class);
        registerDaoClass(DBGbCadreHistoryPositionListBeanDao.class);
        registerDaoClass(DBGbCadreNowPositionListBeanDao.class);
        registerDaoClass(DBGbCadreRankListBeanDao.class);
        registerDaoClass(DBGbCadreResumeListBeanDao.class);
        registerDaoClass(DBGbCadreTrainListBeanDao.class);
        registerDaoClass(DBTyHjDao.class);
        registerDaoClass(DBTyHjListDao.class);
        registerDaoClass(DBUserListBeanDao.class);
        registerDaoClass(DBYjjcCadreDao.class);
        registerDaoClass(DBYjjcMeetingDao.class);
        registerDaoClass(DBZcfgBeanDao.class);
        registerDaoClass(DbTyJgDao.class);
        registerDaoClass(DbTyZsDao.class);
        registerDaoClass(DbYjjcBeanDao.class);
        registerDaoClass(MeiziDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }

    /**
     * Calls {@link #createAllTables(Database, boolean)} in {@link #onCreate(Database)} -
     */
    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String name) {
            super(context, name, SCHEMA_VERSION);
        }

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(Database db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }

    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name) {
            super(context, name);
        }

        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

}
