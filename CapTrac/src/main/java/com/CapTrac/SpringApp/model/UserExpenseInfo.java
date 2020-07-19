package com.CapTrac.SpringApp.model;


import java.sql.Date;


public class UserExpenseInfo {

        
        private String transacid;

        
        private String ExpenseType;

        
        private float amount;

        
        private String Remark;

        
        private Date date;

        private float totalexpense;


        private Users user;

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

        public Date getDate() {
            return date;
        }
        public void setDate(Date date) {
            this.date=date;
        }

        public float getTotalexpense() {
            return totalexpense;
        }
        public void setTotalexpense(float totalexpense) {
            this.totalexpense = totalexpense;
        }

        public long getUserID(){
            return user.getUserID();
        }

        public String getUserName(){
            return user.getUsername();
        }
    }
