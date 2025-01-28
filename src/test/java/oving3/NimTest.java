package oving3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NimTest {

	private Nim nim;

	private boolean checkValidMove(Nim game, int pieces, boolean legal) {
		return (legal == game.isValidMove(pieces, 0) && (legal == game.isValidMove(pieces, 1))
				&& (legal == game.isValidMove(pieces, 2)));
	}

	@BeforeEach
	public void setup() {
		nim = new Nim(5);
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		assertEquals(5, nim.getPile(0));
		assertEquals(5, nim.getPile(1));
		assertEquals(5, nim.getPile(2));
	}

	@Test
	@DisplayName("Remove pieces")
	public void testRemovePieces() {
		nim.removePieces(3, 0);
		nim.removePieces(2, 1);
		nim.removePieces(1, 2);
		assertEquals(2, nim.getPile(0));
		assertEquals(3, nim.getPile(1));
		assertEquals(4, nim.getPile(2));

		// Fjerne negativt antall gir feil
		assertThrows(IllegalArgumentException.class, () -> {
			nim.removePieces(-1, 0);
		});

		// Fjerne for få brikker gir feil
		assertThrows(IllegalArgumentException.class, () -> {
			nim.removePieces(0, 0);
		});

		// Fjerne for mange brukker gir feil
		assertThrows(IllegalArgumentException.class, () -> {
			nim.removePieces(6, 0);
		});
	}

	@Test
	@DisplayName("Game over")
	public void testGameOver() {
		assertFalse(nim.isGameOver());

		nim.removePieces(5, 0);
		assertEquals(0, nim.getPile(0));
		assertTrue(nim.isGameOver());

		// Fjerne brikker etter avsluttet spill gir feil
		assertThrows(IllegalStateException.class, () -> {
			nim.removePieces(5, 0);
		});
	}

	@Test
	@DisplayName("Valid moves")
	public void testIsValidMove() {
		assertTrue(this.checkValidMove(nim, 2, true));
		assertTrue(this.checkValidMove(nim, -2, false));
		assertTrue(this.checkValidMove(nim, 0, false));
		assertTrue(this.checkValidMove(nim, 6, false));

		nim.removePieces(5, 0);
		assertTrue(this.checkValidMove(nim, 2, false));
	}
}
