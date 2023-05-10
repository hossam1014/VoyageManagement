package main_page;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main_page extends Application {

    Scene home_page, scene;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        HBox home_pane = new HBox();
        VBox root = new VBox(10);
        VBox navigator = new VBox(10);
        HBox h1 = new HBox(10);
        root.setAlignment(Pos.CENTER);
        h1.setAlignment(Pos.CENTER);

        Button btn_login = new Button("Login");
        Button btn_signup = new Button("Sign up");
        Button travel_booking = new Button("Traveling");
        Button hotel_booking = new Button("Hotels");
        Button btn_voiage_info = new Button("Voyage info");
        Button btn_user_info = new Button("User info");
        Button btn_tools = new Button("Tools");

        Label lbl_username = new Label("User Name");

        Line l1 = new Line();
        l1.setScaleX(1);
        l1.setScaleY(1);
        l1.setScaleZ(1);
        l1.setLayoutX(129);
        l1.setLayoutY(226);
        l1.setStartX(-127);
        l1.setStartY(0);
        l1.setEndX(212);
        l1.setEndY(0);
        l1.setStroke(Color.valueOf("#00FFCA"));

        // adding the background to the main page.
        root.setStyle("-fx-background-image: url('images/background_main.png');"
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size: 1000 700;"
                + "-fx-background-position: center center;");

        //styling buttons
        btn_login.setMinSize(150, 35);
        btn_login.setStyle(
                "-fx-background-color: #05BFDB;"
                + "-fx-text-fill: #0A4D68;"
                + "-fx-background-radius: 20px;"
        );

        btn_signup.setMinSize(150, 35);
        btn_signup.setStyle(
                "-fx-background-color: #05BFDB;"
                + "-fx-text-fill: #0A4D68;"
                + "-fx-background-radius: 20px;"
        );

        travel_booking.setMinSize(150, 35);
        travel_booking.setStyle(
                "-fx-background-color: #05BFDB;"
                + "-fx-text-fill: #0A4D68;"
                + "-fx-background-radius: 20px;"
        );
        hotel_booking.setMinSize(150, 35);
        hotel_booking.setStyle(
                "-fx-background-color: #05BFDB;"
                + "-fx-text-fill: #0A4D68;"
                + "-fx-background-radius: 20px;"
        );
        btn_voiage_info.setMinSize(150, 35);
        btn_voiage_info.setStyle(
                "-fx-background-color: #05BFDB;"
                + "-fx-text-fill: #0A4D68;"
                + "-fx-background-radius: 20px;"
        );
        btn_user_info.setMinSize(150, 35);
        btn_user_info.setStyle(
                "-fx-background-color: #05BFDB;"
                + "-fx-text-fill: #0A4D68;"
                + "-fx-background-radius: 20px;"
        );
        btn_tools.setMinSize(150, 35);
        btn_tools.setStyle(
                "-fx-background-color: #05BFDB;"
                + "-fx-text-fill: #0A4D68;"
                + "-fx-background-radius: 20px;"
        );

        //styling labels
        lbl_username.setPadding(new Insets(100));

        //styling panes
        navigator.setAlignment(Pos.TOP_CENTER);
        navigator.setMinSize(200, 760);
        navigator.setStyle("-fx-background-color: linear-gradient(to bottom right, #0A4D68, #00FFCA)");

        home_pane.setMinSize(200, 760);

        // adding noods to the h & v box
        h1.getChildren().addAll(btn_login, btn_signup);
        root.getChildren().addAll(h1);
        navigator.getChildren().addAll(lbl_username, l1, travel_booking, hotel_booking,
                btn_voiage_info, btn_user_info, btn_tools);
        home_pane.getChildren().addAll(navigator);

        // event handling
        btn_login.setOnAction(e -> {
            primaryStage.setScene(home_page);
        });
        btn_signup.setOnAction(e -> {
            primaryStage.setScene(home_page);
        });

        // creating the scene
        scene = new Scene(root, 1250, 760);
        home_page = new Scene(home_pane, 1250, 760);

        primaryStage.setTitle("Main");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
