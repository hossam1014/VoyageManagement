package main_page.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hossam & amir
 */
public class Admin_reports_page extends Scene {

    public Admin_reports_page(Stage primaryStage) {

        super(new VBox(20), 1250, 760);

        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());
        VBox root = (VBox) this.getRoot();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));

        HBox lables_box = new HBox(20);
        lables_box.setAlignment(Pos.CENTER);

        Button back = new Button("Back");

        Label lbl_1 = new Label("label 1");
        Label lbl_2 = new Label("label 2");
        Label lbl_3 = new Label("label 3");
        Label lbl_4 = new Label("label 4");
        
        lbl_1.setMinSize(160, 100);
        lbl_1.setAlignment(Pos.CENTER);
        lbl_1.getStyleClass().add("label_admin");
        
        lbl_2.setMinSize(160, 100);
        lbl_2.setAlignment(Pos.CENTER);
        lbl_2.getStyleClass().add("label_admin");
        
        lbl_3.setMinSize(160, 100);
        lbl_3.setAlignment(Pos.CENTER);
        lbl_3.getStyleClass().add("label_admin");
        
        lbl_4.setMinSize(160, 100);
        lbl_4.setAlignment(Pos.CENTER);
        lbl_4.getStyleClass().add("label_admin");

        lables_box.getChildren().addAll(lbl_1, lbl_2, lbl_3, lbl_4);

        root.getChildren().addAll(lables_box);
        primaryStage.setTitle("Reports");
    }
}
