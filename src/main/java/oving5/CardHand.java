package oving5;

import java.util.ArrayList;
import java.util.List;

public class CardHand implements CardContainer {
    private final List<Card> cards;

    public CardHand() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCardCount() {
        return cards.size();
    }

    @Override
    public Card getCard(int index) {
        if (index < 0 || index >= cards.size()) {
            throw new IndexOutOfBoundsException("Invalid card index: " + index);
        }
        return cards.get(index);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card play(int n) {
        if (n < 0 || n >= cards.size()) {
            throw new IndexOutOfBoundsException("Invalid card index: " + n);
        }
        return cards.remove(n);
    }
}
