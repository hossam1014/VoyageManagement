//<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Scenes;

import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.stage.Stage;
//import main_page.Handlers.CalcDistanceHandler;
import main_page.Models.Location;
import main_page.SqlLiteDB;

/**
 *
 * @author hossam
 */
public class DistanceCalculatorPage extends Scene {

    private final ComboBox<String> startCityComboBox;
    private final ComboBox<String> endCityComboBox;
    private final Label distanceLabel;

    private Connection connection;

    public DistanceCalculatorPage(Stage stage) {
        super(new GridPane(), 1250, 760);

        GridPane gridPane = (GridPane) getRoot();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25));

        // Create the location selection combo boxes
        startCityComboBox = new ComboBox<>();
        endCityComboBox = new ComboBox<>();
        gridPane.add(new Label("Location 1:"), 0, 0);
        gridPane.add(startCityComboBox, 1, 0);
        gridPane.add(new Label("Location 2:"), 0, 1);
        gridPane.add(endCityComboBox, 1, 1);

        // Create the calculate distance button
        Button calculateButton = new Button("Calculate Distance");

        gridPane.add(calculateButton, 0, 2, 2, 1);

        // Create the distance label
        distanceLabel = new Label();
        distanceLabel.setFont(new Font(18));
        gridPane.add(distanceLabel, 0, 3, 2, 1);

        calculateButton.setOnAction(event -> {

            if (startCityComboBox.getValue() == null || endCityComboBox.getValue() == null) {
                distanceLabel.setText("Please select a start city and an end city.");
                return;
            }
            
           // CalcDistanceHandler calcDistanceHandler = new CalcDistanceHandler(startCityComboBox.getValue(),
             //       endCityComboBox.getValue());

            //calcDistanceHandler.handle(event);
        });

        this.getComboBoxesValues();

    }

    private void getComboBoxesValues() {

        try {

            connection = SqlLiteDB.connectDB();

            String sql = "SELECT * FROM Locations";

            // Execute the SQL statement
            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                // Add the city names to the combo boxes
                while (resultSet.next()) {
                    String cityName = resultSet.getString("CityName");
                    startCityComboBox.getItems().add(cityName);
                    endCityComboBox.getItems().add(cityName);
                }

                SqlLiteDB.closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private double calculateHaversineDistance(double startLatitude, double startLongitude, double endLatitude, double endLongitude) {

        double earthRadius = 6371; // km

        double deltaLat = Math.toRadians(endLatitude - startLatitude);
        double deltaLon = Math.toRadians(endLongitude - startLongitude);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(Math.toRadians(startLatitude)) * Math.cos(Math.toRadians(endLatitude))
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c; // km
    }
}
//*/=======
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package main_page.Scenes;
//
//import javafx.scene.Scene;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ComboBox;
//import javafx.scene.layout.GridPane;
//import javafx.scene.text.Font;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javafx.stage.Stage;
//import main_page.Database;
//import main_page.Handlers.CalcDistanceHandler;
//import main_page.Models.Location;
//
///**
// *
// * @author hossam
// */
//public class DistanceCalculatorPage extends Scene {
//
//    private final ComboBox<String> startCityComboBox;
//    private final ComboBox<String> endCityComboBox;
//    private final Label distanceLabel;
//
//    private Connection connection;
//
//    public DistanceCalculatorPage(Stage stage) {
//        super(new GridPane(), 1250, 760);
//
//        GridPane gridPane = (GridPane) getRoot();
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        gridPane.setPadding(new Insets(25));
//
//        // Create the location selection combo boxes
//        startCityComboBox = new ComboBox<>();
//        endCityComboBox = new ComboBox<>();
//        gridPane.add(new Label("Location 1:"), 0, 0);
//        gridPane.add(startCityComboBox, 1, 0);
//        gridPane.add(new Label("Location 2:"), 0, 1);
//        gridPane.add(endCityComboBox, 1, 1);
//
//        // Create the calculate distance button
//        Button calculateButton = new Button("Calculate Distance");
//
//        gridPane.add(calculateButton, 0, 2, 2, 1);
//
//        // Create the distance label
//        distanceLabel = new Label();
//        distanceLabel.setFont(new Font(18));
//        gridPane.add(distanceLabel, 0, 3, 2, 1);
//
//        calculateButton.setOnAction(event -> {
//
//            if (startCityComboBox.getValue() == null || endCityComboBox.getValue() == null) {
//                distanceLabel.setText("Please select a start city and an end city.");
//                return;
//            }
//            
//            CalcDistanceHandler calcDistanceHandler = new CalcDistanceHandler(startCityComboBox.getValue(),
//                    endCityComboBox.getValue());
//
//            calcDistanceHandler.handle(event);
//        });
//
//        this.getComboBoxesValues();
//
//    }
//
//    private void getComboBoxesValues() {
//
//        try {
//
//            connection = Database.connectDB();
//
//            String sql = "SELECT * FROM Locations";
//
//            // Execute the SQL statement
//            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
//
//                // Add the city names to the combo boxes
//                while (resultSet.next()) {
//                    String cityName = resultSet.getString("CityName");
//                    startCityComboBox.getItems().add(cityName);
//                    endCityComboBox.getItems().add(cityName);
//                }
//
//                Database.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private double calculateHaversineDistance(double startLatitude, double startLongitude, double endLatitude, double endLongitude) {
//
//        double earthRadius = 6371; // km
//
//        double deltaLat = Math.toRadians(endLatitude - startLatitude);
//        double deltaLon = Math.toRadians(endLongitude - startLongitude);
//
//        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
//                + Math.cos(Math.toRadians(startLatitude)) * Math.cos(Math.toRadians(endLatitude))
//                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
//
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//
//        return earthRadius * c; // km
//    }
//}
//>>>>>>> 6196c1a9cf50f964780f7c874914fec9786d3a5b*/
