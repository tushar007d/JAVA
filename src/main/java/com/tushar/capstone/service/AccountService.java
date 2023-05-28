package com.tushar.capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tushar.capstone.entities.Account;

@Service
public interface AccountService {
	public List<Account> getAllAccount();
	public int transferFund(int from, int to, int amount);
	public Account getBalanceOf(int id);
}
