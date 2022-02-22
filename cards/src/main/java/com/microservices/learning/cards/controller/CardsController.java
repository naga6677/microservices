package com.microservices.learning.cards.controller;

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
import com.microservices.learning.cards.config.CardServiceConfig;

import com.microservices.learning.cards.entity.Cards;
import com.microservices.learning.cards.entity.Customer;

@RestController
public class CardsController {

	
	@Autowired
	private CardServiceConfig cardServiceConfig;


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
	
	@GetMapping("/cards/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties();

		properties.setProperty("Msg", cardServiceConfig.getMsg());
		properties.setProperty("Build Version", cardServiceConfig.getBuildVersion());

		properties.put("MailDetails", cardServiceConfig.getMailDetails());
		properties.put("Active Branches", cardServiceConfig.getActiveBranches());

		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}


}
