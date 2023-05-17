/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_page.Models;

/**
 *
 * @author hossam
 */
public class User {
    
    private int Id;
    private String UserName;
    private String FullName;
    private String Email;
    private String PhoneNumber;
    private String Password;
    private boolean IsAdmin;

    public User(int Id, String UserName, String FullName, String Email, String PhoneNumber, String Password, boolean IsAdmin) {
        this.Id = Id;
        this.UserName = UserName;
        this.FullName = FullName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Password = Password;
        this.IsAdmin = IsAdmin;
    }

    public int getId() {
        return Id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getFullName() {
        return FullName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public boolean isIsAdmin() {
        return IsAdmin;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setIsAdmin(boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }
    
    



    
}
