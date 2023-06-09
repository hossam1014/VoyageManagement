
package main_page.Scenes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import main_page.Models.Trip;
import static main_page.Scenes.TravellingPage.btnnext;

/**
 *
 * @author hp
 */
public class CarButtonPage extends AnchorPane {
    
    private Trip tripCar = new Trip();
    public static RadioButton rad_b1c = new RadioButton("O-Travel");
    public static RadioButton rad_b2c = new RadioButton("B-Travel");
    public static RadioButton rad_b3c = new RadioButton("N-trevel");
   
    public CarButtonPage() {

        this.setLayoutX(20);
        this.setLayoutY(370);
    
        // Create a ToggleGroup to manage the radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        
        //radio button for trip1
        rad_b1c.setPrefSize(120, 38);
        rad_b1c.setToggleGroup(toggleGroup);
        
        Label lbltimego1 = new Label("Go");
        lbltimego1.setAlignment(Pos.CENTER);
        lbltimego1.setPrefSize(150, 75);
        Label lbltime1 = new Label("9:00 AM");
        lbltime1.setAlignment(Pos.CENTER);
        lbltime1.setPrefSize(150, 75);
        
        
        //label for show price
        int p1 = 25;
        Label lblprice1_2 = new Label(p1+"$");
        lblprice1_2.setAlignment(Pos.CENTER);
        lblprice1_2.setPrefSize(150, 75);
    
        //label for  arrive time
        Label lblarrivetime1 = new Label("Arrive");
        lblarrivetime1.setAlignment(Pos.CENTER);
        lblarrivetime1.setPrefSize(150, 75);
        
        //label for showing time
        Label lbltime2 = new Label("12:00 PM");
        lbltime2.setAlignment(Pos.CENTER);
        lbltime2.setPrefSize(150, 75);
    
        //hbox for adding trip2 info
        HBox h1 = new HBox(20);
        h1.setPrefSize(820, 50);
        h1.getChildren().addAll(rad_b1c,lbltimego1,lbltime1, lblprice1_2, lblarrivetime1, lbltime2);
        
        //line under radio button 2
        Line l1 =new Line();
        l1.setEndX(910);
    
        //radio button for trip2
        rad_b2c.setPrefSize(120, 38);
        rad_b2c.setToggleGroup(toggleGroup);
        
        //label for time
        Label lbltimego2 = new Label("Go");
        lbltimego2.setAlignment(Pos.CENTER);
        lbltimego2.setPrefSize(150, 75);
        Label lbltime3 = new Label("1:30 PM");
        lbltime3.setAlignment(Pos.CENTER);
        lbltime3.setPrefSize(150, 75);
    
        //label for show price
        int p2 = 23;
        Label lblprice2_2 = new Label(p2+" $");
        lblprice2_2.setAlignment(Pos.CENTER);
        lblprice2_2.setPrefSize(150, 75);
    
        //label for text on it arrive go
        Label lblarrivetime2 = new Label("Arrive");
        lblarrivetime2.setAlignment(Pos.CENTER);
        lblarrivetime2.setPrefSize(150, 75);
    
        //label for showing time
        Label lbltime4 = new Label("3:30 PM");
        lbltime4.setAlignment(Pos.CENTER);
        lbltime4.setPrefSize(150, 75);
    
        //hbox for adding trip2 info
        HBox h2 = new HBox(20);
        h2.setPrefSize(820, 50);
        h2.getChildren().addAll(rad_b2c,lbltimego2,lbltime3, lblprice2_2, lblarrivetime2, lbltime4);
        
        //line under radio button 2
        Line l2 =new Line();
        l2.setEndX(910);
        
        //radio button for trip3
        rad_b3c.setPrefSize(120, 38);
        rad_b3c.setToggleGroup(toggleGroup);
        
       //label for time
       Label lbltimego3 =new Label("Go");
       lbltimego3.setAlignment(Pos.CENTER);
       lbltimego3.setPrefSize(150, 75);
       Label lbltime5 = new Label("5:30 PM");
       lbltime5.setAlignment(Pos.CENTER);
       lbltime5.setPrefSize(150, 75);
    
        //label for show price
        int p3 = 30;
        Label lblprice3_2 = new Label(p3+" $");
        lblprice3_2.setAlignment(Pos.CENTER);
        lblprice3_2.setPrefSize(150, 75);
        
        //label for  arrive
        Label lblarrivetime3 = new Label("Arrive ");
        lblarrivetime3.setAlignment(Pos.CENTER);
        lblarrivetime3.setPrefSize(150, 75);
        
        //label for showing time  
        Label lbltime6 = new Label("7:00 PM");
        lbltime6.setAlignment(Pos.CENTER);
        lbltime6.setPrefSize(150, 75);
        
        //hbox for adding trip3 info
        HBox h3 = new HBox(20);
        h3.setPrefSize(820, 50);
        h3.getChildren().addAll(rad_b3c,lbltimego3,lbltime5, lblprice3_2, lblarrivetime3, lbltime6);
        
        //line under radio button 3
        Line l3 =new Line();
        l3.setEndX(910);
        
        //vbox to add controll on it
        VBox v1 = new VBox(10);
        v1.getChildren().addAll( h1,l1,h2,l2, h3,l3);
        
        // add vbox on anchropane
        this.getChildren().addAll(v1);
        
        //handle for radio buttons
        rad_b1c.setOnAction(e ->{
          btnnext.setDisable(false);
          tripCar.setLeavingDate("09:00 AM");
          tripCar.setArrivalDate("12:00 PM");
          tripCar.setTripName("O-Travel");
          tripCar.setTripPrice(25);
        });
        
        rad_b2c.setOnAction(e ->{
          btnnext.setDisable(false);
          tripCar.setLeavingDate("1:30 PM");
          tripCar.setArrivalDate("3:30 PM");
          tripCar.setTripName("B-Travel");
          tripCar.setTripPrice(23);
        });
        
        rad_b3c.setOnAction(e ->{
          btnnext.setDisable(false);
          tripCar.setLeavingDate("5:30 PM");
          tripCar.setArrivalDate("7:00 PM");
          tripCar.setTripName("N-trevel");
          tripCar.setTripPrice(30);
        });
    }

    public Trip getTrip() {
        return tripCar;
    } 
}
