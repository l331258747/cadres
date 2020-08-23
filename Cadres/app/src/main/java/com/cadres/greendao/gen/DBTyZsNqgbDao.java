package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBTyZsNqgb;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBTY_ZS_NQGB".
*/
public class DBTyZsNqgbDao extends AbstractDao<DBTyZsNqgb, Long> {

    public static final String TABLENAME = "DBTY_ZS_NQGB";

    /**
     * Properties of entity DBTyZsNqgb.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property Year = new Property(1, String.class, "year", false, "YEAR");
        public final static Property Principal = new Property(2, int.class, "principal", false, "PRINCIPAL");
        public final static Property Deputy = new Property(3, int.class, "deputy", false, "DEPUTY");
        public final static Property Sum = new Property(4, int.class, "sum", false, "SUM");
        public final static Property Jlh = new Property(5, int.class, "jlh", false, "JLH");
    }


    public DBTyZsNqgbDao(DaoConfig config) {
        super(config);
    }
    
    public DBTyZsNqgbDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBTY_ZS_NQGB\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"YEAR\" TEXT," + // 1: year
                "\"PRINCIPAL\" INTEGER NOT NULL ," + // 2: principal
                "\"DEPUTY\" INTEGER NOT NULL ," + // 3: deputy
                "\"SUM\" INTEGER NOT NULL ," + // 4: sum
                "\"JLH\" INTEGER NOT NULL );"); // 5: jlh
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBTY_ZS_NQGB\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBTyZsNqgb entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String year = entity.getYear();
        if (year != null) {
            stmt.bindString(2, year);
        }
        stmt.bindLong(3, entity.getPrincipal());
        stmt.bindLong(4, entity.getDeputy());
        stmt.bindLong(5, entity.getSum());
        stmt.bindLong(6, entity.getJlh());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBTyZsNqgb entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String year = entity.getYear();
        if (year != null) {
            stmt.bindString(2, year);
        }
        stmt.bindLong(3, entity.getPrincipal());
        stmt.bindLong(4, entity.getDeputy());
        stmt.bindLong(5, entity.getSum());
        stmt.bindLong(6, entity.getJlh());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBTyZsNqgb readEntity(Cursor cursor, int offset) {
        DBTyZsNqgb entity = new DBTyZsNqgb( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // year
            cursor.getInt(offset + 2), // principal
            cursor.getInt(offset + 3), // deputy
            cursor.getInt(offset + 4), // sum
            cursor.getInt(offset + 5) // jlh
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBTyZsNqgb entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setYear(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPrincipal(cursor.getInt(offset + 2));
        entity.setDeputy(cursor.getInt(offset + 3));
        entity.setSum(cursor.getInt(offset + 4));
        entity.setJlh(cursor.getInt(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBTyZsNqgb entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBTyZsNqgb entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBTyZsNqgb entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
