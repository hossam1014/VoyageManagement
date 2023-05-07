package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        
        
        Scene loginScene = new Scene(root);
        
        
        
        
        
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setTitle("Home");
        stage.setScene(loginScene);
        stage.show();       
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
