package oving6.observable;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements StockListener{
  private String nameOfIndex;
  private double index;
  private List<Stock> stocks;

  public StockIndex(String name, Stock... stocks) {
    if (name == null) {
      throw new IllegalArgumentException("Cannot be null");
    }

    this.nameOfIndex = name;
    this.stocks = new ArrayList<>();

    for (Stock stock : stocks) {
      if (stock == null) throw new IllegalArgumentException("Stock cant be null");
      this.stocks.add(stock);
      stock.addStockListener(this);
    }
    
    if (stocks.length == 0) {
      this.index = 0;
    } else {
      double sum = 0;

      for (Stock stock : stocks) {
        if (stock == null) {
          throw new IllegalArgumentException("Cant be null");
        }
        sum += stock.getPrice();
      }
      this.index = sum;
    }
  }
  
  public void addStock(Stock stock) {
    if (stock == null)
      throw new IllegalArgumentException("Cant be null");
    if (!stocks.contains(stock)) {
      this.stocks.add(stock);
      stock.addStockListener(this);
    }
  }

  public void removeStock(Stock stock) {
    this.stocks.remove(stock);
    stock.removeStockListener(this);
  }

  public double getIndex() {
    double sum = 0;
    for (Stock stock : stocks) {
      sum += stock.getPrice();
    }
    index = sum;
    return index;
  }

  @Override
  public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
    System.out.println(nameOfIndex + " Index: " + stock.getTicker() + " changed from $" + oldValue + " to $" + newValue
        + "\n" + "New Index: " + index);
  }
  
  public static void main(String[] args) {
    Stock stock1 = new Stock("Tesla", 100);
    Stock stock2 = new Stock("Google", 200);
    Stock stock3 = new Stock("Apple", 300);

    StockIndex stockIndex = new StockIndex("NasDaq", stock1, stock2, stock3);
    System.out.println(stockIndex.nameOfIndex + ": " + stockIndex.stocks);

    stock1.setPrice(400);

    System.out.println(stockIndex.nameOfIndex + ": " + stockIndex.stocks);
  }
}
