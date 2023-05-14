/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_page.Scenes;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class T_R extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         /**** Travelling Reservation Page ****/
        /* Stack pane */
        StackPane root = new StackPane();
        root.setPrefSize(1080, 720);
        
        /* H Box for two AnchorPane */
        HBox anc = new HBox();
        //VBOX 
        VBox v1 = new VBox();
        
        
        
        /* AnchorPane left-page & right-page & car page & train page & flaght page & bus bage  */
        AnchorPane left = new AnchorPane();
        AnchorPane right = new AnchorPane();
        AnchorPane carpane = new AnchorPane();
        AnchorPane flaghtpane = new AnchorPane();
        AnchorPane trainpane = new AnchorPane();
        AnchorPane buspane = new AnchorPane();
        
        //add right page ,carpane,trainpane,flaghtpane and buspane to vbox
        v1.getChildren().addAll(right, carpane);
        v1.setLayoutX(342);
        /* get Childern */
        anc.getChildren().addAll(left,v1);
        anc.setLayoutX(400);
        root.getChildren().addAll(anc);
        
        /* set Size and Style for the page */
        
        left.setPrefSize(341, 759);
        left.setLayoutX(0);
        left.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf);");
        
        right.setPrefSize(920, 282);
        right.setLayoutX(342);
        right.setStyle("-fx-background-color: white");
        
        carpane.setPrefSize(920, 400);
        carpane.setStyle("-fx-background-color: white");
        carpane.setLayoutX(341);
        carpane.setLayoutY(292);
        
        trainpane.setPrefSize(920, 400);
        trainpane.setStyle("-fx-background-color: white");
        trainpane.setLayoutX(20);
        trainpane.setLayoutY(292);
        
        flaghtpane.setPrefSize(920, 400);
        flaghtpane.setStyle("-fx-background-color: white");
        flaghtpane.setLayoutX(20);
        flaghtpane.setLayoutY(292);
        
        buspane.setPrefSize(920, 400);
        buspane.setStyle("-fx-background-color: white");
        buspane.setLayoutX(20);
        buspane.setLayoutY(292);
        
        /* Left page controls */
        /** previous page button **/
        Button prev_page = new Button("Previous Page");
        prev_page.setLayoutX(106);
        prev_page.setLayoutY(653);
        prev_page.setPrefSize(130, 48);
        prev_page.setStyle("-fx-font: 18 Serif; -fx-base: #06063f;");
        
        /** Username Label **/
        Label username = new Label("Username");
        username.setAlignment(Pos.CENTER);
        username.setLayoutX(69);
        username.setLayoutY(151);
        username.setPrefSize(203, 75);
        username.setTextFill(Color.WHITE);
        username.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
        /** User icon **/
        
        /** Line 1 **/
        Line l1 = new Line();
        l1.setScaleX(1);
        l1.setScaleY(1);
        l1.setScaleZ(1);
        l1.setLayoutX(129);
        l1.setLayoutY(226);
        l1.setStartX(-127);
        l1.setStartY(0);
        l1.setEndX(212);
        l1.setEndY(0);
        l1.setStroke(Color.ALICEBLUE);
        
        /* get childern of left page */
        left.getChildren().addAll(prev_page, username, l1);
        
        //right page conterllor
        //from where travael
        Label lblfrom =new Label("From");
        lblfrom.setPrefSize(80, 30);
        lblfrom.setAlignment(Pos.CENTER);
        
        //to where travael
        Label lblto =new Label("To");
        lblto.setPrefSize(80, 30);
        lblto.setAlignment(Pos.CENTER);
        
        //text field for from 
        TextField txtfrom =new TextField();
        txtfrom.setPrefSize(141, 30);
        
        //textfield for to
         TextField txtto =new TextField();
        txtto.setPrefSize(141, 30);
        
        //context menue for search
    ContextMenu contextMenu = new ContextMenu();
    MenuItem item1 = new MenuItem("Option 1");
    MenuItem item2 = new MenuItem("Option 2");
    MenuItem item3 = new MenuItem("Option 3");
    MenuItem item4 = new MenuItem("Option 4");
    MenuItem item5 = new MenuItem("Option 5");
    MenuItem item6 = new MenuItem("Option 6");
    MenuItem item7 = new MenuItem("Option 7");
    MenuItem item8 = new MenuItem("Option 8");
    contextMenu.getItems().addAll(item1, item2, item3, item4, item5, item6, item7, item8);
    
    txtfrom.setContextMenu(contextMenu);
    txtto.setContextMenu(contextMenu);
    
    //put control in h box
    HBox h1 =new HBox();
    h1.getChildren().addAll(lblfrom, txtfrom, lblto, txtto);
    h1.setSpacing(10);
    h1.setPrefSize(604, 48);
    h1.setLayoutX(20);
    h1.setLayoutY(42);
    
    //fonts
     Font font_buttons = Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 19);
     Font font_Labels = Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 33);
    
    
    //First line  
    Line line1 = new Line();
    line1.setScaleX(1);
    line1.setScaleY(1);
    line1.setScaleZ(1);
    line1.setLayoutX(336); 
    line1.setLayoutY(80);
    line1.setStartX(-344);
    line1.setStartY(9);
    line1.setEndX(920);
    line1.setEndY(9);
    line1.setStroke(Color.valueOf("#22406b"));
    
    /* Check Date */
    Label l_in = new Label("Date");
    DatePicker date_in = new DatePicker();
        
    l_in.setLayoutX(20);
    l_in.setLayoutY(100);
    l_in.setPrefSize(141, 38);
    l_in.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 19));
    l_in.setTextFill(Color.DARKBLUE);
    date_in.setLayoutX(20);
    date_in.setLayoutY(145);
    date_in.setPrefSize(203, 38);
    date_in.setPromptText("DD-MM-YYYY");
        
        //Second line
    Line line2 = new Line();
    line2.setScaleX(1);
    line2.setScaleY(1);
    line2.setScaleZ(1);
    line2.setLayoutX(336); 
    line2.setLayoutY(193);
    line2.setStartX(-344);
    line2.setStartY(9);
    line2.setEndX(920);
    line2.setEndY(9);
    line2.setStroke(Color.valueOf("#22406b"));
    
    // button fot how you want to travel
    Button btncar =new Button("Car");
    btncar.setLayoutX(20);
    btncar.setLayoutY(223);
    btncar.setPrefSize(97, 48);
    btncar.setFont(font_buttons);
    btncar.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btncar.setTextFill(Color.WHITE);
    
    Button btntrain =new Button("Train");
    btntrain.setLayoutX(147);
    btntrain.setLayoutY(223);
    btntrain.setPrefSize(97, 48);
    btntrain.setFont(font_buttons);
    btntrain.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btntrain.setTextFill(Color.WHITE);
    
    Button btnfly =new Button("Flaght");
    btnfly.setLayoutX(276);
    btnfly.setLayoutY(223);
    btnfly.setPrefSize(97, 48);
    btnfly.setFont(font_buttons);
    btnfly.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btnfly.setTextFill(Color.WHITE);
    
    Button btnbus =new Button("Bus");
    btnbus.setLayoutX(403);
    btnbus.setLayoutY(223);
    btnbus.setPrefSize(97, 48);
    btnbus.setFont(font_buttons);
    btnbus.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btnbus.setTextFill(Color.WHITE);
    
    //third line
    Line line3 = new Line();
    line3.setScaleX(1);
    line3.setScaleY(1);
    line3.setScaleZ(1);
    line3.setLayoutX(336); 
    line3.setLayoutY(281);
    line3.setStartX(-344);
    line3.setStartY(9);
    line3.setEndX(920);
    line3.setEndY(9);
    line3.setStroke(Color.valueOf("#22406b"));
    
    //carpane controller
    //radoi buttons
    RadioButton rad_b1 = new RadioButton("trip1");
    rad_b1.setPrefSize(120, 38);
    rad_b1.setLayoutX(20);
    rad_b1.setLayoutY(20);
    rad_b1.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice1 = new Label("price");
    lblprice1.setAlignment(Pos.CENTER);
    lblprice1.setLayoutX(160);
    lblprice1.setLayoutY(10);
    lblprice1.setPrefSize(150, 75);
    lblprice1.setTextFill(Color.BLACK);
    lblprice1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int p = 0;
    Label lblprice1_2 = new Label(p+"$");
    lblprice1_2.setAlignment(Pos.CENTER);
    lblprice1_2.setLayoutX(320);
    lblprice1_2.setLayoutY(10);
    lblprice1_2.setPrefSize(150, 75);
    lblprice1_2.setTextFill(Color.BLACK);
    lblprice1_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //forth line
    Line line4 = new Line();
    line4.setScaleX(1);
    line4.setScaleY(1);
    line4.setScaleZ(1);
    line4.setLayoutX(341); 
    line4.setLayoutY(68);
    line4.setStartX(-344);
    line4.setStartY(9);
    line4.setEndX(920);
    line4.setEndY(9);
    line4.setStroke(Color.valueOf("#22406b"));
    
     RadioButton rad_b2 = new RadioButton("trip2");
    rad_b2.setPrefSize(120, 38);
    rad_b2.setLayoutX(20);
    rad_b2.setLayoutY(78);
    rad_b2.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice2 = new Label("price");
    lblprice2.setAlignment(Pos.CENTER);
    lblprice2.setLayoutX(160);
    lblprice2.setLayoutY(68);
    lblprice2.setPrefSize(150, 75);
    lblprice2.setTextFill(Color.BLACK);
    lblprice2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int s = 0;
    Label lblprice2_2 = new Label(s+"$");
    lblprice2_2.setAlignment(Pos.CENTER);
    lblprice2_2.setLayoutX(320);
    lblprice2_2.setLayoutY(68);
    lblprice2_2.setPrefSize(150, 75);
    lblprice2_2.setTextFill(Color.BLACK);
    lblprice2_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //fivth line
    Line line5 = new Line();
    line5.setScaleX(1);
    line5.setScaleY(1);
    line5.setScaleZ(1);
    line5.setLayoutX(341); 
    line5.setLayoutY(126);
    line5.setStartX(-344);
    line5.setStartY(9);
    line5.setEndX(920);
    line5.setEndY(9);
    line5.setStroke(Color.valueOf("#22406b"));
    
    RadioButton rad_b3 = new RadioButton("trip3");
    rad_b3.setPrefSize(120, 38);
    rad_b3.setLayoutX(20);
    rad_b3.setLayoutY(136);
    rad_b3.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice3 = new Label("price");
    lblprice3.setAlignment(Pos.CENTER);
    lblprice3.setLayoutX(160);
    lblprice3.setLayoutY(126);
    lblprice3.setPrefSize(150, 75);
    lblprice3.setTextFill(Color.BLACK);
    lblprice3.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int x = 0;
    Label lblprice3_2 = new Label(x+"$");
    lblprice3_2.setAlignment(Pos.CENTER);
    lblprice3_2.setLayoutX(320);
    lblprice3_2.setLayoutY(126);
    lblprice3_2.setPrefSize(150, 75);
    lblprice3_2.setTextFill(Color.BLACK);
    lblprice3_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //sixth line
    Line line6 = new Line();
    line6.setScaleX(1);
    line6.setScaleY(1);
    line6.setScaleZ(1);
    line6.setLayoutX(341); 
    line6.setLayoutY(184);
    line6.setStartX(-344);
    line6.setStartY(9);
    line6.setEndX(920);
    line6.setEndY(9);
    line6.setStroke(Color.valueOf("#22406b"));
    
    //add button for confrm
    Button btnconferm =new Button("confirm");
    btnconferm.setLayoutX(203);
    btnconferm.setLayoutY(194);
    btnconferm.setPrefSize(100, 48);
    btnconferm.setFont(font_buttons);
    btnconferm.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btnconferm.setTextFill(Color.WHITE);
    
    //add itams to car page
     carpane.getChildren().addAll(rad_b1,rad_b2, rad_b3, lblprice1, lblprice2, lblprice3, lblprice1_2,lblprice2_2, lblprice3_2);
    
    
    //train page controll
    //radoi buttons
    RadioButton rad_b1t = new RadioButton("trip1");
    rad_b1t.setPrefSize(120, 38);
    rad_b1t.setLayoutX(20);
    rad_b1t.setLayoutY(20);
    rad_b1t.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice1t = new Label("price");
    lblprice1t.setAlignment(Pos.CENTER);
    lblprice1t.setLayoutX(160);
    lblprice1t.setLayoutY(10);
    lblprice1t.setPrefSize(150, 75);
    lblprice1t.setTextFill(Color.BLACK);
    lblprice1t.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int pt = 0;
    Label lblprice1_2t = new Label(pt+"$");
    lblprice1_2t.setAlignment(Pos.CENTER);
    lblprice1_2t.setLayoutX(320);
    lblprice1_2t.setLayoutY(10);
    lblprice1_2t.setPrefSize(150, 75);
    lblprice1_2t.setTextFill(Color.BLACK);
    lblprice1_2t.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //three label to show go and arrive time
    Label lblgot = new Label("go and arrive");
    lblgot.setAlignment(Pos.CENTER);
    lblgot.setLayoutX(480);
    lblgot.setLayoutY(10);
    lblgot.setPrefSize(150, 75);
    lblgot.setTextFill(Color.BLACK);
    lblgot.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimego = new Label("");
    lbltimego.setAlignment(Pos.CENTER);
    lbltimego.setLayoutX(640);
    lbltimego.setLayoutY(10);
    lbltimego.setPrefSize(150, 75);
    lbltimego.setTextFill(Color.BLACK);
    lbltimego.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        Label lbltimearrive = new Label("");
    lbltimearrive.setAlignment(Pos.CENTER);
    lbltimearrive.setLayoutX(800);
    lbltimearrive.setLayoutY(10);
    lbltimearrive.setPrefSize(120, 75);
    lbltimearrive.setTextFill(Color.BLACK);
    lbltimearrive.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //forth line
    Line line4t = new Line();
    line4t.setScaleX(1);
    line4t.setScaleY(1);
    line4t.setScaleZ(1);
    line4t.setLayoutX(341); 
    line4t.setLayoutY(68);
    line4t.setStartX(-344);
    line4t.setStartY(9);
    line4t.setEndX(920);
    line4t.setEndY(9);
    line4t.setStroke(Color.valueOf("#22406b"));
    
     RadioButton rad_b2t = new RadioButton("trip2");
    rad_b2t.setPrefSize(120, 38);
    rad_b2t.setLayoutX(20);
    rad_b2t.setLayoutY(78);
    rad_b2t.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice2t = new Label("price");
    lblprice2t.setAlignment(Pos.CENTER);
    lblprice2t.setLayoutX(160);
    lblprice2t.setLayoutY(68);
    lblprice2t.setPrefSize(150, 75);
    lblprice2t.setTextFill(Color.BLACK);
    lblprice2t.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int st = 0;
    Label lblprice2_2t = new Label(st+"$");
    lblprice2_2t.setAlignment(Pos.CENTER);
    lblprice2_2t.setLayoutX(320);
    lblprice2_2t.setLayoutY(68);
    lblprice2_2t.setPrefSize(150, 75);
    lblprice2_2t.setTextFill(Color.BLACK);
    lblprice2_2t.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //three label to show go and arrive time
    Label lblgot1 = new Label("go and arrive");
    lblgot1.setAlignment(Pos.CENTER);
    lblgot1.setLayoutX(480);
    lblgot1.setLayoutY(68);
    lblgot1.setPrefSize(150, 75);
    lblgot1.setTextFill(Color.BLACK);
    lblgot1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimego1 = new Label("");
    lbltimego1.setAlignment(Pos.CENTER);
    lbltimego1.setLayoutX(640);
    lbltimego1.setLayoutY(68);
    lbltimego1.setPrefSize(150, 75);
    lbltimego1.setTextFill(Color.BLACK);
    lbltimego1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearrive1 = new Label("");
    lbltimearrive1.setAlignment(Pos.CENTER);
    lbltimearrive1.setLayoutX(800);
    lbltimearrive1.setLayoutY(68);
    lbltimearrive1.setPrefSize(120, 75);
    lbltimearrive1.setTextFill(Color.BLACK);
    lbltimearrive1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //fivth line
    Line line5t = new Line();
    line5t.setScaleX(1);
    line5t.setScaleY(1);
    line5t.setScaleZ(1);
    line5t.setLayoutX(341); 
    line5t.setLayoutY(126);
    line5t.setStartX(-344);
    line5t.setStartY(9);
    line5t.setEndX(920);
    line5t.setEndY(9);
    line5t.setStroke(Color.valueOf("#22406b"));
    
    RadioButton rad_b3t = new RadioButton("trip3");
    rad_b3t.setPrefSize(120, 38);
    rad_b3t.setLayoutX(20);
    rad_b3t.setLayoutY(136);
    rad_b3t.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice3t = new Label("price");
    lblprice3t.setAlignment(Pos.CENTER);
    lblprice3t.setLayoutX(160);
    lblprice3t.setLayoutY(126);
    lblprice3t.setPrefSize(150, 75);
    lblprice3t.setTextFill(Color.BLACK);
    lblprice3t.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int xt = 0;
    Label lblprice3_2t = new Label(xt+"$");
    lblprice3_2t.setAlignment(Pos.CENTER);
    lblprice3_2t.setLayoutX(320);
    lblprice3_2t.setLayoutY(126);
    lblprice3_2t.setPrefSize(150, 75);
    lblprice3_2t.setTextFill(Color.BLACK);
    lblprice3_2t.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    
    Label lblgot2 = new Label("trip will go and arrive at");
    lblgot2.setAlignment(Pos.CENTER);
    lblgot2.setLayoutX(480);
    lblgot2.setLayoutY(126);
    lblgot2.setPrefSize(150, 75);
    lblgot2.setTextFill(Color.BLACK);
    lblgot2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimego2 = new Label("");
    lbltimego2.setAlignment(Pos.CENTER);
    lbltimego2.setLayoutX(640);
    lbltimego2.setLayoutY(126);
    lbltimego2.setPrefSize(150, 75);
    lbltimego2.setTextFill(Color.BLACK);
    lbltimego2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearrive2 = new Label("");
    lbltimearrive2.setAlignment(Pos.CENTER);
    lbltimearrive2.setLayoutX(800);
    lbltimearrive2.setLayoutY(126);
    lbltimearrive2.setPrefSize(120, 75);
    lbltimearrive2.setTextFill(Color.BLACK);
    lbltimearrive2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
         //sixth line
    Line line6t = new Line();
    line6t.setScaleX(1);
    line6t.setScaleY(1);
    line6t.setScaleZ(1);
    line6t.setLayoutX(341); 
    line6t.setLayoutY(184);
    line6t.setStartX(-344);
    line6t.setStartY(9);
    line6t.setEndX(920);
    line6t.setEndY(9);
    line6t.setStroke(Color.valueOf("#22406b"));
    
    //add button for confrm
    Button btnconferm1 =new Button("confirm");
    btnconferm1.setLayoutX(203);
    btnconferm1.setLayoutY(194);
    btnconferm1.setPrefSize(100, 48);
    btnconferm1.setFont(font_buttons);
    btnconferm1.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btnconferm1.setTextFill(Color.WHITE);
    
    //add itams to train page
    trainpane.getChildren().addAll(rad_b1, lblprice1, lblprice1_2, line4, rad_b2, lblprice2, lblprice2_2, line5,  rad_b3, lblprice3, lblprice3_2, line6, btnconferm, lblgot, lblgot1, lblgot2, lbltimego, lbltimego1,lbltimego2, lbltimearrive, lbltimearrive1, lbltimearrive2);
    
    //bus page controll
    //radoi buttons
    RadioButton rad_bb1 = new RadioButton("trip1");
    rad_bb1.setPrefSize(120, 38);
    rad_bb1.setLayoutX(20);
    rad_bb1.setLayoutY(20);
    rad_bb1.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice1b = new Label("price");
    lblprice1b.setAlignment(Pos.CENTER);
    lblprice1b.setLayoutX(160);
    lblprice1b.setLayoutY(10);
    lblprice1b.setPrefSize(150, 75);
    lblprice1b.setTextFill(Color.BLACK);
    lblprice1b.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int pb = 0;
    Label lblpriceb1_2 = new Label(pb+"$");
    lblpriceb1_2.setAlignment(Pos.CENTER);
    lblpriceb1_2.setLayoutX(320);
    lblpriceb1_2.setLayoutY(10);
    lblpriceb1_2.setPrefSize(150, 75);
    lblpriceb1_2.setTextFill(Color.BLACK);
    lblpriceb1_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //three label to show go and arrive time
    Label lblgotb = new Label("go and arrive");
    lblgotb.setAlignment(Pos.CENTER);
    lblgotb.setLayoutX(480);
    lblgotb.setLayoutY(10);
    lblgotb.setPrefSize(150, 75);
    lblgotb.setTextFill(Color.BLACK);
    lblgotb.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimegob = new Label("");
    lbltimegob.setAlignment(Pos.CENTER);
    lbltimegob.setLayoutX(640);
    lbltimegob.setLayoutY(10);
    lbltimegob.setPrefSize(150, 75);
    lbltimegob.setTextFill(Color.BLACK);
    lbltimegob.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearriveb = new Label("");
    lbltimearriveb.setAlignment(Pos.CENTER);
    lbltimearriveb.setLayoutX(800);
    lbltimearriveb.setLayoutY(10);
    lbltimearriveb.setPrefSize(120, 75);
    lbltimearriveb.setTextFill(Color.BLACK);
    lbltimearriveb.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //forth line
    Line lineb4 = new Line();
    lineb4.setScaleX(1);
    lineb4.setScaleY(1);
    lineb4.setScaleZ(1);
    lineb4.setLayoutX(341); 
    lineb4.setLayoutY(68);
    lineb4.setStartX(-344);
    lineb4.setStartY(9);
    lineb4.setEndX(920);
    lineb4.setEndY(9);
    lineb4.setStroke(Color.valueOf("#22406b"));
    
     RadioButton rad_bb2 = new RadioButton("trip2");
    rad_bb2.setPrefSize(120, 38);
    rad_bb2.setLayoutX(20);
    rad_bb2.setLayoutY(78);
    rad_bb2.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblpriceb2 = new Label("price");
    lblpriceb2.setAlignment(Pos.CENTER);
    lblpriceb2.setLayoutX(160);
    lblpriceb2.setLayoutY(68);
    lblpriceb2.setPrefSize(150, 75);
    lblpriceb2.setTextFill(Color.BLACK);
    lblpriceb2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int sb = 0;
    Label lblpriceb2_2 = new Label(sb+"$");
    lblpriceb2_2.setAlignment(Pos.CENTER);
    lblpriceb2_2.setLayoutX(320);
    lblpriceb2_2.setLayoutY(68);
    lblpriceb2_2.setPrefSize(150, 75);
    lblpriceb2_2.setTextFill(Color.BLACK);
    lblpriceb2_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //three label to show go and arrive time
    Label lblgotb1 = new Label("go and arrive");
    lblgotb1.setAlignment(Pos.CENTER);
    lblgotb1.setLayoutX(480);
    lblgotb1.setLayoutY(68);
    lblgotb1.setPrefSize(150, 75);
    lblgotb1.setTextFill(Color.BLACK);
    lblgotb1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimegob1 = new Label("");
    lbltimegob1.setAlignment(Pos.CENTER);
    lbltimegob1.setLayoutX(640);
    lbltimegob1.setLayoutY(68);
    lbltimegob1.setPrefSize(150, 75);
    lbltimegob1.setTextFill(Color.BLACK);
    lbltimegob1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearriveb1 = new Label("");
    lbltimearriveb1.setAlignment(Pos.CENTER);
    lbltimearriveb1.setLayoutX(800);
    lbltimearriveb1.setLayoutY(68);
    lbltimearriveb1.setPrefSize(120, 75);
    lbltimearriveb1.setTextFill(Color.BLACK);
    lbltimearriveb1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //fivth line
    Line lineb5 = new Line();
    lineb5.setScaleX(1);
    lineb5.setScaleY(1);
    lineb5.setScaleZ(1);
    lineb5.setLayoutX(341); 
    lineb5.setLayoutY(126);
    lineb5.setStartX(-344);
    lineb5.setStartY(9);
    lineb5.setEndX(920);
    lineb5.setEndY(9);
    lineb5.setStroke(Color.valueOf("#22406b"));
    
    RadioButton rad_bb3 = new RadioButton("trip3");
    rad_bb3.setPrefSize(120, 38);
    rad_bb3.setLayoutX(20);
    rad_bb3.setLayoutY(136);
    rad_bb3.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblpriceb3 = new Label("price");
    lblpriceb3.setAlignment(Pos.CENTER);
    lblpriceb3.setLayoutX(160);
    lblpriceb3.setLayoutY(126);
    lblpriceb3.setPrefSize(150, 75);
    lblpriceb3.setTextFill(Color.BLACK);
    lblpriceb3.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int xb = 0;
    Label lblpriceb3_2 = new Label(xb+"$");
    lblpriceb3_2.setAlignment(Pos.CENTER);
    lblpriceb3_2.setLayoutX(320);
    lblpriceb3_2.setLayoutY(126);
    lblpriceb3_2.setPrefSize(150, 75);
    lblpriceb3_2.setTextFill(Color.BLACK);
    lblpriceb3_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    
    Label lblgotb2 = new Label("go and arrive");
    lblgotb2.setAlignment(Pos.CENTER);
    lblgotb2.setLayoutX(480);
    lblgotb2.setLayoutY(126);
    lblgotb2.setPrefSize(150, 75);
    lblgotb2.setTextFill(Color.BLACK);
    lblgotb2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimegob2 = new Label("");
    lbltimegob2.setAlignment(Pos.CENTER);
    lbltimegob2.setLayoutX(640);
    lbltimegob2.setLayoutY(126);
    lbltimegob2.setPrefSize(150, 75);
    lbltimegob2.setTextFill(Color.BLACK);
    lbltimegob2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearriveb2 = new Label("");
    lbltimearriveb2.setAlignment(Pos.CENTER);
    lbltimearriveb2.setLayoutX(800);
    lbltimearriveb2.setLayoutY(126);
    lbltimearriveb2.setPrefSize(120, 75);
    lbltimearriveb2.setTextFill(Color.BLACK);
    lbltimearriveb2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
         //sixth line
    Line lineb6 = new Line();
    lineb6.setScaleX(1);
    lineb6.setScaleY(1);
    lineb6.setScaleZ(1);
    lineb6.setLayoutX(341); 
    lineb6.setLayoutY(184);
    lineb6.setStartX(-344);
    lineb6.setStartY(9);
    lineb6.setEndX(920);
    lineb6.setEndY(9);
    lineb6.setStroke(Color.valueOf("#22406b"));
    
    //add button for confrm
    Button btnconfermb =new Button("confirm");
    btnconfermb.setLayoutX(203);
    btnconfermb.setLayoutY(194);
    btnconfermb.setPrefSize(100, 48);
    btnconfermb.setFont(font_buttons);
    btnconfermb.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btnconfermb.setTextFill(Color.WHITE);
    
    //add itams to train page
    buspane.getChildren().addAll(rad_bb1, lblprice1b, lblpriceb1_2, lineb4, rad_bb2, lblpriceb2, lblpriceb2_2, lineb5,  rad_bb3, lblpriceb3, lblpriceb3_2, lineb6, btnconfermb, lblgotb, lblgotb1, lblgotb2, lbltimegob, lbltimegob1,lbltimegob2, lbltimearriveb, lbltimearriveb1, lbltimearriveb2);
    
    //flaght page controll
    //radoi buttons
    RadioButton rad_b1f = new RadioButton("trip1");
    rad_b1f.setPrefSize(120, 38);
    rad_b1f.setLayoutX(20);
    rad_b1f.setLayoutY(20);
    rad_b1f.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblprice1f = new Label("price");
    lblprice1f.setAlignment(Pos.CENTER);
    lblprice1f.setLayoutX(160);
    lblprice1f.setLayoutY(10);
    lblprice1f.setPrefSize(150, 75);
    lblprice1f.setTextFill(Color.BLACK);
    lblprice1f.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int pf = 0;
    Label lblpricef1_2 = new Label(pf+"$");
    lblpricef1_2.setAlignment(Pos.CENTER);
    lblpricef1_2.setLayoutX(320);
    lblpricef1_2.setLayoutY(10);
    lblpricef1_2.setPrefSize(150, 75);
    lblpricef1_2.setTextFill(Color.BLACK);
    lblpricef1_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //three label to show go and arrive time
    Label lblgof = new Label("go and arrive");
    lblgof.setAlignment(Pos.CENTER);
    lblgof.setLayoutX(480);
    lblgof.setLayoutY(10);
    lblgof.setPrefSize(150, 75);
    lblgof.setTextFill(Color.BLACK);
    lblgof.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimegof = new Label("");
    lbltimegof.setAlignment(Pos.CENTER);
    lbltimegof.setLayoutX(640);
    lbltimegof.setLayoutY(10);
    lbltimegof.setPrefSize(150, 75);
    lbltimegof.setTextFill(Color.BLACK);
    lbltimegof.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearrivef = new Label("");
    lbltimearrivef.setAlignment(Pos.CENTER);
    lbltimearrivef.setLayoutX(800);
    lbltimearrivef.setLayoutY(10);
    lbltimearrivef.setPrefSize(120, 75);
    lbltimearrivef.setTextFill(Color.BLACK);
    lbltimearrivef.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //forth line
    Line linef4 = new Line();
    linef4.setScaleX(1);
    linef4.setScaleY(1);
    linef4.setScaleZ(1);
    linef4.setLayoutX(341); 
    linef4.setLayoutY(68);
    linef4.setStartX(-344);
    linef4.setStartY(9);
    linef4.setEndX(920);
    linef4.setEndY(9);
    linef4.setStroke(Color.valueOf("#22406b"));
    
     RadioButton rad_bf2 = new RadioButton("trip2");
    rad_bf2.setPrefSize(120, 38);
    rad_bf2.setLayoutX(20);
    rad_bf2.setLayoutY(78);
    rad_bf2.setTextFill(Color.valueOf("#517bba"));
        
    //add label for price
    Label lblpricef2 = new Label("price");
    lblpricef2.setAlignment(Pos.CENTER);
    lblpricef2.setLayoutX(160);
    lblpricef2.setLayoutY(68);
    lblpricef2.setPrefSize(150, 75);
    lblpricef2.setTextFill(Color.BLACK);
    lblpricef2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int sf = 0;
    Label lblpricef2_2 = new Label(sf+"$");
    lblpricef2_2.setAlignment(Pos.CENTER);
    lblpricef2_2.setLayoutX(320);
    lblpricef2_2.setLayoutY(68);
    lblpricef2_2.setPrefSize(150, 75);
    lblpricef2_2.setTextFill(Color.BLACK);
    lblpricef2_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //three label to show go and arrive time
    Label lblgof1 = new Label("go and arrive");
    lblgof1.setAlignment(Pos.CENTER);
    lblgof1.setLayoutX(480);
    lblgof1.setLayoutY(68);
    lblgof1.setPrefSize(150, 75);
    lblgof1.setTextFill(Color.BLACK);
    lblgof1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimegof1 = new Label("");
    lbltimegof1.setAlignment(Pos.CENTER);
    lbltimegof1.setLayoutX(640);
    lbltimegof1.setLayoutY(68);
    lbltimegof1.setPrefSize(150, 75);
    lbltimegof1.setTextFill(Color.BLACK);
    lbltimegof1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearrivef1 = new Label("");
    lbltimearrivef1.setAlignment(Pos.CENTER);
    lbltimearrivef1.setLayoutX(800);
    lbltimearrivef1.setLayoutY(68);
    lbltimearrivef1.setPrefSize(120, 75);
    lbltimearrivef1.setTextFill(Color.BLACK);
    lbltimearrivef1.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
        
         //fivth line
    Line linef5 = new Line();
    linef5.setScaleX(1);
    linef5.setScaleY(1);
    linef5.setScaleZ(1);
    linef5.setLayoutX(341); 
    linef5.setLayoutY(126);
    linef5.setStartX(-344);
    linef5.setStartY(9);
    linef5.setEndX(920);
    linef5.setEndY(9);
    linef5.setStroke(Color.valueOf("#22406b"));
    
    RadioButton rad_bf3 = new RadioButton("trip3");
    rad_bf3.setPrefSize(120, 38);
    rad_bf3.setLayoutX(20);
    rad_bf3.setLayoutY(136);
    rad_bf3.setTextFill(Color.valueOf("#517bba"));
       
    //add label for price
    Label lblpricef3 = new Label("price");
    lblpricef3.setAlignment(Pos.CENTER);
    lblpricef3.setLayoutX(160);
    lblpricef3.setLayoutY(126);
    lblpricef3.setPrefSize(150, 75);
    lblpricef3.setTextFill(Color.BLACK);
    lblpricef3.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    //label for show price
    int xf = 0;
    Label lblpricef3_2 = new Label(xf+"$");
    lblpricef3_2.setAlignment(Pos.CENTER);
    lblpricef3_2.setLayoutX(320);
    lblpricef3_2.setLayoutY(126);
    lblpricef3_2.setPrefSize(150, 75);
    lblpricef3_2.setTextFill(Color.BLACK);
    lblpricef3_2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    
    Label lblgof2 = new Label("go and arrive");
    lblgof2.setAlignment(Pos.CENTER);
    lblgof2.setLayoutX(480);
    lblgof2.setLayoutY(126);
    lblgof2.setPrefSize(150, 75);
    lblgof2.setTextFill(Color.BLACK);
    lblgof2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimegof2 = new Label("");
    lbltimegof2.setAlignment(Pos.CENTER);
    lbltimegof2.setLayoutX(640);
    lbltimegof2.setLayoutY(126);
    lbltimegof2.setPrefSize(150, 75);
    lbltimegof2.setTextFill(Color.BLACK);
    lbltimegof2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
    
    Label lbltimearrivef2 = new Label("");
    lbltimearrivef2.setAlignment(Pos.CENTER);
    lbltimearrivef2.setLayoutX(800);
    lbltimearrivef2.setLayoutY(126);
    lbltimearrivef2.setPrefSize(120, 75);
    lbltimearrivef2.setTextFill(Color.BLACK);
    lbltimearrivef2.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 29));
   
         //sixth line
    Line linef6 = new Line();
    linef6.setScaleX(1);
    linef6.setScaleY(1);
    linef6.setScaleZ(1);
    linef6.setLayoutX(341); 
    linef6.setLayoutY(184);
    linef6.setStartX(-344);
    linef6.setStartY(9);
    linef6.setEndX(920);
    linef6.setEndY(9);
    linef6.setStroke(Color.valueOf("#22406b"));
    
    //add button for confrm
    Button btnconfermf =new Button("confirm");
    btnconfermf.setLayoutX(203);
    btnconfermf.setLayoutY(194);
    btnconfermf.setPrefSize(100, 48);
    btnconfermf.setFont(font_buttons);
    btnconfermf.setStyle("-fx-background-color: linear-gradient(to bottom right, #150a57, #5167bf)");
    btnconfermf.setTextFill(Color.WHITE);
    
    //add itams to train page
    flaghtpane.getChildren().addAll(rad_b1f, lblprice1f, lblpricef1_2, linef4, rad_bf2, lblpricef2, lblpricef2_2, linef5,  rad_bf3, lblpricef3, lblpricef3_2, linef6, btnconfermf, lblgof, lblgof1, lblgof2, lbltimegof, lbltimegof1,lbltimegof2, lbltimearrivef, lbltimearrivef1, lbltimearrivef2);
   
    
    //add itam to page right
    right.getChildren().addAll(h1, line1, l_in, date_in, line2, btncar, btntrain, btnfly, btnbus, line3);
    
    
    

        
        Scene scene = new Scene(root,1261,720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Travella");
        primaryStage.setResizable(true);
        primaryStage.show();
        
    }
       
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
