package main_page.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Handlers.LoginHandler;
import main_page.Handlers.MyReservationsHandler;

/**
 *
 * @author hossam & amir
 */
public class LoginPage extends Scene {

    public LoginPage(Stage primaryStage) {

        super(new VBox(20), 1250, 760);
        this.getStylesheets().add(getClass().getResource("/main_page/login_signup_style.css").toExternalForm());
        
        VBox vBox = (VBox) this.getRoot();
        vBox.setStyle("-fx-background-color: #e5eff1");
 
        HBox centr_box = new HBox(20);
        centr_box.setAlignment(Pos.CENTER);
        
        GridPane log_in_box = new GridPane();
        log_in_box.setPadding(new Insets(20));
        log_in_box.setHgap(40);
        log_in_box.setVgap(10);
        log_in_box.setPrefSize(400, 200);
        log_in_box.setAlignment(Pos.CENTER);
        log_in_box.setId("card");
        
        Label lblUserName = new Label("username");
        TextField txtUserName = new TextField();

        Label lblPassword = new Label("password");
        PasswordField txtPassword = new PasswordField();

        Button btn_log_in = new Button("Sign In");
        btn_log_in.setPrefSize(120, 40);

        btn_log_in.setOnAction(event -> {
//            primaryStage.setScene(new main_page_demo(primaryStage));
            

//            مش تمسح حاجه الله يكرمك . اعملها كومنت
//                    حاضرررر
//
            LoginHandler loginHandler = new LoginHandler(txtUserName.getText(), txtPassword.getText());
            loginHandler.handle(event);
            if (loginHandler.isLoggedIn())
            {
                main_page_demo mainPage = new main_page_demo(primaryStage, loginHandler.getUser());
//                reservationsHandler.handle(event);
//                primaryStage.setScene(new MyReservationPage(primaryStage, reservationsHandler));
                primaryStage.setScene(mainPage);

            }
        });
        
        log_in_box.add(lblUserName, 0, 0);
        log_in_box.add(txtUserName, 1, 0);
        log_in_box.add(lblPassword, 0, 2);
        log_in_box.add(txtPassword, 1, 2);
        
        centr_box.getChildren().addAll(log_in_box);
        
        vBox.getChildren().addAll(centr_box, btn_log_in);
        vBox.setAlignment(Pos.CENTER);
        
        primaryStage.setTitle("Login");
    }
}
