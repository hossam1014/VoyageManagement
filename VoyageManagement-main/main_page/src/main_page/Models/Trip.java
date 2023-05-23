/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Models;

/**
 *
 * @author hossam
 */
public class Trip {
    private String LeavingDate;
    private String ArrivalDate;
    private String TripName;
    private double TripPrice;

    public Trip(String LeavingDate, String ArrivalDate, String TripName, double TripPrice) {
        this.LeavingDate = LeavingDate;
        this.ArrivalDate = ArrivalDate;
        this.TripName = TripName;
        this.TripPrice = TripPrice;
    }
    
    public Trip() {
       
    }

    public String getLeavingDate() {
        return LeavingDate;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public String getTripName() {
        return TripName;
    }

    public double getTripPrice() {
        return TripPrice;
    }

    public void setLeavingDate(String LeavingDate) {
        this.LeavingDate = LeavingDate;
    }

    public void setArrivalDate(String ArrivalDate) {
        this.ArrivalDate = ArrivalDate;
    }

    public void setTripName(String TripName) {
        this.TripName = TripName;
    }

    public void setTripPrice(double TripPrice) {
        this.TripPrice = TripPrice;
    }
    
    


}
