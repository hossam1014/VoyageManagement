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

/**
 *
 * @author hossam & amir
 */
public class SignUpPage extends Scene {

    public SignUpPage(Stage primaryStage) {

        super(new VBox(20), 1250, 760);
        this.getStylesheets().add(getClass().getResource("/main_page/login_signup_style.css").toExternalForm());
        VBox vBox = (VBox) this.getRoot();
        vBox.getStyleClass().add("signUp-box");
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-image: url('images/login+backgrond2.jpg');");
        
        HBox centr_box = new HBox(20);
        centr_box.setAlignment(Pos.CENTER);

        GridPane sign_up_box = new GridPane();
        sign_up_box.setPadding(new Insets(20));
        sign_up_box.setHgap(40);
        sign_up_box.setVgap(10);
        sign_up_box.setPrefSize(400, 400);
        sign_up_box.setAlignment(Pos.CENTER);
        sign_up_box.setId("card");

        
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

        Button btn_sign_up = new Button("Sign Up");
        btn_sign_up.setPrefSize(120, 40);

        btn_sign_up.setOnAction(event -> {
            primaryStage.setScene(new LoginPage(primaryStage));
        });

        sign_up_box.add(lblFullName, 0, 0);
        sign_up_box.add(txtFullName, 1, 0);
        sign_up_box.add(lblEmail, 0, 1);
        sign_up_box.add(txtEmail, 1, 1);
        sign_up_box.add(lblPhoneNumber, 0, 2);
        sign_up_box.add(txtPhoneNumber, 1, 2);
        sign_up_box.add(lblUserName, 0, 3);
        sign_up_box.add(txtUserName, 1, 3);
        sign_up_box.add(lblPassword, 0, 4);
        sign_up_box.add(txtPassword, 1, 4);

        centr_box.getChildren().addAll(sign_up_box);
        
        vBox.getChildren().addAll(centr_box, btn_sign_up);
        
        
//        HBox hBox1 = new HBox(15);
//        hBox1.setAlignment(Pos.CENTER);
//        HBox hBox2 = new HBox(15);
//        hBox2.setAlignment(Pos.CENTER);
//        HBox hBox3 = new HBox(15);
//        hBox3.setAlignment(Pos.CENTER);
//        HBox hBox4 = new HBox(15);
//        hBox4.setAlignment(Pos.CENTER);
//        HBox hBox5 = new HBox(15);
//        hBox5.setAlignment(Pos.CENTER);
//
//        hBox1.getChildren().addAll(lblFullName, txtFullName);
//
//        hBox2.getChildren().addAll(lblEmail, txtEmail);
//
//        hBox3.getChildren().addAll(lblPhoneNumber, txtPhoneNumber);
//
//        hBox4.getChildren().addAll(lblUserName, txtUserName);
//
//        hBox5.getChildren().addAll(lblPassword, txtPassword);

//        primaryStage.setScene(this);
//        txtFullName.getStyleClass().add("text-field");
//        txtEmail.getStyleClass().add("text-field");
//        txtPhoneNumber.getStyleClass().add("text-field");
//        txtUserName.getStyleClass().add("text-field");
//        txtPassword.getStyleClass().add("text-field");
        primaryStage.setTitle("SignUp");
//        primaryStage.show();
    }

}
