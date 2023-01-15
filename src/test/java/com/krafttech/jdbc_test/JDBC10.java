package com.krafttech.jdbc_test;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JDBC10 {
    public static void main(String[] args) {

        JDBC_Utilities_Mentoring.createConnection();

        List<Map<String, Object>> queryResultMap = JDBC_Utilities_Mentoring.getQueryResultMap("select * from tableName");
        System.out.println("queryResultMap = " + queryResultMap);





        List<List<Object>> queryResultList =JDBC_Utilities_Mentoring.getQueryResultList("select * from tableName");
        System.out.println("queryResultList = " + queryResultList);

        JDBC_Utilities_Mentoring.destroy();
    }



}

