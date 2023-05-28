package com.tushar.capstone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.capstone.entities.Account;
import com.tushar.capstone.entities.Customer;
import com.tushar.capstone.repos.AccountRepository;
import com.tushar.capstone.service.AccountService;
import com.tushar.capstone.exception.InputDataError;
import com.tushar.capstone.exception.InsufficientFunds;
import com.tushar.capstone.exception.NoDataException;

@RestController
public class AccountController {
	
	@Autowired
	AccountService serv;
	@GetMapping(value = "/accounts/")
	public ResponseEntity<?> getProduct() throws Exception {
		if(serv.getAllAccount().isEmpty()) {
			throw new NoDataException("Not Found");
		}
		return new ResponseEntity<> (serv.getAllAccount(), HttpStatus.FOUND);
	}
	@PutMapping("FundTransfer/{From}/{To}/{amount}")
	public ResponseEntity<?> transferFund(@PathVariable("From")int from, @PathVariable ("To") int to,@PathVariable ("amount")int amount)throws Exception{
			switch(serv.transferFund(from, to, amount)) { //getting the intger from the service class for switch cases 
			case 1:return new ResponseEntity<>("Transfer Successfull",HttpStatus.OK);
			case 2 : throw new InputDataError("Amount is negative");
			case 3: throw new InsufficientFunds("Insufficient Fund");
			case 4 : throw new InputDataError("from account and to account not found");
			case 5 : throw new InputDataError("from account not found");
			case 6 : throw new InputDataError("To account not found");
			case 7 : throw new InputDataError("Both accounts are same");
			}
			return new ResponseEntity<>("internal error occured", HttpStatus.CONFLICT);
		}
	
	@GetMapping(value="/getBalance/{id}")
	public ResponseEntity<?> getBalance(@PathVariable("id") int id) throws InputDataError{
		if (serv.getBalanceOf(id)!= null) {
			return new  ResponseEntity<>(serv.getBalanceOf(id).getAccountbalance(),HttpStatus.FOUND);
		}	
		throw new InputDataError("The  details NOT AVAILABLE");
	}
	

	
	
}
