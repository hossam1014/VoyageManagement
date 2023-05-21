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
import javafx.scene.control.Alert;
import main_page.Database;
import main_page.SqlLiteDB;

/**
 *
 * @author hossam
 */
public class SignUpHandler implements EventHandler<ActionEvent> {

    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;

    private String FullName;
    private String Email;
    private String PhoneNumber;
    private String UserName;
    private String Password;

    public SignUpHandler(String fullName, String email, String phoneNumber, String userName, String password) {
        FullName = fullName;
        Email = email;
        PhoneNumber = phoneNumber;
        UserName = userName;
        Password = password;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            connection = SqlLiteDB.connectDB();
            String sql = "INSERT INTO Users (FullName, Email, PhoneNumber, UserName, Password, IsAdmin) VALUES (?, ?, ?, ?, ?, 0)";

            prepare = connection.prepareStatement(sql);

            prepare.setString(1, FullName);
            prepare.setString(2, Email);
            prepare.setString(3, PhoneNumber);
            prepare.setString(4, UserName);
            prepare.setString(5, Password);

            int rowsInserted = prepare.executeUpdate();

            if (rowsInserted > 0) {
                // Sign up successful, show success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Sign up successful!");
                alert.showAndWait();
                
                Database.close();
            } else {
                // Sign up failed, show error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Sign up failed");
                alert.showAndWait();
                Database.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    private void clear() {
//        
//    }
}
