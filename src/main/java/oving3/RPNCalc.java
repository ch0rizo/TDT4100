package oving3;

import java.util.Stack;

public class RPNCalc {
  private Stack<Double> stack;

  public RPNCalc() {
    stack = new Stack<>();
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
    Double tall1 = stack.pop();
    Double tall2 = stack.pop();

    Double value;

    switch (operation) {
      case '+' -> value = tall2 + tall1;
      case '-' -> value = tall2 - tall1;
      case '*' -> value = tall2 * tall1;
      case '/' -> value = tall2 / tall1;
      default -> throw new IllegalArgumentException("Operation not supported");
    }

    stack.push(value);
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
