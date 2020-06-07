package com.CapTrac.SpringApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {

	@Id
	private int accountid;
	private String ExpenseType;
	private int amount;
	private String Remark;
	
	
	public String getExpenseType() {
		return ExpenseType;
	}
	public void setExpenseType(String expenseType) {
		ExpenseType = expenseType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		return "UserModel [ExpenseType=" + ExpenseType + ", amount=" + amount + ", Remark=" + Remark + ", accountid="
				+ accountid + "]";
	}
	
	
	
}
