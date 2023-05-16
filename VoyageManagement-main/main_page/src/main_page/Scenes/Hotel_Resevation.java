package main_page.Scenes;

//import hotel.HotelFillInformations;
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
//import main_page.Handlers.ConfirmBookingHandler;

/**
 *
 * @author Ehab
 */
public class Hotel_Resevation extends Scene {
    
    /* Global Variables used in Handler classes */
    static Label total_price = new Label("380 $");
    static Boolean information_isFilled = false;
    
    static Label room_id = new Label("Your room ID: ");
    static Label id = new Label("13");
    static Label welcome = new Label("Welcome, Wish you a nice voyage");
    /* End of Global Variable Declerations */
    
    public Hotel_Resevation(Stage primaryStage) {
        super(new StackPane(),1250, 760);
        StackPane root = (StackPane)this.getRoot();
        
        /* H Box for two AnchorPane */
        HBox anc = new HBox();
        
        /* AnchorPane left-page & right-page */
        AnchorPane navigator = new AnchorPane();
        AnchorPane page = new AnchorPane();
        
        /* get Childern */
        anc.getChildren().addAll(navigator,page);
        root.getChildren().addAll(anc);
        
        /* set Size and Style for the left & right page */
        navigator.setPrefSize(250, 760);
        page.setPrefSize(1000, 760);	
        navigator.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf);");
        page.setStyle("-fx-background-color: white");
        
        /** previous page button **/
        Button prev_page = new Button("Previous Page");
        prev_page.setLayoutX(60);
        prev_page.setLayoutY(653);
        prev_page.setPrefSize(130, 48);
        prev_page.setStyle("-fx-font: 18 Serif; -fx-base: #06063f;");
       
        
        /* get childern of navigator */
        navigator.getChildren().addAll(prev_page);
        
        /* Right page controls */
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
        H_type.setLayoutX(400);
        H_type.setLayoutY(35);
        H_type.setPrefSize(192, 48);
        H_type.setTextFill(Color.DARKBLUE);
        H_type.setFont(font_Labels);
        
        /* hotel type radio buttons in HBox */
        HBox hotelTypeRB = new HBox(20);
        hotelTypeRB.setLayoutX(150);
        hotelTypeRB.setLayoutY(99);
        hotelTypeRB.getChildren().addAll(rads[0],rads[1],rads[2],rads[3]);
          
        rads[0].setText("5 Star");
        rads[1].setText("4 Star");
        rads[2].setText("3 Star");
        rads[3].setText("Motel");
        
        /* hotel type select button */
        Button b_type_select = new Button("Select");
        b_type_select.setPrefSize(83, 38);
        b_type_select.setLayoutX(780);
        b_type_select.setLayoutY(99);
        b_type_select.setFont(font_buttons);
        b_type_select.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        b_type_select.setTextFill(Color.WHITE);
        /************      End of Hotel Type        **************/
        
        /************      Hotel Room      ************/
        Label R_type = new Label("Room Type");
        R_type.setAlignment(Pos.CENTER);
        R_type.setLayoutX(400);
        R_type.setLayoutY(176);
        R_type.setPrefSize(192, 48);
        R_type.setTextFill(Color.DARKBLUE);
        R_type.setFont(font_Labels);
        
        /* Room Price */
        Label r_price = new Label("Price");
        r_price.setLayoutX(240);
        r_price.setLayoutY(224);
        r_price.setPrefSize(141, 48);
        r_price.setTextFill(Color.DARKBLUE);
        r_price.setFont(font_room);
        
        /* room price radio buttons */
        VBox roomPriceRB = new VBox(10);
        roomPriceRB.setLayoutX(150);
        roomPriceRB.setLayoutY(270);
        roomPriceRB.getChildren().addAll(rads[4],rads[5],rads[6]);
        
        rads[4].setText("Economy");  
        rads[5].setText("Normal");  
        rads[6].setText("VIP");   
        
        /* Room Capacity */
        Label r_capacity = new Label("Capacity");
        r_capacity.setLayoutX(650);
        r_capacity.setLayoutY(224);
        r_capacity.setPrefSize(141, 48);
        r_capacity.setTextFill(Color.DARKBLUE);
        r_capacity.setFont(font_room);
        
        /* room capacity radio buttons */
        VBox roomCapacityRB = new VBox(10);
        roomCapacityRB.setLayoutX(560);
        roomCapacityRB.setLayoutY(270);
        roomCapacityRB.getChildren().addAll(rads[7],rads[8],rads[9]);
        
        rads[7].setText("Single");    
        rads[8].setText("Double");  
        rads[9].setText("More");
        
        Button r_type_select = new Button("Select");
        r_type_select.setPrefSize(83, 38);
        r_type_select.setLayoutX(780);
        r_type_select.setLayoutY(360);
        r_type_select.setFont(font_buttons);
        r_type_select.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        r_type_select.setTextFill(Color.WHITE);
        /************     End of Hotel Room      ************/
        
