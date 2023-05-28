package com.tushar.capstone.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tushar.capstone.controller.CustomerController;
import com.tushar.capstone.entities.Account;
import com.tushar.capstone.entities.Customer;
import com.tushar.capstone.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockmvc; //mockmvc is a testing framework that is used to mock the request in between application and client
	
	@MockBean
	private CustomerService serv;
	
	@Test
	public void addCustomer() throws Exception {
		Account acc =new Account(1,"IBKL", "Ambad", "Savings", 23);
		Account acc1 =new Account(1,"IBKL", "Ambad", "Savings", 23);
		List<Account> ls =new ArrayList();
		ls.add(acc1);
		ls.add(acc);
		Customer c = new Customer(1,"Tushar","Fadol","7246243","Male","Nashik",ls);
		when(serv.addCustomer(c)).thenReturn(c);
		String object = "{\r\n" + 
				"        \"cid\": 1,\r\n" + 
				"        \"firstname\": \"Tushar\",\r\n" + 
				"        \"lastname\": \"Fadol\",\r\n" + 
				"        \"number\": \"346456432\",\r\n" + 
				"        \"gender\": \"male\"\r\n" + 
				"        }";
		mockmvc.perform(post("/AddCustomer").content(object).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
	
	@Test
	public void getCustomers() throws Exception {
		Account acc =new Account(1,"IBKL", "Ambad", "Savings", 23);
		Account acc1 =new Account(1,"IBKL", "Ambad", "Savings", 23);
		List<Account> ls =new ArrayList();
		ls.add(acc1);
		ls.add(acc);
		Customer c = new Customer(1,"Tushar","Fadol","7246243","Male","Nashik",ls);
		Customer c1 = new Customer(2,"Tushar","Fadol","7246243","Male","Nashik",ls);
		List<Customer> cus = Arrays.asList(c);
		 cus = Arrays.asList(c1);
		when(serv.getAllCustomers()).thenReturn(cus);
		mockmvc.perform(get("/AllCustomers")).andExpect(status().isFound());
	}
	
	@Test
	public void deleteCustomers() throws Exception {
		Account acc1 =new Account(1,"IBKL", "Ambad", "Savings", 23);
		List<Account> ls =new ArrayList();
		ls.add(acc1);
		Customer c1 = new Customer(2,"Tushar","Fadol","7246243","Male","Nashik",ls);
		when(serv.deletCustomer(2)).thenReturn(true);
		mockmvc.perform(delete("/deleteCustomerByID/2")).andExpect(status().isOk());
	}
	
	@Test
	public void deleteAllCustomers() throws Exception {
		when(serv.deleteAllCustomer()).thenReturn("All Customers Deleted SuccessFully");
		mockmvc.perform(delete("/DeleteAllCustomers")).andExpect(status().isOk());
	}
}
