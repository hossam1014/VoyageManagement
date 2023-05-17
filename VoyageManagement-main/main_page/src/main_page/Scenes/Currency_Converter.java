/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_page.Scenes;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main_page.Handlers.CurrencyConverterHandler;

/**
 *
 * @author Ehab
 */
public class Currency_Converter extends Scene {
    /* Vaiables used in Handler Class */
    public static TextField amount = new TextField();
    public static ComboBox currency_from = new ComboBox<>(FXCollections.observableArrayList(
        "Egyptian Pound",
        "US Dollar",
        "UK Pound",
        "Europe Euro"
    ));
    public static ComboBox currency_to = new ComboBox<>(FXCollections.observableArrayList(
        "Egyptian Pound",
        "US Dollar",
        "UK Pound",
        "Europe Euro"
    ));
    public static TextField converted_currency = new TextField();
    
    public Currency_Converter(Stage primaryStage) {
        super(new StackPane(),600, 600);
        StackPane root = (StackPane)this.getRoot();
        
        VBox page = new VBox(30);
        page.setAlignment(Pos.CENTER);
        root.getChildren().add(page);
        
        /* GridPane to contain user entred info about converting */
        GridPane info = new GridPane();
        info.setAlignment(Pos.CENTER);
        info.setPadding(new Insets(20));
        info.setHgap(20);
        info.setVgap(20);
        
        /* Labels */
        Label lbl_amount = new Label("Amount");
        Label lbl_currency_from = new Label("From");
        Label lbl_currency_to = new Label("To");
        
        /* Set Size */
        amount.setPrefWidth(180);
        amount.setMaxWidth(180);
        currency_from.setPrefWidth(180);
        currency_from.setMaxWidth(180);
        currency_to.setPrefWidth(180);
        currency_to.setMaxWidth(180);
        
        /* set PromptText */
        amount.setPromptText("0.0");
        
        /* Adding to info GridPane */
        info.addRow(0, lbl_amount,amount);
        info.addRow(1, lbl_currency_from,currency_from);
        info.addRow(2, lbl_currency_to,currency_to);
        
        /* Convert button */
        Button btn_convert = new Button("Convert");
        
        /* converted currency TextField result */   
        converted_currency.setPromptText("0.0");
        converted_currency.setEditable(false);
        converted_currency.setPrefWidth(180);
        converted_currency.setMaxWidth(180);
        
        /* Return to main Page */
        Button main_page = new Button("main page");
        main_page.setOnAction(e->{
            primaryStage.setScene(new main_page_demo(primaryStage));
        });
        
        /* Get Children of the page */
        page.getChildren().addAll(info,btn_convert,converted_currency,main_page);
        
        /* convert Button Handler */
        btn_convert.setOnAction(new CurrencyConverterHandler());
    }
}

