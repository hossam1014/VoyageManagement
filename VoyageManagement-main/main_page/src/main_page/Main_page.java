    package main_page;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Handlers.MyReservationsHandler;
import main_page.Models.Reservation;
import main_page.Scenes.Admin_reports_page;
import main_page.Scenes.Currency_Converter;
import main_page.Scenes.Hotel_Resevation;
import main_page.Scenes.LoginPage;
import main_page.Scenes.MyReservationPage;
import main_page.Scenes.SignUpPage;
import main_page.Scenes.main_page_demo;
import main_page.Scenes.user_reports_page;

public class Main_page extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox main_page = new VBox(20);
        main_page.setId("main_page");
        main_page.getStyleClass().add("main_page");
        HBox buttons_box = new HBox(20);

//        Button test = new Button("test");
        Button login_btn = new Button("Log in");
        Button signup_btn = new Button("Sign up");
        buttons_box.getChildren().addAll(login_btn, signup_btn);
        buttons_box.setAlignment(Pos.CENTER);

        login_btn.setMinSize(150, 40);
        signup_btn.setMinSize(150, 40);

        main_page.getChildren().addAll(buttons_box);
        main_page.setAlignment(Pos.CENTER);

        main_page.setStyle("-fx-background-image: url('images/background_main.png');");

        login_btn.setOnAction(e -> {
            primaryStage.setScene(new LoginPage(primaryStage));
        });

        signup_btn.setOnAction(e -> {
            primaryStage.setScene(new SignUpPage(primaryStage));
        });

        Scene scene = new Scene(main_page, 1250, 760);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("main page");
//        primaryStage.setScene(new main_page_demo(primaryStage));
//        primaryStage.setScene(scene);
//        primaryStage.setScene(new Admin_reports_page(primaryStage));
//        primaryStage.setScene(new user_reports_page(primaryStage));
//        primaryStage.setScene(new Currency_Converter(primaryStage));

//        MyReservationsHandler handler = new MyReservationsHandler(1);
        
//        primaryStage.setScene(new MyReservationPage(primaryStage, handler));
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     * 
     * remaining parts
     * 1 - distance calculator
     * 2 - styling currency_converter
     *     hotel booking
     *     flight booking and its sub pages
     * 
     * 
     */
    public static void main(String[] args) {
        launch(args);
    }

}
