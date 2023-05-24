
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
import main_page.Handlers.SignUpHandler;

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
        vBox.setStyle("-fx-background-color: #e5eff1");
        
        HBox centr_box = new HBox(20);
        centr_box.setAlignment(Pos.CENTER);

        GridPane sign_up_box = new GridPane();
        sign_up_box.setPadding(new Insets(20));
        sign_up_box.setHgap(40);
        sign_up_box.setVgap(10);
        sign_up_box.setPrefSize(400, 400);
        sign_up_box.setAlignment(Pos.CENTER);
        sign_up_box.setId("card");

        
        Label lblFullName = new Label("Full name");
        TextField txtFullName = new TextField();

        Label lblEmail = new Label("Email address");
        TextField txtEmail = new TextField();

        Label lblPhoneNumber = new Label("Phone number");
        TextField txtPhoneNumber = new TextField();

        Label lblUserName = new Label("Username");
        TextField txtUserName = new TextField();

        Label lblPassword = new Label("Password");
        PasswordField txtPassword = new PasswordField();

        Button btn_sign_up = new Button("Sign Up");
        btn_sign_up.setPrefSize(120, 40);

        btn_sign_up.setOnAction(event -> {
            SignUpHandler signUpHandler = new SignUpHandler(txtFullName.getText(), txtEmail.getText(),
                    txtPhoneNumber.getText(), txtUserName.getText(), txtPassword.getText());
            signUpHandler.handle(event);
            primaryStage.setScene(new LoginPage(primaryStage));
        });

        sign_up_box.addRow(0, lblFullName, txtFullName);
        sign_up_box.addRow(1, lblEmail, txtEmail);
        sign_up_box.addRow(2, lblPhoneNumber, txtPhoneNumber);
        sign_up_box.addRow(3, lblUserName, txtUserName);
        sign_up_box.addRow(4, lblPassword, txtPassword);

        centr_box.getChildren().addAll(sign_up_box);
        
        vBox.getChildren().addAll(centr_box, btn_sign_up);
    }
}
