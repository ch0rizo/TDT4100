package oving2;

public class Account {
    private double balance;
    private double interestRate;

    public Account(double balance, double interestRate) {
        if (balance < 0 || interestRate < 0) {
            throw new IllegalArgumentException("Balance or interest rate can not be negative");
        }

        this.balance = balance;
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate can not be negative");
        } else {
            this.interestRate = interestRate;
        }
    }

    public void deposit(double deposit) {
        if (deposit < 0) {
            throw new IllegalArgumentException("You can not deposit a negative sum");
        } else {
            this.balance += deposit;
        }
    }

    public void withdraw(double sum) {
        if (sum < 0) {
            throw new IllegalArgumentException("You can not withdraw a negative sum");
        } else {
            this.balance -= sum;
        }

        if (this.balance < 0) {
            throw new IllegalArgumentException("Balance are negative");
        }
    }

    public void addInterest() {
        this.balance += this.balance * this.interestRate;
    }

    public static void main(String[] args) {
        Account account = new Account(100, 0.1);
        System.out.println(account.getBalance());
        account.addInterest();
        System.out.println(account.getBalance());
    }
}
