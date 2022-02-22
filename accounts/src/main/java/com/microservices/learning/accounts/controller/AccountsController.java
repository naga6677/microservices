package com.microservices.learning.accounts.controller;

import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.learning.accounts.config.AccountsServiceConfig;

import com.microservices.learning.accounts.entity.Accounts;
import com.microservices.learning.accounts.entity.Customer;

@RestController
public class AccountsController {


	@Autowired
	AccountsServiceConfig accountsConfig;


	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts tAccounts = new Accounts();
		tAccounts.setAccountName("Vekat Ede");
		tAccounts.setAccountNumber(123);

		return tAccounts;
	}


	@GetMapping("/account/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties();

		properties.setProperty("Msg", accountsConfig.getMsg());
		properties.setProperty("Build Version", accountsConfig.getBuildVersion());

		properties.put("MailDetails", accountsConfig.getMailDetails());
		properties.put("Active Branches", accountsConfig.getActiveBranches());

		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}



}
