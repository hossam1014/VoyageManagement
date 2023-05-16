package main_page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author amir
 */
public class main_page_demo extends Scene {

    public main_page_demo(Stage primaryStage) {
        super(new VBox(20), 1250, 760);
        VBox vBox = (VBox) this.getRoot();
        vBox.setAlignment(Pos.CENTER);
        vBox.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        HBox main_page = new HBox(20);

        VBox info = new VBox(20);
        info.setAlignment(Pos.CENTER);
        info.setPrefSize(1050, 760);
        info.setId("home_page_info");
        info.getStyleClass().add("home_page_info");
        vBox.setStyle("-fx-background-image: url('images/sky.png');");

        VBox navigator = new VBox(20);
        navigator.setPadding(new Insets(10));
        navigator.setAlignment(Pos.TOP_CENTER);
        navigator.setPrefSize(200, 760);
        navigator.setId("navigator");
        navigator.getStyleClass().add("navigator");

        GridPane user_info = new GridPane();
        user_info.setPadding(new Insets(10));
        user_info.setHgap(10);
        user_info.setVgap(10);
        user_info.setId("user_info");

        GridPane trip_info = new GridPane();
        trip_info.setPadding(new Insets(10));
        trip_info.setHgap(10);
        trip_info.setVgap(10);
        trip_info.setId("trip_info");

        // navigator part of code //
        // adding the photo of the user, dont forget to change adel shakal's photo :)
        Circle img_circle = new Circle(75);
        Image user_photo = new Image("images/user_photo.jpg", 300, 300, false, true);
        img_circle.setFill(new ImagePattern(user_photo));

        // there will be some action handling here amir
        Button btn_tarvel = new Button("Traveling");
        Button btn_hotel = new Button("Hotels");
        Button btn_tools = new Button("Tools");

        btn_tarvel.setMinSize(150, 35);
        btn_hotel.setMinSize(150, 35);
        btn_tools.setMinSize(150, 35);

        // there will be some database code here so dont forget hosam  -----------------------------------------------------------------------------------------
        Label user_name = new Label("Adel Shakal");
        user_name.setId("user_name_nav");
        user_name.getStyleClass().add("user_name_nav");

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
        navigator.setPadding(new Insets(20));

        //user_info part
        Label lbl_user_info = new Label("User information");
        lbl_user_info.getStyleClass().add("user_name_nav");
        Label lbl_user_name = new Label("User name");
        Label lbl_email = new Label("Email");
        Label lbl_number = new Label("Phone number");
        Label lbl_age = new Label("Age");

        // back end and database part -----------------------------------------------------------------------------------------------------------------------------
        // you have to get all these data from sign, login, traveling and hotel pages
        TextField txt_user_name = new TextField();
        TextField txt_email = new TextField();
        TextField txt_number = new TextField();
        TextField txt_age = new TextField();

        txt_user_name.setEditable(false);
        txt_email.setEditable(false);
        txt_number.setEditable(false);
        txt_age.setEditable(false);

        user_info.add(lbl_user_name, 0, 0);
        user_info.add(txt_user_name, 1, 0);
        user_info.add(lbl_email, 0, 1);
        user_info.add(txt_email, 1, 1);
        user_info.add(lbl_number, 0, 2);
        user_info.add(txt_number, 1, 2);
        user_info.add(lbl_age, 0, 3);
        user_info.add(txt_age, 1, 3);
//        user_info.add(change, 0, 4, 2, 1);

        // trip info part
        // some back end and database here also hosam ----------------------------------------------------------------------------------------
        Label lbl_destination = new Label("Destination");
        Label lbl_current_location = new Label("Current Location");
        Label lbl_hotel_name = new Label("Hotel Name");
        Label lbl_trave_info = new Label("Traveling Information");

        TextField txt_destination = new TextField();
        TextField txt_current_location = new TextField();
        TextField txt_hotel_name = new TextField();

        txt_destination.setEditable(false);
        txt_current_location.setEditable(false);
        txt_hotel_name.setEditable(false);

        Button change = new Button("Change");

        change.setOnAction(e -> {
            txt_user_name.setEditable(true);
            txt_email.setEditable(true);
            txt_number.setEditable(true);
            txt_age.setEditable(true);
            txt_destination.setEditable(true);
            txt_current_location.setEditable(true);
            txt_hotel_name.setEditable(true);

        });

        trip_info.add(lbl_destination, 0, 0);
        trip_info.add(txt_destination, 1, 0);
        trip_info.add(lbl_current_location, 0, 2);
        trip_info.add(txt_current_location, 1, 2);
        trip_info.add(lbl_hotel_name, 0, 3);
        trip_info.add(txt_hotel_name, 1, 3);
        trip_info.add(change, 0, 4, 2, 1);

        navigator.getChildren().addAll(img_circle, user_name, l1, btn_tarvel, btn_hotel, btn_tools);

        info.getChildren().addAll(lbl_user_info, user_info, lbl_trave_info, trip_info);

        main_page.getChildren().addAll(navigator, info);

        vBox.getChildren().add(main_page);

        primaryStage.setTitle("home page");
        primaryStage.show();
    }
}