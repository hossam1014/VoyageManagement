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

/**
 *
 * @author hossam
 */
public class LoginHandler implements EventHandler<ActionEvent> {
    
    
    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private String UserName;
    private String Password;
    
    private int userId;
    
    private boolean isLoggedIn = false;


    
    public LoginHandler(String userName, String password) {
        UserName = userName;
        Password = password;
    }
    
    

    @Override
    public void handle(ActionEvent event) {

        try {
            connection = Database.connectDB();
            String sql = "SELECT * FROM Users WHERE UserName = ? AND Password = ?";

            prepare = connection.prepareStatement(sql);

            prepare.setString(1, UserName);
            prepare.setString(2, Password);

            result = prepare.executeQuery();

            if (UserName.isEmpty() || Password.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("please fill all blank fields");
                alert.showAndWait();

            } else {

                if (result.next()) {
                    // User exists in database, show success message
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Login successful!");
                    System.out.println(result.getString("FullName"));
                    userId = result.getInt("Id");
                    isLoggedIn = true;
                    
                    

//                    alert.showAndWait();
                    Database.close();
                } else {
                    // User does not exist in database, show error message
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid username or password");
                    alert.showAndWait();
                    Database.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getUserId() {
        return userId;
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

}
