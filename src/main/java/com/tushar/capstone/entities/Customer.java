package com.tushar.capstone.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;


@Entity
public class Customer {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int cid; 
	private String firstname;
	private String lastname;
	private String number ;
	private String gender;
	private String address;
	
	
	@OneToMany(targetEntity=Account.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="fk", referencedColumnName="cid")
	private List<com.tushar.capstone.entities.Account> Account;

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", firstname=" + firstname + ", lastname=" + lastname + ", number=" + number
				+ ", gender=" + gender + ", address=" + address + ", Account=" + Account + "]";
	}

	public Customer(int cid, String firstname, String lastname, String number, String gender, String address,
			List<com.tushar.capstone.entities.Account> account) {
		super();
		this.cid = cid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.number = number;
		this.gender = gender;
		this.address = address;
		Account = account;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<com.tushar.capstone.entities.Account> getAccount() {
		return Account;
	}

	public void setAccount(List<com.tushar.capstone.entities.Account> account) {
		Account = account;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int cid, String firstname, String lastname, String number, String gender, String address) {
		super();
		this.cid = cid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.number = number;
		this.gender = gender;
		this.address = address;
	}
	
	//this one

}
