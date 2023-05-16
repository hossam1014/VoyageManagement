///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package main_page;
//
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Stage;
//
///**
// *
// * @author Ehab
// */
//public class H extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        /**
//         * ** Hotel Reservation Page ***
//         */
//        /* Stack pane */
//        StackPane root = new StackPane();
//        root.setPrefSize(1250, 759);
//
//        /* H Box for two AnchorPane */
//        HBox anc = new HBox();
//
//        /* AnchorPane left-page & right-page */
//        AnchorPane left = new AnchorPane();
//        AnchorPane right = new AnchorPane();
//
//        /* get Childern */
//        anc.getChildren().addAll(left, right);
//        root.getChildren().addAll(anc);
//
//        /* set Size and Style for the page */
//        left.setPrefSize(341, 759);
//        right.setPrefSize(920, 759);
//        left.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf);");
//        right.setStyle("-fx-background-color: white");
//
//        /* Left page controls */
//        /**
//         * previous page button *
//         */
//        Button prev_page = new Button("Previous Page");
//        prev_page.setLayoutX(106);
//        prev_page.setLayoutY(653);
//        prev_page.setPrefSize(130, 48);
//        prev_page.setStyle("-fx-font: 18 Serif; -fx-base: #06063f;");
//
//        /**
//         * Username Label *
//         */
//        Label username = new Label("Username");
//        username.setAlignment(Pos.CENTER);
//        username.setLayoutX(69);
//        username.setLayoutY(151);
//        username.setPrefSize(203, 75);
//        username.setTextFill(Color.WHITE);
//        username.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
//
//        /**
//         * User icon *
//         */
//        /**
//         * Line 1 *
//         */
//        Line l1 = new Line();
//        l1.setScaleX(1);
//        l1.setScaleY(1);
//        l1.setScaleZ(1);
//        l1.setLayoutX(129);
//        l1.setLayoutY(226);
//        l1.setStartX(-127);
//        l1.setStartY(0);
//        l1.setEndX(212);
//        l1.setEndY(0);
//        l1.setStroke(Color.ALICEBLUE);
//
//        /* get childern of left page */
//        left.getChildren().addAll(prev_page, username, l1);
//
//        /* Right page controls */
// /* Font Types */
//        Font font_Labels = Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 33);
//        Font font_radio = Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 21);
//        Font font_buttons = Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 19);
//        Font font_room = Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29);
//
//        /* Hotel Type */
//        /**
//         * Hotel Type Label *
//         */
//        Label H_type = new Label("Hotel Type");
//        H_type.setAlignment(Pos.CENTER);
//        H_type.setLayoutX(334);
//        H_type.setLayoutY(35);
//        H_type.setPrefSize(192, 48);
//        H_type.setTextFill(Color.DARKBLUE);
//        H_type.setFont(font_Labels);
//
//        /**
//         * Hotel Type Labels Buttons *
//         */
//        RadioButton rad_b1 = new RadioButton("5 Star");
//        rad_b1.setPrefSize(111, 38);
//        rad_b1.setLayoutX(122);
//        rad_b1.setLayoutY(99);
//        rad_b1.setFont(font_radio);
//        rad_b1.setTextFill(Color.valueOf("#517bba"));
//
//        RadioButton rad_b2 = new RadioButton("4 Star");
//        rad_b2.setPrefSize(111, 38);
//        rad_b2.setLayoutX(261);
//        rad_b2.setLayoutY(99);
//        rad_b2.setFont(font_radio);
//        rad_b2.setTextFill(Color.valueOf("#517bba"));
//
//        RadioButton rad_b3 = new RadioButton("3 Star");
//        rad_b3.setPrefSize(111, 38);
//        rad_b3.setLayoutX(410);
//        rad_b3.setLayoutY(99);
//        rad_b3.setFont(font_radio);
//        rad_b3.setTextFill(Color.valueOf("#517bba"));
//
//        RadioButton rad_b4 = new RadioButton("Motel");
//        rad_b4.setPrefSize(111, 38);
//        rad_b4.setLayoutX(551);
//        rad_b4.setLayoutY(99);
//        rad_b4.setFont(font_radio);
//        rad_b4.setTextFill(Color.valueOf("#517bba"));
//
//        Button b_type_select = new Button("Select");
//        b_type_select.setPrefSize(83, 38);
//        b_type_select.setLayoutX(732);
//        b_type_select.setLayoutY(99);
//        b_type_select.setFont(font_buttons);
//        b_type_select.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
//        b_type_select.setTextFill(Color.WHITE);
//
//        /* Hotel Room */
//        Label R_type = new Label("Room Type");
//        R_type.setAlignment(Pos.CENTER);
//        R_type.setLayoutX(334);
//        R_type.setLayoutY(176);
//        R_type.setPrefSize(192, 48);
//        R_type.setTextFill(Color.DARKBLUE);
//        R_type.setFont(font_Labels);
//
//        /* Room Price */
//        Label r_price = new Label("Price");
//        r_price.setLayoutX(200);
//        r_price.setLayoutY(224);
//        r_price.setPrefSize(141, 48);
//        r_price.setTextFill(Color.DARKBLUE);
//        r_price.setFont(font_room);
//
//        RadioButton rad_b5 = new RadioButton("Economy");
//        rad_b5.setPrefSize(120, 38);
//        rad_b5.setLayoutX(130);
//        rad_b5.setLayoutY(277);
//        rad_b5.setFont(font_radio);
//        rad_b5.setTextFill(Color.valueOf("#517bba"));
//
//        RadioButton rad_b6 = new RadioButton("Normal");
//        rad_b6.setPrefSize(120, 38);
//        rad_b6.setLayoutX(130);
//        rad_b6.setLayoutY(320);
//        rad_b6.setFont(font_radio);
//        rad_b6.setTextFill(Color.valueOf("#517bba"));
//
//        RadioButton rad_b7 = new RadioButton("VIP");
//        rad_b7.setPrefSize(120, 38);
//        rad_b7.setLayoutX(130);
//        rad_b7.setLayoutY(361);
//        rad_b7.setFont(font_radio);
//        rad_b7.setTextFill(Color.valueOf("#517bba"));
//
//        /* Room Capacity */
//        Label r_capacity = new Label("Capacity");
//        r_capacity.setLayoutX(590);
//        r_capacity.setLayoutY(224);
//        r_capacity.setPrefSize(141, 48);
//        r_capacity.setTextFill(Color.DARKBLUE);
//        r_capacity.setFont(font_room);
//
//        RadioButton rad_b8 = new RadioButton("Single");
//        rad_b8.setPrefSize(111, 38);
//        rad_b8.setLayoutX(538);
//        rad_b8.setLayoutY(277);
//        rad_b8.setFont(font_radio);
//        rad_b8.setTextFill(Color.valueOf("#517bba"));
//
//        RadioButton rad_b9 = new RadioButton("Double");
//        rad_b9.setPrefSize(111, 38);
//        rad_b9.setLayoutX(538);
//        rad_b9.setLayoutY(320);
//        rad_b9.setFont(font_radio);
//        rad_b9.setTextFill(Color.valueOf("#517bba"));
//
//        RadioButton rad_b10 = new RadioButton("More");
//        rad_b10.setPrefSize(111, 38);
//        rad_b10.setLayoutX(538);
//        rad_b10.setLayoutY(361);
//        rad_b10.setFont(font_radio);
//        rad_b10.setTextFill(Color.valueOf("#517bba"));
//
//        Button r_type_select = new Button("Select");
//        r_type_select.setPrefSize(83, 38);
//        r_type_select.setLayoutX(732);
//        r_type_select.setLayoutY(360);
//        r_type_select.setFont(font_buttons);
//        r_type_select.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
//        r_type_select.setTextFill(Color.WHITE);
//
//        /* Check Date */
//        Label l_in = new Label("Check-in Date");
//        Label l_out = new Label("Check-out Date");
//        DatePicker date_in = new DatePicker();
//        DatePicker date_out = new DatePicker();
//
//        l_in.setLayoutX(113);
//        l_in.setLayoutY(448);
//        l_in.setPrefSize(141, 38);
//        l_in.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 19));
//        l_in.setTextFill(Color.DARKBLUE);
//        l_out.setLayoutX(516);
//        l_out.setLayoutY(448);
//        l_out.setPrefSize(141, 38);
//        l_out.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 19));
//        l_out.setTextFill(Color.DARKBLUE);
//
//        date_in.setLayoutX(113);
//        date_in.setLayoutY(493);
//        date_in.setPrefSize(203, 38);
//        date_in.setPromptText("DD-MM-YYYY");
//        date_out.setLayoutX(516);
//        date_out.setLayoutY(493);
//        date_out.setPrefSize(203, 38);
//        date_out.setPromptText("DD-MM-YYYY");
//
//        /* confirm Booking */
//        Label booking_price = new Label("Total Price: ");
//        booking_price.setAlignment(Pos.CENTER_RIGHT);
//        booking_price.setLayoutX(307);
//        booking_price.setLayoutY(547);
//        booking_price.setPrefSize(130, 38);
//        booking_price.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 23));
//
//        Label total_price = new Label("70 $");
//        total_price.setAlignment(Pos.CENTER);
//        total_price.setLayoutX(437);
//        total_price.setLayoutY(547);
//        total_price.setPrefSize(111, 38);
//        total_price.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 23));
//
//        Button confirm = new Button("Confirm");
//        confirm.setLayoutX(381);
//        confirm.setLayoutY(600);
//        confirm.setPrefSize(97, 48);
//        confirm.setFont(font_buttons);
//        confirm.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
//        confirm.setTextFill(Color.WHITE);
//
//        Label room_id = new Label("Your room ID: ");
//        room_id.setAlignment(Pos.CENTER_RIGHT);
//        room_id.setLayoutX(304);
//        room_id.setLayoutY(650);
//        room_id.setPrefSize(155, 48);
//        room_id.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 23));
//
//        Label id = new Label("13");
//        id.setAlignment(Pos.CENTER_LEFT);
//        id.setLayoutX(468);
//        id.setLayoutY(650);
//        id.setPrefSize(97, 48);
//        id.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 23));
//
//        Label welcome = new Label("Wish you a nice voyage");
//        welcome.setAlignment(Pos.CENTER);
//        welcome.setLayoutX(286);
//        welcome.setLayoutY(705);
//        welcome.setPrefSize(289, 38);
//        welcome.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.ITALIC, 25));
//        welcome.setTextFill(Color.valueOf("#517bba"));
//
//        /* Lines */
//        Line l2 = new Line();
//        l2.setScaleX(1);
//        l2.setScaleY(1);
//        l2.setScaleZ(1);
//        l2.setLayoutX(436);
//        l2.setLayoutY(162);
//        l2.setStartX(-344);
//        l2.setStartY(9);
//        l2.setEndX(402);
//        l2.setEndY(9);
//        l2.setStroke(Color.valueOf("#22406b"));
//
//        Line l3 = new Line();
//        l3.setScaleX(1);
//        l3.setScaleY(1);
//        l3.setScaleZ(1);
//        l3.setLayoutX(436);
//        l3.setLayoutY(423);
//        l3.setStartX(-344);
//        l3.setStartY(9);
//        l3.setEndX(402);
//        l3.setEndY(9);
//        l3.setStroke(Color.valueOf("#22406b"));
//
//        Line l4 = new Line();
//        l4.setScaleX(1);
//        l4.setScaleY(1);
//        l4.setScaleZ(1);
//        l4.setLayoutX(430);
//        l4.setLayoutY(309);
//        l4.setStartX(0);
//        l4.setStartY(-68);
//        l4.setEndX(0);
//        l4.setEndY(89);
//        l4.setStroke(Color.valueOf("#22406b"));
//
//        /* get Children of right page */
//        right.getChildren().addAll(H_type, rad_b1, rad_b2, rad_b3, rad_b4, b_type_select, R_type, l2,
//                r_price, rad_b5, rad_b6, rad_b7, r_capacity, rad_b8, rad_b9, rad_b10, r_type_select, l3, l4,
//                l_in, l_out, date_in, date_out,
//                booking_price, total_price, confirm, room_id, id, welcome);
//
//        Scene traveling = new Scene(root);
//        primaryStage.setScene(traveling);
//        primaryStage.setTitle("Travella");
//        primaryStage.setResizable(false);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//}
