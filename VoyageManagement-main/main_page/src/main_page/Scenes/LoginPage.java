/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Handlers.GetUsersHandler;
import main_page.Handlers.LoginHandler;
import main_page.Handlers.MyReservationsHandler;
import main_page.Helpers.AlertHelper;

/**
 *
 * @author hossam
 */
public class LoginPage extends Scene {
    
    
    public LoginPage(Stage primaryStage) {
        
        super(new VBox(20), 1250, 760);

        Label lblUserName = new Label("username");
        TextField txtUserName = new TextField();

        Label lblPassword = new Label("password");
        PasswordField txtPassword = new PasswordField();

        Button btn = new Button("Login");
        btn.setId("login-button");

        btn.setOnAction(event -> {
            LoginHandler loginHandler = new LoginHandler(txtUserName.getText(), txtPassword.getText());
            loginHandler.handle(event);
            if (loginHandler.isLoggedIn())
            {
                MyReservationsHandler reservationsHandler = new MyReservationsHandler(loginHandler.getUserId());
                reservationsHandler.handle(event);
                primaryStage.setScene(new MyReservationPage(primaryStage, reservationsHandler));
            }
        });

        Button btnUsers = new Button("Users");
        btnUsers.setId("users-button");

        btnUsers.setOnAction(event -> {
            GetUsersHandler getUsersHandler = new GetUsersHandler();
            getUsersHandler.handle(event);
        });

        VBox vBox = (VBox) this.getRoot();
        vBox.getStyleClass().add("login-box");

        HBox hBox1 = new HBox(15);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(15);
        hBox2.setAlignment(Pos.CENTER);

        hBox1.getChildren().addAll(lblUserName, txtUserName);

        hBox2.getChildren().addAll(lblPassword, txtPassword);

        vBox.getChildren().addAll(hBox1, hBox2, btn, btnUsers);

        vBox.setAlignment(Pos.CENTER);

        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

//        primaryStage.setScene(this);

//        primaryStage.setTitle("Login");
//        primaryStage.show();
    }
}
