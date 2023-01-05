package com.krafttech.jdbc_test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test_JDBC2 {
    public static void main(String[] args) {
        String url= "jdbc:sqlserver://94.73.170.25:1433;DatabaseName=u0583688_Kraft2;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";
        String userName = "u0583688_Kraft2";
        String password ="ANKARA123456789*0987654fg";
        String query = "SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";


        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("CONNECTİON OK");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();//Paketin içine girdik 1. satır
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getRow());//bulunduğumuz yerin sıra numarası
            System.out.println("resultSet.getString(\"brand_name\") = " + resultSet.getString("brand_name"));
            System.out.println(resultSet.getRow()+ "|"+ resultSet.getString(2));

            String brand_name=resultSet.getString("brand_name");
            System.out.println("brand_name = " + brand_name);
            int brand_id=resultSet.getInt("brand_id");
            System.out.println("brand_id = " + brand_id);
            resultSet.next();
            System.out.println(resultSet.getRow()+ "|"+ resultSet.getString(2));
            String brand_name2=resultSet.getString("brand_name");
            System.out.println("brand_name = " + brand_name);
            int brand_id2=resultSet.getInt("brand_id");
            System.out.println("brand_id = " + brand_id2);
            resultSet.next();

        }
        catch (SQLException e){
            System.out.println("CONNECTİON ERROR" + e.getMessage());

        }
    }
}

