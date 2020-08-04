package com.CapTrac.SpringApp.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;


public class UserExpenseInfo implements Serializable {

        
        private String transacid;

        
        private String ExpenseType;

        
        private float amount;

        
        private String Remark;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        private Timestamp timestamp;

        private float totalexpense;


        private Users user;

    public UserExpenseInfo() {
    }

    public UserExpenseInfo(String transacid, String expenseType, float amount, String remark, Timestamp timestamp, float totalexpense, Users user) {
            this.transacid = transacid;
            ExpenseType = expenseType;
            this.amount = amount;
            Remark = remark;
            this.timestamp = timestamp;
            this.totalexpense = totalexpense;
            this.user = user;
        }

        public Users getUser() {
        return user;
         }

        public void setUser(Users user) {
        this.user = user;
         }

        public String getTransacid() {
            return transacid;
        }
        public void setTransacid(String transacid) {
            this.transacid = transacid;
        }
        public String getExpenseType() {
            return ExpenseType;
        }
        public void setExpenseType(String expenseType) {
            ExpenseType = expenseType;
        }
        public float getAmount() {
            return amount;
        }
        public void setAmount(float amount) {
            this.amount = amount;
        }
        public String getRemark() {
            return Remark;
        }
        public void setRemark(String remark) {
            Remark = remark;
        }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public float getTotalexpense() {
            return totalexpense;
        }
        public void setTotalexpense(float totalexpense) {
            this.totalexpense = totalexpense;
        }

    }
