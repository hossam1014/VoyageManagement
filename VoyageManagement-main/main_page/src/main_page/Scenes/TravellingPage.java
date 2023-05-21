package main_page.Scenes;

import java.sql.Connection;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main_page.Handlers.TravellingPageHundler;
import main_page.Models.User;
import  main_page.Scenes.CarButtonPage;
/**
 *
 * @author sayed
 */

public class TravellingPage extends Scene {

    private final ComboBox<String> startCityComboBox;
    private final ComboBox<String> endCityComboBox;

    private Connection connection;
    public static Button btncar = new Button("Car");
    public static Button btnbus = new Button("Bus");
    public static Button btntrain = new Button("Train");
    public static Button btnflaght = new Button("Flaght");
    public static Boolean information_isFilled = false;

   
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
        Button btnback = new Button("Back");
        btnback.setPrefSize(150, 50);
        btnback.setLayoutX(25);
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

        Label date = new Label("Date");
        DatePicker date_in = new DatePicker();

        date.setLayoutX(600);
        date.setLayoutY(42);
        date.setPrefSize(141, 38);
        date_in.setLayoutX(661);
        date_in.setLayoutY(42);
        date_in.setPrefSize(203, 38);
        date_in.setPromptText("DD-MM-YYYY");

        
        btncar.setPrefSize(120, 48);
        
        btntrain.setPrefSize(120, 48);

        btnflaght.setPrefSize(120, 48);
       
        btnbus.setPrefSize(120, 48);
        
        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

        //put control in h box
        HBox h1 = new HBox();
        h1.getChildren().addAll(lblfrom, startCityComboBox, lblto, endCityComboBox);
        h1.setSpacing(10);
        h1.setPrefSize(604, 48);
        
        
        // add buttons in hbox
        HBox h2 = new HBox(20);
        h2.setPrefSize(540, 50);
        h2.setLayoutX(255);
        h2.setLayoutY(250);
        h2.getChildren().addAll(btncar, btntrain, btnflaght, btnbus);

        //add button back to navigator
        navigator.getChildren().add(btnback);
        
        //add controller to right page
        right.getChildren().addAll(h1, date, date_in, h2);
        
        HBox hBox = (HBox) this.getRoot();
        hBox.getChildren().addAll(navigator, right);
        
        /*//////  
                   Back End
                              //////*/        
        
        // handler for car button
        btncar.setOnAction(x -> {
            right.getChildren().remove(new BusButtonPage());
            right.getChildren().remove(new FlaghtButtonPage());
            right.getChildren().remove(new TrainButtonPage());
            right.getChildren().add(new CarButtonPage());
        });
        
        // handler for bus button
        btnbus.setOnAction(x -> {
            right.getChildren().remove(new CarButtonPage());
            right.getChildren().remove(new FlaghtButtonPage());
            right.getChildren().remove(new TrainButtonPage());
            right.getChildren().add(new BusButtonPage());
        });
        
        // handler for flaght button
        btntrain.setOnAction(x -> {
            right.getChildren().remove(new CarButtonPage());
            right.getChildren().remove(new BusButtonPage());
            right.getChildren().remove(new TrainButtonPage());
            right.getChildren().add(new FlaghtButtonPage());
        });
        
        // handler for train button
        btnflaght.setOnAction(x -> {
            right.getChildren().remove(new CarButtonPage());
            right.getChildren().remove(new FlaghtButtonPage());
            right.getChildren().remove(new BusButtonPage());
            right.getChildren().add(new TrainButtonPage());
        });
        
        // handler for Previous page button
        btnback.setOnAction(e -> {
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });
        
        
//         handle Date
        TravellingPageHundler chack_Date = new TravellingPageHundler();
        /* Current Date */
        LocalDate current_date = LocalDate.now();

        /* Check Date Declarations */
        LocalDate[] Date = new LocalDate[1];

        /* Check-in Date */
        if(null == date_in.getValue()){
                btncar.setDisable(true);
                btnbus.setDisable(true);
                btntrain.setDisable(true);
                btnflaght.setDisable(true);
                right.getChildren().remove(new CarButtonPage());
                right.getChildren().remove(new BusButtonPage());
                right.getChildren().remove(new TrainButtonPage());
                right.getChildren().remove(new FlaghtButtonPage());
        }
        date_in.setOnAction(e -> {
            
            right.getChildren().remove(new CarButtonPage());
            right.getChildren().remove(new BusButtonPage());
            right.getChildren().remove(new TrainButtonPage());
            right.getChildren().remove(new FlaghtButtonPage());
            
            if(null == date_in.getValue()){
                btncar.setDisable(true);
                btnbus.setDisable(true);
                btntrain.setDisable(true);
                btnflaght.setDisable(true);
                right.getChildren().remove(new CarButtonPage());
                right.getChildren().remove(new BusButtonPage());
                right.getChildren().remove(new TrainButtonPage());
                right.getChildren().remove(new FlaghtButtonPage());
            }
            else{
                btncar.setDisable(false);
                btnbus.setDisable(false);
                btntrain.setDisable(false);
                btnflaght.setDisable(false);
            }
            /* Checks if Check-in date not set */
            if (null != date_in.getValue()) {
                Date[0] = date_in.getValue();
                chack_Date.setDate(Date[0]);
                
                /* ERROR: if the user enter a date less than current date */
            if (current_date.compareTo(Date[0]) > 0) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Invalid Date");
                errorAlert.setContentText("Please, Enter a valid Check-in Date");
                errorAlert.showAndWait();
                date_in.setValue(null);
            }
                chack_Date.setDate_in(date_in);
            }
        });

        
       
        //getComboBoxesValues();
       
}        
              
             

        //getComboBoxesValues();
}

//// handle two cmboboxs
//private void getComboBoxesValues() {
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
//}




