
package main_page.Scenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import main_page.Handlers.LoginHandler;

/**
 *
 * @author hossam & amir
 */
public class LoginPage extends Scene {

    public LoginPage(Stage primaryStage) {

        super(new VBox(20), 1250, 760);
        this.getStylesheets().add(getClass().getResource("/main_page/login_signup_style.css").toExternalForm());
        
        primaryStage.setMaximized(true);
        
        VBox vBox = (VBox) this.getRoot();
        vBox.setStyle("-fx-background-image: url('images/badkground_every_thing.jpg');");        
 
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
        txtUserName.requestFocus();

        Label lblPassword = new Label("password");
        PasswordField txtPassword = new PasswordField();

        Button btn_log_in = new Button("Sign In");
        btn_log_in.setPrefSize(120, 40);
        
        Button btn_register = new Button("Sign Up");
        btn_register.setPrefSize(120, 40);
        
        txtUserName.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.ENTER){
                txtPassword.requestFocus();
            }
        });
        
        txtPassword.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.ENTER){
                btn_log_in.fire();
            }
        });

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
                primaryStage.setScene(mainPage);
            }
        });
        
        
        btn_register.setOnAction(event -> {
            primaryStage.setScene(new SignUpPage(primaryStage));
        });
        
        HBox BtnBox = new HBox(20);
        BtnBox.setAlignment(Pos.CENTER);
        
        log_in_box.add(lblUserName, 0, 0);
        log_in_box.add(txtUserName, 1, 0);
        log_in_box.add(lblPassword, 0, 2);
        log_in_box.add(txtPassword, 1, 2);
        
        centr_box.getChildren().addAll(log_in_box);
        
        BtnBox.getChildren().addAll(btn_log_in, btn_register);
        
        vBox.getChildren().addAll(centr_box, BtnBox);
        vBox.setAlignment(Pos.CENTER);
        
        // Set the scene on the stage
        primaryStage.setScene(this);

        // Set the stage to full screen
        primaryStage.setFullScreen(true);

        // Disable the full screen exit hint
        primaryStage.setFullScreenExitHint("");

       

        // Delay the appearance of the overlay message until the scene is shown
        primaryStage.setOnShown(e -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            }));
            timeline.play();
        });

        // Show the stage
        primaryStage.show();
    }
}
