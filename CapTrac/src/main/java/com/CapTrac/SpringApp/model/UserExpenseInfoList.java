package com.CapTrac.SpringApp.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonRootName("userExpenseInfo")
public class UserExpenseInfoList implements Serializable {

    private List<UserExpenseInfo> userExpenseInfoList;


    //Constructors


    public UserExpenseInfoList() {
    }

    @JsonCreator
    public UserExpenseInfoList(@JsonProperty List<UserExpenseInfo> userExpenseInfo) {
        this.userExpenseInfoList = userExpenseInfo;
    }

    //Getters and Setters

    public List<UserExpenseInfo> getUserExpenseInfo() {
        return userExpenseInfoList;
    }

    @JsonSetter
    public void setUserExpenseInfo(List<UserExpenseInfo> userExpenseInfo) {
        this.userExpenseInfoList = userExpenseInfo;
    }
}
