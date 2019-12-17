package com.skilldistillery.cards.common;

public enum Suit {
  SPADES("\u2660"), HEARTS("\u2665"), DIAMONDS("\u2666"), CLUBS("\u2663");
  private String suit;

  Suit(String suit) {
    this.suit = suit;
  }

  @Override
  public String toString() {
    return suit;
  }
}