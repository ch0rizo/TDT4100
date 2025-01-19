package oving2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DigitTest {

	private Digit digit;

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(Digit.class);
	}

	@Test
	public void testDigit() {
		digit = new Digit(10);
		assertEquals(0, digit.getValue());
		assertEquals(10, digit.getBase());

		assertThrows(IllegalArgumentException.class, () -> {
			digit = new Digit(-1);
		}, "Should not be able to create digit with negative base");
	}

	private void testIncrement(int base, boolean checkValue, boolean checkToString) {
		digit = new Digit(base);
		int i = 0;
		String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		while (i < base) {
			if (checkValue) {
				assertEquals(i % base, digit.getValue());
			}
			if (checkToString) {
				assertEquals(String.valueOf(digits.charAt(i % base)),
						digit.toString().toUpperCase());
			}

			boolean overflow = digit.increment();
			i++;

			if (checkValue) {
				assertEquals(i % base == 0, overflow);
				assertEquals(i % base, digit.getValue());
			}
			if (checkToString) {
				assertEquals(String.valueOf(digits.charAt(i % base)),
						digit.toString().toUpperCase());
			}
		}
	}

	private void testIncrement(boolean checkValue, boolean checkToString) {
		for (int base = 2; base <= 16; base++) {
			testIncrement(base, checkValue, checkToString);
		}
	}

	@Test
	@DisplayName("Digit should increment correctly")
	public void testIncrement() {
		testIncrement(true, false);
	}

	@Test
	@DisplayName("Digit should be displayed by correct characters. For example 10 in base 16 "
			+ "should be displayed as A")
	public void testToString() {
		testIncrement(false, true);
	}
}
