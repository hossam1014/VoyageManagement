
package main_page.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Models.Reservation;
import main_page.Models.User;

/**
 *
 * @author Ehab
 */
public class Bill extends Scene {
    
    public Bill(Stage primaryStage, User user, Reservation reservation) {
        super(new StackPane(),1250, 760);
        StackPane root = (StackPane)this.getRoot();
        
        root.setStyle("-fx-background-image: url('images/badkground_every_thing.jpg');");        
        
        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

        VBox page = new VBox(50);
        root.getChildren().add(page);
        page.setAlignment(Pos.CENTER);

        GridPane bill_gridPane = new GridPane();
        bill_gridPane.setAlignment(Pos.CENTER);
        bill_gridPane.setPadding(new Insets(20));
        bill_gridPane.setHgap(30);
        bill_gridPane.setVgap(15);

        /* Labels */
        Label username = new Label("Username");
        
        Label travllingFrom = new Label("Travlling From");
        Label travllingTo = new Label("Travlling To");
        Label tranportaionType = new Label("Tranportaion Type");
        Label tripName = new Label("Trip Name");
        Label tripPrice = new Label("Trip Price");
        
        Label hotelName = new Label("Hotel Name");
        Label hotelCheckInDate = new Label("Hotel Check-in Date");
        Label hotelCheckOutDate = new Label("Hotel Check-out Date ");
        Label hotelPrice = new Label("Total Price");

        /* Values from DataBase */
        TextField username_val = new TextField();
        
        TextField travllingFrom_val = new TextField();
        TextField travllingTo_val = new TextField();
        TextField tranportaionType_val = new TextField();
        TextField tripName_val = new TextField();
        TextField tripPrice_val = new TextField();
        
        TextField hotelName_val = new TextField();
        TextField hotelCheckInDate_val = new TextField();
        TextField hotelCheckOutDate_val = new TextField();
        TextField hotelPrice_val = new TextField();
        
        /* TextFields setEditable -> false */
        username_val.setEditable(false);
        
        travllingFrom_val.setEditable(false);
        travllingTo_val.setEditable(false);
        tranportaionType_val.setEditable(false);
        tripName_val.setEditable(false);
        tripPrice_val.setEditable(false);
        
        hotelName_val.setEditable(false);
        hotelCheckInDate_val.setEditable(false);
        hotelCheckOutDate_val.setEditable(false);
        hotelPrice_val.setEditable(false);
        
        /* Set Size */
        username_val.setMinWidth(160);
        username_val.setMaxWidth(160);
        
        
        travllingFrom_val.setMinWidth(160);
        travllingFrom_val.setMaxWidth(160);
        travllingTo_val.setMinWidth(160);
        travllingTo_val.setMaxWidth(160);
        tranportaionType_val.setMinWidth(160);
        tranportaionType_val.setMaxWidth(160);
        tripName_val.setMinWidth(160);
        tripName_val.setMaxWidth(160);
        tripPrice_val.setMinWidth(160);
        tripPrice_val.setMaxWidth(160);
        
        hotelName_val.setMinWidth(160);
        hotelName_val.setMaxWidth(160);
        hotelCheckInDate_val.setMinWidth(160);
        hotelCheckInDate_val.setMaxWidth(160);
        hotelCheckOutDate_val.setMinWidth(160);
        hotelCheckOutDate_val.setMaxWidth(160);
        hotelPrice_val.setMinWidth(160);
        hotelPrice_val.setMaxWidth(160);
        
        /* Set Data */
        username_val.setText(user.getUserName());
        
        travllingFrom_val.setText(""+reservation.getFrom());
        travllingTo_val.setText(""+reservation.getTo());
        tranportaionType_val.setText(""+reservation.getTravelType());
        tripName_val.setText(""+reservation.getTripName());
        tripPrice_val.setText(""+reservation.getTripPrice());
        
        hotelName_val.setText(""+reservation.getHotelName());
        hotelCheckInDate_val.setText(""+reservation.getHotel_CheckInDate());
        hotelCheckOutDate_val.setText(""+reservation.getHotel_CheckOutDate());
        hotelPrice_val.setText(""+reservation.getTotalPrice());

        /* Adding Labels & Values */
        bill_gridPane.addRow(0, username, username_val);
        
        bill_gridPane.addRow(1, travllingFrom, travllingFrom_val);
        bill_gridPane.addRow(2, travllingTo, travllingTo_val);
        bill_gridPane.addRow(3, tranportaionType, tranportaionType_val);
        bill_gridPane.addRow(4, tripName, tripName_val);
        bill_gridPane.addRow(5, tripPrice, tripPrice_val);
        
        bill_gridPane.addRow(6, hotelName, hotelName_val);
        bill_gridPane.addRow(7, hotelCheckInDate, hotelCheckInDate_val);
        bill_gridPane.addRow(8, hotelCheckOutDate, hotelCheckOutDate_val);
        bill_gridPane.addRow(9, hotelPrice, hotelPrice_val);

        /* Button to go back to main page */
        Button goToMainPage = new Button("Home Page");
        goToMainPage.getStyleClass().add("custom-button");
        goToMainPage.setPrefSize(90, 35);

        goToMainPage.setOnAction(x -> {
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });

        /* get children of the page */
        page.getChildren().addAll(bill_gridPane, goToMainPage);
    }
}
