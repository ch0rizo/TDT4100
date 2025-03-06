package oving6.delegation.office;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
  private Collection<Employee> employees;
  private Iterator<Employee> employeeIterator;

  public Manager(Collection<Employee> employees) {
    if (employees == null || employees.isEmpty()) {
      throw new IllegalArgumentException("Cant be empty");
    }
    this.employees = employees;
    this.employeeIterator = employees.iterator();
  }

  @Override
  public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
      return getNextEmployee().doCalculations(operation, value1, value2);
  }

  @Override
  public void printDocument(String document) {
      getNextEmployee().printDocument(document);
  }

  @Override
  public int getTaskCount() {
    int count = 0;
    for (Employee employee : employees) {
      count += employee.getTaskCount();
    }
    return count;
  }

  private Employee getNextEmployee() {
    if (!employeeIterator.hasNext()) {
      employeeIterator = employees.iterator();
    }
    return employeeIterator.next();
  }

  @Override
  public int getResourceCount() {
    int count = 1; // for å telle med seg selv
    for (Employee employee : employees) {
      if (employee instanceof Manager manager) {
        count += manager.getResourceCount(); // Rekrusiv fucker
      }
      else {
        count = employees.size() + 1;
      }
    }
    return count;
  }
}
