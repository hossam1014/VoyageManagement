/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import main_page.Database;
import main_page.Models.Reservation;

/**
 *
 * @author hossam
 */
public class MyReservationsHandler implements EventHandler<ActionEvent> {

    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    
    List<Reservation> reservations = new ArrayList<Reservation>();


//    private String UserName;
//    private String Password;
//
//    
//    public MyReservationsHandler(String userName, String password) {
//        UserName = userName;
//        Password = password;
//    }
    @Override
    public void handle(ActionEvent event) {

        try {
            connection = Database.connectDB();

            LoginHandler loginHandler = new LoginHandler();

            int userId = loginHandler.getUserId();

            String sql = "SELECT * FROM Reservations WHERE UserId = ?";

            prepare = connection.prepareStatement(sql);

            prepare.setInt(1, userId);

            result = prepare.executeQuery();

            while (result.next()) {
                Reservation reservation = new Reservation(result.getInt("Id"),
                    result.getString("PackageName"), result.getString("TravelTicketName"),
                    result.getString("HotelName"), result.getDouble("Total"),
                    result.getDate("ReserveDate"), result.getInt("UserId"));
                
//                nothing appear here in console ERRORR
                System.out.println(reservation);
                
                reservations.add(reservation);
            }
            
            System.out.println(reservations);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Reservation> getMyReservations() {
        return this.reservations;
    }

}
