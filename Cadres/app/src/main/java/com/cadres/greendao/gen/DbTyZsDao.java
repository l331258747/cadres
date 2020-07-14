package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DbTyZs;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DB_TY_ZS".
*/
public class DbTyZsDao extends AbstractDao<DbTyZs, Long> {

    public static final String TABLENAME = "DB_TY_ZS";

    /**
     * Properties of entity DbTyZs.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property Year = new Property(1, String.class, "year", false, "YEAR");
        public final static Property RankAge = new Property(2, int.class, "rankAge", false, "RANK_AGE");
        public final static Property ToVacancy = new Property(3, int.class, "toVacancy", false, "TO_VACANCY");
        public final static Property Parallel = new Property(4, int.class, "parallel", false, "PARALLEL");
        public final static Property Overmatch = new Property(5, int.class, "overmatch", false, "OVERMATCH");
        public final static Property Vacancy = new Property(6, int.class, "vacancy", false, "VACANCY");
        public final static Property Digestion = new Property(7, int.class, "digestion", false, "DIGESTION");
    }


    public DbTyZsDao(DaoConfig config) {
        super(config);
    }
    
    public DbTyZsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DB_TY_ZS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"YEAR\" TEXT," + // 1: year
                "\"RANK_AGE\" INTEGER NOT NULL ," + // 2: rankAge
                "\"TO_VACANCY\" INTEGER NOT NULL ," + // 3: toVacancy
                "\"PARALLEL\" INTEGER NOT NULL ," + // 4: parallel
                "\"OVERMATCH\" INTEGER NOT NULL ," + // 5: overmatch
                "\"VACANCY\" INTEGER NOT NULL ," + // 6: vacancy
                "\"DIGESTION\" INTEGER NOT NULL );"); // 7: digestion
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DB_TY_ZS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DbTyZs entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String year = entity.getYear();
        if (year != null) {
            stmt.bindString(2, year);
        }
        stmt.bindLong(3, entity.getRankAge());
        stmt.bindLong(4, entity.getToVacancy());
        stmt.bindLong(5, entity.getParallel());
        stmt.bindLong(6, entity.getOvermatch());
        stmt.bindLong(7, entity.getVacancy());
        stmt.bindLong(8, entity.getDigestion());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DbTyZs entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String year = entity.getYear();
        if (year != null) {
            stmt.bindString(2, year);
        }
        stmt.bindLong(3, entity.getRankAge());
        stmt.bindLong(4, entity.getToVacancy());
        stmt.bindLong(5, entity.getParallel());
        stmt.bindLong(6, entity.getOvermatch());
        stmt.bindLong(7, entity.getVacancy());
        stmt.bindLong(8, entity.getDigestion());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DbTyZs readEntity(Cursor cursor, int offset) {
        DbTyZs entity = new DbTyZs( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // year
            cursor.getInt(offset + 2), // rankAge
            cursor.getInt(offset + 3), // toVacancy
            cursor.getInt(offset + 4), // parallel
            cursor.getInt(offset + 5), // overmatch
            cursor.getInt(offset + 6), // vacancy
            cursor.getInt(offset + 7) // digestion
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DbTyZs entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setYear(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRankAge(cursor.getInt(offset + 2));
        entity.setToVacancy(cursor.getInt(offset + 3));
        entity.setParallel(cursor.getInt(offset + 4));
        entity.setOvermatch(cursor.getInt(offset + 5));
        entity.setVacancy(cursor.getInt(offset + 6));
        entity.setDigestion(cursor.getInt(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DbTyZs entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DbTyZs entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DbTyZs entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}