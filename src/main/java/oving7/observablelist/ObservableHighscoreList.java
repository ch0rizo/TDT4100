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

    if (size() >= maxSize && position == size()) {
      return;
    }

    elements.add(position, result);

    for (ObservableListListener listener : listeners) {
      listener.listChanged(this, position);
    }

    if (size() > maxSize) {
      elements.remove(size() - 1);
    }
  }

  // Hjelpemetode for å finne posisjon
  private int findPosition(int result) {
    for (int i = 0; i < elements.size(); i++) {
      Integer current = (Integer) getElement(i);
      if (current != null && current > result) {
        return i;
      }
    }
    return size();
  }

  @Override
  public String toString() {
    return "Listen med: " + elements;
  }
}
