package main_page.Scenes;

import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main_page.Handlers.HotelFillInfoHandler;

/**
 *
 * @author Ehab
 */
public class Hotel_Resevation extends Scene {
    
    /* Global Variables used in Handler class */
    public static Label total_price = new Label("380 $");
    public static Boolean information_isFilled = false;
    public static Button confirm = new Button("Confirm Booking");
    /* End of Global Variable Declerations */
    
    public Hotel_Resevation(Stage primaryStage) {
        super(new StackPane(),1250, 760);
        StackPane root = (StackPane)this.getRoot();
        
        AnchorPane page = new AnchorPane();
        page.setStyle("-fx-background-color: white");
        
        root.getChildren().addAll(page);
        
        /** previous page button **/
        Button prev_page = new Button("Previous Page");
        prev_page.setLayoutX(50);
        prev_page.setLayoutY(350);
        prev_page.setPrefSize(120, 48);
        prev_page.setStyle("-fx-font: 16 Serif; -fx-base: DARKBLUE;");

        /* Font Types */
        Font font_Labels = Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 33);
        Font font_radio = Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 21);
        Font font_buttons = Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 19);
        Font font_room = Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29);
        
        /* Radio Buttons Declerations */
        RadioButton []rads = new RadioButton[10];
        for(int i = 0 ; i < 10 ; i++){
            rads[i] = new RadioButton(); 
            rads[i].setPrefSize(120, 38);
            rads[i].setFont(font_radio);
            rads[i].setTextFill(Color.valueOf("#517bba"));
        }
        
        /************       Hotel Type        **************/
        /* Hotel Type Label */
        Label H_type = new Label("Hotel Type");
        H_type.setAlignment(Pos.CENTER);
        H_type.setLayoutX(530);
        H_type.setLayoutY(35);
        H_type.setPrefSize(190, 48);
        H_type.setTextFill(Color.DARKBLUE);
        H_type.setFont(font_Labels);
        
        /* hotel type radio buttons in HBox */
        HBox hotelTypeRB = new HBox(40);
        hotelTypeRB.setLayoutX(340);
        hotelTypeRB.setLayoutY(99);
        hotelTypeRB.getChildren().addAll(rads[0],rads[1],rads[2],rads[3]);
          
        rads[0].setText("5 Star");
        rads[1].setText("4 Star");
        rads[2].setText("3 Star");
        rads[3].setText("Motel");
        
        /* hotel type select button */
        Button hotel_type_select = new Button("Select");
        hotel_type_select.setPrefSize(83, 38);
        hotel_type_select.setLayoutX(1000);
        hotel_type_select.setLayoutY(99);
        hotel_type_select.setFont(font_buttons);
        hotel_type_select.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        hotel_type_select.setTextFill(Color.WHITE);
        /************      End of Hotel Type        **************/
        
        /************      Hotel Room      ************/
        Label R_type = new Label("Room Type");
        R_type.setAlignment(Pos.CENTER);
        R_type.setLayoutX(530);
        R_type.setLayoutY(176);
        R_type.setPrefSize(192, 48);
        R_type.setTextFill(Color.DARKBLUE);
        R_type.setFont(font_Labels);
        
        /* Room Price */
        Label r_price = new Label("Price");
        r_price.setLayoutX(390);
        r_price.setLayoutY(215);
        r_price.setPrefSize(141, 48);
        r_price.setTextFill(Color.DARKBLUE);
        r_price.setFont(font_room);
        
        /* room price radio buttons */
        VBox roomPriceRB = new VBox(10);
        roomPriceRB.setLayoutX(340);
        roomPriceRB.setLayoutY(270);
        roomPriceRB.getChildren().addAll(rads[4],rads[5],rads[6]);
        
        rads[4].setText("Economy");  
        rads[5].setText("Normal");  
        rads[6].setText("VIP");   
        
        /* Room Capacity */
        Label r_capacity = new Label("Capacity");
        r_capacity.setLayoutX(790);
        r_capacity.setLayoutY(215);
        r_capacity.setPrefSize(141, 48);
        r_capacity.setTextFill(Color.DARKBLUE);
        r_capacity.setFont(font_room);
        
        /* room capacity radio buttons */
        VBox roomCapacityRB = new VBox(10);
        roomCapacityRB.setLayoutX(740);
        roomCapacityRB.setLayoutY(270);
        roomCapacityRB.getChildren().addAll(rads[7],rads[8],rads[9]);
        
        rads[7].setText("Single");    
        rads[8].setText("Double");      
        rads[9].setText("More");    
        
        Button room_type_select = new Button("Select");
        room_type_select.setPrefSize(83, 38);
        room_type_select.setLayoutX(1000);
        room_type_select.setLayoutY(360);
        room_type_select.setFont(font_buttons);
        room_type_select.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        room_type_select.setTextFill(Color.WHITE);
        /************     End of Hotel Room      ************/
        
        /************       Check-In & Check-out Date       ************/
        Label chk_in = new Label("Check-in Date:");
        Label chk_out = new Label("Check-out Date:");
        DatePicker date_in = new DatePicker();
        DatePicker date_out = new DatePicker();
        Button infoDone = new Button("Done");
        
        chk_in.setLayoutX(460);
        chk_in.setLayoutY(448);
        chk_in.setPrefSize(141, 38);
        chk_in.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 19));
        chk_in.setTextFill(Color.DARKBLUE);
        chk_out.setLayoutX(460);
        chk_out.setLayoutY(500);
        chk_out.setPrefSize(141, 38);
        chk_out.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 19));
        chk_out.setTextFill(Color.DARKBLUE);
        
        date_in.setLayoutX(630);
        date_in.setLayoutY(448);
        date_in.setPrefSize(203, 38);
        date_in.setPromptText("DD-MM-YYYY");
        date_out.setLayoutX(630);
        date_out.setLayoutY(500);
        date_out.setPrefSize(203, 38);
        date_out.setPromptText("DD-MM-YYYY");
        
        infoDone.setPrefSize(83, 38);
        infoDone.setLayoutX(800);
        infoDone.setLayoutY(600);
        infoDone.setFont(font_buttons);
        infoDone.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        infoDone.setTextFill(Color.WHITE);
        /************      End of Check-In & Check-out Date       ************/
        
        /************       Booking Confirmation      *************/
        /* Total Price Label */
        Label booking_price = new Label("Total Price: ");
        booking_price.setAlignment(Pos.CENTER_RIGHT);
        booking_price.setLayoutX(420);
        booking_price.setLayoutY(600);
        booking_price.setPrefSize(130, 38);
        booking_price.setTextFill(Color.DARKBLUE);
        booking_price.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 24));
        /* Total Price value */
        total_price.setAlignment(Pos.CENTER);
        total_price.setLayoutX(540);
        total_price.setLayoutY(600);
        total_price.setPrefSize(111, 38);
        total_price.setTextFill(Color.DARKBLUE);
        total_price.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 24));
        total_price.setVisible(false);
        
        /* Confirm Booking Button */
        confirm.setLayoutX(555);
        confirm.setLayoutY(680);
        confirm.setPrefSize(165, 48);
        confirm.setFont(font_buttons);
        confirm.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        confirm.setTextFill(Color.WHITE);
        confirm.setDisable(true);
        
        /************       End of Booking Confirmation      *************/
        
        /**********     page Lines      *********/
        Line line1_horz = new Line(-150,9,510,9);
        line1_horz.setLayoutX(436);
        line1_horz.setLayoutY(162);
        line1_horz.setStroke(Color.valueOf("#22406b"));
        
        Line line2_horz = new Line(-150,9,510,9);
        line2_horz.setLayoutX(436);
        line2_horz.setLayoutY(423);
        line2_horz.setStroke(Color.valueOf("#22406b"));
        
        Line line3_vertical = new Line(70,-68,70,89);
        line3_vertical.setLayoutX(560);
        line3_vertical.setLayoutY(309);
        line3_vertical.setStroke(Color.valueOf("#22406b"));
        
        Line line4_horz = new Line(-150,9,510,9);
        line4_horz.setLayoutX(436);
        line4_horz.setLayoutY(560);
        line4_horz.setStroke(Color.valueOf("#22406b"));
        /**********     End of page Lines      *********/
        
        /* get Children of page */
        page.getChildren().addAll(prev_page,H_type,hotelTypeRB,hotel_type_select,R_type,line1_horz,
        r_price,roomPriceRB,r_capacity,roomCapacityRB,room_type_select,line2_horz,line3_vertical,
        chk_in,chk_out,date_in,date_out,infoDone,line4_horz,booking_price,total_price,confirm);
        /************************
        *       End of GUI      *
        ************************/  
        
        //////////////////////////////////////////////////
        
        /************************
        *       Back-End        * 
        ************************/
        
        /* Make only one button selected at a time */
        /* Hotel Type Radio Button package */
        rads[0].setOnAction(e->{
            rads[1].setSelected(false);
            rads[2].setSelected(false);
            rads[3].setSelected(false);
        });
        rads[1].setOnAction(e->{
            rads[0].setSelected(false);
            rads[2].setSelected(false);
            rads[3].setSelected(false);
        });
        rads[2].setOnAction(e->{
            rads[0].setSelected(false);
            rads[1].setSelected(false);
            rads[3].setSelected(false);
        });
        rads[3].setOnAction(e->{
            rads[0].setSelected(false);
            rads[1].setSelected(false);
            rads[2].setSelected(false);
        });
        
        /** Price Radio Button package **/
        rads[4].setOnAction(e->{
            rads[5].setSelected(false);
            rads[6].setSelected(false);
        });
        rads[5].setOnAction(e->{
            rads[4].setSelected(false);
            rads[6].setSelected(false);
        });
        rads[6].setOnAction(e->{
            rads[4].setSelected(false);
            rads[5].setSelected(false);
        });
        
        /** Capacity Radio Button package **/
        rads[7].setOnAction(e->{
            rads[8].setSelected(false);
            rads[9].setSelected(false);
        });
        rads[8].setOnAction(e->{
            rads[7].setSelected(false);
            rads[9].setSelected(false);
        });
        rads[9].setOnAction(e->{
            rads[7].setSelected(false);
            rads[8].setSelected(false);
        });
        
        /* Hotel Fill Informations Handler object */
        HotelFillInfoHandler done_reservation = new HotelFillInfoHandler();

        /* Handle hotel Type Select Button */
        int []selected_type = new int[1];
        selected_type[0] = 0;
        hotel_type_select.setOnAction(e->{
            total_price.setVisible(false);
            confirm.setDisable(true);
            if(true == rads[0].isSelected()){
                selected_type[0] = 4;
            }
            else if(true == rads[1].isSelected()){
                selected_type[0] = 3;
            }
            else if(true == rads[2].isSelected()){
                selected_type[0] = 2;
            }
            else if(true == rads[3].isSelected()){
                selected_type[0] = 1;
            }
            else{
                selected_type[0] = 0;
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Please, Select Hotel type");
                errorAlert.showAndWait();   
            }
            done_reservation.setHotel_type(selected_type[0]);
        });
        
        /* Handle Room Type Select Button */
        int []selected_price = new int[1];
        selected_price[0] = 0;
        int []selected_capacity = new int[1];
        selected_capacity[0] = 0;
        room_type_select.setOnAction(e->{
            total_price.setVisible(false);
            confirm.setDisable(true);
            if(true == rads[4].isSelected()){
                selected_price[0] = 1;
            }
            else if(true == rads[5].isSelected()){
                selected_price[0] = 2;
            }
            else if(true == rads[6].isSelected()){
                selected_price[0] = 3;
            }
            else{
                selected_price[0] = 0;
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Please, Select Room Price");
                errorAlert.showAndWait();   
            }
            done_reservation.setRoom_price(selected_price[0]);
     
            if(true == rads[7].isSelected()){
                selected_capacity[0] = 1;
            }
            else if(true == rads[8].isSelected()){
                selected_capacity[0] = 2;
            }
            else if(true == rads[9].isSelected()){
                selected_capacity[0] = 3;
            }
            else{
                selected_capacity[0] = 0;
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Please, Select Room Capacity");
                errorAlert.showAndWait();   
            }
            done_reservation.setRoom_capacity(selected_capacity[0]);
        });
        
        /** Current Date **/
        LocalDate current_date = LocalDate.now();
        
        /** Check Date Declarations **/
        LocalDate []start_date = new LocalDate[1];
        LocalDate []end_date = new LocalDate[1];
        
        /** Check-in Date **/
        date_in.setOnAction(e->{
            total_price.setVisible(false);
            confirm.setDisable(true);
            /** Checks if Check-in date not set **/
            if(null != date_in.getValue()){
                start_date[0] = date_in.getValue();
                done_reservation.setStart_date(start_date[0]);
                /* ERROR: if the user enter a date less than current date */
                if(current_date.compareTo(start_date[0]) > 0){
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Invalid Date");
                    errorAlert.setContentText("Please, Enter a valid Check-in Date");
                    errorAlert.showAndWait();
                    date_in.setValue(null);
                }   
                done_reservation.setDate_in(date_in);
            }
        });
        
        /** Check-out Date **/
        date_out.setOnAction(e->{
            total_price.setVisible(false);
            confirm.setDisable(true);
            /** Checks if Check-out date not set **/
            if(null != date_out.getValue()){
                end_date[0] = date_out.getValue();
                done_reservation.setEnd_date(end_date[0]);
                /* ERROR: if the user enter a date less than current date */
                if(current_date.compareTo(end_date[0]) > 0){
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Invalid Date");
                    errorAlert.setContentText("Please, Enter a valid Check-out Date");
                    errorAlert.showAndWait();
                    date_out.setValue(null);
                }     
                done_reservation.setDate_out(date_out);
            }
        });
        
        /* Reservation Done Action Handler Object */
        infoDone.setOnAction(done_reservation);
        
        /* Confirm Booking & Bill */
        confirm.setOnAction(e->{
            primaryStage.setScene(new Bill(primaryStage));
        });
        
        /* Previous page */
        prev_page.setOnAction(e->{
            primaryStage.setScene(new main_page_demo(primaryStage));
        });
    }
}
