package com.microservices.learning.accounts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.learning.accounts.entity.Accounts;
import com.microservices.learning.accounts.entity.Customer;

@RestController
public class AccountsController {

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts tAccounts = new Accounts();
		tAccounts.setAccountName("Vekat Ede");
		tAccounts.setAccountNumber(123);

		return tAccounts;
	}

}
