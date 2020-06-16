package com.example.cadres.bean.allData;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Meizi {

    //------------------111111111
    // @Entity：将我们的java普通类变为一个能够被greenDAO识别的数据库类型的实体类;
    // @nameInDb：在数据库中的名字，如不写则为实体中类名；
    // @Id：选择一个long / Long属性作为实体ID。 在数据库方面，它是主键。 参数autoincrement是设置ID值自增；
    // @NotNull：使该属性在数据库端成为“NOT NULL”列。 通常使用@NotNull标记原始类型（long，int，short，byte）是有意义的；
    // @Transient：表明这个字段不会被写入数据库，只是作为一个普通的java类字段，用来临时存储数据的，不会被持久化。

    //---------------22222222222
    //DaoMaster：使用greenDAO的切入点。DaoMaster保存数据库对象（SQLiteDatabase）并管理特定模式的DAO类（而不是对象）。
    // 它具有静态方法来创建表或将它们删除。 其内部类OpenHelper和DevOpenHelper是在SQLite数据库中创建模式的SQLiteOpenHelper实现。
    // 一个DaoMaster就代表着一个数据库的连接。

    //DaoSession：管理特定模式的所有可用DAO对象，您可以使用其中一个getter方法获取。
    // DaoSession还为实体提供了一些通用的持久性方法，如插入，加载，更新，刷新和删除。
    // DaoSession可以让我们使用一些Entity的基本操作和获取Dao操作类，DaoSession可以创建多个，每一个都是属于同一个数据库连接的。

    //XxxDAO：数据访问对象（DAO）持续存在并查询实体。 对于每个实体，GreenDAO生成一个DAO。
    // 它比DaoSession有更多的持久化方法，例如：count，loadAll和insertInTx。

    //------------3
    //1,编写DaoManager，用于创建数据库、创建数据库表、包含增删改查的操作以及数据库的升级。

    @Id(autoincrement = true)
    private Long _id;
    private String source;
    @NotNull
    private String url;
    @Generated(hash = 717937950)
    public Meizi(Long _id, String source, @NotNull String url) {
        this._id = _id;
        this.source = source;
        this.url = url;
    }
    @Generated(hash = 507723578)
    public Meizi() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Meizi{" +
                "_id=" + _id +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}