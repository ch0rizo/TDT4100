package oving6.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {
  private String ticker;
  private double price;
  private List<StockListener> stockListeners = new ArrayList<>();;

  public Stock(String ticker, double price) {
    if (ticker == null) throw new IllegalArgumentException("Ticker can't be null");
    if (price <= 0) throw new IllegalArgumentException("No negative");
    
    this.ticker = ticker;
    this.price = price;
  }

  public void setPrice(double price) {
    if (price <= 0) throw new IllegalArgumentException("No negative");
    
    double oldPrice = this.price;
    this.price = price;

    for (StockListener listener : stockListeners) {
      listener.stockPriceChanged(this, oldPrice, price);
    }
  }

  public String getTicker() {
    return ticker;
  }

  public double getPrice() {
    return price;
  }

  public void addStockListener(StockListener listener) {
    if (!stockListeners.contains(listener)) {
      stockListeners.add(listener);
    }
  }

  public void removeStockListener(StockListener listener) {
    stockListeners.remove(listener);
  }

  @Override
  public String toString() {
    return ticker + " " + price;
  }
}
