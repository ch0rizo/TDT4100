package oving7.savingsaccount;

public class SavingsAccount implements Account {
  protected double balance;
  protected double rent;

  public SavingsAccount(double rent) {
    if (rent <= 0)
      throw new IllegalArgumentException("Rent can not be negative");
    this.balance = 0.0;
    this.rent = rent;
  }

  @Override
  public void deposit(double amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Not valid amount");

    this.balance += amount;
  }

  @Override
  public void withdraw(double amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Not be negative");
    
    if (this.balance - amount < 0)
      throw new IllegalStateException("Not enough money on account");

    this.balance -= amount;
  }

  @Override
  public double getBalance() {
    return this.balance;
  }

  public void endYearUpdate() {
    this.balance += this.balance * this.rent;
  }

  public static void main(String[] args) {
    SavingsAccount account = new SavingsAccount(0.1);

    account.balance = 100;

    account.endYearUpdate();

    System.out.println(account.getBalance());
  }
}
