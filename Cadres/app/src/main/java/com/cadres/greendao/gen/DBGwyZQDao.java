package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBGwyZQ;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBGWY_ZQ".
*/
public class DBGwyZQDao extends AbstractDao<DBGwyZQ, Long> {

    public static final String TABLENAME = "DBGWY_ZQ";

    /**
     * Properties of entity DBGwyZQ.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property DeptId = new Property(1, int.class, "deptId", false, "DEPT_ID");
        public final static Property DeptName = new Property(2, String.class, "deptName", false, "DEPT_NAME");
        public final static Property Subset = new Property(3, int.class, "subset", false, "SUBSET");
        public final static Property Display = new Property(4, int.class, "display", false, "DISPLAY");
        public final static Property Verificationeg = new Property(5, int.class, "verificationeg", false, "VERIFICATIONEG");
        public final static Property Verificationsg = new Property(6, int.class, "verificationsg", false, "VERIFICATIONSG");
        public final static Property Verificationsig = new Property(7, int.class, "verificationsig", false, "VERIFICATIONSIG");
        public final static Property Actualeg = new Property(8, int.class, "actualeg", false, "ACTUALEG");
        public final static Property Actualsg = new Property(9, int.class, "actualsg", false, "ACTUALSG");
        public final static Property Actualsig = new Property(10, int.class, "actualsig", false, "ACTUALSIG");
        public final static Property Actualyb = new Property(11, int.class, "actualyb", false, "ACTUALYB");
        public final static Property Actualeb = new Property(12, int.class, "actualeb", false, "ACTUALEB");
        public final static Property Actualsb = new Property(13, int.class, "actualsb", false, "ACTUALSB");
        public final static Property Actualsib = new Property(14, int.class, "actualsib", false, "ACTUALSIB");
        public final static Property Actualyx = new Property(15, int.class, "actualyx", false, "ACTUALYX");
        public final static Property Actualex = new Property(16, int.class, "actualex", false, "ACTUALEX");
        public final static Property Surpasseg = new Property(17, int.class, "surpasseg", false, "SURPASSEG");
        public final static Property Surpasssg = new Property(18, int.class, "surpasssg", false, "SURPASSSG");
        public final static Property Surpasssig = new Property(19, int.class, "surpasssig", false, "SURPASSSIG");
        public final static Property Vacancyeg = new Property(20, int.class, "vacancyeg", false, "VACANCYEG");
        public final static Property Vacancysg = new Property(21, int.class, "vacancysg", false, "VACANCYSG");
        public final static Property Vacancysig = new Property(22, int.class, "vacancysig", false, "VACANCYSIG");
    }


    public DBGwyZQDao(DaoConfig config) {
        super(config);
    }
    
    public DBGwyZQDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBGWY_ZQ\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"DEPT_ID\" INTEGER NOT NULL ," + // 1: deptId
                "\"DEPT_NAME\" TEXT," + // 2: deptName
                "\"SUBSET\" INTEGER NOT NULL ," + // 3: subset
                "\"DISPLAY\" INTEGER NOT NULL ," + // 4: display
                "\"VERIFICATIONEG\" INTEGER NOT NULL ," + // 5: verificationeg
                "\"VERIFICATIONSG\" INTEGER NOT NULL ," + // 6: verificationsg
                "\"VERIFICATIONSIG\" INTEGER NOT NULL ," + // 7: verificationsig
                "\"ACTUALEG\" INTEGER NOT NULL ," + // 8: actualeg
                "\"ACTUALSG\" INTEGER NOT NULL ," + // 9: actualsg
                "\"ACTUALSIG\" INTEGER NOT NULL ," + // 10: actualsig
                "\"ACTUALYB\" INTEGER NOT NULL ," + // 11: actualyb
                "\"ACTUALEB\" INTEGER NOT NULL ," + // 12: actualeb
                "\"ACTUALSB\" INTEGER NOT NULL ," + // 13: actualsb
                "\"ACTUALSIB\" INTEGER NOT NULL ," + // 14: actualsib
                "\"ACTUALYX\" INTEGER NOT NULL ," + // 15: actualyx
                "\"ACTUALEX\" INTEGER NOT NULL ," + // 16: actualex
                "\"SURPASSEG\" INTEGER NOT NULL ," + // 17: surpasseg
                "\"SURPASSSG\" INTEGER NOT NULL ," + // 18: surpasssg
                "\"SURPASSSIG\" INTEGER NOT NULL ," + // 19: surpasssig
                "\"VACANCYEG\" INTEGER NOT NULL ," + // 20: vacancyeg
                "\"VACANCYSG\" INTEGER NOT NULL ," + // 21: vacancysg
                "\"VACANCYSIG\" INTEGER NOT NULL );"); // 22: vacancysig
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBGWY_ZQ\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBGwyZQ entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getDeptId());
 
        String deptName = entity.getDeptName();
        if (deptName != null) {
            stmt.bindString(3, deptName);
        }
        stmt.bindLong(4, entity.getSubset());
        stmt.bindLong(5, entity.getDisplay());
        stmt.bindLong(6, entity.getVerificationeg());
        stmt.bindLong(7, entity.getVerificationsg());
        stmt.bindLong(8, entity.getVerificationsig());
        stmt.bindLong(9, entity.getActualeg());
        stmt.bindLong(10, entity.getActualsg());
        stmt.bindLong(11, entity.getActualsig());
        stmt.bindLong(12, entity.getActualyb());
        stmt.bindLong(13, entity.getActualeb());
        stmt.bindLong(14, entity.getActualsb());
        stmt.bindLong(15, entity.getActualsib());
        stmt.bindLong(16, entity.getActualyx());
        stmt.bindLong(17, entity.getActualex());
        stmt.bindLong(18, entity.getSurpasseg());
        stmt.bindLong(19, entity.getSurpasssg());
        stmt.bindLong(20, entity.getSurpasssig());
        stmt.bindLong(21, entity.getVacancyeg());
        stmt.bindLong(22, entity.getVacancysg());
        stmt.bindLong(23, entity.getVacancysig());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBGwyZQ entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getDeptId());
 
        String deptName = entity.getDeptName();
        if (deptName != null) {
            stmt.bindString(3, deptName);
        }
        stmt.bindLong(4, entity.getSubset());
        stmt.bindLong(5, entity.getDisplay());
        stmt.bindLong(6, entity.getVerificationeg());
        stmt.bindLong(7, entity.getVerificationsg());
        stmt.bindLong(8, entity.getVerificationsig());
        stmt.bindLong(9, entity.getActualeg());
        stmt.bindLong(10, entity.getActualsg());
        stmt.bindLong(11, entity.getActualsig());
        stmt.bindLong(12, entity.getActualyb());
        stmt.bindLong(13, entity.getActualeb());
        stmt.bindLong(14, entity.getActualsb());
        stmt.bindLong(15, entity.getActualsib());
        stmt.bindLong(16, entity.getActualyx());
        stmt.bindLong(17, entity.getActualex());
        stmt.bindLong(18, entity.getSurpasseg());
        stmt.bindLong(19, entity.getSurpasssg());
        stmt.bindLong(20, entity.getSurpasssig());
        stmt.bindLong(21, entity.getVacancyeg());
        stmt.bindLong(22, entity.getVacancysg());
        stmt.bindLong(23, entity.getVacancysig());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBGwyZQ readEntity(Cursor cursor, int offset) {
        DBGwyZQ entity = new DBGwyZQ( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getInt(offset + 1), // deptId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // deptName
            cursor.getInt(offset + 3), // subset
            cursor.getInt(offset + 4), // display
            cursor.getInt(offset + 5), // verificationeg
            cursor.getInt(offset + 6), // verificationsg
            cursor.getInt(offset + 7), // verificationsig
            cursor.getInt(offset + 8), // actualeg
            cursor.getInt(offset + 9), // actualsg
            cursor.getInt(offset + 10), // actualsig
            cursor.getInt(offset + 11), // actualyb
            cursor.getInt(offset + 12), // actualeb
            cursor.getInt(offset + 13), // actualsb
            cursor.getInt(offset + 14), // actualsib
            cursor.getInt(offset + 15), // actualyx
            cursor.getInt(offset + 16), // actualex
            cursor.getInt(offset + 17), // surpasseg
            cursor.getInt(offset + 18), // surpasssg
            cursor.getInt(offset + 19), // surpasssig
            cursor.getInt(offset + 20), // vacancyeg
            cursor.getInt(offset + 21), // vacancysg
            cursor.getInt(offset + 22) // vacancysig
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBGwyZQ entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDeptId(cursor.getInt(offset + 1));
        entity.setDeptName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSubset(cursor.getInt(offset + 3));
        entity.setDisplay(cursor.getInt(offset + 4));
        entity.setVerificationeg(cursor.getInt(offset + 5));
        entity.setVerificationsg(cursor.getInt(offset + 6));
        entity.setVerificationsig(cursor.getInt(offset + 7));
        entity.setActualeg(cursor.getInt(offset + 8));
        entity.setActualsg(cursor.getInt(offset + 9));
        entity.setActualsig(cursor.getInt(offset + 10));
        entity.setActualyb(cursor.getInt(offset + 11));
        entity.setActualeb(cursor.getInt(offset + 12));
        entity.setActualsb(cursor.getInt(offset + 13));
        entity.setActualsib(cursor.getInt(offset + 14));
        entity.setActualyx(cursor.getInt(offset + 15));
        entity.setActualex(cursor.getInt(offset + 16));
        entity.setSurpasseg(cursor.getInt(offset + 17));
        entity.setSurpasssg(cursor.getInt(offset + 18));
        entity.setSurpasssig(cursor.getInt(offset + 19));
        entity.setVacancyeg(cursor.getInt(offset + 20));
        entity.setVacancysg(cursor.getInt(offset + 21));
        entity.setVacancysig(cursor.getInt(offset + 22));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBGwyZQ entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBGwyZQ entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBGwyZQ entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}