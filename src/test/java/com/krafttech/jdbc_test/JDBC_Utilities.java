package com.krafttech.jdbc_test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Utilities {


    static String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
            "encrypt=true;" +
            "trustServerCertificate=true;";
    static String userName = "u0583688_vlk";
    static String password = "VolkanAntalya159*";
    static String query = "SELECT * from u0583688_vlk.dbo.regions";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static ResultSetMetaData resultSetMetaData;

    public static void main(String[] args) throws SQLException {

        connectJdbc();
        runQuery();
        getRowCount();
        getColumnCount();
        closeJDBC();


    }

    static void connectJdbc() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.getMessage();
        }
    }

    static ResultSet runQuery() {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    static int getRowCount(){
        int row=0;
        try {
            resultSet.last();
            row=resultSet.getRow();
            System.out.println("rowCount = " + row);
            resultSet.beforeFirst();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    static void closeJDBC(){
        try {
            if (resultSet!=null){
                resultSet.close();
                System.out.println("resultSet closed");
            }
            if (statement!=null){
                statement.close();
                System.out.println("statement closed");
            }
            if (connection!=null){
                connection.close();
                System.out.println("connection closed");
            }

        } catch (SQLException e) {
            System.out.println("closeJDBC FAILED");
            e.getMessage();
        }
    }

    static ResultSetMetaData getResultSetMetada(){
        try {
            resultSetMetaData = resultSet.getMetaData();
            System.out.println("metadata is got");
        }
        catch (SQLException e) {
            System.out.println("Metadata cannot get");
        }
        return resultSetMetaData;
    }


    static int getColumnCount(){
        int columnCount=0;
        try {
            resultSetMetaData = resultSet.getMetaData();
            columnCount=resultSetMetaData.getColumnCount();
            System.out.println("metadata is got");
            System.out.println("ColumnCount = " + resultSetMetaData.getColumnCount());
        }
        catch (SQLException e) {
            System.out.println("metadata can not get");
            e.getMessage();
        }
        return columnCount;
    }

    static List<String> getAllColumnNameAsList() {
        List<String> columnNameList = new ArrayList<>();

        try {
            for (int i = 1; i < getColumnCount(); i++) {
                System.out.println("resultSetMetaData.getColumnName(i) = " + resultSetMetaData.getColumnName(i));
                columnNameList.add(resultSetMetaData.getColumnName(i));
                System.out.println("columnNameList.size() = " + columnNameList.size());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return columnNameList;
    }
  /* parametre olarak  row numarası alan,
             rowun tüm değerlerini listeye alan bir method
  */
            static List<String> getRawDataAsList (int rowNumber) {
        List<String> rowDataList=new ArrayList<>();
                for (int i = 1; i <=getColumnCount() ; i++) {
                    try {
                        String cell=resultSet.getString(i);
                        rowDataList.add(cell);

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }

         return rowDataList;
        }

        /* parametre olarak  row numarası ve kolon numarası alan,
            o hücrenin tüm değerlerini alan bir method
  */
static  String getCellData (int rowNumber, int columnIndex){//elimde sütun ındex no varsa bu
    String celldata="";
    try {
        resultSet.absolute(rowNumber);
        celldata=resultSet.getString(columnIndex);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }return celldata;

}
    static String getCellData(int rowNumber, String columnLabel){//elimde sütün ismi varsa bu method overloading

        String cellData="";

        try {
            resultSet.absolute(rowNumber);
            cellData=resultSet.getString(columnLabel);
            resultSet.beforeFirst();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cellData;
    }
        }