        /************       Check-In & Check-out Date       ************/
        Label l_in = new Label("Check-in Date:");
        Label l_out = new Label("Check-out Date:");
        DatePicker date_in = new DatePicker();
        DatePicker date_out = new DatePicker();
        Button select_date = new Button("Done");
        
        l_in.setLayoutX(145);
        l_in.setLayoutY(448);
        l_in.setPrefSize(141, 38);
        l_in.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 19));
        l_in.setTextFill(Color.DARKBLUE);
        l_out.setLayoutX(145);
        l_out.setLayoutY(500);
        l_out.setPrefSize(141, 38);
        l_out.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 19));
        l_out.setTextFill(Color.DARKBLUE);
        
        date_in.setLayoutX(295);
        date_in.setLayoutY(448);
        date_in.setPrefSize(203, 38);
        date_in.setPromptText("DD-MM-YYYY");
        date_out.setLayoutX(295);
        date_out.setLayoutY(500);
        date_out.setPrefSize(203, 38);
        date_out.setPromptText("DD-MM-YYYY");
        
        select_date.setPrefSize(83, 38);
        select_date.setLayoutX(780);
        select_date.setLayoutY(500);
        select_date.setFont(font_buttons);
        select_date.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        select_date.setTextFill(Color.WHITE);
        /************      End of Check-In & Check-out Date       ************/
        
        /************       Booking Confirmation      *************/
        /* Total Price Label */
        Label booking_price = new Label("Total Price: ");
        booking_price.setAlignment(Pos.CENTER_RIGHT);
        booking_price.setLayoutX(265);
        booking_price.setLayoutY(600);
        booking_price.setPrefSize(130, 38);
        booking_price.setTextFill(Color.DARKBLUE);
        booking_price.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 24));
        /* Total Price value */
        total_price.setAlignment(Pos.CENTER);
        total_price.setLayoutX(380);
        total_price.setLayoutY(600);
        total_price.setPrefSize(111, 38);
        total_price.setTextFill(Color.DARKBLUE);
        total_price.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 24));
        total_price.setVisible(false);
        
        /* Confirm Booking Button */
        Button confirm = new Button("Confirm Booking");
        confirm.setLayoutX(590);
        confirm.setLayoutY(595);
        confirm.setPrefSize(165, 49);
        confirm.setFont(font_buttons);
        confirm.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
        confirm.setTextFill(Color.WHITE);
        /* Hotel Room ID Labe; */
        room_id.setAlignment(Pos.CENTER_RIGHT);
        room_id.setLayoutX(355);
        room_id.setLayoutY(660);
        room_id.setPrefSize(170, 48);
        room_id.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 24));
        room_id.setVisible(false);
        /* Hotel Room ID value */
        id.setAlignment(Pos.CENTER_LEFT);
        id.setLayoutX(540);
        id.setLayoutY(660);
        id.setPrefSize(97, 48);
        id.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 24));
        id.setVisible(false);
        /* Welcoming message */
        welcome.setAlignment(Pos.CENTER);
        welcome.setLayoutX(325);
        welcome.setLayoutY(715);
        welcome.setPrefSize(310, 40);
        welcome.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.ITALIC, 22));
        welcome.setTextFill(Color.valueOf("#517bba"));
        welcome.setVisible(false);
        /************       End of Booking Confirmation      *************/
        
        /**********     page Lines      *********/
        Line l2 = new Line(-330,9,450,9);
        l2.setLayoutX(436);
        l2.setLayoutY(162);
        l2.setStroke(Color.valueOf("#22406b"));
        
        Line l3 = new Line(-330,9,450,9);
        l3.setLayoutX(436);
        l3.setLayoutY(423);
        l3.setStroke(Color.valueOf("#22406b"));
        
        Line l4 = new Line(70,-68,70,89);
        l4.setLayoutX(430);
        l4.setLayoutY(309);
        l4.setStroke(Color.valueOf("#22406b"));
        
        Line l5 = new Line(-330,9,450,9);
        l5.setLayoutX(436);
        l5.setLayoutY(560);
        l5.setStroke(Color.valueOf("#22406b"));
        /**********     End of page Lines      *********/
        
        /* get Children of right page */
        page.getChildren().addAll(H_type,hotelTypeRB,b_type_select,R_type,l2,
        r_price,roomPriceRB,r_capacity,roomCapacityRB,r_type_select,l3,l4,
        l_in,l_out,date_in,date_out,select_date,l5,
        booking_price,total_price,confirm,room_id,id,welcome);
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
        HotelFillInformations done_reservation = new HotelFillInformations();

        /* Handle hotel Type Select Button */
        int []selected_type = new int[1];
        selected_type[0] = 0;
        b_type_select.setOnAction(e->{
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
        r_type_select.setOnAction(e->{
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
        select_date.setOnAction(done_reservation);
        
        /* Confirm Booking Action Handler Object */
//        confirm.setOnAction(new ConfirmBookingHandler());
        
        /* Previous page */
        prev_page.setOnAction(e->{
            ///////////////////////////////////////     Amir -> setScene ****************
        });
    }
}
