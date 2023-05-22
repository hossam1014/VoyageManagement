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
import javafx.scene.shape.Line;
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
        
        // btn go back to main page 
        Button btnback = new Button("Back");
        btnback.setPrefSize(150, 50);
        btnback.setLayoutX(25);
        btnback.setLayoutY(390);
        
        //Button hotel  go to hotel page
        Button btnhotel = new Button("Hotel");
        btnhotel.setPrefSize(150, 50);
        btnhotel.setLayoutX(25);
        btnhotel.setLayoutY(320);

        startCityComboBox = new ComboBox<>();
        startCityComboBox.setPrefSize(100, 38);
        endCityComboBox = new ComboBox<>();
        endCityComboBox.setPrefSize(100, 38);

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
        
        //label for write on it "distance"
        Label lbldis = new Label("Distance");
        lbldis.setLayoutX(435);
        lbldis.setLayoutY(200);
        lbldis.setPrefSize(80, 30);
        
        //label for show distance
        Label lbldist = new Label("plplpl");
        lbldist.setLayoutX(535);
        lbldist.setLayoutY(200);
        lbldist.setPrefSize(80, 30);
        
        // line vertical between combo box and datepacker
        Line l1 = new Line();
        l1.setStartX(525);
        l1.setStartY(42);
        l1.setEndX(525);
        l1.setEndY(190);
        
        // line herziontal with two labels distance
        Line l2 = new Line();
        l2.setStartX(255);
        l2.setStartY(190);
        l2.setEndX(795);
        l2.setEndY(190);
        
        //line herziontal with car , bus , train , flaght buttons
        Line l3 = new Line();
        l3.setStartX(255);
        l3.setStartY(240);
        l3.setEndX(795);
        l3.setEndY(240);
        
        // line under buttons
        Line l4 = new Line();
        l4.setStartX(255);
        l4.setStartY(310);
        l4.setEndX(795);
        l4.setEndY(310);
        
        //edit propertis for buttons
        btncar.setPrefSize(120, 48);
        btntrain.setPrefSize(120, 48);
        btnflaght.setPrefSize(120, 48);
        btnbus.setPrefSize(120, 48);
        
        //add style for page
        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

        //put control in h box
        HBox h1 = new HBox(10);
        h1.setLayoutX(20);
        h1.setLayoutY(42);
        h1.getChildren().addAll(lblfrom, startCityComboBox, lblto, endCityComboBox);
        h1.setPrefSize(390, 38);
        
        
        // add buttons in hbox
        HBox h2 = new HBox(20);
        h2.setPrefSize(540, 50);
        h2.setLayoutX(255);
        h2.setLayoutY(250);
        h2.getChildren().addAll(btncar, btntrain, btnflaght, btnbus);

        //add button back to navigator
        navigator.getChildren().addAll(btnback, btnhotel);
        
        //add controller to right page
        right.getChildren().addAll(h1, date, date_in, h2,l1,l2,lbldis,lbldist,l3,l4);
        
        HBox hBox = (HBox) this.getRoot();
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
            right.getChildren().remove(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().add(carPage);
        });
        
        // handler for bus button
        btnbus.setOnAction(x -> {
            right.getChildren().add(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().remove(carPage);
        });
        
        // handler for flaght button
        btntrain.setOnAction(x -> {
            right.getChildren().remove(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().add(trainPage);
            right.getChildren().remove(carPage);
        });
        
        // handler for train button
        btnflaght.setOnAction(x -> {
            right.getChildren().remove(busPage);
            right.getChildren().add(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().remove(carPage);
        });
        
        // handler for  back button
        btnback.setOnAction(e -> {
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });
        
        // handler for hotel button
        btnhotel.setOnAction(e -> {
            primaryStage.setScene(new Hotel_Resevation(primaryStage, user));
        });
        
        
        // handle Date
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




