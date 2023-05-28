package com.tushar.capstone.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.tushar.capstone.dto.InputReequest;
import com.tushar.capstone.entities.Account;
import com.tushar.capstone.entities.Customer;
import com.tushar.capstone.exception.InputDataError;
import com.tushar.capstone.exception.NoDataException;
import com.tushar.capstone.repos.CustomerRepository;
import com.tushar.capstone.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService serv;
	
	@PostMapping(value = "/AddCustomer", consumes ="application/json")
	public ResponseEntity<?> addCustomer(@RequestBody Customer c){
		Customer cs = serv.addCustomer(c);
		return new ResponseEntity<Customer>(cs,HttpStatus.CREATED);
	}
	

	@GetMapping("/AllCustomers")
	public ResponseEntity<?> getCustomers()throws Exception{
		//return new ResponseEntity<> (serv.getAllCustomers(),HttpStatus.FOUND);
		List<Customer> list=serv.getAllCustomers();
		if(list.isEmpty()) {
			throw new NoDataException("No Data Found");
		}
		else {
			return new ResponseEntity<>(serv.getAllCustomers(),HttpStatus.FOUND);
			}
	}

	@DeleteMapping("deleteCustomerByID/{Id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("Id")int id) throws Exception{
		if (serv.deletCustomer(id)) {
			return new ResponseEntity<>(" Deleted SuccessFully",HttpStatus.OK);
		}
		else {
			throw new InputDataError("The Customer not found");
		}
	}
	
	@DeleteMapping("/DeleteAllCustomers")
	public ResponseEntity<?> deleteAllCustomers(){
		serv.deleteAllCustomer();
		return new ResponseEntity<>("All Customers Deleted SuccessFully", HttpStatus.OK);
	}
	
	@PutMapping("/updateById/{cid}")
	public ResponseEntity<?> updateCustomerById(@PathVariable("cid") int cid,@RequestBody Customer cus) throws Exception {
		Customer c =serv.updateCustomerById(cid, cus);
		if(c!=null) {
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		else {
			throw new InputDataError("No data found");
		}
	}
}
