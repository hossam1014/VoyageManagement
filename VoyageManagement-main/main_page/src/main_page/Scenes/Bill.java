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
        super(new StackPane(),600, 600);
        StackPane root = (StackPane)this.getRoot();
        
        VBox page = new VBox(50);
        root.getChildren().add(page);
        page.setAlignment(Pos.CENTER);
        
        GridPane bill_gridPane = new GridPane();
        bill_gridPane.setAlignment(Pos.CENTER);
        bill_gridPane.setPadding(new Insets(20));
        bill_gridPane.setHgap(30);
        bill_gridPane.setVgap(15);
        
        /* Labels */
        Label username = new Label("Username:");   
        Label travllingFrom = new Label("Travlling From: ");
        Label travllingTo = new Label("Travlling To: ");
        Label tranportaionType = new Label("Tranportaion Type: ");
        Label tripDate = new Label("Trip Date: ");
        Label hotelCheckInDate = new Label("Hotel Check-in Date: ");
        Label hotelCheckOutDate = new Label("Hotel Check-out Date: ");
        
        /* Values from DataBase */
        Label username_val = new Label("-----");
        Label travllingFrom_val = new Label("------");
        Label travllingTo_val = new Label("------");
        Label tranportaionType_val = new Label("------");
        Label tripDate_val = new Label("------");
        Label hotelCheckInDate_val = new Label("------");
        Label hotelCheckOutDate_val = new Label("------");  
        
        /* Adding Labels & Values */
        bill_gridPane.addRow(0,username,username_val);
        bill_gridPane.addRow(1,travllingFrom,travllingFrom_val);
        bill_gridPane.addRow(2,travllingTo,travllingTo_val);
        bill_gridPane.addRow(3,tranportaionType,tranportaionType_val);
        bill_gridPane.addRow(4,tripDate,tripDate_val);
        bill_gridPane.addRow(5,hotelCheckInDate,hotelCheckInDate_val);
        bill_gridPane.addRow(6,hotelCheckOutDate,hotelCheckOutDate_val);
        
        /* Button to go back to main page */
        Button goToMainPage = new Button("Main Page");
        
        goToMainPage.setOnAction(e->{
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });
        
        /* get children of the page */
        page.getChildren().addAll(bill_gridPane,goToMainPage);
    }
}
