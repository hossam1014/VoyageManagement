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
    public static Button btnnext = new Button("Next");

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
        btnback.setLayoutY(330);
        
        // two cmbobox 
        startCityComboBox = new ComboBox<>();
        startCityComboBox.setPrefSize(100, 38);
        endCityComboBox = new ComboBox<>();
        endCityComboBox.setPrefSize(100, 38);
        endCityComboBox.setLayoutX(650);
        endCityComboBox.setLayoutY(42);

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
        Label lbldis = new Label("Distance");
        lbldis.setLayoutX(410);
        lbldis.setLayoutY(100);
        lbldis.setPrefSize(80, 30);
        
        //label for show distance
        Label lbldist = new Label("plplpl");
        lbldist.setLayoutX(510);
        lbldist.setLayoutY(100);
        lbldist.setPrefSize(80, 30);
        
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
        
        //button next properties
        btnnext.setPrefSize(120, 48);
        btnnext.setLayoutX(450);
        btnnext.setLayoutY(570);
        btnnext.setDisable(true);
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
        right.getChildren().addAll(h1, h2,lbldis,lbldist,l3,l4,btnnext,lblto,endCityComboBox);
        
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
            btnnext.setVisible(true);
        });
        
        // handler for bus button
        btnbus.setOnAction(x -> {
            right.getChildren().add(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().remove(carPage);
            btnnext.setVisible(true);
        });
        
        // handler for flaght button
        btntrain.setOnAction(x -> {
            right.getChildren().remove(busPage);
            right.getChildren().remove(flightPage);
            right.getChildren().add(trainPage);
            right.getChildren().remove(carPage);
            btnnext.setVisible(true);
        });
        
        // handler for train button
        btnflaght.setOnAction(x -> {
            right.getChildren().remove(busPage);
            right.getChildren().add(flightPage);
            right.getChildren().remove(trainPage);
            right.getChildren().remove(carPage);
            btnnext.setVisible(true);
            
        });
        
        // handler for  back button
        btnback.setOnAction(e -> {
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });
     
    }              
}
