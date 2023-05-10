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
import main_page.Database;

/**
 *
 * @author hossam
 */
public class GetUsersHandler implements EventHandler<ActionEvent> {

    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;

    @Override
    public void handle(ActionEvent event) {
        try {
            connection = Database.connectDB();
            String sql = "SELECT * FROM Users";

            prepare = connection.prepareStatement(sql);

            result = prepare.executeQuery();

            if (result != null) {
                // Create a new VBox to hold the labels
                VBox labelsContainer = new VBox();
                while (result.next()) {
                    // For each user, create a new label and set its text to the user information
                    Label userLabel = new Label("User ID: " + result.getInt("Id")
                            + ", Username: " + result.getString("UserName")
                            + ", Password: " + result.getString("Password"));
                    labelsContainer.getChildren().add(userLabel);
                }
                // Create a new scene with the VBox as its root and show it
                Scene scene = new Scene(labelsContainer, 400, 400);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } else {
                // Show an error message if no users were found
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No users found");
                alert.showAndWait();
            }

            Database.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
