package oving3;

public class Nim {
  private int[] piles;

  // Constructor
  public Nim(int pileSize) {
    this.piles = new int[] { pileSize, pileSize, pileSize };
  }
  
  public Nim() {
    this.piles = new int[] { 10, 10, 10 };
  }

  public void removePieces(int number, int targetPile) {
    if (number < 1) {
      throw new IllegalArgumentException("Du kan ikke velge 0 eller negative brikker");
    }
    else if (this.piles[targetPile] - number < 0 && !isGameOver()) {
      throw new IllegalArgumentException("NOT DO");
    }
    if (isValidMove(number, targetPile) && !isGameOver()) {
      this.piles[targetPile] -= number;
    }
    else if (isValidMove(number, targetPile) && isGameOver()) {
      throw new IllegalStateException("FAIL!");
    }
  }

  // Validators
  public boolean isValidMove(int number, int targetPile) {
    if (targetPile < 0 || targetPile > 2) {
      return false;
    }
    else if (number <= 0) {
      return false;
    }
    else if (this.piles[targetPile] - number < 0) {
      return false; 
    }
    return true;
  }

  public boolean isGameOver() {
    return this.piles[0] == 0 || this.piles[1] == 0 || this.piles[2] == 0;
  }

  // Getter
  public int getPile(int targetPile) {
    return this.piles[targetPile];
  }

  @Override
  public String toString() {
    return "Game state: " + "\n0: " + this.piles[0] + "\n1: " + this.piles[1] + "\n2: " + this.piles[2];
  }
  
  public static void main(String[] args) {
    Nim nim = new Nim();
    System.out.println(nim.getPile(0));
    nim.removePieces(11, 0);
    System.out.println(nim.getPile(0));
    //System.out.println(nim.toString());
  }
}
