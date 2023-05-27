
package main_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hossam
 */
public class SqlLiteDB {
    private static final String DATABASE_URL = "jdbc:sqlite:src/main_page/database/voyage_management";
    
    public static Connection connectDB() throws SQLException {
        
//        String drivers = "org.sqllite.JDBC";
//
//        
//        try {    
//            Class.forName(drivers);
//        } catch (ClassNotFoundException e) {
//                System.out.println(e.getMessage());
//        }
        
        return DriverManager.getConnection(DATABASE_URL);
    }
    
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close database connection: " + e.getMessage());
            }
        }
    }
}
