package com.krafttech.jdbc_test;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class JDBC_6 {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "";
        String dbUsername = "";
        String dbPassword = "";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from tableName");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //kaç tane sütunumuz var?
        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        //sütun isimleri
        String columnName = resultSetMetaData.getColumnName(5);
        System.out.println("columnName = " + columnName);

        //bütün sütun isimlerini dinamik olarak getir
        for (int i = 1; i <= columnCount; i++) {
            System.out.println("resultSetMetaData.getColumnName(" + i + ") = " + resultSetMetaData.getColumnName(i));
        }

        //close the instance
        resultSet.close();
        statement.close();
        connection.close();
    }
}

