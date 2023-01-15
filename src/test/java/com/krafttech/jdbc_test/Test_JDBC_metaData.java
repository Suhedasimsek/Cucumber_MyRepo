package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_metaData {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://94.73.170.25:1433;DatabaseName=u0583688_Kraft2;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";
        String userName = "u0583688_Kraft2";
        String password = "ANKARA123456789*0987654fg";
        String query = "SELECT TOP(10) * FROM u0583688_Kraft2.product.product";


        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("CONNECTİON OK");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData=resultSet.getMetaData();
            System.out.println("kolon sayısı: " + metaData.getColumnCount());
            System.out.println("kolon adı1: " + metaData.getColumnName(1));
            System.out.println("kolon adı2: " + metaData.getColumnName(2));
            System.out.println("kolon adları: " + metaData.getColumnName(3)+" | "+metaData.getColumnName(4));
            int kolonSayisi=metaData.getColumnCount();
            for (int i = 1; i <=kolonSayisi ; i++) {// sütun adları
                System.out.println("Kolon "+i + "=>" +metaData.getColumnName(i));


            }
            while (resultSet.next()) {//sütundaki bütün veriler
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + "            ");
                }
                System.out.println("");

            }

        }
    catch (
    SQLException e){
        System.out.println("CONNECTİON ERROR" + e.getMessage());

    }
}
}