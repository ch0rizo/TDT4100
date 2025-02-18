package oving4;

import java.util.ArrayList;

public class CardDeck {
  private ArrayList<Card> deck;

  public CardDeck(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Cannot make a empty or negative deckstack");
    }
    deck = new ArrayList<>();
    char[] suits = { 'S', 'H', 'D', 'C' };

    for (char suit : suits) {
      for (int i = 1; i < n + 1; i++) {
        deck.add(new Card(suit, i));
      }
    }
  }

  public int getCardCount() {
    return this.deck.size();
  }

  public Card getCard(int n) {
    if (correctCards(n)) {
      return deck.get(n);
    }
    return null;
  }

  
  // Validation
  private boolean correctCards(int n) {
    if (n < 0 || n >= getCardCount()) {
      throw new IllegalArgumentException("The n'th card is not in the deck");
    }
    return true;
  }

  public void shufflePerfectly() {
    if (getCardCount() >= 2) {
      int deckSize = getCardCount();
      
      ArrayList<Card> deckList = this.deck;

      ArrayList<Card> deck1 = new ArrayList<>(deckList.subList(0, deckSize / 2)); // Bottom
      ArrayList<Card> deck2 = new ArrayList<>(deckList.subList(deckSize / 2, deckSize)); // Top

      this.deck.clear();

      for (int i = 0; i < deck1.size(); i++) {
        this.deck.add(deck1.get(i));
        this.deck.add(deck2.get(i));
      }
    }
  }
  
  public static void main(String[] args) {
    CardDeck carddeck = new CardDeck(2);
    System.out.println(carddeck.deck);
    carddeck.shufflePerfectly();
    System.out.println(carddeck.deck);
  }
}
