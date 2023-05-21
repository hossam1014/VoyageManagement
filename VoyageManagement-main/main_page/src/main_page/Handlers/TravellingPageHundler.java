package main_page.Handlers;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import java.time.temporal.ChronoUnit;
import static main_page.Scenes.TravellingPage.information_isFilled;
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

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }
    public void setDate_in(DatePicker Date_in) {
        this.Date_in = Date_in;
    }

    

    @Override
    public void handle(ActionEvent event) {
        try{
            if(null == Date || null == Date_in  ){
                btncar.setDisable(true);
                btnbus.setDisable(true);
                btntrain.setDisable(true);
                btnflaght.setDisable(true);
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Please, Enter Date");
                errorAlert.showAndWait();
            }
            else{
                information_isFilled = checkInformation(Date);
                if(information_isFilled){
                btncar.setDisable(false);
                btnbus.setDisable(false);
                btntrain.setDisable(false);
                btnflaght.setDisable(false);  
                }
            }
        }
         catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    
    public boolean checkInformation(LocalDate Date_in){
        if(null == Date_in){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please, Select Check-in Date");
            errorAlert.showAndWait();
            return false;
        }
        else
    return true;
    }
}
