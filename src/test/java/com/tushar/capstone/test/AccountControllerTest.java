package com.tushar.capstone.test;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import java.util.Arrays;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
//import org.assertj.core.util.Arrays;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tushar.capstone.controller.AccountController;
import com.tushar.capstone.repos.AccountRepository;
import com.tushar.capstone.service.AccountService;
import com.tushar.capstone.entities.Account;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService serv;
	
	@InjectMocks
	private AccountController contr;
	
	@Test
	public void getProduct() throws Exception {
		Account acc =new Account(1,"IBKL", "Ambad", "Savings", 23);
		List<Account> ls = Arrays.asList(acc) ;
		when(serv.getAllAccount()).thenReturn(ls);
		mockMvc.perform(get("/accounts/")).andExpect(status().isFound());
	}
	
	@Test
	public void getbalance() throws Exception {
		Account a =new Account(1,"IBKL", "Ambad", "Savings", 23);
		when(serv.getBalanceOf(1)).thenReturn(a);
		mockMvc.perform(get("/getBalance/1")).andExpect(status().isFound());
	}
	
	@Test
	public void transferFund() throws Exception {
		when(serv.transferFund(1, 2, 77)).thenReturn(1);
		mockMvc.perform(put("http://localhost:8080/FundTransfer/2/3/50")).andExpect(status().isConflict());
	}
}
