package oving6.delegation.office;

import java.util.List;

public class OfficeSimulation {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Clerk clerk1 = new Clerk(printer);
        Clerk clerk2 = new Clerk(printer);
        Manager manager = new Manager(List.of(clerk1, clerk2));

        // Utføre operasjoner
        clerk1.printDocument("doc1");
        clerk2.printDocument("doc2");
        manager.printDocument("doc3");
        System.out.println(manager.doCalculations((a, b) -> a * b, 3, 4));

        // Skriv ut antall oppgaver
        System.out.println("Clerk1 tasks: " + clerk1.getTaskCount());
        System.out.println("Clerk2 tasks: " + clerk2.getTaskCount());
        System.out.println("Manager total tasks: " + manager.getTaskCount());
    }
}
