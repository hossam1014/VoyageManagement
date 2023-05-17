package main_page.Scenes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main_page.Models.User;
import main_page.Database;

public class TravellingPage extends Scene {

    private final ComboBox<String> startCityComboBox;
    private final ComboBox<String> endCityComboBox;

    private Connection connection;
   
    public TravellingPage(Stage primaryStage, User user) {


        super(new HBox(20), 1250, 760);

        //Travelling Reservation Page
        AnchorPane navigator = new AnchorPane();
        navigator.setId("navigator");
        AnchorPane right = new AnchorPane();

        //styling panes
        navigator.setMinSize(200, 760);
        navigator.getStyleClass().add("navigator");

        //navigator controller
        Button btnback = new Button("Previous page");
        btnback.setPrefSize(150, 50);
        btnback.setLayoutX(50);
        btnback.setLayoutY(355);

        startCityComboBox = new ComboBox<>();
        endCityComboBox = new ComboBox<>();

        //right page conterllor
        //from where travael
        Label lblfrom = new Label("From");
        lblfrom.setPrefSize(80, 30);
        lblfrom.setAlignment(Pos.CENTER);

        //to where travael
        Label lblto = new Label("To");
        lblto.setPrefSize(80, 30);
        lblto.setAlignment(Pos.CENTER);

        Label l_in = new Label("Date");
        DatePicker date_in = new DatePicker();

        l_in.setLayoutX(600);
        l_in.setLayoutY(42);
        l_in.setPrefSize(141, 38);
        date_in.setLayoutX(661);
        date_in.setLayoutY(42);
        date_in.setPrefSize(203, 38);
        date_in.setPromptText("DD-MM-YYYY");

        Button btncar = new Button("Car");
        btncar.setLayoutX(110);
        btncar.setLayoutY(300);
        btncar.setPrefSize(120, 48);

        btncar.setOnAction(event -> {
            primaryStage.setScene(new CarButtonPage(primaryStage));
        });

        Button btntrain = new Button("Train");
        btntrain.setLayoutX(250);
        btntrain.setLayoutY(300);
        btntrain.setPrefSize(120, 48);

        Button btnfly = new Button("Flaght");
        btnfly.setLayoutX(390);
        btnfly.setLayoutY(300);
        btnfly.setPrefSize(120, 48);
                this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

        //Travelling Reservation Page 
//>>>>>>> d07c005a6090082f588e1efd76ccdf45d1154dfd
        
            Button btnbus = new Button("Bus");
        btnbus.setLayoutX(530);
        btnbus.setLayoutY(300);
        btnbus.setPrefSize(120, 48);

        //put control in h box
        HBox h1 = new HBox();
        h1.getChildren().addAll(lblfrom, startCityComboBox, lblto, endCityComboBox);
        h1.setSpacing(10);
        h1.setPrefSize(604, 48);
        h1.setLayoutX(20);
        h1.setLayoutY(42);

        right.getChildren().addAll(h1, l_in, date_in, btncar, btnbus, btntrain, btnfly);
        HBox hBox = (HBox) this.getRoot();
        hBox.getChildren().addAll(navigator, right);

        getComboBoxesValues();
}

// handle two cmboboxs
private void getComboBoxesValues() {
    
        try {

            connection = Database.connectDB();

            String sql = "SELECT * FROM Locations";

            // Execute the SQL statement
            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                // Add the city names to the combo boxes
                while (resultSet.next()) {
                    String cityName = resultSet.getString("CityName");
                    startCityComboBox.getItems().add(cityName);
                    endCityComboBox.getItems().add(cityName);
                }

                Database.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}



