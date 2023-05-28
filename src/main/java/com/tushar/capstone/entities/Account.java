package com.tushar.capstone.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Account {
	@Id
	private int id;
	private String ifsc;
	private String branch;
	private String accounttype;
	private  int accountbalance;
	
	public Account(int id, String ifsc, String branch, String accounttype, int accountbalance) {
		super();
		this.id = id;
		this.ifsc = ifsc;
		this.branch = branch;
		this.accounttype = accounttype;
		this.accountbalance = accountbalance;
	}
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public int getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", ifsc=" + ifsc + ", branch=" + branch + ", accounttype=" + accounttype
				+ ", accountbalance=" + accountbalance + "]";
	}
	
	
	
}
