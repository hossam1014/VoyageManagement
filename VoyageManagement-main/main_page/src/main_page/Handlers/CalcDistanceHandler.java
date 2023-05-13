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
import main_page.Database;
import main_page.Models.Location;

/**
 *
 * @author hossam
 */
public class CalcDistanceHandler implements EventHandler<ActionEvent> {

    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;

    private String startLocationName;
    private String endLocationName;

    public CalcDistanceHandler(String startLocationName, String endLocationName) {
        this.startLocationName = startLocationName;
        this.endLocationName = endLocationName;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            connection = Database.connectDB();
            String sql = "SELECT Latitude, Longitude FROM Locations WHERE CityName IN (?, ?)";

            try {
                
                PreparedStatement statement =   connection.prepareStatement(sql);
statement.setString(1, startCity);
                    statement.setString(2, endCity);
                    ResultSet resultSet = statement.executeQuery();

                    scss Copy code // Get the latitude and longitude values for the two cities
                    double startLatitude = 0;
                    double startLongitude = 0;
                    double endLatitude = 0;
                    double endLongitude = 0;

                    while (resultSet.next()) {
                        String cityName = resultSet.getString("cityName");
                        double latitude = resultSet.getDouble("latitude");
                        double longitude = resultSet.getDouble("longitude");

                        if (cityName.equals(startCity)) {
                            startLatitude = latitude;
                            startLongitude = longitude;
                        } else {
                            endLatitude = latitude;
                            endLongitude = longitude;
                        }
                    }

                    // Calculate the distance between the two cities using the Haversine formula
                    double distance = calculateHaversineDistance(startLatitude, startLongitude, endLatitude, endLongitude);

                    // Display the distance between the two cities
                    distanceLabel.setText(String.format("The distance between %s and %s is %.2f km.", startCity, endCity, distance));
                }

            }catch (SQLException e) {
        e.printStackTrace();
    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
