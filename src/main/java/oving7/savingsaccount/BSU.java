package oving7.savingsaccount;

public class BSU extends SavingsAccount {
  private double limitAmount;
  private double currentYearBalance;

  public BSU(double rent, double limitAmount) {
    this.limitAmount = limitAmount;
    super(rent);
  }

  @Override
  public void deposit(double amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Not valid amount");

    if (currentYearBalance + amount > limitAmount)
      throw new IllegalStateException("Current limit amount");

    this.balance += amount;
    this.currentYearBalance += amount;
  }
  
  @Override
  public void withdraw(double amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Not be negative");
    
    if (this.balance - amount < 0 || this.currentYearBalance - amount < 0)
      throw new IllegalStateException("Not enough money on account");

    this.balance -= amount;
    this.currentYearBalance -= amount;
  }

  @Override
  public void endYearUpdate() {
    this.balance += this.balance * this.rent;
    this.currentYearBalance = 0;
  }

  public double getTaxDeduction() {
    return currentYearBalance * 0.20;
  }
}
