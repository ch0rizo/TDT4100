package oving6.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
  Map<Employee, List<String>> employeePrintedDocs = new HashMap<>();
  
  public void printDocument(String document, Employee employee) {
    if (document == null || employee == null) {
      throw new IllegalArgumentException("None of the args can be null");
    }
    employeePrintedDocs.computeIfAbsent(employee, _ -> new ArrayList<>()).add(document);
    System.out.println("Printed: " + document);
  }

  public List<String> getPrintHistory(Employee employee) {
    return new ArrayList<>(employeePrintedDocs.getOrDefault(employee, new ArrayList<>()));
  }
}
