/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Models;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author hossam
 */
public class Reservation {


    private int Id;
    private String From;
    private String To;
    private String LeavingDate;
    private String ArrivalDate;
    
    private String TravelType;
    private String TripName;
    
    private String HotelName;
    private int HotelDuration;



    private double TotalPrice;
    private int UserId;

    public Reservation(int Id, String From, String To, String LeavingDate, String ArrivalDate, String TravelType, String TripName, String HotelName, int HotelDuration, double TotalPrice, int UserId) {
        this.Id = Id;
        this.From = From;
        this.To = To;
        this.LeavingDate = LeavingDate;
        this.ArrivalDate = ArrivalDate;
        this.TravelType = TravelType;
        this.TripName = TripName;
        this.HotelName = HotelName;
        this.HotelDuration = HotelDuration;
        this.TotalPrice = TotalPrice;
        this.UserId = UserId;
    }

    public int getId() {
        return Id;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public String getLeavingDate() {
        return LeavingDate;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public String getTravelType() {
        return TravelType;
    }

    public String getTripName() {
        return TripName;
    }

    public String getHotelName() {
        return HotelName;
    }

    public int getHotelDuration() {
        return HotelDuration;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public int getUserId() {
        return UserId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public void setTo(String To) {
        this.To = To;
    }

    public void setLeavingDate(String LeavingDate) {
        this.LeavingDate = LeavingDate;
    }

    public void setArrivalDate(String ArrivalDate) {
        this.ArrivalDate = ArrivalDate;
    }

    public void setTravelType(String TravelType) {
        this.TravelType = TravelType;
    }

    public void setTripName(String TripName) {
        this.TripName = TripName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public void setHotelDuration(int HotelDuration) {
        this.HotelDuration = HotelDuration;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    
    
    
    

}
