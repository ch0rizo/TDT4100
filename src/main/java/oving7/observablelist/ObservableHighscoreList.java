package oving7.observablelist;

public class ObservableHighscoreList extends ObservableList {
  private final int maxSize;

  public ObservableHighscoreList(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public boolean acceptsElement(Object element) {
    return element instanceof Integer;
  }

  public void addResult(int result) {
    int position = findPosition(result);
    addElement(position, result);

    if (this.elements.size() > maxSize) {
      this.elements.remove(this.elements.size() - 1);

      if (position >= elements.size()) { // Viktig å ha med dette fordi listener må være sist posisjon.
        position = -1; // fordi hvis den havner utfor listen skal posisjon være lik -1
      }
    }
    
    for (ObservableListListener listener : listeners) {
      listener.listChanged(this, position);
    }
  }

  // Hjelpemetode for å finne posisjon
  private int findPosition(int result) {
    if (acceptsElement(result)) {
      for (int i = 0; i < elements.size(); i++) {
        if (this.elements.get(i) > result) {
          return i;
        }
      }
      return elements.size();
    }
    return 0;
  }

  @Override
  public String toString() {
    return "Listen med: " + elements;
  }
}
