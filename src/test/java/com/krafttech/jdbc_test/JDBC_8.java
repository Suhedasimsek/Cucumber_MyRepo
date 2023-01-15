package com.krafttech.jdbc_test;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC_8 {

    public static void main(String[] args) throws SQLException {

        String dbUrl = "";
        String dbUsername = "";
        String dbPassword = "";

        Map<String, Object> row1 = new HashMap<>();
        row1.put("employeeId", 1000);
        row1.put("firstName", "Eren");
        row1.put("lastName", "Çengel");
        row1.put("salary", 100000);
        System.out.println("row3 = " + row1);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("employeeId", 1001);
        row2.put("firstName", "Alperen");
        row2.put("lastName", "Çengel");
        row2.put("salary", 150000);
        System.out.println("row4 = " + row2);

        //list for keeping all rows in a map
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);

        System.out.println("list = " + list);

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tableName");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //move to first row
        resultSet.next();
        Map<String, Object> row3 = new HashMap<>();
        row3.put(resultSetMetaData.getColumnName(1), resultSet.getString(1));
        row3.put(resultSetMetaData.getColumnName(2),resultSet.getString(2));
        row3.put(resultSetMetaData.getColumnName(3),resultSet.getString(3));
        row3.put(resultSetMetaData.getColumnName(4),resultSet.getString(4));
        //System.out.println("row3 = " + row3);

        //move to next row
        resultSet.next();
        Map<String, Object> row4 = new HashMap<>();
        row4.put(resultSetMetaData.getColumnName(1),resultSet.getString(1));
        row4.put(resultSetMetaData.getColumnName(2),resultSet.getString(2));
        row4.put(resultSetMetaData.getColumnName(3),resultSet.getString(3));
        row4.put(resultSetMetaData.getColumnName(4),resultSet.getString(4));
        //System.out.println("row4 = " + row4);

        List<Map<String, Object>> list2 = new ArrayList<>();
        list2.add(row3);
        list2.add(row4);
        System.out.println("list = " + list2);
        System.out.println("");
        System.out.println("list2.get(0) = " + list2.get(0));
        System.out.println("list2.get(0).get(\"EMPLOYEEID\") = " + list2.get(0).get("EMPLOYEEID"));


        resultSet.close();
        statement.close();
        connection.close();
    }

}

