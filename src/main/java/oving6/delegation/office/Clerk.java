package oving6.delegation.office;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Clerk implements Employee {
  private Printer printer;
  private List<Clerk> listOfClerks = new ArrayList<>();
  private int taskCount = 0;
  
  public Clerk(Printer printer) {
    this.printer = printer;
  }

  @Override
  public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
    taskCount++;
    return operation.apply(value1, value2);
  }

  @Override
  public void printDocument(String document) {
    taskCount++;
    printer.printDocument(document, this);
  }

  @Override
  public int getTaskCount() {
      return taskCount;
  }

  @Override
  public int getResourceCount() {
    return 1;
  }
  
  public void addClerk() {
    listOfClerks.add(this);
  }

  public static void main(String[] args) {
    Printer printer = new Printer();
    Clerk clerk1 = new Clerk(printer);
    Clerk clerk2 = new Clerk(printer);

    clerk1.printDocument("doc1");
    clerk1.printDocument("doc2");
    System.out.println(clerk1.doCalculations((a, b) -> (a-b), 1, 3));
    System.out.println(clerk1.getTaskCount());
    
  }
}
