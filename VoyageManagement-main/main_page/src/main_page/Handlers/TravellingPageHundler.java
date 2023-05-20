/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_page.Handlers;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import static main_page.Scenes.Hotel_Resevation.confirm;
import static main_page.Scenes.Hotel_Resevation.total_price;
import static main_page.Scenes.TravellingPage.btncar;
import static main_page.Scenes.TravellingPage.btnbus;
import static main_page.Scenes.TravellingPage.btntrain;
import static main_page.Scenes.TravellingPage.btnflaght;



/**
 *
 * @author sayed
 */
public class TravellingPageHundler implements EventHandler<ActionEvent> {
    public LocalDate Date;
    public DatePicker Date_in;

    public TravellingPageHundler(LocalDate Date, DatePicker Date_in) {
        this.Date = Date;
        this.Date_in = Date_in;
    }

    @Override
    public void handle(ActionEvent event) {
        try{
            if(null == Date || null == Date_in ){
                btncar.setDisable(true);
                btnbus.setDisable(true);
                btntrain.setDisable(true);
                btnflaght.setDisable(true);
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Please, Enter Date");
                errorAlert.showAndWait();
            }
        }
         catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    
}
