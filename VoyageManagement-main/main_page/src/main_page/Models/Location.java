/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Models;

/**
 *
 * @author hossam
 */
public class Location {
    
    private String CityName;
    private double Latitude;
    private double Longitude;

    public Location(String CityName, double Latitude, double Longitude) {
        this.CityName = CityName;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }

    public String getCityName() {
        return CityName;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }
    
    

}
