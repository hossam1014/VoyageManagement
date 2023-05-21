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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class BusButtonPage extends AnchorPane {
    
    public BusButtonPage() {
        
        
    this.setLayoutX(20);
    this.setLayoutY(350);
        
    RadioButton rad_b1 = new RadioButton("hhhhhhh");
    rad_b1.setPrefSize(120, 38);
    
    Label lblprice1 = new Label("price");
    lblprice1.setAlignment(Pos.CENTER);
    lblprice1.setPrefSize(150, 75);
    
    //label for show price
    int p = 0;
    Label lblprice1_2 = new Label(p+"$");
    lblprice1_2.setAlignment(Pos.CENTER);
    lblprice1_2.setPrefSize(150, 75);
    
    Label lblgotime = new Label("Time go");
    lblgotime.setAlignment(Pos.CENTER);
    lblgotime.setPrefSize(150, 75);
    
    Label lbltime = new Label("hh:mm:ss");
    lbltime.setAlignment(Pos.CENTER);
    lbltime.setPrefSize(150, 75);
    
    HBox h1 = new HBox(20);
    h1.setPadding(new Insets(20));
    h1.getChildren().addAll(rad_b1,lblprice1, lblprice1_2, lblgotime, lbltime);
    
    Line l1 =new Line();
    l1.setEndX(1050);
    
    RadioButton rad_b2 = new RadioButton("trip1");
    rad_b2.setPrefSize(120, 38);
    
    Label lblprice2 = new Label("price");
    lblprice2.setAlignment(Pos.CENTER);
    lblprice2.setPrefSize(150, 75);
    
    //label for show price
    int p2 = 0;
    Label lblprice2_2 = new Label(p2+"$");
    lblprice2_2.setAlignment(Pos.CENTER);
    lblprice2_2.setPrefSize(150, 75);
    
    Label lblgotime2 = new Label("Time go");
    lblgotime2.setAlignment(Pos.CENTER);
    lblgotime2.setPrefSize(150, 75);
    
    Label lbltime2 = new Label("hh:mm:ss");
    lbltime2.setAlignment(Pos.CENTER);
    lbltime2.setPrefSize(150, 75);
    
    HBox h2 = new HBox(20);
    h2.setPadding(new Insets(20));
    h2.getChildren().addAll(rad_b2,lblprice2, lblprice2_2, lblgotime2, lbltime2);
    
    Line l2 =new Line();
    l2.setEndX(1050);
    
    RadioButton rad_b3 = new RadioButton("trip1");
    rad_b3.setPrefSize(120, 38);
    
    Label lblprice3 = new Label("price");
    lblprice3.setAlignment(Pos.CENTER);
    lblprice3.setPrefSize(150, 75);
    
    //label for show price
    int p3 = 0;
    Label lblprice3_2 = new Label(p3+"$");
    lblprice3_2.setAlignment(Pos.CENTER);
    lblprice3_2.setPrefSize(150, 75);
    
    Label lblgotime3 = new Label("Time go");
    lblgotime3.setAlignment(Pos.CENTER);
    lblgotime3.setPrefSize(150, 75);
    
    Label lbltime3 = new Label("hh:mm:ss");
    lbltime3.setAlignment(Pos.CENTER);
    lbltime3.setPrefSize(150, 75);
    
    HBox h3 = new HBox(20);
    h3.setPadding(new Insets(20));
    h3.getChildren().addAll(rad_b3,lblprice3, lblprice3_2, lblgotime3, lbltime3);
    
    Line l3 =new Line();
    l3.setEndX(1050);
    
    Button btnconferm =new Button("confirm");
    btnconferm.setPrefSize(100, 48);
    
    VBox v1 = new VBox(10);
    v1.getChildren().addAll( h1,l1,h2,l2, h3,l3,btnconferm);
    
//    AnchorPane busPage = (AnchorPane) this.getRoot();
//    busPage.getChildren().addAll(v1);
    this.getChildren().addAll(v1);

    }
    
    
}
