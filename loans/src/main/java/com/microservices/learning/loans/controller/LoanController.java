package com.microservices.learning.loans.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservices.learning.loans.config.LoansServiceConfig;

import com.microservices.learning.loans.entity.Customer;
import com.microservices.learning.loans.entity.Loans;

@RestController
public class LoanController {


	@Autowired
	private LoansServiceConfig loansServiceConfig;


	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {
		
		System.out.println("Calling Test loans service>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		List<Loans> tLoans = new ArrayList<Loans>();

		for (int i = 1; i < 10; i++) {
			Loans tLoan = new Loans();
			tLoan.setLoanAmount(i);
			tLoan.setLoanId(i);
			tLoans.add(tLoan);
		}

		return tLoans;
	}

	@GetMapping("/cards/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties();

		properties.setProperty("Msg", loansServiceConfig.getMsg());
		properties.setProperty("Build Version", loansServiceConfig.getBuildVersion());

		properties.put("MailDetails", loansServiceConfig.getMailDetails());
		properties.put("Active Branches", loansServiceConfig.getActiveBranches());

		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}


}
