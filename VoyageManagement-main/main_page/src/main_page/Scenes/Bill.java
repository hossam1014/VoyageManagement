/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import main_page.Models.User;

/**
 *
 * @author Ehab
 */
public class Bill extends Scene {
    
    
    public Bill(Stage primaryStage, User user) {
        super(new StackPane(),1250, 760);
        StackPane root = (StackPane)this.getRoot();
        
        root.setStyle("-fx-background-color: #e5eff1");
        
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
        Label tripDate = new Label("Trip Date: ");
        Label hotelCheckInDate = new Label("Hotel Check-in Date");
        Label hotelCheckOutDate = new Label("Hotel Check-out Date ");

        /* Values from DataBase */
        TextField username_val = new TextField();
        TextField travllingFrom_val = new TextField();
        TextField travllingTo_val = new TextField();
        TextField tranportaionType_val = new TextField();
        TextField tripDate_val = new TextField();
        TextField hotelCheckInDate_val = new TextField();
        TextField hotelCheckOutDate_val = new TextField();
        
        /* TextFields setEditable -> false */
        username_val.setEditable(false);
        travllingFrom_val.setEditable(false);
        travllingTo_val.setEditable(false);
        tranportaionType_val.setEditable(false);
        tripDate_val.setEditable(false);
        hotelCheckInDate_val.setEditable(false);
        hotelCheckOutDate_val.setEditable(false);
        
        /* Set Size */
        username_val.setMinWidth(160);
        username_val.setMaxWidth(160);
        travllingFrom_val.setMinWidth(160);
        travllingFrom_val.setMaxWidth(160);
        travllingTo_val.setMinWidth(160);
        travllingTo_val.setMaxWidth(160);
        tranportaionType_val.setMinWidth(160);
        tranportaionType_val.setMaxWidth(160);
        tripDate_val.setMinWidth(160);
        tripDate_val.setMaxWidth(160);
        hotelCheckInDate_val.setMinWidth(160);
        hotelCheckInDate_val.setMaxWidth(160);
        hotelCheckOutDate_val.setMinWidth(160);
        hotelCheckOutDate_val.setMaxWidth(160);

        /* Adding Labels & Values */
        bill_gridPane.addRow(0, username, username_val);
        bill_gridPane.addRow(1, travllingFrom, travllingFrom_val);
        bill_gridPane.addRow(2, travllingTo, travllingTo_val);
        bill_gridPane.addRow(3, tranportaionType, tranportaionType_val);
        bill_gridPane.addRow(4, tripDate, tripDate_val);
        bill_gridPane.addRow(5, hotelCheckInDate, hotelCheckInDate_val);
        bill_gridPane.addRow(6, hotelCheckOutDate, hotelCheckOutDate_val);

        /* Button to go back to main page */
        Button goToMainPage = new Button("Back");
        goToMainPage.getStyleClass().add("custom-button");
        goToMainPage.setPrefSize(90, 35);

        goToMainPage.setOnAction(x -> {
            primaryStage.setScene(new main_page_demo(primaryStage, user));
         //   primaryStage.setScene(new main_page_demo(primaryStage));

        });

        /* get children of the page */
        page.getChildren().addAll(bill_gridPane, goToMainPage);
    }
}
