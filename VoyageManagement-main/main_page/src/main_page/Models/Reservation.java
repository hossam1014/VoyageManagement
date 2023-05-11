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
    private String PackageName;
    private String TravelTicketName;
    private String HotelName;
    private double Total;
    private Date ReserveDate;
    private int UserId;

    public Reservation(int Id, String PackageName, String TravelTicketName, String HotelName, double Total, Date ReserveDate, int UserId) {
        this.Id = Id;
        this.PackageName = PackageName;
        this.TravelTicketName = TravelTicketName;
        this.HotelName = HotelName;
        this.Total = Total;
        this.ReserveDate = ReserveDate;
        this.UserId = UserId;
    }
    
    
    public int getId() {
        return Id;
    }

    public String getPackageName() {
        return PackageName;
    }

    public String getTravelTicketName() {
        return TravelTicketName;
    }

    public String getHotelName() {
        return HotelName;
    }

    public double getTotal() {
        return Total;
    }

    public Date getReserveDate() {
        return ReserveDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setPackageName(String PackageName) {
        this.PackageName = PackageName;
    }

    public void setTravelTicketName(String TravelTicketName) {
        this.TravelTicketName = TravelTicketName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public void setReserveDate(Date ReserveDate) {
        this.ReserveDate = ReserveDate;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    

}
