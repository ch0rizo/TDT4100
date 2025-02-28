package oving5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CardContainerIterator implements Iterator<Card> {
  private final CardContainer cardContainer;
  private int currentIndex = 0;

  public CardContainerIterator(CardContainer cardContainer) {
    this.cardContainer = cardContainer;
  }

  @Override
  public boolean hasNext() {
    return currentIndex < cardContainer.getCardCount();
  }

  @Override
  public Card next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return cardContainer.getCard(currentIndex++);
  }
}
