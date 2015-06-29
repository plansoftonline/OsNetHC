package com.plansoftonline.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

     private static ConexaoUtil conexaoUtil;
     
     public static ConexaoUtil getInstance() {
    	 
    	 if (conexaoUtil == null) {
    		 conexaoUtil = new ConexaoUtil();
    	 }
    	 
    	 return conexaoUtil;
     }
     
     public Connection getConection() throws ClassNotFoundException, SQLException {
    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
    	 String URL = "jdbc:sqlserver://localhost:1433;databaseName=dbHC_pessoal;";
    	 
    	 return DriverManager.getConnection(URL,"sa","smsenha");
     }
   
     
}
