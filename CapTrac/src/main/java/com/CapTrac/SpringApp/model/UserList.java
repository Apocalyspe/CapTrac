package com.CapTrac.SpringApp.model;

import java.io.Serializable;
import java.util.List;

public class UserList implements Serializable {

    private List<Users> usersList;

    public UserList() {

    }

    public UserList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}
