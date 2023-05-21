///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package main_page;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// *
// * @author hossam
// */
//public class Database {
//    private static final String URL = "jdbc:sqlserver://localhost:1433;database=master;encrypt=true;trustservercertificate=true";
//    
//     
//    private static final String USERNAME = "sa";
//    private static final String PASSWORD = "<Anas01015730963>";
//    
//    private static Connection connection;
//    
//    public static Connection connectDB() {
//        
//        String drivers = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        
//        try {
//            
//            try {
//                Class.forName(drivers);
//            } catch (ClassNotFoundException e) {
//                System.out.println(e.getMessage());
//            }
//            
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            
//            System.out.println("Connected to SQL Server");
//            
//            return connection;
//        } catch (SQLException e) {
//            System.err.println("Error connecting to SQL Server: " + e.getMessage());
//        }
//        return null;
//    }
//    
//    public Connection getConnection() {
//        return connection;
//    }
//    
//    public static void close() {
//        if (connection != null) {
//            try {
//                connection.close();
//                System.out.println("Disconnected from SQL Server");
//            } catch (SQLException e) {
//                System.err.println("Error disconnecting from SQL Server: " + e.getMessage());
//            }
//        }
//    }
//}
