
package main_page.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Models.User;

/**
 *
 * @author amir
 */
public class user_reports_page extends Scene{

    public user_reports_page(Stage primaryStage, User user) {
        super(new VBox(20), 1500, 860);
                
        VBox main_box = (VBox) this.getRoot();
        HBox btn_box = new HBox(20);
        btn_box.setAlignment(Pos.CENTER);
        main_box.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());
        main_box.setStyle("-fx-background-image: url('images/badkground_every_thing.jpg');");        
        main_box.setAlignment(Pos.CENTER_LEFT);
        main_box.setPadding(new Insets(20));
        
        Label lbl_header = new Label("Please, enter your issue!");
        lbl_header.getStyleClass().add("custom-label");
        
        TextArea txt_report = new TextArea();
        txt_report.setPrefRowCount(15); // Set the number of visible rows
        txt_report.setWrapText(true);
        txt_report.setId("user_reports");
        Button btn_supmit = new Button("Submit");
        btn_supmit.setPrefSize(120, 40);
        Button btn_back = new Button("Back");
        btn_back.setId("btn_back");
        btn_back.getStyleClass().add("custom-button");
        btn_back.setPrefSize(120, 40);
        
        btn_back.setOnAction(e->{
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });
        btn_supmit.setOnAction(e -> {
            /* Submit message */
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Your report has been received successfully");
            alert.showAndWait();
            /* Go back to main page demo */
            primaryStage.setScene(new main_page_demo(primaryStage, user));
        });
        
        btn_box.getChildren().addAll(btn_supmit, btn_back);
        main_box.getChildren().addAll(lbl_header, txt_report, btn_box);
       
        // Set the scene on the stage
        primaryStage.setScene(this);
        
        // Set the stage to full screen
        primaryStage.setFullScreen(true);
        
        // Show the stage
        primaryStage.show();
    }
}
