/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Scenes;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Handlers.MyReservationsHandler;
import main_page.Models.Reservation;

/**
 *
 * @author hossam
 */
public class MyReservationPage extends Scene {

    List<Reservation> reservations = new ArrayList<>();
    private TableView<Reservation> table;

    public MyReservationPage(Stage primaryStage) {

        super(new VBox(20), 1250, 760);
        

        MyReservationsHandler myReservationsHandler = new MyReservationsHandler();
        reservations = myReservationsHandler.getMyReservations();
        


        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Reservation, String> reservationIdCol = new TableColumn<>("Reservation ID");
        reservationIdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Reservation, String> reservationDateCol = new TableColumn<>("Reservation Date");
        reservationDateCol.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));

        TableColumn<Reservation, String> customerNameCol = new TableColumn<>("Customer Name");
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Reservation, String> roomNumberCol = new TableColumn<>("Room Number");
        roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        TableColumn<Reservation, String> checkInDateCol = new TableColumn<>("Check-In Date");
        checkInDateCol.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));

        TableColumn<Reservation, String> checkOutDateCol = new TableColumn<>("Check-Out Date");
        checkOutDateCol.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));

        table.getColumns().addAll(reservationIdCol, reservationDateCol, customerNameCol, roomNumberCol, checkInDateCol, checkOutDateCol);
        table.setItems(FXCollections.observableArrayList(reservations));

        VBox root = (VBox) getRoot();
        root.getChildren().addAll(table);

        // Apply CSS style
        root.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

//        primaryStage.setTitle("Reservations");
        primaryStage.show();
    }

}
