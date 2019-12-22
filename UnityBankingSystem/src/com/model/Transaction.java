package com.model;

public class Transaction {
	
	String transation_id;
	String from_account;
	String to_account;
	String transactionType;
	String transactionDate;
	//String tranactionTime;
	String tranactionStatus;
	public String getTransation_id() {
		return transation_id;
	}
	public void setTransation_id(String transation_id) {
		this.transation_id = transation_id;
	}
	public String getFrom_account() {
		return from_account;
	}
	public void setFrom_account(String from_account) {
		this.from_account = from_account;
	}
	public String getTo_account() {
		return to_account;
	}
	public void setTo_account(String to_account) {
		this.to_account = to_account;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTranactionStatus() {
		return tranactionStatus;
	}
	public void setTranactionStatus(String tranactionStatus) {
		this.tranactionStatus = tranactionStatus;
	}
	
	

}
