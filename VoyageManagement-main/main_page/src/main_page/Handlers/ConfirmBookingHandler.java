/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Models.Reservation;
import main_page.SqlLiteDB;

/**
 *
 * @author hossam
 */
public class ConfirmBookingHandler implements EventHandler<ActionEvent> {
    
    private Reservation reservation;

    public ConfirmBookingHandler(Reservation reservation) {
        this.reservation = reservation;
    }
    
    
    
    @Override
    public void handle(ActionEvent event){
        
        String insertQuery = "INSERT INTO Reservations (FromCity, ToCity, LeavingDate, ArrivalDate, " +
        "TravelType, TripName, TripPrice, HotelName, HotelDuration, TotalPrice, UserId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        
        try (Connection conn = SqlLiteDB.connectDB();
         PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            
        stmt.setString(1, reservation.getFrom());
        stmt.setString(2, reservation.getTo());
        stmt.setString(3, reservation.getLeavingDate());
        stmt.setString(4, reservation.getArrivalDate());
        stmt.setString(5, reservation.getTravelType());
        stmt.setString(6, reservation.getTripName());
        stmt.setDouble(7, reservation.getTripPrice());
        stmt.setString(8, reservation.getHotelName());
        stmt.setInt(9, reservation.getHotelDuration());
        stmt.setDouble(10, reservation.getTotalPrice());
        stmt.setInt(11, reservation.getUserId());

        stmt.executeUpdate();
        System.out.println("Reservation inserted successfully.");
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
