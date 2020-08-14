package com.CapTrac.SpringApp.model;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class UserExpenseInfoList {

    private List<UserExpenseInfo> userExpenseInfoList;


}
