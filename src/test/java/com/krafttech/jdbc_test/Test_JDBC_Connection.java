package com.krafttech.jdbc_test;

import com.krafttech.utilities.Driver;

import java.sql.*;

public class Test_JDBC_Connection {
    public static void main(String[] args) {
        String url= "jdbc:sqlserver://94.73.170.25:1433;DatabaseName=u0583688_Kraft2;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";
        String userName = "u0583688_Kraft2";
        String password ="ANKARA123456789*0987654fg";
        String query = "SELECT * FROM u0583688_Kraft2.product.product";


try {
    Connection connection = DriverManager.getConnection(url, userName, password);
    System.out.println("CONNECTİON OK");
    Statement statement=connection.createStatement();
    ResultSet resultSet=statement.executeQuery(query);
    resultSet.next();//Paketin içine girdik 1. satır
    System.out.println(resultSet.getString(2));
    System.out.println(resultSet.getString(3));
    System.out.println(resultSet.getString(4));
    System.out.println(resultSet.getString(5));
    System.out.println(resultSet.getString(6));
    resultSet.next();//alttaki satıra geçiriyor
    System.out.println(resultSet.getString(2));//2.satırın 2. kolonu
}
catch (SQLException e){
    System.out.println("CONNECTİON ERROR" + e.getMessage());

}
    }
}
