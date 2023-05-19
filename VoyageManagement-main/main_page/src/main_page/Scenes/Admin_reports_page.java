package main_page.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Models.User;

/**
 *
 * @author hossam & amir
 */
public class Admin_reports_page extends Scene {

    public Admin_reports_page(Stage primaryStage) {
//    public Admin_reports_page(Stage primaryStage, User user) {

        super(new VBox(20), 1250, 760);

        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());
        VBox root = (VBox) this.getRoot();
        root.setId("admin_background");
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));

        HBox lables_box = new HBox(20);
        lables_box.setAlignment(Pos.CENTER);
        
//       Button back = new Button("back");
//       back.setId("back");
       
//       back.setOnAction(e -> {
//            primaryStage.setScene(new main_page_demo(primaryStage, user));

        HBox button_box = new HBox();

        Button back = new Button("Back");
        back.setPrefSize(120, 40);
        back.getStyleClass().add("custom-button");

        back.setOnAction(e -> {
//            primaryStage.setScene(new main_page_demo(primaryStage, user));
            primaryStage.setScene(new main_page_demo(primaryStage));
        });

        Label lbl_1 = new Label("150\n Users");
        Label lbl_2 = new Label("132 \n Reservations");
        Label lbl_3 = new Label("24 \n Loged in");
        Label lbl_4 = new Label("35000 $ \n Profit");

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

        button_box.getChildren().add(back);
        button_box.setAlignment(Pos.BASELINE_LEFT);
        lables_box.getChildren().addAll(lbl_1, lbl_2, lbl_3, lbl_4);

//        table bart of code.
        //the <person> is the type of opject we want to add
        TableView table = new TableView<person>();
        table.getStyleClass().add("table");
//                  neme of table                  opject, type        name of column.
        TableColumn firs_name_col = new TableColumn<person, String>("Firs Name");
        firs_name_col.setCellValueFactory(new PropertyValueFactory<person, String>("first_name"));

        TableColumn email_col = new TableColumn<person, String>("Email");
        email_col.setCellValueFactory(new PropertyValueFactory<person, String>("email"));

        TableColumn age_col = new TableColumn<person, Integer>("Age");
        age_col.setCellValueFactory(new PropertyValueFactory<person, String>("age"));

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
//        addint data to the table 
        
        table.getItems().add(new person("amir", "amiralsayed123@gmail.com", 21));
        table.getItems().add(new person("hosam", "hosam14@gmail.com", 21));
        table.getItems().add(new person("adel shakal", "adel_elgamed12@gmail.com", 46));
        table.getItems().add(new person("adel shakal", "adel_elgamed12@gmail.com", 46));
        table.getItems().add(new person("adel shakal", "adel_elgamed12@gmail.com", 46));
        table.getItems().add(new person("adel shakal", "adel_elgamed12@gmail.com", 46));
        table.getItems().add(new person("adel shakal", "adel_elgamed12@gmail.com", 46));
        table.getItems().add(new person("adel shakal", "adel_elgamed12@gmail.com", 46));
        table.getItems().add(new person("adel shakal", "adel_elgamed12@gmail.com", 46));
        
        table.getColumns().addAll(firs_name_col, email_col, age_col);
        root.getChildren().addAll(lables_box, table, button_box);

        primaryStage.setTitle("Admin Reports");
    }
}
