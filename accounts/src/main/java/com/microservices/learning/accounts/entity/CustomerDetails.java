package com.microservices.learning.accounts.entity;

import java.util.List;

public class CustomerDetails {

	public Accounts accounts;

	public List<Cards> cards;

	public List<Loans> loans;

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public List<Cards> getCards() {
		return cards;
	}

	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}

	public List<Loans> getLoans() {
		return loans;
	}

	public void setLoans(List<Loans> loans) {
		this.loans = loans;
	}

	

}
