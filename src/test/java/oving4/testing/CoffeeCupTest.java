package oving4.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import oving4.TwitterAccount;

public class CoffeeCupTest {

  CoffeeCup coffeeCup1;
  CoffeeCup coffeeCup2;

  @BeforeEach
  public void setup() {
    coffeeCup1 = new CoffeeCup(10, 0);
    coffeeCup2 = new CoffeeCup(10, 6);
  }
  
  
  @Test
  @DisplayName("Sjekk om getCapacity funker")
  void testGetCapacity() {
    assertEquals(10, coffeeCup1.getCapacity());
    assertEquals(10, coffeeCup2.getCapacity());
  }

  @Test
  @DisplayName("Sjekk getCurrentVolume()")
  void testGetCurrentVolume() {
    assertEquals(0, coffeeCup1.getCurrentVolume());
    assertEquals(6, coffeeCup2.getCurrentVolume());
  }

  @Test
  @DisplayName("Sjekk increaseCupSize funker som tenkt")
  void testIncreaseCupSize() {
    coffeeCup1.increaseCupSize(2);
    assertEquals(12, coffeeCup1.getCapacity());
    assertNotEquals(10, coffeeCup1.getCapacity());

    coffeeCup2.increaseCupSize(-2);
    assertEquals(10, coffeeCup2.getCapacity());
    assertNotEquals(8, coffeeCup2.getCapacity());
  }

  @Test
  @DisplayName("Test drinkCoffee")
  void testDrinkCoffee() {
    assertThrows(RuntimeException.class, () -> {
      coffeeCup1.drinkCoffee(11);
    }, "You can't drink that much coffee!");
    assertThrows(RuntimeException.class, () -> {
      coffeeCup1.drinkCoffee(-1);
    }, "You can't drink that much coffee!");
    
    coffeeCup2.drinkCoffee(4);
    assertEquals(2, coffeeCup2.getCurrentVolume());
    coffeeCup1.drinkCoffee(0);
    assertEquals(0, coffeeCup1.getCurrentVolume());
  }

  @Test
  @DisplayName("Test fillCoffee")
  void fillCoffee() {
    assertThrows(RuntimeException.class, () -> {
      coffeeCup1.fillCoffee(11);
    }, "You just poured coffee all over the table. Good job.");

    coffeeCup1.fillCoffee(8);
    coffeeCup2.fillCoffee(2);
    assertEquals(8, coffeeCup2.getCurrentVolume());
    assertEquals(8, coffeeCup1.getCurrentVolume());
  }
}
