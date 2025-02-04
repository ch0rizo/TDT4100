package oving1;

public class Account {
    private double balance = 0.0;
    private double interestRate = 0.0;

    public Account(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public Account() {
        this.balance = 0.0;
        this.interestRate = 0.0;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void addInterest() {
        this.balance += this.balance * this.interestRate/100;
    }

    public void setInterestRate(double newRate) {
        this.interestRate = newRate;
    }

    public static void main(String[] args) {
        Account account = new Account(100.0, 1.05);
        System.out.println("Balance: " + account.getBalance());
        account.deposit(160);
        System.out.println("Updated Balance: " + account.getBalance());
        account.addInterest();
        System.out.println("After rents: " + account.getBalance());
    }
}
