
package main_page.Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Models.User;

/**
 *
 * @author hossam & amir
 */
public class Admin_reports_page extends Scene {

    public Admin_reports_page(Stage primaryStage, User user) {

        super(new VBox(20), 1250, 760);

        

        // Report title
        Label reportTitle = new Label("Voyage Management Report");
        reportTitle.setId("report-title");
        
       Button back = new Button("back");
       back.setId("back");
       
       back.setOnAction(e -> {
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });

        // Users section
        VBox usersCard = new VBox();
        usersCard.getStyleClass().add("card");
        Label usersCardTitle = new Label("Users");
        usersCardTitle.setId("card-title");
        Label usersCountLabel = new Label("50");
        usersCountLabel.setId("card-count");
        usersCard.getChildren().addAll(usersCardTitle, usersCountLabel);

        // Reservations section
        VBox reservationsCard = new VBox();
        reservationsCard.getStyleClass().add("card");
        Label reservationsCardTitle = new Label("Reservations");
        reservationsCardTitle.setId("card-title");
        Label reservationsCountLabel = new Label("50");
        reservationsCountLabel.setId("card-count");
        reservationsCard.getChildren().addAll(reservationsCardTitle, reservationsCountLabel);
        
        VBox root = (VBox) this.getRoot();


        root.getStyleClass().add("report-page");
        root.getChildren().addAll(reportTitle, usersCard, reservationsCard, back);

        
        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());


    }
}
