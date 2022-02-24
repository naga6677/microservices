package com.microservices.learning.accounts.controller;


import java.util.List;

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
import com.microservices.learning.accounts.entity.Cards;
import com.microservices.learning.accounts.entity.Customer;
import com.microservices.learning.accounts.entity.CustomerDetails;
import com.microservices.learning.accounts.entity.Loans;
import com.microservices.learning.accounts.service.client.CardsFeignClient;
import com.microservices.learning.accounts.service.client.LoansFeignClient;

@RestController
public class AccountsController {


	@Autowired
	AccountsServiceConfig accountsConfig;

	@Autowired
	CardsFeignClient cardsFeignClient;

	@Autowired
	LoansFeignClient loansFeignClient;

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


	@PostMapping(value = "/myCustomerDeatils")
	public CustomerDetails getCustomerDetails(@RequestBody Customer customer) {

		Accounts accounts = getAccountDetails(new Customer());
		List<Cards> tCards = cardsFeignClient.getCardDetails(new Customer());
		List<Loans> tLoans = loansFeignClient.getLoanDetails(new Customer());

		CustomerDetails tCustomerDetails = new CustomerDetails();
		tCustomerDetails.setAccounts(accounts);
		tCustomerDetails.setCards(tCards);
		tCustomerDetails.setLoans(tLoans);

		return tCustomerDetails;

	}


}
