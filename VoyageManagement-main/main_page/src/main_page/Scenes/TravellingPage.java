
package main_page.Scenes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import main_page.Models.Location;
import main_page.Models.Reservation;

import main_page.Models.User;
import main_page.SqlLiteDB;

/**
 *
 * @author sayed
 */
public class TravellingPage extends Scene {

    private final ComboBox<String> startCityComboBox;
    private final ComboBox<String> endCityComboBox;
    public static Button btnnext = new Button("Next");

    private Connection connection;
    public static Button btncar = new Button("Car");
    public static Button btnbus = new Button("Bus");
    public static Button btntrain = new Button("Train");
    public static Button btnflaght = new Button("Flight");
    public static Boolean information_isFilled = false;
    
    private List<Location> locations = new ArrayList<>();
    
    private Location location1;
    private Location location2;
    
    private Reservation reservation = new Reservation(0, "", "", "", "", "", "", 0, "", 0, 0, 0);

   
    public TravellingPage(Stage primaryStage, User user) {

        super(new HBox(20), 1250, 760);

        //Travelling Reservation Page
        AnchorPane navigator = new AnchorPane();
        navigator.setId("navigator");
        navigator.setStyle("-fx-background-color: #e5eff1");
        
        AnchorPane right = new AnchorPane();
        
        //styling panes
        navigator.setMinSize(200, 760);
        navigator.getStyleClass().add("navigator");

        //navigator controller
        
        // btn go back to main page 
        Button btnback = new Button("Back");
        btnback.setPrefSize(100, 40);
        btnback.getStyleClass().add("custom-button");
        btnback.setLayoutX(50);
        btnback.setLayoutY(330);
       
        
        // two cmbobox 
        startCityComboBox = new ComboBox<>();
        startCityComboBox.setPrefSize(170, 40);
        endCityComboBox = new ComboBox<>();
        endCityComboBox.setPrefSize(170, 40);
        endCityComboBox.setLayoutX(650);
        endCityComboBox.setLayoutY(42);
        
        this.getComboBoxesValues();
        
        startCityComboBox.setOnAction(event -> {
            String selectedCity = startCityComboBox.getSelectionModel().getSelectedItem();
            location1 = getLocationByName(selectedCity);
            reservation.setFrom(selectedCity);
        });

        endCityComboBox.setOnAction(event -> {
            String selectedCity = endCityComboBox.getSelectionModel().getSelectedItem();
            location2 = getLocationByName(selectedCity);
            reservation.setTo(selectedCity);
        });
        
        //right page conterllor
        //from where travael
        Label lblfrom = new Label("From");
        lblfrom.setPrefSize(80, 30);
        lblfrom.setAlignment(Pos.CENTER);

        //to where travael
        Label lblto = new Label("To");
        lblto.setPrefSize(40, 30);
        lblto.setLayoutX(600);
        lblto.setLayoutY(42);
        
        //label for write on it "distance"
        Button btnDis = new Button("Distance");
        btnDis.setLayoutX(420);
        btnDis.setLayoutY(130);
        btnDis.setPrefSize(100, 38);
        
        //TextField for show distance
        TextField txtdist = new TextField();
        txtdist.setPromptText("0.0 km");
        txtdist.setLayoutX(540);
        txtdist.setLayoutY(130);
        txtdist.setPrefSize(100, 38);
        txtdist.setEditable(false);
        
        //line herziontal with car , bus , train , flaght buttons
        Line l3 = new Line(255,240,795,240);
        
        // line under buttons
        Line l4 = new Line(255,310,795,310);
        
        //button next properties
        btnnext.setPrefSize(120, 48);
        btnnext.setLayoutX(450);
        btnnext.setLayoutY(600);
        btnnext.setVisible(false);
        
        //edit propertis for buttons
        btncar.setPrefSize(120, 48);
        btntrain.setPrefSize(120, 48);
        btnflaght.setPrefSize(120, 48);
        btnbus.setPrefSize(120, 48);
        
        //add style for page
        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

        //put control in h box
        HBox h1 = new HBox(10);
        h1.setLayoutX(180);
        h1.setLayoutY(42);
        h1.getChildren().addAll(lblfrom, startCityComboBox);
        h1.setPrefSize(390, 38);
        
        
        // add buttons in hbox
        HBox h2 = new HBox(20);
        h2.setPrefSize(540, 50);
        h2.setLayoutX(255);
        h2.setLayoutY(250);
        h2.getChildren().addAll(btncar, btntrain, btnflaght, btnbus);
        

        //add button back to navigator
        navigator.getChildren().addAll(btnback);
        
        //add controller to right page
        right.getChildren().addAll(h1, h2,btnDis,txtdist,l3,l4,btnnext,lblto,endCityComboBox);
        
        HBox hBox = (HBox) this.getRoot();
        hBox.setStyle("-fx-background-color: #e5eff1");
        hBox.getChildren().addAll(navigator, right);
        
        /*//////  
                   Back End
                              //////*/
        
        CarButtonPage carPage = new CarButtonPage();
        FlaghtButtonPage flightPage = new FlaghtButtonPage();
        TrainButtonPage trainPage = new TrainButtonPage();
        BusButtonPage busPage = new BusButtonPage();
        
        // handler for car button
        btncar.setOnAction(x -> {
            reservation.setTravelType("Car");
            right.getChildren().remove(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().add(carPage);
            btnnext.setVisible(true);
        });
        
        // handler for bus button
        btnbus.setOnAction(x -> {
            reservation.setTravelType("Bus");
            right.getChildren().add(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().remove(carPage);
            btnnext.setVisible(true);
        });
        
        // handler for flaght button
        btntrain.setOnAction(x -> {
            reservation.setTravelType("Train");
            right.getChildren().remove(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().add(trainPage);
            right.getChildren().remove(carPage);
            btnnext.setVisible(true);
        });
        
        // handler for train button
        btnflaght.setOnAction(x -> {
            reservation.setTravelType("Flight");
            right.getChildren().remove(busPage);
            right.getChildren().add(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().remove(carPage);
            btnnext.setVisible(true);
        });
        
        btnDis.setOnAction(x -> {

            if (location1 != null && location2 != null) {
                // Calculate the distance
                double distance = calculateHaversineDistance();
                
                double roundedDistance = Math.round(distance * 100.0) / 100.0;                

                // Update the TextField with the calculated distance
                txtdist.setText(String.valueOf(roundedDistance)+" km");
            }   
        }); 
        
        // handler for  back button
        btnback.setOnAction(e -> {
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });
        
        //handle for btn next
        btnnext.setOnAction(e ->{
            primaryStage.setScene(new Hotel_Resevation(primaryStage, user));
        });
    }
    
    private void getComboBoxesValues() {

        try {
            connection = SqlLiteDB.connectDB();

            String sql = "SELECT * FROM Locations";

            // Execute the SQL statement
            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                // Add the city names to the combo boxes
                while (resultSet.next()) {
                    Location location = new Location(resultSet.getString("CityName"),
                            resultSet.getDouble("Latitude"), resultSet.getDouble("Longitude")
                    );
                    
                    locations.add(location);

                    startCityComboBox.getItems().add(location.getCityName());
                    endCityComboBox.getItems().add(location.getCityName());
                }
                
                SqlLiteDB.closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private double calculateHaversineDistance() {
        
        double startLatitude = location1.getLatitude();
        double startLongitude = location1.getLongitude();
        double endLatitude = location2.getLatitude();
        double endLongitude = location2.getLongitude();
        

        double earthRadius = 6371; // km

        double deltaLat = Math.toRadians(endLatitude - startLatitude);
        double deltaLon = Math.toRadians(endLongitude - startLongitude);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(Math.toRadians(startLatitude)) * Math.cos(Math.toRadians(endLatitude))
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c; // km
    }
    
    private Location getLocationByName(String cityName) {
        for (Location location : locations) {
            if (location.getCityName().equals(cityName)) {
                return location;
            }
        }
        return null;
    }
}
