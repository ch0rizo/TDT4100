package oving6.observable;

import java.util.Scanner;

public class HighscoreProgram implements HighscoreListListener {
  private HighscoreList highscoreList;
  private Scanner scanner;

  public void init() {
    highscoreList = new HighscoreList(10);
    highscoreList.addHighscoreListListener(this);
    scanner = new Scanner(System.in);
  }

  public void run() {
    System.out.println("Velg et nummer: ");
    if (scanner.hasNextInt()) {
      int number = scanner.nextInt();
      highscoreList.addResult(number);
    } else {
      System.out.println("Ugyldig input! Skriv inn et tall!");
      scanner.next();
    }
  }

  @Override
  public void listChanged(HighscoreList highscoreList, int position) {
    System.out.println("Sist endret posisjon " +  position + "\n" + highscoreList);
  }

  public static void main(String[] args) {
    HighscoreProgram program = new HighscoreProgram();
    program.init();

    while (true) {
      program.run();  
    }
  }
}
