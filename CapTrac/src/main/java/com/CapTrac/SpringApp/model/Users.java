package com.CapTrac.SpringApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class Users implements Serializable {


    private Long userID;

    private String username;

    private String password;

    private String email;


}
