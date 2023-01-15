package com.krafttech.jdbc_test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_7 {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "";
        String dbUsername = "";
        String dbPassword = "";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername,dbPassword);

        //create statement object
        //Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in resultset object
        //ResultSet resultSet = statement.executeQuery("select * from employeesEren");

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("databaseMetaData.getDriverVersion() = " + databaseMetaData.getDriverVersion());


        //close the instance
        //resultSet.close();
        //statement.close();
        connection.close();
    }


}

