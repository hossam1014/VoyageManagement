
package main_page.Scenes;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import main_page.Helpers.ReportsHelper;
import main_page.Models.Reservation;
import main_page.Models.User;

/**
 *
 * @author amir
 */
public class main_page_demo extends Scene {

    private TableView<Reservation> table;
    private User loggedUser;


    public main_page_demo(Stage primaryStage, User user) {
        super(new VBox(), 1250, 760);

        loggedUser = user;
        
        int userId = user.getId();

        VBox vBox = (VBox) this.getRoot();
        vBox.setAlignment(Pos.CENTER);
        vBox.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

        vBox.setStyle("-fx-background-image: url('images/badkground_every_thing.jpg');");        
        HBox main_page = new HBox(20);

        VBox info = new VBox(30);
        info.setAlignment(Pos.CENTER);
        info.setId("home_page_info");
        info.getStyleClass().add("home_page_info");

        VBox navigator = new VBox(20);
        navigator.setPadding(new Insets(10));
        navigator.setAlignment(Pos.TOP_CENTER);
        navigator.setPrefSize(200, 760);
        navigator.setId("navigator");
        navigator.getStyleClass().add("navigator");

        GridPane user_info = new GridPane();
        user_info.setPadding(new Insets(20));
        user_info.setHgap(200);
        user_info.setVgap(10);
        user_info.setAlignment(Pos.CENTER);
        user_info.setPrefSize(800, 200);
        user_info.setId("user_info");

        // navigator part of code //
        // adding the photo of the user, dont forget to change adel shakal's photo :)
        Circle img_circle = new Circle(75);
//        Image user_photo = new Image("images/user_photo.jpg", 300, 300, false, true);
        Image user_photo = new Image("images/user.png", 300, 300, false, true);
        img_circle.setFill(new ImagePattern(user_photo));

        // there will be some action handling here amir
        Button btn_travel = new Button("Traveling");
        Button btn_hotel = new Button("Hotels");
        Button btn_tools = new Button("Currency Converter");
        Button btn_report = new Button("Admin Reports");
        Button btn_user_report = new Button("Reports");
        Button btn_logout = new Button("Logout");

        btn_report.setOnAction(e -> {
            primaryStage.setScene(new Admin_reports_page(primaryStage, loggedUser));
        });

        btn_travel.setOnAction(e -> {
            primaryStage.setScene(new TravellingPage(primaryStage, loggedUser));
        });

        btn_tools.setOnAction(e -> {
           primaryStage.setScene(new Currency_Converter(primaryStage, loggedUser));
        });

        btn_user_report.setOnAction(e -> {
              primaryStage.setScene(new user_reports_page(primaryStage, loggedUser));
        });
        
        btn_logout.setOnAction(e -> {
              primaryStage.setScene(new LoginPage(primaryStage));
        });

        btn_travel.setMinSize(160, 40);
        btn_hotel.setMinSize(160, 40);
        btn_tools.setMinSize(160, 40);
        btn_report.setMinSize(160, 40);
        btn_user_report.setMinSize(160, 40);
        btn_logout.setMinSize(160, 40);
        
        Label user_name = new Label(this.loggedUser.getFullName());
        user_name.setId("user_name_nav");
        user_name.getStyleClass().add("user_name_nav");

        Line l1 = new Line(-127,0,212,0);
        l1.setLayoutX(129);
        l1.setLayoutY(226);
        l1.setStroke(Color.WHITE);
        navigator.setPadding(new Insets(20));

        //user_info part
        Label lbl_full_name = new Label("Full name");
        Label lbl_user_name = new Label("User name");
        Label lbl_email = new Label("Email");
        Label lbl_number = new Label("Phone number");

        Button change = new Button("Change");

        // back end and database part 
        
        // you have to get all these data from sign, login, traveling and hotel pages
        TextField txt_full_name = new TextField(loggedUser.getFullName());
        TextField txt_user_name = new TextField(loggedUser.getUserName());
        TextField txt_email = new TextField(loggedUser.getEmail());
        TextField txt_number = new TextField(loggedUser.getPhoneNumber());

        txt_user_name.setPrefWidth(400);
        txt_user_name.setEditable(false);
        txt_email.setEditable(false);
        txt_number.setEditable(false);

        user_info.addRow(0, lbl_full_name, txt_full_name);
        user_info.addRow(1, lbl_user_name, txt_user_name);
        user_info.addRow(2, lbl_email, txt_email);
        user_info.addRow(3, lbl_number, txt_number);
        user_info.add(change, 0, 4, 2, 1);

        change.setOnAction(e -> {
            txt_user_name.setEditable(true);
            txt_email.setEditable(true);
            txt_number.setEditable(true);
        });

        /* table part */
        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        /* User Reservation info table */
        TableColumn<Reservation, String> reservationIdCol = new TableColumn<>("ID");
        reservationIdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Reservation, String> reservationFrom = new TableColumn<>("From");
        reservationFrom.setCellValueFactory(new PropertyValueFactory<>("From"));
        
        TableColumn<Reservation, String> reservationTo = new TableColumn<>("To");
        reservationTo.setCellValueFactory(new PropertyValueFactory<>("To"));

        TableColumn<Reservation, String> leavingCol = new TableColumn<>("Leaving");
        leavingCol.setCellValueFactory(new PropertyValueFactory<>("LeavingDate"));
        
        TableColumn<Reservation, String> arriveCol = new TableColumn<>("Arrive");
        arriveCol.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));
        
        TableColumn<Reservation, String> tranportCol = new TableColumn<>("Trans");
        tranportCol.setCellValueFactory(new PropertyValueFactory<>("TravelType"));

        TableColumn<Reservation, String> TripNameCol = new TableColumn<>("Trip");
        TripNameCol.setCellValueFactory(new PropertyValueFactory<>("TripName"));

        TableColumn<Reservation, String> hotelNameCol = new TableColumn<>("Hotel");
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("HotelName"));

        TableColumn<Reservation, String> hotelDurationCol = new TableColumn<>("Duration");
        hotelDurationCol.setCellValueFactory(new PropertyValueFactory<>("HotelDuration"));
        
       
        TableColumn<Reservation, String> checkOutDateCol = new TableColumn<>("Total");
        checkOutDateCol.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));

        table.getColumns().addAll(reservationIdCol, reservationFrom, reservationTo, leavingCol, arriveCol,
                tranportCol, TripNameCol, hotelNameCol, hotelDurationCol);
        table.setItems(FXCollections.observableArrayList(ReportsHelper.getMyReservations(user.getId())));
        table.getStyleClass().add("rounded-table");
        
        

        navigator.getChildren().addAll(img_circle, user_name, l1, btn_travel,
                btn_tools, btn_user_report,btn_report, btn_logout);
//
        if (!user.isIsAdmin()) {
            navigator.getChildren().remove(btn_report); // Add the button to the container
      }  
//        } else {
//            navigator.getChildren().remove(btn_report); // Remove the button from the container
//        }

        info.getChildren().addAll(user_info, table);

        main_page.getChildren().addAll(navigator, info);

        vBox.getChildren().add(main_page);
    }
}
