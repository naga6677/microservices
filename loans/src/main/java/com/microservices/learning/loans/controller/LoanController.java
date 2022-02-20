package com.microservices.learning.loans.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.learning.loans.entity.Customer;
import com.microservices.learning.loans.entity.Loans;

@RestController
public class LoanController {

	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {

		List<Loans> tLoans = new ArrayList<Loans>();

		for (int i = 1; i < 10; i++) {
			Loans tLoan = new Loans();
			tLoan.setLoanAmount(i);
			tLoan.setLoanId(i);
			tLoans.add(tLoan);
		}

		return tLoans;
	}

}
