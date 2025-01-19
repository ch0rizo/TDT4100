package oving2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineEditorTest {

	private LineEditor lineEditor;

	@BeforeEach
	public void setup() {
		lineEditor = new LineEditor();
	}

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(LineEditor.class);
	}

	@Test
	public void testConstructor() {
		assertEquals("", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testGetSetText() {
		lineEditor.setText("ABC");
		assertEquals("ABC", lineEditor.getText());
		assertEquals(3, lineEditor.getInsertionIndex());

		lineEditor.setText("");
		assertEquals("", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testGetSetInsertionIndex() {
		lineEditor.setText("ABC");
		assertEquals("ABC", lineEditor.getText());
		assertEquals(3, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(0);
		assertEquals("ABC", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(3);
		assertEquals("ABC", lineEditor.getText());
		assertEquals(3, lineEditor.getInsertionIndex());

		assertThrows(IllegalArgumentException.class, () -> {
			lineEditor.setInsertionIndex(-1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			lineEditor.setInsertionIndex(4);
		});
	}

	@Test
	public void testLeft() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(2);
		lineEditor.left();
		assertEquals("Ja", lineEditor.getText());
		assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.left();
		assertEquals("Ja", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.left();
		assertEquals("Ja", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testRight() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(0);
		lineEditor.right();
		assertEquals("Ja", lineEditor.getText());
		assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.right();
		lineEditor.setText("Ja");
		assertEquals(2, lineEditor.getInsertionIndex());

		lineEditor.right();
		lineEditor.setText("Ja");
		assertEquals(2, lineEditor.getInsertionIndex());
	}

	@Test
	public void testDeleteLeft() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(0);
		lineEditor.deleteLeft();
		assertEquals("Ja", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(1);
		lineEditor.deleteLeft();
		assertEquals("a", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteLeft();
		assertEquals("a", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(2);
		lineEditor.deleteLeft();
		assertEquals("J", lineEditor.getText());
		assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.deleteLeft();
		assertEquals("", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteLeft();
		assertEquals("", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testDeleteRight() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(2);
		lineEditor.deleteRight();
		assertEquals("Ja", lineEditor.getText());
		assertEquals(2, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(1);
		lineEditor.deleteRight();
		assertEquals("J", lineEditor.getText());
		assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.deleteRight();
		assertEquals("J", lineEditor.getText());
		assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(0);
		lineEditor.deleteRight();
		assertEquals("a", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteRight();
		assertEquals("", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteRight();
		assertEquals("", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testInsertString() {
		lineEditor.insertString("");
		assertEquals("", lineEditor.getText());
		assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.insertString("Java");
		assertEquals("Java", lineEditor.getText());
		assertEquals(4, lineEditor.getInsertionIndex());

		lineEditor.insertString(" er gøy!");
		assertEquals("Java er gøy!", lineEditor.getText());
		assertEquals(12, lineEditor.getInsertionIndex());

		lineEditor.setText("Javagøy!");
		lineEditor.setInsertionIndex(4);
		lineEditor.insertString(" er ");
		assertEquals("Java er gøy!", lineEditor.getText());
		assertEquals(8, lineEditor.getInsertionIndex());

		lineEditor.setText("er gøy!");
		lineEditor.setInsertionIndex(0);
		lineEditor.insertString("Java ");
		assertEquals("Java er gøy!", lineEditor.getText());
		assertEquals(5, lineEditor.getInsertionIndex());
	}
}
