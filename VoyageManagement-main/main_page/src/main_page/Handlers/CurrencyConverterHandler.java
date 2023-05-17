/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_page.Handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import static main_page.Scenes.Currency_Converter.amount;
import static main_page.Scenes.Currency_Converter.converted_currency;
import static main_page.Scenes.Currency_Converter.currency_from;
import static main_page.Scenes.Currency_Converter.currency_to;

/**
 *
 * @author Ehab
 */
public class CurrencyConverterHandler implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event){
        if(amount.getText().trim().isEmpty() || true == currency_from.getSelectionModel().isEmpty() || true == currency_to.getSelectionModel().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please, Enter Missing Data");
            errorAlert.showAndWait();
        }   
        else{
            try{
                /* Calculating the converted currency */
                Double amount_val = Double.parseDouble(amount.getText());
                Double currency = 0.0;
                if("Egyptian Pound" == currency_from.getValue()){
                    if("Egyptian Pound" == currency_to.getValue()){
                        currency = amount_val;
                    }
                    else if("US Dollar" == currency_to.getValue()){
                        currency = (double)amount_val * 0.032;
                    }
                    else if("UK Pound" == currency_to.getValue()){
                        currency = (double)amount_val * 0.026;
                    }
                    else if("Europe Euro" == currency_to.getValue()){
                        currency = (double)amount_val * 0.030;
                    }
                }
                else if("US Dollar" == currency_from.getValue()){
                    if("Egyptian Pound" == currency_to.getValue()){
                        currency = (double)amount_val * 30.95;
                    }
                    else if("US Dollar" == currency_to.getValue()){
                        currency = amount_val;
                    }
                    else if("UK Pound" == currency_to.getValue()){
                        currency = (double)amount_val * 0.80;
                    }
                    else if("Europe Euro" == currency_to.getValue()){
                        currency = (double)amount_val * 0.92;
                    }
                }
                else if("UK Pound" == currency_from.getValue()){
                    if("Egyptian Pound" == currency_to.getValue()){
                        currency = (double)amount_val * 38.46;
                    }
                    else if("US Dollar" == currency_to.getValue()){
                        currency = (double)amount_val * 1.24;
                    }
                    else if("UK Pound" == currency_to.getValue()){
                        currency = (double)amount_val;
                    }
                    else if("Europe Euro" == currency_to.getValue()){
                        currency = (double)amount_val * 1.15;
                    }
                }
                else if("Europe Euro" == currency_from.getValue()){
                    if("Egyptian Pound" == currency_to.getValue()){
                        currency = (double)amount_val * 33.53;
                    }
                    else if("US Dollar" == currency_to.getValue()){
                        currency = (double)amount_val * 33.53;
                    }
                    else if("UK Pound" == currency_to.getValue()){
                        currency = (double)amount_val * 0.87;
                    }
                    else if("Europe Euro" == currency_to.getValue()){
                        currency = amount_val;
                    }
                }
                /* Set Converted currency textField */
                converted_currency.setText("" + currency);
            }
            catch(NumberFormatException ex){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Incorrect amount");
                errorAlert.setContentText("Please, Enter a vaild number of money");
                errorAlert.showAndWait();
                return;
            }
        } 
    }
}
