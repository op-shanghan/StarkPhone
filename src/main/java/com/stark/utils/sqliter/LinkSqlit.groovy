package com.stark.utils.sqliter

import groovy.sql.Sql

class LinkSqlit {

    static final def SQLITE_DB = "jdbc:sqlite:innerSQL.sqlite"

    static final def SQLITE_JDBC = "org.sqlite.JDBC"

    static def sql = null

    static {
        sql = Sql.newInstance(SQLITE_DB,SQLITE_JDBC)
    }

    synchronized static def getSQL() throws Exception{
        if(null != sql){
            return sql
        }
    }

}
