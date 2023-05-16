//
//package main_page.Handlers;
//
//import static hotel.Hotel_Resevation.id;
//import static hotel.Hotel_Resevation.information_isFilled;
//import static hotel.Hotel_Resevation.room_id;
//import static hotel.Hotel_Resevation.welcome;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Alert;
//
///**
// *
// * @author Ehab
// */
//public class ConfirmBookingHandler implements EventHandler<ActionEvent>{
//    
//    @Override
//    public void handle(ActionEvent event) { 
//        try{
//            if(!information_isFilled){
//            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//            errorAlert.setHeaderText("Missing informations");
//            errorAlert.setContentText("Please, fill the informations");
//            errorAlert.showAndWait();
//            }
//            else{
//                /***
//                *       Get Room ID Number from Database
//                ***/
//                room_id.setVisible(true);
//                id.setVisible(true);
//                welcome.setVisible(true);
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
