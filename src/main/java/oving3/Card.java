package oving3;

/**
 * The {@code Card} class is a so-called value-based class, which is coded in such a way that its
 * objects cannot be modified after they are created. A {@code Card} object has a suit and a face.
 */
public class Card {

    /**
     * The constructor of the {@code Card} class initializes the suit and face of the card with the
     * first and second arguments, respectively.
     * 
     * @param suit the suit of the card, one of {@code 'S'} (spades), {@code 'H'} (hearts),
     *        {@code 'D'} (diamonds), or {@code 'C'} (clubs)
     * @param face the face of the card, an integer between {@code 1} (ace) and {@code 13} (king)
     *        (both inclusive)
     * @throws IllegalArgumentException if the suit or face is illegal
     * 
     * @see {@link CardTest#testConstructor}
     */
    public Card(char suit, int face) {
        // TODO: implement this constructor
    }

    /**
     * @return the suit of the card
     */
    public char getSuit() {
        // TODO: implement this method
        return '\0';
    }

    /**
     * @return the face of the card
     */
    public int getFace() {
        // TODO: implement this method
        return 0;
    }

    /**
     * @return the value of the card of the form {@code <suit><face>}. For example, the ace of
     *         spades should return {@code "S1"}
     * 
     * @see {@link CardTest#testToString}
     */
    @Override
    public String toString() {
        // TODO: implement this method
        return null;
    }

    public static void main(String[] args) {
        Card card = new Card('S', 1);
        System.out.println(card);
    }
}
