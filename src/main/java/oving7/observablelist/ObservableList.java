package oving7.observablelist;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList {
  protected List<Object> elements;
  protected List<ObservableListListener> listeners;

  public ObservableList() {
    this.elements = new ArrayList<>();
    this.listeners = new ArrayList<>();
  }
  
  public int size() {
    return elements.size();
  }

  public Object getElement(int position) {
    return elements.get(position);
  }

  public abstract boolean acceptsElement(Object object);

  public void addElement(int position, Object object) {
    if (!acceptsElement(object))
      throw new IllegalArgumentException("Object not accepted");

    if (position > size())
      throw new IndexOutOfBoundsException("No position for this element");

    this.elements.add(position, object);

    for (ObservableListListener listener : this.listeners) {
      listener.listChanged(this, position);
    }
  }

  public void addElement(Object object) {
    if (!acceptsElement(object))
      throw new IllegalArgumentException("Object not accepted");

    this.elements.add(size(), object);

    for (ObservableListListener listener : this.listeners) {
      listener.listChanged(this, size() - 1);
    }
  }

  public void removeElement(int position) {
    if (position > size())
      throw new IndexOutOfBoundsException("No position in list");

    this.elements.remove(position);
  }

  public void addObservableListListener(ObservableListListener listener) {
    if (!this.listeners.contains(listener)) {
      this.listeners.add(listener);
    }
  }

  public void removeObservableListListener(ObservableListListener listener) {
    this.listeners.remove(listener);
  }
}
