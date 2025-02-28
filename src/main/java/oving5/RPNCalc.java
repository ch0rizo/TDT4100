package oving5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class RPNCalc {
  private Stack<Double> stack;

  private Map<Character, BinaryOperator<Double>> operations;

  public RPNCalc() {
    this.stack = new Stack<>();
    this.operations = new HashMap<>();
  }
  
  public void push(double tall) {
    stack.push(tall);
  }

  public double pop() {
    if (stack.isEmpty()) {
      return Double.NaN;
    }
    return stack.pop();
  }

  public double peek(int index) {
    if (index < 0 || index >= stack.size()) {
      return Double.NaN;
    }
    return stack.get(stack.size() - 1 - index);
  }

  public int getSize() {
    return stack.size();
  }

  public void performOperation(char operation) {
    if (!this.operations.containsKey(operation)) {
      throw new UnsupportedOperationException("Don't have that operation :(");
    }

    Double tall1 = stack.pop();
    Double tall2 = stack.pop();

    stack.push(operations.get(operation).apply(tall2, tall1));
  }

  public boolean addOperator(char operator, BinaryOperator<Double> operation) {
    if (operator == '\u0000') {
      throw new IllegalArgumentException("Operator can not be null");
    }
    if (!this.operations.containsKey(operator) && operation != null) {
      this.operations.put(operator, operation);
      return true;
    }
    return false;
  }

  public void removeOperator(char operator) {
    operations.remove(operator);
  }

  @Override
  public String toString() {
    return this.stack.toString();
  }

  public static void main(String[] args) {
    RPNCalc calculator = new RPNCalc();
    calculator.push(10.0);
    calculator.push(12.0);
    calculator.push(11.0);

    calculator.performOperation('@');
    System.out.println(calculator);
  }
}
