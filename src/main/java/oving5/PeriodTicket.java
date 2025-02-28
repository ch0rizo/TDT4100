package oving5;

import java.time.LocalDateTime;

public class PeriodTicket implements Ticket {
  private boolean validTicket = false;
  private LocalDateTime start;
  private LocalDateTime end;


  public PeriodTicket(LocalDateTime start, LocalDateTime end) {
    if (isValidTime(start, end)) {
      this.start = start; 
      this.end = end;
    }
  }

  private boolean isValidTime(LocalDateTime start, LocalDateTime end) {
    if (start.isAfter(end) || end.isBefore(start)) {
      throw new IllegalArgumentException("Tidene er fucked mann");
    }
    return true;
  }

  private boolean isValidTicket() {
    if (this.start.isBefore(LocalDateTime.now()) && this.end.isAfter(LocalDateTime.now())) {
      this.validTicket = true;
    }
    return this.validTicket;
  }

 @Override
  public boolean scan() {
    return isValidTicket();
  }
}