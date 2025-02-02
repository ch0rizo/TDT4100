package oving4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardDeckTest {

	private CardDeck cardDeck;

	private static void checkDeck(CardDeck deck, String deckAsString) {
		String[] toStrings = deckAsString.split(",");
		assertEquals(toStrings.length, deck.getCardCount(), "CardDeck har ikke korrekt størrelse");

		int i = 0;

		for (String toString : toStrings) {
			Card card = deck.getCard(i);
			String cardString = String.valueOf(card.getSuit()) + card.getFace();
			assertEquals(toString, cardString, String.format(
					"Card på plass %d var feil. CardDeck skulle vært %s", i + 1, toStrings));
			i++;
		}
	}

	@BeforeEach
	public void setup() {
		cardDeck = new CardDeck(2);
	}

	@Test
	@DisplayName("Sjekk at Deck blir initialisert til to S1,S2,H1,H2,D1,D2,C1,C2")
	public void testConstructor() {
		CardDeckTest.checkDeck(cardDeck, "S1,S2,H1,H2,D1,D2,C1,C2");
	}

	@Test
	@DisplayName("Sjekk at CardDeck blir stokket til S1,D1,S2,D2,H1,C1,H2,C2")
	public void testShufflePerfectly() {
		cardDeck.shufflePerfectly();
		CardDeckTest.checkDeck(cardDeck, "S1,D1,S2,D2,H1,C1,H2,C2");
	}

	@Test
	@DisplayName("Sjekk at deal gir ut de tre siste kortene")
	public void testDeal() {
		CardHand hand = new CardHand();
		cardDeck.deal(hand, 3);
		CardDeckTest.checkDeck(cardDeck, "S1,S2,H1,H2,D1");
	}
}
