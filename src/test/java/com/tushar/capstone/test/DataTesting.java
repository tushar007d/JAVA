package com.tushar.capstone.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tushar.capstone.entities.Account;
import com.tushar.capstone.entities.Customer;
import com.tushar.capstone.repos.CustomerRepository;
import com.tushar.capstone.service.CustomerService;
import com.tushar.capstone.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
class DataTesting {
	
	@Autowired
	CustomerRepository repo;
	@Test
	public void addTesting() {
		Account acc =new Account(1,"IBKL", "Ambad", "Savings", 23);
		Account acc1 =new Account(1,"IBKL", "Ambad", "Savings", 23);
		List<Account> ls =new ArrayList();
		ls.add(acc1);
		ls.add(acc);
		Customer c = new Customer(1,"Tushar","Fadol","7246243","Male","Nashik",ls);
		assertEquals(c.getFirstname(), c.getFirstname());
	}

}
