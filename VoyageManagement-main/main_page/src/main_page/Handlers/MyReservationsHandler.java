
package main_page.Handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main_page.Models.Reservation;

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
  
    public MyReservationsHandler(int userId) {
        UserId = userId;
    }
    
    @Override
    public void handle(ActionEvent event) {

        try {
            
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
                
                System.out.println(reservation);
                
                reservations.add(reservation);
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Reservation> getMyReservations() {
        return this.reservations;
    }
}
