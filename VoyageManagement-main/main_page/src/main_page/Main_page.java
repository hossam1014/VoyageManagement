    package main_page;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Scenes.Admin_reports_page;
import main_page.Scenes.LoginPage;
import main_page.Scenes.SignUpPage;
import main_page.Scenes.main_page_demo;

public class Main_page extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox main_page = new VBox(20);
        main_page.setId("main_page");
        main_page.getStyleClass().add("main_page");
        HBox buttons_box = new HBox(20);

//        Button test = new Button("test");
        Button login_btn = new Button("Log in");
        Button signup_btn = new Button("Sign up");
        buttons_box.getChildren().addAll(login_btn, signup_btn);
        buttons_box.setAlignment(Pos.CENTER);

        login_btn.setMinSize(150, 40);
        signup_btn.setMinSize(150, 40);

        main_page.getChildren().addAll(buttons_box);
        main_page.setAlignment(Pos.CENTER);

        main_page.setStyle("-fx-background-image: url('images/background_main.png');");

        login_btn.setOnAction(e -> {
            primaryStage.setScene(new LoginPage(primaryStage));
        });

        signup_btn.setOnAction(e -> {
            primaryStage.setScene(new SignUpPage(primaryStage));
        });

        Scene scene = new Scene(main_page, 1250, 760);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("main page");
        primaryStage.setScene(new Admin_reports_page(primaryStage));
//        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
