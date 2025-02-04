package oving4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

	private Person anne;
	private Person hallvard;
	private Person jens;
	private Person marit;

	private static void hasChildren(Person person, Collection<Person> children) {
		assertEquals(children.size(), person.getChildCount());

		for (Person child : children) {
			boolean found = false;
			int i = 0;

			while (i < person.getChildCount()) {
				if (child == person.getChild(i)) {
					found = true;
					break;
				}
				i++;
			}
			assertTrue(found);
		}
	}

	@BeforeEach
	public void setup() {
		anne = new Person("Anne", 'F');
		hallvard = new Person("Hallvard", 'M');
		jens = new Person("Jens", 'M');
		marit = new Person("Marit", 'F');
	}

	@Test
	@DisplayName("Kvinne kan ikke være far")
	public void testFatherException() {
		assertThrows(IllegalArgumentException.class, () -> {
			jens.setFather(marit);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			anne.setFather(marit);
		});
	}

	@Test
	@DisplayName("Mann kan ikke være mor")
	public void testMotherException() {
		assertThrows(IllegalArgumentException.class, () -> {
			jens.setMother(hallvard);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			anne.setMother(hallvard);
		});
	}

	@Test
	@DisplayName("Mann kan ikke være sin egen far")
	public void testSelfFatherException() {
		assertThrows(IllegalArgumentException.class, () -> {
			jens.setFather(jens);
		});
	}

	@Test
	@DisplayName("Kvinne kan ikke være sin egen mor")
	public void testSelfMotherException() {
		assertThrows(IllegalArgumentException.class, () -> {
			anne.setMother(anne);
		});
	}

	@Test
	@DisplayName("Sette farskap med setFather")
	public void testSetFather() {
		jens.setFather(hallvard);

		// Check state of hallvard
		assertEquals(null, hallvard.getFather());
		assertEquals(null, hallvard.getMother());
		PersonTest.hasChildren(hallvard, List.of(jens));

		// Check state of jens
		assertEquals(hallvard, jens.getFather());
		assertEquals(null, jens.getMother());
		assertEquals(0, jens.getChildCount());

		anne.setFather(hallvard);

		// Check state of hallvard
		assertEquals(null, hallvard.getFather());
		assertEquals(null, hallvard.getMother());
		PersonTest.hasChildren(hallvard, List.of(jens, anne));

		// Check state of jens
		assertEquals(hallvard, jens.getFather());
		assertEquals(null, jens.getMother());
		assertEquals(0, jens.getChildCount());

		// Check state of anne
		assertEquals(hallvard, anne.getFather());
		assertEquals(null, anne.getMother());
		assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Sette farskap med addChild")
	public void testFatherAddChild() {
		hallvard.addChild(jens);

		// Check state of hallvard
		assertEquals(null, hallvard.getFather());
		assertEquals(null, hallvard.getMother());
		PersonTest.hasChildren(hallvard, List.of(jens));

		// Check state of jens
		assertEquals(hallvard, jens.getFather());
		assertEquals(null, jens.getMother());
		assertEquals(0, jens.getChildCount());

		hallvard.addChild(anne);

		// Check state of hallvard
		assertEquals(null, hallvard.getFather());
		assertEquals(null, hallvard.getMother());
		PersonTest.hasChildren(hallvard, List.of(jens, anne));

		// Check state of jens
		assertEquals(hallvard, jens.getFather());
		assertEquals(null, jens.getMother());
		assertEquals(0, jens.getChildCount());

		// Check state of anne
		assertEquals(hallvard, anne.getFather());
		assertEquals(null, anne.getMother());
		assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Sette morskap med setMother")
	public void testSetMother() {
		jens.setMother(marit);

		// Check state of marit
		assertEquals(null, marit.getFather());
		assertEquals(null, marit.getMother());
		PersonTest.hasChildren(marit, List.of(jens));

		// Check state of jens
		assertEquals(null, jens.getFather());
		assertEquals(marit, jens.getMother());
		assertEquals(0, jens.getChildCount());

		anne.setMother(marit);

		// Check state of marit
		assertEquals(null, marit.getFather());
		assertEquals(null, marit.getMother());
		PersonTest.hasChildren(marit, List.of(jens, anne));

		// Check state of jens
		assertEquals(null, jens.getFather());
		assertEquals(marit, jens.getMother());
		assertEquals(0, jens.getChildCount());

		// Check state of anne
		assertEquals(null, anne.getFather());
		assertEquals(marit, anne.getMother());
		assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Sette morskap med addChild")
	public void testMotherAddChild() {
		marit.addChild(jens);

		// Check state of marit
		assertEquals(null, marit.getFather());
		assertEquals(null, marit.getMother());
		PersonTest.hasChildren(marit, List.of(jens));

		// Check state of jens
		assertEquals(null, jens.getFather());
		assertEquals(marit, jens.getMother());
		assertEquals(0, jens.getChildCount());

		marit.addChild(anne);

		// Check state of marit
		assertEquals(null, marit.getFather());
		assertEquals(null, marit.getMother());
		PersonTest.hasChildren(marit, List.of(jens, anne));

		// Check state of jens
		assertEquals(null, jens.getFather());
		assertEquals(marit, jens.getMother());
		assertEquals(0, jens.getChildCount());

		// Check state of anne
		assertEquals(null, anne.getFather());
		assertEquals(marit, anne.getMother());
		assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Endre far med setFather")
	public void testChangeFatherSetFather() {
		anne.setFather(jens);
		// Check state of anne
		assertEquals(jens, anne.getFather());
		// Check state of jens
		PersonTest.hasChildren(jens, List.of(anne));

		anne.setFather(hallvard);
		// Check state of anne
		assertEquals(hallvard, anne.getFather());
		// Check state of jens
		assertEquals(0, jens.getChildCount());
		// Check state of hallvard
		PersonTest.hasChildren(hallvard, List.of(anne));
	}

	@Test
	@DisplayName("Endre far med addChild")
	public void testChangeFatherAddChild() {
		jens.addChild(anne);
		// Check state of anne
		assertEquals(jens, anne.getFather());
		// Check state of jens
		PersonTest.hasChildren(jens, List.of(anne));

		hallvard.addChild(anne);
		// Check state of anne
		assertEquals(hallvard, anne.getFather());
		// Check state of jens
		assertEquals(0, jens.getChildCount());
		// Check state of hallvard
		PersonTest.hasChildren(hallvard, List.of(anne));
	}

	@Test
	@DisplayName("Endre morskap med setMother")
	public void testChangeMotherSetMother() {
		jens.setMother(anne);
		// Check state of jens
		assertEquals(anne, jens.getMother());
		// Check state of anne
		PersonTest.hasChildren(anne, List.of(jens));

		jens.setMother(marit);
		// Check state of jens
		assertEquals(marit, jens.getMother());
		// Check state of anne
		assertEquals(0, anne.getChildCount());
		// Check state of marit
		PersonTest.hasChildren(marit, List.of(jens));
	}

	@Test
	@DisplayName("Endre morskap med addChild")
	public void testChangeMotherAddChild() {
		anne.addChild(jens);
		// Check state of jens
		assertEquals(anne, jens.getMother());
		// Check state of anne
		PersonTest.hasChildren(anne, List.of(jens));

		marit.addChild(jens);
		// Check state of jens
		assertEquals(marit, jens.getMother());
		// Check state of anne
		assertEquals(0, anne.getChildCount());
		// Check state of marit
		PersonTest.hasChildren(marit, List.of(jens));
	}
}
