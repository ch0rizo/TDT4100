package oving7.savingsaccount;

public class ForeldreSpar extends SavingsAccount {
  private int amountWithdrawls;
  private int originalAmouthWithdrawls;
  
  public ForeldreSpar(double rent, int amountWithdrawls) {
    if (rent < 0 || amountWithdrawls < 0)
      throw new IllegalArgumentException("Cant be negative");

    this.amountWithdrawls = amountWithdrawls;
    this.originalAmouthWithdrawls = amountWithdrawls;
    super(rent);
  }

  @Override
  public void withdraw(double amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Not be negative");
    
    if (this.balance - amount < 0)
      throw new IllegalStateException("Not enough money on account");
    
    if (amountWithdrawls == 0)
      throw new IllegalStateException("No more withdrawls");

    this.balance -= amount;
    this.amountWithdrawls --;
  }

  public int getRemainingWithdrawals() {
    return amountWithdrawls;
  }

  @Override
  public void endYearUpdate() {
    this.balance += this.balance * this.rent;
    this.amountWithdrawls = originalAmouthWithdrawls;
  }

  public static void main(String[] args) {
    ForeldreSpar spar = new ForeldreSpar(0.05, 10);
    spar.deposit(1000);
    System.out.println(spar.getBalance());
    spar.withdraw(100);
    System.out.println(spar.getBalance());
  }
}
