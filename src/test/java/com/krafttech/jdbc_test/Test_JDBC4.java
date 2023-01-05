package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC4 {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://94.73.170.25:1433;DatabaseName=u0583688_Kraft2;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";
        String userName = "u0583688_Kraft2";
        String password = "ANKARA123456789*0987654fg";
        String query = "SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";

        Connection connection=null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.beforeFirst();
            /*
            //Tüm rowların ilk 2 kolonunu alt alta yazdıralım

            for (int i = 1; i <=10 ; i++) {
                resultSet.absolute(i);
                System.out.println("resultSet.getString(i) = " + resultSet.getString(1));
                System.out.println("resultSet.getString(i) = " + resultSet.getString(2));

            }

            //2. yol
            while (resultSet.next()){

                System.out.println(resultSet.getString(1)+" ||"+resultSet.getString(2));

            }*/

          resultSet.next();
            System.out.println("resultSet.getRow() = " + resultSet.getRow());
            resultSet.last();
            System.out.println("resultSet.getRow() = " + resultSet.getRow());

            resultSet.getString("brand_name");
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (
                SQLException e){
            System.out.println("CONNECTİON ERROR" + e.getMessage());

        }
    }
}

