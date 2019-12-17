package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {

	protected List<Card> cardsInHand = new ArrayList<>();

	public AbstractHand() {
	}

	public void clear() {
	}

	public abstract int getHandValue();


	public void addCard(Card card) {
		cardsInHand.add(card);
	}

	@Override
	public String toString() {
		return "Cards in hand: " + cardsInHand + " --";
	}

}
