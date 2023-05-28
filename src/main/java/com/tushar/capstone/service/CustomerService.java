package com.tushar.capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tushar.capstone.entities.Customer;

@Service
public interface CustomerService {
	public Customer addCustomer(Customer cu);
	public List<Customer>getAllCustomers();
	public boolean deletCustomer(int cid);
	public String deleteAllCustomer();
	public Customer updateCustomerById(int cid,Customer cus);
}
