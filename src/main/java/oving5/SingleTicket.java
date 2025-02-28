package oving5;

public class SingleTicket implements Ticket {
  private boolean validTicket;

  public SingleTicket() {
    this.validTicket = true;
  }

  @Override
  public boolean scan() {
    if (this.validTicket) {
      this.validTicket = false;
      return true;
    }
    return false;
  }
}
