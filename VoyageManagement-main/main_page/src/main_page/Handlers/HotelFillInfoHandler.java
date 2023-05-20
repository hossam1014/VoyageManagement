package main_page.Handlers;

import static main_page.Scenes.Hotel_Resevation.information_isFilled;
import static main_page.Scenes.Hotel_Resevation.total_price;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import static main_page.Scenes.Hotel_Resevation.confirm;
import static main_page.Scenes.Hotel_Resevation.var_hotel_type;
import static main_page.Scenes.Hotel_Resevation.var_room_capacity;
import static main_page.Scenes.Hotel_Resevation.var_room_price;

/**
 *
 * @author Ehab
 */
public class HotelFillInfoHandler implements EventHandler<ActionEvent> {
    
    public LocalDate start_date;
    public LocalDate end_date;
    public DatePicker date_in;
    public DatePicker date_out; 

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setDate_in(DatePicker date_in) {
        this.date_in = date_in;
    }

    public void setDate_out(DatePicker date_out) {
        this.date_out = date_out;
    }
    
    @Override
    /* Handling 'Done' Button */
    public void handle(ActionEvent event) {  
        try{
            if(null == date_in || null == date_out || null == start_date || null == end_date){
                total_price.setText("");
                confirm.setDisable(true);
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Please, Enter Check Date");
                errorAlert.showAndWait();
            }
            else if(start_date.compareTo(end_date) >= 0){
                total_price.setText("");
                confirm.setDisable(true);
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Invalid Date");
                errorAlert.setContentText("Please, Enter a valid Check Date");
                errorAlert.showAndWait();
                date_in.setValue(null);
                date_out.setValue(null);
            }
            else if(ChronoUnit.DAYS.between(start_date, end_date) > 14){
                total_price.setText("");
                confirm.setDisable(true);
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Invalid Date");
                errorAlert.setContentText("Sorry, You Can't book more than 14 days");
                errorAlert.showAndWait();
                date_out.setValue(null);
            }
            else{
                information_isFilled = checkInformation(start_date,end_date);
                if(information_isFilled){
                    int number_of_days = (int)ChronoUnit.DAYS.between(start_date, end_date);
                    int total_price_value = number_of_days * var_hotel_type;
                    total_price_value += (((double)var_room_price/2) * total_price_value);
                    total_price_value += (((double)var_room_capacity/3) * total_price_value);
                    total_price.setText(total_price_value+ " $");
                    confirm.setDisable(false);
                }
            }
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    
    /* Check if the user fill all the information */
    public boolean checkInformation(LocalDate start_date, LocalDate end_date){
        if(0 == var_hotel_type){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please, Select Hotel Type");
            errorAlert.showAndWait();
            return false;
        }
        if(0 == var_room_price){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please, Select Room Price");
            errorAlert.showAndWait();
            return false;
        }
        if(0 == var_room_capacity){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please, Select Room Capacity");
            errorAlert.showAndWait();
            return false;
        }
        if(null == start_date){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please, Select Check-in Date");
            errorAlert.showAndWait();
            return false;
        }
        if(null == end_date){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please, Select Check-out Date");
            errorAlert.showAndWait();
            return false;
        }
        return true;
    }
}

