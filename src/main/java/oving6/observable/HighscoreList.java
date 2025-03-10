package oving6.observable;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
  private final int maxSize;
  private final List<Integer> results = new ArrayList<>();; 
  private final List<HighscoreListListener> listeners = new ArrayList<>();

  public HighscoreList(int maxSize) {
    this.maxSize = maxSize;
  }

  public int size() {
    return results.size();
  }

  public int getElement(int position) {
    return results.get(position);
  }

  public void addResult(int result) {
    int position = findPosition(result);
    results.add(position, result);

    if (results.size() > maxSize) {
      results.remove(results.size() - 1);

      if (position >= results.size()) { // Viktig å ha med dette fordi listener må være sist posisjon.
        position = -1; // fordi hvis den havner utfor listen skal posisjon være lik -1
      }
    }
    
    for (HighscoreListListener listener : listeners) {
      listener.listChanged(this, position);
    }
  }

  // Hjelpemetode for å finne posisjon
  private int findPosition(int result) {
    for (int i = 0; i < results.size(); i++) {
      if (results.get(i) > result) {
        return i;
      }
    }
    return results.size();
  }

  public void addHighscoreListListener(HighscoreListListener listener) {
    if (!listeners.contains(listener)) {
      listeners.add(listener);
    }
  }

  public void removeHighscoreListListener(HighscoreListListener listener) {
    listeners.remove(listener);
  }

  @Override
  public String toString() {
    return results.toString();
  }

  public static void main(String[] args) {
    HighscoreList highscore = new HighscoreList(5);
    System.out.println("Max size: " + highscore.maxSize);

    
    highscore.addResult(2);
    highscore.addResult(3);
    highscore.addResult(4);
    highscore.addResult(5);
    highscore.addResult(6);
    highscore.addResult(2);

    System.out.println(highscore);

  }
}
