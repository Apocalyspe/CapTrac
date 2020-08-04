package com.CapTrac.SpringApp.model;


import java.io.Serializable;

public class Users implements Serializable {


    private Long userID;

    private String username;

    private String password;

    private String email;


    public Users() {
    	
    }
    

    public Users(Long userID, String username, String password, String email) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
	}
    
    
	public long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
