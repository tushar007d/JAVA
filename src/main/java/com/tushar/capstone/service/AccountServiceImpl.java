package com.tushar.capstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.capstone.entities.Account;
import com.tushar.capstone.entities.Customer;
import com.tushar.capstone.repos.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository repo;
	@Override
	public List<Account> getAllAccount() {
		List<Account> list = repo.findAll();
		return list;
	}
	public Account getBalanceOf(int id) {
		Account acc = repo.findByid(id);
		return acc;
	}
	@Override
	public int transferFund(int from, int to, int amount) {
		Account From =repo.findByid(from);
		Account To = repo.findByid(to);   // getting accounts from database 
		if((From!=null && To!=null)&&(From.getId()!=To.getId())) {// checking is accounts present and both the from and to are mot null
			if(From.getAccountbalance()>=amount) {	// checking amount of from account
				if(amount>0) {
					int remain =From.getAccountbalance()-amount;
					From.setAccountbalance(remain);
					repo.save(From);
					int add = To.getAccountbalance()+amount;
					To.setAccountbalance(add);
					repo.save(To);
					return 1 ; //Transfer Successfull
				}
				else {
					return 2 ; //Amount is negative
			
				}
			}
			else {
				return 3 ; //Insufficient Fund
			}}
		else {
			if (From==null && To==null) {
				 return 4; //from account and to account not found
			}
			else if(From==null) {
				return 5;  //from account not found
			}
			else if (To==null){
				return 6; //To account not found
			}
			else {
				return 7;  //Both accounts are same
			}
		}
	}
}
	

	

	
	
	

