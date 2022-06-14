package com.ukg.Configuration

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import com.microsoft.sqlserver.jdbc.SQLServerDriver;



class ConnectSql {
    private val ip = "moose.int.kronos.com\\mss2019:61763"
    private val db = "cognos_db"
    private val user = "cognos_db"
    private val pass = "cognos_db"

    fun dbConn():Connection{
        lateinit var conn : Connection
        val connString : String

        try {
            DriverManager.registerDriver(com.microsoft.sqlserver.jdbc.SQLServerDriver())
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
            connString = "jdbc:sqlserver://$ip;databaseName=$db;user=$user;password=$pass"
            conn = DriverManager.getConnection(connString)
        }catch (ex:SQLException){
           print("Error: "+ex.message)
        }catch (ex1:ClassNotFoundException){
            print("Error: "+ex1.message)
        }
        catch (ex2:Exception){
            print("Error: "+ex2.message)
        }
        return conn
    }
}