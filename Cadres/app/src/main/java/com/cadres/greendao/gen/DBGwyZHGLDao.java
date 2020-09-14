package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBGwyZHGL;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBGWY_ZHGL".
*/
public class DBGwyZHGLDao extends AbstractDao<DBGwyZHGL, Long> {

    public static final String TABLENAME = "DBGWY_ZHGL";

    /**
     * Properties of entity DBGwyZHGL.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property DeptId = new Property(1, int.class, "deptId", false, "DEPT_ID");
        public final static Property DeptName = new Property(2, String.class, "deptName", false, "DEPT_NAME");
        public final static Property Subset = new Property(3, int.class, "subset", false, "SUBSET");
        public final static Property Display = new Property(4, int.class, "display", false, "DISPLAY");
        public final static Property GwyType = new Property(5, String.class, "gwyType", false, "GWY_TYPE");
        public final static Property Verificationed = new Property(6, int.class, "verificationed", false, "VERIFICATIONED");
        public final static Property Verificationsd = new Property(7, int.class, "verificationsd", false, "VERIFICATIONSD");
        public final static Property Verificationsid = new Property(8, int.class, "verificationsid", false, "VERIFICATIONSID");
        public final static Property Verificationyez = new Property(9, int.class, "verificationyez", false, "VERIFICATIONYEZ");
        public final static Property Verificationssz = new Property(10, int.class, "verificationssz", false, "VERIFICATIONSSZ");
        public final static Property Actualed = new Property(11, int.class, "actualed", false, "ACTUALED");
        public final static Property Actualsd = new Property(12, int.class, "actualsd", false, "ACTUALSD");
        public final static Property Actualsid = new Property(13, int.class, "actualsid", false, "ACTUALSID");
        public final static Property Actualyz = new Property(14, int.class, "actualyz", false, "ACTUALYZ");
        public final static Property Actualez = new Property(15, int.class, "actualez", false, "ACTUALEZ");
        public final static Property Actualsz = new Property(16, int.class, "actualsz", false, "ACTUALSZ");
        public final static Property Actualsiz = new Property(17, int.class, "actualsiz", false, "ACTUALSIZ");
        public final static Property Actualyk = new Property(18, int.class, "actualyk", false, "ACTUALYK");
        public final static Property Actualek = new Property(19, int.class, "actualek", false, "ACTUALEK");
        public final static Property Surpassed = new Property(20, int.class, "surpassed", false, "SURPASSED");
        public final static Property Surpasssd = new Property(21, int.class, "surpasssd", false, "SURPASSSD");
        public final static Property Surpasssid = new Property(22, int.class, "surpasssid", false, "SURPASSSID");
        public final static Property Surpassyez = new Property(23, int.class, "surpassyez", false, "SURPASSYEZ");
        public final static Property Surpassssz = new Property(24, int.class, "surpassssz", false, "SURPASSSSZ");
        public final static Property Vacancyed = new Property(25, int.class, "vacancyed", false, "VACANCYED");
        public final static Property Vacancysd = new Property(26, int.class, "vacancysd", false, "VACANCYSD");
        public final static Property Vacancysid = new Property(27, int.class, "vacancysid", false, "VACANCYSID");
        public final static Property Vacancyyez = new Property(28, int.class, "vacancyyez", false, "VACANCYYEZ");
        public final static Property Vacancyssz = new Property(29, int.class, "vacancyssz", false, "VACANCYSSZ");
    }


    public DBGwyZHGLDao(DaoConfig config) {
        super(config);
    }
    
    public DBGwyZHGLDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBGWY_ZHGL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"DEPT_ID\" INTEGER NOT NULL ," + // 1: deptId
                "\"DEPT_NAME\" TEXT," + // 2: deptName
                "\"SUBSET\" INTEGER NOT NULL ," + // 3: subset
                "\"DISPLAY\" INTEGER NOT NULL ," + // 4: display
                "\"GWY_TYPE\" TEXT," + // 5: gwyType
                "\"VERIFICATIONED\" INTEGER NOT NULL ," + // 6: verificationed
                "\"VERIFICATIONSD\" INTEGER NOT NULL ," + // 7: verificationsd
                "\"VERIFICATIONSID\" INTEGER NOT NULL ," + // 8: verificationsid
                "\"VERIFICATIONYEZ\" INTEGER NOT NULL ," + // 9: verificationyez
                "\"VERIFICATIONSSZ\" INTEGER NOT NULL ," + // 10: verificationssz
                "\"ACTUALED\" INTEGER NOT NULL ," + // 11: actualed
                "\"ACTUALSD\" INTEGER NOT NULL ," + // 12: actualsd
                "\"ACTUALSID\" INTEGER NOT NULL ," + // 13: actualsid
                "\"ACTUALYZ\" INTEGER NOT NULL ," + // 14: actualyz
                "\"ACTUALEZ\" INTEGER NOT NULL ," + // 15: actualez
                "\"ACTUALSZ\" INTEGER NOT NULL ," + // 16: actualsz
                "\"ACTUALSIZ\" INTEGER NOT NULL ," + // 17: actualsiz
                "\"ACTUALYK\" INTEGER NOT NULL ," + // 18: actualyk
                "\"ACTUALEK\" INTEGER NOT NULL ," + // 19: actualek
                "\"SURPASSED\" INTEGER NOT NULL ," + // 20: surpassed
                "\"SURPASSSD\" INTEGER NOT NULL ," + // 21: surpasssd
                "\"SURPASSSID\" INTEGER NOT NULL ," + // 22: surpasssid
                "\"SURPASSYEZ\" INTEGER NOT NULL ," + // 23: surpassyez
                "\"SURPASSSSZ\" INTEGER NOT NULL ," + // 24: surpassssz
                "\"VACANCYED\" INTEGER NOT NULL ," + // 25: vacancyed
                "\"VACANCYSD\" INTEGER NOT NULL ," + // 26: vacancysd
                "\"VACANCYSID\" INTEGER NOT NULL ," + // 27: vacancysid
                "\"VACANCYYEZ\" INTEGER NOT NULL ," + // 28: vacancyyez
                "\"VACANCYSSZ\" INTEGER NOT NULL );"); // 29: vacancyssz
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBGWY_ZHGL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBGwyZHGL entity) {
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
 
        String gwyType = entity.getGwyType();
        if (gwyType != null) {
            stmt.bindString(6, gwyType);
        }
        stmt.bindLong(7, entity.getVerificationed());
        stmt.bindLong(8, entity.getVerificationsd());
        stmt.bindLong(9, entity.getVerificationsid());
        stmt.bindLong(10, entity.getVerificationyez());
        stmt.bindLong(11, entity.getVerificationssz());
        stmt.bindLong(12, entity.getActualed());
        stmt.bindLong(13, entity.getActualsd());
        stmt.bindLong(14, entity.getActualsid());
        stmt.bindLong(15, entity.getActualyz());
        stmt.bindLong(16, entity.getActualez());
        stmt.bindLong(17, entity.getActualsz());
        stmt.bindLong(18, entity.getActualsiz());
        stmt.bindLong(19, entity.getActualyk());
        stmt.bindLong(20, entity.getActualek());
        stmt.bindLong(21, entity.getSurpassed());
        stmt.bindLong(22, entity.getSurpasssd());
        stmt.bindLong(23, entity.getSurpasssid());
        stmt.bindLong(24, entity.getSurpassyez());
        stmt.bindLong(25, entity.getSurpassssz());
        stmt.bindLong(26, entity.getVacancyed());
        stmt.bindLong(27, entity.getVacancysd());
        stmt.bindLong(28, entity.getVacancysid());
        stmt.bindLong(29, entity.getVacancyyez());
        stmt.bindLong(30, entity.getVacancyssz());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBGwyZHGL entity) {
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
 
        String gwyType = entity.getGwyType();
        if (gwyType != null) {
            stmt.bindString(6, gwyType);
        }
        stmt.bindLong(7, entity.getVerificationed());
        stmt.bindLong(8, entity.getVerificationsd());
        stmt.bindLong(9, entity.getVerificationsid());
        stmt.bindLong(10, entity.getVerificationyez());
        stmt.bindLong(11, entity.getVerificationssz());
        stmt.bindLong(12, entity.getActualed());
        stmt.bindLong(13, entity.getActualsd());
        stmt.bindLong(14, entity.getActualsid());
        stmt.bindLong(15, entity.getActualyz());
        stmt.bindLong(16, entity.getActualez());
        stmt.bindLong(17, entity.getActualsz());
        stmt.bindLong(18, entity.getActualsiz());
        stmt.bindLong(19, entity.getActualyk());
        stmt.bindLong(20, entity.getActualek());
        stmt.bindLong(21, entity.getSurpassed());
        stmt.bindLong(22, entity.getSurpasssd());
        stmt.bindLong(23, entity.getSurpasssid());
        stmt.bindLong(24, entity.getSurpassyez());
        stmt.bindLong(25, entity.getSurpassssz());
        stmt.bindLong(26, entity.getVacancyed());
        stmt.bindLong(27, entity.getVacancysd());
        stmt.bindLong(28, entity.getVacancysid());
        stmt.bindLong(29, entity.getVacancyyez());
        stmt.bindLong(30, entity.getVacancyssz());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBGwyZHGL readEntity(Cursor cursor, int offset) {
        DBGwyZHGL entity = new DBGwyZHGL( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getInt(offset + 1), // deptId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // deptName
            cursor.getInt(offset + 3), // subset
            cursor.getInt(offset + 4), // display
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // gwyType
            cursor.getInt(offset + 6), // verificationed
            cursor.getInt(offset + 7), // verificationsd
            cursor.getInt(offset + 8), // verificationsid
            cursor.getInt(offset + 9), // verificationyez
            cursor.getInt(offset + 10), // verificationssz
            cursor.getInt(offset + 11), // actualed
            cursor.getInt(offset + 12), // actualsd
            cursor.getInt(offset + 13), // actualsid
            cursor.getInt(offset + 14), // actualyz
            cursor.getInt(offset + 15), // actualez
            cursor.getInt(offset + 16), // actualsz
            cursor.getInt(offset + 17), // actualsiz
            cursor.getInt(offset + 18), // actualyk
            cursor.getInt(offset + 19), // actualek
            cursor.getInt(offset + 20), // surpassed
            cursor.getInt(offset + 21), // surpasssd
            cursor.getInt(offset + 22), // surpasssid
            cursor.getInt(offset + 23), // surpassyez
            cursor.getInt(offset + 24), // surpassssz
            cursor.getInt(offset + 25), // vacancyed
            cursor.getInt(offset + 26), // vacancysd
            cursor.getInt(offset + 27), // vacancysid
            cursor.getInt(offset + 28), // vacancyyez
            cursor.getInt(offset + 29) // vacancyssz
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBGwyZHGL entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDeptId(cursor.getInt(offset + 1));
        entity.setDeptName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSubset(cursor.getInt(offset + 3));
        entity.setDisplay(cursor.getInt(offset + 4));
        entity.setGwyType(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setVerificationed(cursor.getInt(offset + 6));
        entity.setVerificationsd(cursor.getInt(offset + 7));
        entity.setVerificationsid(cursor.getInt(offset + 8));
        entity.setVerificationyez(cursor.getInt(offset + 9));
        entity.setVerificationssz(cursor.getInt(offset + 10));
        entity.setActualed(cursor.getInt(offset + 11));
        entity.setActualsd(cursor.getInt(offset + 12));
        entity.setActualsid(cursor.getInt(offset + 13));
        entity.setActualyz(cursor.getInt(offset + 14));
        entity.setActualez(cursor.getInt(offset + 15));
        entity.setActualsz(cursor.getInt(offset + 16));
        entity.setActualsiz(cursor.getInt(offset + 17));
        entity.setActualyk(cursor.getInt(offset + 18));
        entity.setActualek(cursor.getInt(offset + 19));
        entity.setSurpassed(cursor.getInt(offset + 20));
        entity.setSurpasssd(cursor.getInt(offset + 21));
        entity.setSurpasssid(cursor.getInt(offset + 22));
        entity.setSurpassyez(cursor.getInt(offset + 23));
        entity.setSurpassssz(cursor.getInt(offset + 24));
        entity.setVacancyed(cursor.getInt(offset + 25));
        entity.setVacancysd(cursor.getInt(offset + 26));
        entity.setVacancysid(cursor.getInt(offset + 27));
        entity.setVacancyyez(cursor.getInt(offset + 28));
        entity.setVacancyssz(cursor.getInt(offset + 29));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBGwyZHGL entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBGwyZHGL entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBGwyZHGL entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
