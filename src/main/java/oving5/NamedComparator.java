package oving5;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {

  @Override
  public int compare(Named named1, Named named2) {
    int comparedValue = named1.getFamilyName().charAt(0) - named2.getFamilyName().charAt(0);
    if (comparedValue == 0) {
      return named1.getGivenName().charAt(0) - named2.getGivenName().charAt(0);
    }
    return named1.getFamilyName().charAt(0) - named2.getFamilyName().charAt(0);
  }
}
