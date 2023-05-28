package com.tushar.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.capstone.entities.Customer;
import com.tushar.capstone.repos.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repo;
	
	public Customer addCustomer(Customer cu) {
		return repo.save(cu);
	}

	@Override
	public List<Customer> getAllCustomers(){
		List<Customer> list =repo.findAll();
		return list;
	}
//	@Override
//	public List<Customer> getAllCustomer(){
//		List<Customer> ls = repo.findAll();
//		return ls;
//	}
	
	@Override
	public boolean deletCustomer(int cid) {
		Customer customer = repo.getBycid(cid);
		if(!(customer==null)) {
			repo.delete(customer);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String deleteAllCustomer() {
		repo.deleteAll();
		return "All Customers Deleted Successfully";
	}

	@Override
	public Customer updateCustomerById(int cid, Customer cus) {
		Customer c = null ;
		Optional<Customer> optional = repo.findById(cid);
		if(optional.isPresent()) {
			c = optional.get();
			c.setFirstname(cus.getFirstname());
			c.setLastname(cus.getLastname());
			c.setGender(cus.getGender());
			c.setNumber(cus.getNumber());
			c.setAddress(cus.getAddress());
			c = repo.save(c);
			return c;
		}
		else {
			return null;
		}
	}
}
