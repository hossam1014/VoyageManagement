package voyagemanagement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane mainn = new GridPane();
        VBox loginmain = new VBox();
        VBox signupmain = new VBox();
        
        Scene loginScene = new Scene(loginmain, 720, 480);
        Scene signupScene = new Scene(signupmain, 720, 480);
        Scene scene = new Scene(mainn, 720, 480);
        
//        Image icone = new Image("logo.png");
        Button log_in = new Button("Log in");
        Button back1 = new Button ("Back");
        Button back2 = new Button ("Back");
        Button sign_up = new Button("Sign up");
        
        Label logolbl = new Label("Travely");
        
        mainn.add(log_in, 0, 0);
        mainn.add(sign_up, 0, 3);
        mainn.add(logolbl, 5, 2);
        
        loginmain.getChildren().addAll(back1, new Label("log in page"));
        signupmain.getChildren().addAll(back2, new Label("sign up page"));
        
        

        log_in.setOnAction(e->{
                stage.setScene(loginScene);
                stage.setTitle("login");
        });
        sign_up.setOnAction(e->{
                stage.setScene(signupScene);
                stage.setTitle("signup");
        });
        back1.setOnAction(e->{
                stage.setScene(scene);
                stage.setTitle("home");
        });
        back2.setOnAction(e->{
                stage.setScene(scene);
                stage.setTitle("home");
        });
        
        
//        stage.getIcons().add(icone);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();       
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
