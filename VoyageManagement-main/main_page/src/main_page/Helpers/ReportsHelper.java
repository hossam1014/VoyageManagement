
package main_page.Helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main_page.Models.Reservation;
import main_page.Models.User;
import main_page.SqlLiteDB;

/**
 *
 * @author hossam
 */
public class ReportsHelper {
     
    public int getUserCount() {
        String query = "SELECT COUNT(*) FROM Users WHERE IsAdmin = 0";
        try (Connection conn = SqlLiteDB.connectDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getReservationCount() {
        String query = "SELECT COUNT(*) FROM Reservations";
        try (Connection conn = SqlLiteDB.connectDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getTotalProfit() {
        String query = "SELECT SUM(TotalPrice) FROM Reservations";
        try (Connection conn = SqlLiteDB.connectDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    
    
    public List<User> getAllUsers() {
        try {
            List<User> users = new ArrayList<>();

            try (Connection connection = SqlLiteDB.connectDB()) {
                String sql = "SELECT * FROM Users WHERE IsAdmin = 0";

                try (PreparedStatement prepare = connection.prepareStatement(sql);
                     ResultSet result = prepare.executeQuery()) {
                    while (result.next()) {
                        User user = new User(result.getInt("Id"),
                                result.getString("UserName"), result.getString("FullName"),
                                result.getString("Email"), result.getString("PhoneNumber"),
                                result.getString("Password"), result.getBoolean("IsAdmin"));
                        users.add(user);
                    }
                }
            }
            
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
    public static List<Reservation> getMyReservations(int userId) {
        
        List<Reservation> reservations = new ArrayList<>();

        try (Connection connection = SqlLiteDB.connectDB()) {
            System.out.println(userId);

            String sql = "SELECT * FROM Reservations WHERE UserId = ?";

            try (PreparedStatement prepare = connection.prepareStatement(sql)) {
                prepare.setInt(1, userId);

                try (ResultSet result = prepare.executeQuery()) {
                    while (result.next()) {
                        Reservation reservation = new Reservation(result.getInt("Id"),
                                result.getString("FromCity"), result.getString("ToCity"),
                                result.getString("LeavingDate"), result.getString("ArrivalDate"),
                                result.getString("TravelType"), result.getString("TripName"),
                                result.getDouble("TripPrice"),
                                result.getString("HotelName"), result.getInt("HotelDuration"),
                                result.getDouble("TotalPrice"), result.getInt("UserId"));

                        // Output the reservation details
    //                    System.out.println(reservation);

                        reservations.add(reservation);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return reservations;
    }
}
