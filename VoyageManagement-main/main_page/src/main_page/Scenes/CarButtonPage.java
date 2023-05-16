/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_page.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class CarButtonPage extends Scene {
    
    public CarButtonPage( Stage primaryStage) {
        super(new AnchorPane(),1050 ,400);
        
    RadioButton rad_b1 = new RadioButton("trip1");
    rad_b1.setPrefSize(120, 38);
    rad_b1.setLayoutX(20);
    rad_b1.setLayoutY(20);
    
    Label lblprice1 = new Label("price");
    lblprice1.setAlignment(Pos.CENTER);
    lblprice1.setLayoutX(160);
    lblprice1.setLayoutY(10);
    lblprice1.setPrefSize(150, 75);
    
    //label for show price
    int p = 0;
    Label lblprice1_2 = new Label(p+"$");
    lblprice1_2.setAlignment(Pos.CENTER);
    lblprice1_2.setPrefSize(150, 75);
    
    Label lblgotime = new Label("Time go");
    lblprice1_2.setAlignment(Pos.CENTER);
    lblprice1_2.setPrefSize(150, 75);
    
    Label lbltime = new Label("hh:mm:ss");
    lblprice1_2.setAlignment(Pos.CENTER);
    lblprice1_2.setPrefSize(150, 75);
    
    HBox h1 = new HBox(20);
    h1.setLayoutX(20);
    h1.setLayoutY(20);
    h1.getChildren().addAll(rad_b1,lblprice1, lblprice1_2, lblgotime, lbltime);
    
    Line l1 =new Line();
    l1.setLayoutX(0);
    l1.setLayoutY(68);
    l1.setEndX(1050);
        
    }
    
    
}
