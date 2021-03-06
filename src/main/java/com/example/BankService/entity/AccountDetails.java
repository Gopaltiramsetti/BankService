package com.example.BankService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class AccountDetails implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detailed_pk")
	private int aid;
	private long accountNumber;
	private String accountType;
	private long openingBalance;
	private long currentBalance;
	
	
	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AccountDetails(int aid, long accountNumber,String accountType) {
		super();
		this.aid = aid;
		//this.user = user;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}


	/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}


	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the openingBalance
	 */
	public long getOpeningBalance() {
		return openingBalance;
	}


	/**
	 * @param openingBalance the openingBalance to set
	 */
	public void setOpeningBalance(long openingBalance) {
		this.openingBalance = openingBalance;
	}


	/**
	 * @return the currentBalance
	 */
	public long getCurrentBalance() {
		return currentBalance;
	}


	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}


	@Override
	public String toString() {
		return "Account [aid=" + aid + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", openingBalance=" + openingBalance + ", currentBalance=" + currentBalance + "]";
	}

	
	
}
