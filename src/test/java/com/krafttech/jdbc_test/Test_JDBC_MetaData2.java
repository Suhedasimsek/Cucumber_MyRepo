package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_MetaData2 {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://94.73.170.25:1433;DatabaseName=u0583688_Kraft2;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";
        String userName = "u0583688_Kraft2";
        String password = "ANKARA123456789*0987654fg";
        String query = "SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            metaData.getColumnCount();
            System.out.println(metaData.getColumnCount());
            resultSet.next();


            /*//ColumnCountu kullanarak ilk satırın değerlerini ekrana yazdırın
            int kolonSayisi = metaData.getColumnCount();
            for (int i = 1; i <= kolonSayisi; i++) {
                System.out.print(resultSet.getString(i) + "\t"); //1 Samsung

            }
            //columnCountu kullanarak bütün rowları alt alta yazdıralım
            int kolonSayisi2 = metaData.getColumnCount();
            while (resultSet.next()) {//bura boolean değer. True oldukça döngü devam
                for (int j = 1; j <= kolonSayisi2; j++) {
                    System.out.print(resultSet.getString(j) + "\t");
                }
                System.out.println();
            }
            2.yol
            while (resultSet.next()) {
                for (int j = 1; j <= metaData.getColumnCount(); j++) {
                    System.out.print(resultSet.getString(j) + " ");
                }
                System.out.println("");*/

            //Tablomuzu kolon isimleriyle beraber yazdıralım
            int kolonSayisi3 = metaData.getColumnCount();


            for (int i = 1; i <= kolonSayisi3 ; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println(" ");
            while (resultSet.next()){

                for (int i = 1; i <= kolonSayisi3 ; i++) {
                    System.out.print(resultSet.getString(i) + "\t"+ "\t"+ "\t");
                }
                System.out.println(" ");

            }
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

