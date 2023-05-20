/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main_page.Database;
import main_page.Models.Reservation;
import main_page.Models.User;

/**
 *
 * @author hossam
 */
public class ReportsHelper {
     
    public int getUserCount() {
        String query = "SELECT COUNT(*) FROM Users";
        try (Connection conn = Database.connectDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getReservationCount() {
        String query = "SELECT COUNT(*) FROM Reservations";
        try (Connection conn = Database.connectDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getTotalProfit() {
        String query = "SELECT SUM(Total) FROM Reservations";
        try (Connection conn = Database.connectDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    
    
    public List<User> getAllUsers() {
        
        try {
            List<User> users = new ArrayList<User>();

            Connection connection = Database.connectDB();
            
            String sql = "SELECT * FROM Users WHERE IsAdmin = 0";

            PreparedStatement prepare = connection.prepareStatement(sql);

            ResultSet result = prepare.executeQuery();
            

            while (result.next()) {
                
                User user = new User(result.getInt("Id"),
                    result.getString("UserName"), result.getString("FullName"),
                    result.getString("Email"), result.getString("PhoneNumber"),
                    result.getString("Password"), result.getBoolean("IsAdmin"));
                
                
                users.add(user);
            }
            
            
//            System.out.println(reservations);

            Database.close();

            return users;

            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    return null;

    }
}
