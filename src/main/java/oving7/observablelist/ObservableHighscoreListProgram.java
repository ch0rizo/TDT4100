package oving7.observablelist;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {
  private ObservableHighscoreList observableHighscoreList;

  void init() {
    this.observableHighscoreList = new ObservableHighscoreList(10);
    this.observableHighscoreList.addObservableListListener(this);
  }

  void run() {
    init();

    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println("Skriv inn et tall: ");
        int result = scanner.nextInt();
        this.observableHighscoreList.addResult(result);
      }
    }
  }

  @Override
  public void listChanged(ObservableList list, int position) {
    System.out.println("Posisjon " + position + " ble endret i " + list);
  }

  public static void main(String[] args) {
    ObservableHighscoreListProgram program = new ObservableHighscoreListProgram();
    program.run();
  }
}
