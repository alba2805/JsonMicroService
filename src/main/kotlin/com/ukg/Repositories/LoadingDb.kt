package com.ukg.Repositories

import com.ukg.Configuration.ConnectSql
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

class LoadingDb {
    private var connSql = ConnectSql()

    fun LoadingData():ResultSet{
        val query: Statement = connSql.dbConn().createStatement()
        var sql: String =("select sum(d.PROMOTIONS) total, CONCAT(trim(l.COUNTRY), '-', TRIM(l.STATE)) LOCATION,  j.JOB_TITLE, TRIM(g.GENDER) GENDER " +
                                                                                "from FACT_PROMOTIONS d join DIM_LOCATION l  on d.ID_LOCATION = l.ID " +
                                                                                "join DIM_GENDER g on d.ID_GENDER = g.ID " +
                                                                                "join DIM_COMPANY c on d.ID_COMPANY = c.ID " +
                                                                                "join DIM_JOB_TITLE j on d.ID_JOB_TITLE = j.ID " +
                                                                                "join DIM_TIME t on d.ID_TIME = t.ID " +
                                                                                "where t.YEAR = 2022 " +
                                                                                "and c.UKG_COMPANY = 'AGR1004' " +
                                                                                "group by CONCAT(trim(l.COUNTRY), '-', TRIM(l.STATE)), j.JOB_TITLE, TRIM(g.GENDER) " +
                                                                                "order by CONCAT(trim(l.COUNTRY), '-', TRIM(l.STATE)), j.JOB_TITLE, TRIM(g.GENDER)")
        var result: ResultSet = query.executeQuery(sql)
        return result
    }
}