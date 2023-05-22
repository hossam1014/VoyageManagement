/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_page.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class FlaghtButtonPage extends AnchorPane {
    
    public FlaghtButtonPage() {
        
        this.setLayoutX(20);
        this.setLayoutY(350);

    
        // Create a ToggleGroup to manage the radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        
        //radio button for trip1
        RadioButton rad_b1 = new RadioButton("trip1");
        rad_b1.setPrefSize(120, 38);
        rad_b1.setToggleGroup(toggleGroup);
    
        //label for show on it word "price"
        Label lblprice1 = new Label("price");
        lblprice1.setAlignment(Pos.CENTER);
        lblprice1.setPrefSize(150, 75);
    
        //label for show price
        int p = 0;
        Label lblprice1_2 = new Label(p+"$");
        lblprice1_2.setAlignment(Pos.CENTER);
        lblprice1_2.setPrefSize(150, 75);
    
        //label for text on it time go
        Label lblgotime = new Label("Time go");
        lblgotime.setAlignment(Pos.CENTER);
        lblgotime.setPrefSize(150, 75);
        
        //label for showing time
        Label lbltime = new Label("hh:mm:ss");
        lbltime.setAlignment(Pos.CENTER);
        lbltime.setPrefSize(150, 75);
    
        //hbox for adding trip2 info
        HBox h1 = new HBox(20);
        h1.setPrefSize(820, 50);
        h1.getChildren().addAll(rad_b1,lblprice1, lblprice1_2, lblgotime, lbltime);
        
        //line under radio button 2
        Line l1 =new Line();
        l1.setEndX(1050);
    
        //radio button for trip2
        RadioButton rad_b2 = new RadioButton("trip2");
        rad_b2.setPrefSize(120, 38);
        rad_b2.setToggleGroup(toggleGroup);
        
        //label for show on it word "price"
        Label lblprice2 = new Label("price");
        lblprice2.setAlignment(Pos.CENTER);
        lblprice2.setPrefSize(150, 75);
    
        //label for show price
        int p2 = 0;
        Label lblprice2_2 = new Label(p2+"$");
        lblprice2_2.setAlignment(Pos.CENTER);
        lblprice2_2.setPrefSize(150, 75);
    
        //label for text on it time go
        Label lblgotime2 = new Label("Time go");
        lblgotime2.setAlignment(Pos.CENTER);
        lblgotime2.setPrefSize(150, 75);
    
        //label for showing time
        Label lbltime2 = new Label("hh:mm:ss");
        lbltime2.setAlignment(Pos.CENTER);
        lbltime2.setPrefSize(150, 75);
    
        //hbox for adding trip2 info
        HBox h2 = new HBox(20);
        h2.setPrefSize(820, 50);
        h2.getChildren().addAll(rad_b2,lblprice2, lblprice2_2, lblgotime2, lbltime2);
        
        //line under radio button 2
        Line l2 =new Line();
        l2.setEndX(1050);
        
        //radio button for trip3
        RadioButton rad_b3 = new RadioButton("trip3");
        rad_b3.setPrefSize(120, 38);
        rad_b3.setToggleGroup(toggleGroup);
        
        //label for show on it word "price"
        Label lblprice3 = new Label("price");
        lblprice3.setAlignment(Pos.CENTER);
        lblprice3.setPrefSize(150, 75);
    
        //label for show price
        int p3 = 0;
        Label lblprice3_2 = new Label(p3+"$");
        lblprice3_2.setAlignment(Pos.CENTER);
        lblprice3_2.setPrefSize(150, 75);
        
        //label for text on it time go
        Label lblgotime3 = new Label("Time go");
        lblgotime3.setAlignment(Pos.CENTER);
        lblgotime3.setPrefSize(150, 75);
        
        //label for showing time  
        Label lbltime3 = new Label("hh:mm:ss");
        lbltime3.setAlignment(Pos.CENTER);
        lbltime3.setPrefSize(150, 75);
        
        //hbox for adding trip3 info
        HBox h3 = new HBox(20);
        h3.setPrefSize(820, 50);
        h3.getChildren().addAll(rad_b3,lblprice3, lblprice3_2, lblgotime3, lbltime3);
        
        //line under radio button 3
        Line l3 =new Line();
        l3.setEndX(1050);
    
        Button btnconferm =new Button("confirm");
        btnconferm.setPrefSize(100, 48);
        btnconferm.setDisable(true);
        
        //vbox to add controll on it
        VBox v1 = new VBox(10);
        v1.getChildren().addAll( h1,l1,h2,l2, h3,l3,btnconferm);
        
        // add vbox on anchropane
        this.getChildren().addAll(v1);
        
        /*///
                Back End
                           ///*/
        //handler for rad button1
        rad_b1.setOnAction(e ->{
            if(rad_b1.isSelected()){
            btnconferm.setDisable(false);
            }
            else{
                btnconferm.setDisable(true);
            }
        });
        //handler for rad button2
        rad_b2.setOnAction(e ->{
            if(rad_b2.isSelected()){
            btnconferm.setDisable(false);
            }
            else{
                btnconferm.setDisable(true);
            }
        });
        //handler for rad button3
        rad_b3.setOnAction(e ->{
            if(rad_b3.isSelected()){
            btnconferm.setDisable(false);
            }
            else{
                btnconferm.setDisable(true);
            }
        });
    }
    
}
