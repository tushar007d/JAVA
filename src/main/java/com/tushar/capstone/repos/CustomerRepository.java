package com.tushar.capstone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.capstone.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
		public Customer getBycid(int cid) ;
}
