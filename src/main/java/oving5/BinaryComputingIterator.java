package oving5;

import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {
  Iterator<Double> iterator1;
  Iterator<Double> iterator2;
  BinaryOperator<Double> operator;
  Double default1 = null;
  Double default2 = null;

  public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,
      BinaryOperator<Double> operator) {
    if (isValidCon1(iterator1, iterator2, operator)) {
      this.iterator1 = iterator1;
      this.iterator2 = iterator2;
      this.operator = operator;
    }
  }
  
  public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
    // Valider ingen av args kan være null
    this.iterator1 = iterator1;
    this.iterator2 = iterator2;
    this.operator = operator;
    this.default1 = default1;
    this.default2 = default2;
  }

  private boolean isValidCon1(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
    if (iterator1 == null || iterator2 == null || operator == null) {
      throw new IllegalArgumentException("None of args can be null");
    }
    return true;
  }

  @Override
  public boolean hasNext() {
    return (iterator1.hasNext() || iterator2.hasNext()) && (iterator1.hasNext() || default1 != null) && (iterator2.hasNext() || default2 != null);
  }

  @Override
  public Double next() {
    Double num1 = (iterator1.hasNext()) ? iterator1.next() : default1;
    Double num2 = (iterator2.hasNext()) ? iterator2.next() : default2;

    return operator.apply(num1, num2);
  }

  public static void main(String[] args) {
    Iterator<Double> iterator1 = List.of(2.0, 3.0).iterator();
    Iterator<Double> iterator2 = List.of(5.0).iterator();

    BinaryOperator<Double> addition = (a, b) -> a + b;
    
    BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, 10.0, null, addition);
    System.out.println(binaryIterator.next());
    System.out.println(binaryIterator.hasNext());
    System.out.println(binaryIterator.next());
    System.out.println(binaryIterator.hasNext());
    
  }

}
