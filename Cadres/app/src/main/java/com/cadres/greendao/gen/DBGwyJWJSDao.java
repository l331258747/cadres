package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBGwyJWJS;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBGWY_JWJS".
*/
public class DBGwyJWJSDao extends AbstractDao<DBGwyJWJS, Long> {

    public static final String TABLENAME = "DBGWY_JWJS";

    /**
     * Properties of entity DBGwyJWJS.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property DeptId = new Property(1, int.class, "deptId", false, "DEPT_ID");
        public final static Property DeptName = new Property(2, String.class, "deptName", false, "DEPT_NAME");
        public final static Property Subset = new Property(3, int.class, "subset", false, "SUBSET");
        public final static Property Display = new Property(4, int.class, "display", false, "DISPLAY");
        public final static Property Verificationez = new Property(5, int.class, "verificationez", false, "VERIFICATIONEZ");
        public final static Property Verificationsz = new Property(6, int.class, "verificationsz", false, "VERIFICATIONSZ");
        public final static Property Verificationsiz = new Property(7, int.class, "verificationsiz", false, "VERIFICATIONSIZ");
        public final static Property Actualez = new Property(8, int.class, "actualez", false, "ACTUALEZ");
        public final static Property Actualsz = new Property(9, int.class, "actualsz", false, "ACTUALSZ");
        public final static Property Actualsiz = new Property(10, int.class, "actualsiz", false, "ACTUALSIZ");
        public final static Property Actualyg = new Property(11, int.class, "actualyg", false, "ACTUALYG");
        public final static Property Actualeg = new Property(12, int.class, "actualeg", false, "ACTUALEG");
        public final static Property Actualsg = new Property(13, int.class, "actualsg", false, "ACTUALSG");
        public final static Property Actualsig = new Property(14, int.class, "actualsig", false, "ACTUALSIG");
        public final static Property Actualjsy = new Property(15, int.class, "actualjsy", false, "ACTUALJSY");
        public final static Property Surpassez = new Property(16, int.class, "surpassez", false, "SURPASSEZ");
        public final static Property Surpasssz = new Property(17, int.class, "surpasssz", false, "SURPASSSZ");
        public final static Property Surpasssiz = new Property(18, int.class, "surpasssiz", false, "SURPASSSIZ");
        public final static Property Vacancyez = new Property(19, int.class, "vacancyez", false, "VACANCYEZ");
        public final static Property Vacancysz = new Property(20, int.class, "vacancysz", false, "VACANCYSZ");
        public final static Property Vacancysiz = new Property(21, int.class, "vacancysiz", false, "VACANCYSIZ");
    }


    public DBGwyJWJSDao(DaoConfig config) {
        super(config);
    }
    
    public DBGwyJWJSDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBGWY_JWJS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"DEPT_ID\" INTEGER NOT NULL ," + // 1: deptId
                "\"DEPT_NAME\" TEXT," + // 2: deptName
                "\"SUBSET\" INTEGER NOT NULL ," + // 3: subset
                "\"DISPLAY\" INTEGER NOT NULL ," + // 4: display
                "\"VERIFICATIONEZ\" INTEGER NOT NULL ," + // 5: verificationez
                "\"VERIFICATIONSZ\" INTEGER NOT NULL ," + // 6: verificationsz
                "\"VERIFICATIONSIZ\" INTEGER NOT NULL ," + // 7: verificationsiz
                "\"ACTUALEZ\" INTEGER NOT NULL ," + // 8: actualez
                "\"ACTUALSZ\" INTEGER NOT NULL ," + // 9: actualsz
                "\"ACTUALSIZ\" INTEGER NOT NULL ," + // 10: actualsiz
                "\"ACTUALYG\" INTEGER NOT NULL ," + // 11: actualyg
                "\"ACTUALEG\" INTEGER NOT NULL ," + // 12: actualeg
                "\"ACTUALSG\" INTEGER NOT NULL ," + // 13: actualsg
                "\"ACTUALSIG\" INTEGER NOT NULL ," + // 14: actualsig
                "\"ACTUALJSY\" INTEGER NOT NULL ," + // 15: actualjsy
                "\"SURPASSEZ\" INTEGER NOT NULL ," + // 16: surpassez
                "\"SURPASSSZ\" INTEGER NOT NULL ," + // 17: surpasssz
                "\"SURPASSSIZ\" INTEGER NOT NULL ," + // 18: surpasssiz
                "\"VACANCYEZ\" INTEGER NOT NULL ," + // 19: vacancyez
                "\"VACANCYSZ\" INTEGER NOT NULL ," + // 20: vacancysz
                "\"VACANCYSIZ\" INTEGER NOT NULL );"); // 21: vacancysiz
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBGWY_JWJS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBGwyJWJS entity) {
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
        stmt.bindLong(6, entity.getVerificationez());
        stmt.bindLong(7, entity.getVerificationsz());
        stmt.bindLong(8, entity.getVerificationsiz());
        stmt.bindLong(9, entity.getActualez());
        stmt.bindLong(10, entity.getActualsz());
        stmt.bindLong(11, entity.getActualsiz());
        stmt.bindLong(12, entity.getActualyg());
        stmt.bindLong(13, entity.getActualeg());
        stmt.bindLong(14, entity.getActualsg());
        stmt.bindLong(15, entity.getActualsig());
        stmt.bindLong(16, entity.getActualjsy());
        stmt.bindLong(17, entity.getSurpassez());
        stmt.bindLong(18, entity.getSurpasssz());
        stmt.bindLong(19, entity.getSurpasssiz());
        stmt.bindLong(20, entity.getVacancyez());
        stmt.bindLong(21, entity.getVacancysz());
        stmt.bindLong(22, entity.getVacancysiz());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBGwyJWJS entity) {
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
        stmt.bindLong(6, entity.getVerificationez());
        stmt.bindLong(7, entity.getVerificationsz());
        stmt.bindLong(8, entity.getVerificationsiz());
        stmt.bindLong(9, entity.getActualez());
        stmt.bindLong(10, entity.getActualsz());
        stmt.bindLong(11, entity.getActualsiz());
        stmt.bindLong(12, entity.getActualyg());
        stmt.bindLong(13, entity.getActualeg());
        stmt.bindLong(14, entity.getActualsg());
        stmt.bindLong(15, entity.getActualsig());
        stmt.bindLong(16, entity.getActualjsy());
        stmt.bindLong(17, entity.getSurpassez());
        stmt.bindLong(18, entity.getSurpasssz());
        stmt.bindLong(19, entity.getSurpasssiz());
        stmt.bindLong(20, entity.getVacancyez());
        stmt.bindLong(21, entity.getVacancysz());
        stmt.bindLong(22, entity.getVacancysiz());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBGwyJWJS readEntity(Cursor cursor, int offset) {
        DBGwyJWJS entity = new DBGwyJWJS( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getInt(offset + 1), // deptId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // deptName
            cursor.getInt(offset + 3), // subset
            cursor.getInt(offset + 4), // display
            cursor.getInt(offset + 5), // verificationez
            cursor.getInt(offset + 6), // verificationsz
            cursor.getInt(offset + 7), // verificationsiz
            cursor.getInt(offset + 8), // actualez
            cursor.getInt(offset + 9), // actualsz
            cursor.getInt(offset + 10), // actualsiz
            cursor.getInt(offset + 11), // actualyg
            cursor.getInt(offset + 12), // actualeg
            cursor.getInt(offset + 13), // actualsg
            cursor.getInt(offset + 14), // actualsig
            cursor.getInt(offset + 15), // actualjsy
            cursor.getInt(offset + 16), // surpassez
            cursor.getInt(offset + 17), // surpasssz
            cursor.getInt(offset + 18), // surpasssiz
            cursor.getInt(offset + 19), // vacancyez
            cursor.getInt(offset + 20), // vacancysz
            cursor.getInt(offset + 21) // vacancysiz
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBGwyJWJS entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDeptId(cursor.getInt(offset + 1));
        entity.setDeptName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSubset(cursor.getInt(offset + 3));
        entity.setDisplay(cursor.getInt(offset + 4));
        entity.setVerificationez(cursor.getInt(offset + 5));
        entity.setVerificationsz(cursor.getInt(offset + 6));
        entity.setVerificationsiz(cursor.getInt(offset + 7));
        entity.setActualez(cursor.getInt(offset + 8));
        entity.setActualsz(cursor.getInt(offset + 9));
        entity.setActualsiz(cursor.getInt(offset + 10));
        entity.setActualyg(cursor.getInt(offset + 11));
        entity.setActualeg(cursor.getInt(offset + 12));
        entity.setActualsg(cursor.getInt(offset + 13));
        entity.setActualsig(cursor.getInt(offset + 14));
        entity.setActualjsy(cursor.getInt(offset + 15));
        entity.setSurpassez(cursor.getInt(offset + 16));
        entity.setSurpasssz(cursor.getInt(offset + 17));
        entity.setSurpasssiz(cursor.getInt(offset + 18));
        entity.setVacancyez(cursor.getInt(offset + 19));
        entity.setVacancysz(cursor.getInt(offset + 20));
        entity.setVacancysiz(cursor.getInt(offset + 21));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBGwyJWJS entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBGwyJWJS entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBGwyJWJS entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
