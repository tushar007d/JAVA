package com.tushar.capstone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.capstone.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	public Account findByid(int id);
	
}
