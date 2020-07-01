package com.CapTrac.SpringApp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ExpenseModel {

	@Id
	private int transacid;
	private String ExpenseType;
	private int amount;
	private String Remark;
	private Date date;
	private int totalexpense;
	
	@ManyToOne
	private CredentialManager creds;
	
	
	public CredentialManager getCreds() {
		return creds;
	}
	public void setCreds(CredentialManager creds) {
		this.creds = creds;
	}
	public int getTransacid() {
		return transacid;
	}
	public void setTransacid(int transacid) {
		this.transacid = transacid;
	}
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
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalexpense() {
		return totalexpense;
	}
	public void setTotalexpense(int totalexpense) {
		this.totalexpense = totalexpense;
	}
	@Override
	public String toString() {
		return "ExpenseModel [transacid=" + transacid + ", ExpenseType=" + ExpenseType + ", amount=" + amount
				+ ", Remark=" + Remark + ", date=" + date + ", totalexpense=" + totalexpense + ", creds=" + creds + "]";
	}
	
	
	
	
	
		
}
