package com.example.smart_ration_shop;

public class UserItem {

    String userID;
    String userName;
    String useraddress;
    String userPhone;

    public UserItem() {
    }

    public UserItem(String userID, String userName, String useraddress, String userPhone) {
        this.userID = userID;
        this.userName = userName;
        this.useraddress = useraddress;
        this.userPhone = userPhone;
    }



    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return useraddress;
    }

    public void setUserEmail(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserCountry() {
        return userPhone;
    }

    public void setUserCountry(String userPhone) {
        this.userPhone = userPhone;
    }
    public UserItem(String phone){
        this.userPhone=phone;
    }
}