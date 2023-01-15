package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Mentoring {
    public static void main(String[] args) throws SQLException {//testNG de @Test ile altına bir method adıyla yeni method yazarak
        // yine exeption deklare ederek de kurabilirim.
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password ="VolkanAntalya159";



            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("CONNECTİON OK");
            Statement statement=connection.createStatement();
            ResultSet resultSet1=statement.executeQuery("select email from EmployeesEren");

       resultSet1.close();
       statement.close();
       connection.close();
    }
}

