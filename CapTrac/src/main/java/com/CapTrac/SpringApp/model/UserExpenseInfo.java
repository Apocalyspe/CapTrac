package com.CapTrac.SpringApp.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserExpenseInfo implements Serializable {


    private String transacid;


    private String ExpenseType;


    private float amount;


    private String Remark;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp timestamp;

    private float totalexpense;

    private Users user;


}
