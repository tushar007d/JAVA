package com.tushar.capstone.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.tushar.capstone.entities.Account;
import com.tushar.capstone.entities.Customer;
import com.tushar.capstone.repos.CustomerRepository;
import com.tushar.capstone.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTesting {
	
	@Mock  //@Mock creates a mock. 
	CustomerRepository repo;
	
	@InjectMocks  //@InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance
	CustomerServiceImpl serv;
	
	@Test
	public void addCustomer() {
		Account acc =new Account(1,"IBKL", "Ambad", "Savings", 23);
		Account acc1 =new Account(1,"IBKL", "Ambad", "Savings", 23);
		List<Account> ls =new ArrayList();
		ls.add(acc1);
		ls.add(acc);
		Customer c = new Customer(1,"Tushar","Fadol","7246243","Male","Nashik",ls);
		repo.save(c);
		Mockito.when(repo.save(c)).thenReturn(c);
		assertThat(serv.addCustomer(c)).isEqualTo(c);
	}
	
	@Test
	public void getCustomer() {
		Account acc =new Account(1,"IBKL", "Ambad", "Savings", 23);
		Account acc1 =new Account(1,"IBKL", "Ambad", "Savings", 23);
		List<Account> ls =new ArrayList();
		ls.add(acc1);
		ls.add(acc);
		Customer c = new Customer(1,"Tushar","Fadol","7246243","Male","Nashik",ls);
		Customer cc = new Customer(2,"Tushar","Fadol","7246243","Male","Nashik",ls);
		List<Customer> liist = new ArrayList<Customer>();
		liist.add(c);
		liist.add(cc);
		repo.save(c);
		repo.save(cc);
		Mockito.when(serv.getAllCustomers()).thenReturn(liist);
		assertEquals(serv.getAllCustomers(),liist);
	}
}
