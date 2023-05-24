
package main_page.Scenes;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    List<Reservation> reservations;
    private TableView<Reservation> table;

    public MyReservationPage(Stage primaryStage, MyReservationsHandler reservationHandler) {

        super(new VBox(20), 1250, 760);

        reservations = reservationHandler.getMyReservations();

        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Reservation, String> reservationIdCol = new TableColumn<>("Reservation ID");
        reservationIdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Reservation, String> reservationDateCol = new TableColumn<>("Reservation Date");
        reservationDateCol.setCellValueFactory(new PropertyValueFactory<>("ReserveDate"));

        TableColumn<Reservation, String> customerNameCol = new TableColumn<>("Package Name");
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("PackageName"));

        TableColumn<Reservation, String> roomNumberCol = new TableColumn<>("Travel Ticket Name");
        roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("TravelTicketName"));

        TableColumn<Reservation, String> checkInDateCol = new TableColumn<>("Hotel Name");
        checkInDateCol.setCellValueFactory(new PropertyValueFactory<>("HotelName"));

        TableColumn<Reservation, String> checkOutDateCol = new TableColumn<>("Total");
        checkOutDateCol.setCellValueFactory(new PropertyValueFactory<>("Total"));

        table.getColumns().addAll(reservationIdCol, reservationDateCol, customerNameCol, roomNumberCol, checkInDateCol, checkOutDateCol);
        table.setItems(FXCollections.observableArrayList(reservations));
        
        Button loginBtn = new Button();
        loginBtn.setAlignment(Pos.CENTER);

        VBox root = (VBox) getRoot();
        root.getChildren().addAll(table, loginBtn);

        // Apply CSS style
        root.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

        loginBtn.setOnAction(x -> {
            primaryStage.setScene(new LoginPage(primaryStage));
        });
    }
}
