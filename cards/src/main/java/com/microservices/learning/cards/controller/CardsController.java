package com.microservices.learning.cards.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.learning.cards.entity.Cards;
import com.microservices.learning.cards.entity.Customer;

@RestController
public class CardsController {

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {

		List<Cards> tCards = new ArrayList<Cards>();

		for (int i = 1; i < 10; i++) {
			Cards tCard = new Cards();
			tCard.setCardNumber(i);
			tCard.setCardType("Debit");
			tCards.add(tCard);
		}

		return tCards;
	}

}
