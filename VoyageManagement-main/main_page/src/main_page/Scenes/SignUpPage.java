/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Handlers.SignUpHandler;

/**
 *
 * @author hossam
 */
public class SignUpPage extends Scene {

    public SignUpPage(Stage primaryStage) {

        super(new VBox(20), 1250, 760);

        Label lblFullName = new Label("fullname");
        TextField txtFullName = new TextField();

        Label lblEmail = new Label("email");
        TextField txtEmail = new TextField();

        Label lblPhoneNumber = new Label("Phone number");
        TextField txtPhoneNumber = new TextField();

        Label lblUserName = new Label("username");
        TextField txtUserName = new TextField();

        Label lblPassword = new Label("password");
        PasswordField txtPassword = new PasswordField();

        Button btn = new Button("Sign Up");

        btn.setOnAction(event -> {
            SignUpHandler signUpHandler = new SignUpHandler(txtFullName.getText(), txtEmail.getText(),
                    txtPhoneNumber.getText(), txtUserName.getText(), txtPassword.getText());
            signUpHandler.handle(event);
        });

        VBox vBox = (VBox) this.getRoot();
        vBox.getStyleClass().add("signUp-box");

        HBox hBox1 = new HBox(15);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(15);
        hBox2.setAlignment(Pos.CENTER);
        HBox hBox3 = new HBox(15);
        hBox3.setAlignment(Pos.CENTER);
        HBox hBox4 = new HBox(15);
        hBox4.setAlignment(Pos.CENTER);
        HBox hBox5 = new HBox(15);
        hBox5.setAlignment(Pos.CENTER);

        hBox1.getChildren().addAll(lblFullName, txtFullName);

        hBox2.getChildren().addAll(lblEmail, txtEmail);

        hBox3.getChildren().addAll(lblPhoneNumber, txtPhoneNumber);

        hBox4.getChildren().addAll(lblUserName, txtUserName);

        hBox5.getChildren().addAll(lblPassword, txtPassword);

        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5, btn);

        vBox.setAlignment(Pos.CENTER);

        this.getStylesheets().add(getClass().getResource("/main_page/style.css").toExternalForm());

//        primaryStage.setScene(this);

        txtFullName.getStyleClass().add("text-field");
        txtEmail.getStyleClass().add("text-field");
        txtPhoneNumber.getStyleClass().add("text-field");
        txtUserName.getStyleClass().add("text-field");
        txtPassword.getStyleClass().add("text-field");
        btn.getStyleClass().add("signUpBtn");

        primaryStage.setTitle("SignUp");
        primaryStage.show();
    }

}
