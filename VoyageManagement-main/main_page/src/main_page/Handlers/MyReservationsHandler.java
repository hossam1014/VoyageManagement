
package main_page.Handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import main_page.Models.Reservation;
import main_page.SqlLiteDB;

/**
 *
 * @author hossam
 */
public class MyReservationsHandler implements EventHandler<ActionEvent> {

    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    
    final List<Reservation>  reservations = new ArrayList<>();


    private int UserId;
//
//    
    public MyReservationsHandler(int userId) {
        UserId = userId;
    }
    
    
    @Override
    public void handle(ActionEvent event) {

        try {
//            connection = Database.connectDB();
            
            System.out.println(UserId);

            String sql = "SELECT * FROM Reservations WHERE UserId = ?";

            prepare = connection.prepareStatement(sql);

            prepare.setInt(1, UserId);

            result = prepare.executeQuery();
            
//            System.out.println(result);

            while (result.next()) {
                    Reservation reservation = new Reservation(result.getInt("Id"),
                            result.getString("FromCity"), result.getString("ToCity"),
                            result.getString("LeavingDate"), result.getString("ArrivalDate"),
                            result.getString("TravelType"), result.getString("TripName"),
                            result.getDouble("TripPrice"),
                            result.getString("HotelName"), result.getInt("HotelDuration"),
                            result.getDouble("TotalPrice"), result.getInt("UserId"));
                
//                nothing appear here in console ERRORR
                System.out.println(reservation);
                
                reservations.add(reservation);
            }
            
//            System.out.println(reservations);

//            SqlLiteDB.close();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Reservation> getMyReservations() {
//        System.out.println(this.reservations);

        return this.reservations;
    }

}
