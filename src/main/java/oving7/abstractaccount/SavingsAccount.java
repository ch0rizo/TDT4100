package oving7.abstractaccount;

/**
 * A {@code SavingsAccount} can only have a positive balance. In addition, the account has
 * withdrawal restrictions. A {@code SavingsAccount} has {@code x} number of {@code withdrawals}. If
 * you want to withdraw money after all withdrawals have been used up, the balance should be charged
 * a {@code fee}. If the balance is too low to cover the fee, an {@code IllegalArgumentException}
 * should be thrown.
 * 
 * @see AbstractAccount
 */
public class SavingsAccount extends AbstractAccount {

    // TODO: Add fields here
    private int withdrawls;
    private double fee;

    /**
     * Initializes a new {@code SavingsAccount} with the specified number of withdrawals and fee.
     * 
     * @param withdrawals the number of withdrawals
     * @param fee the fee
     * @throws IllegalArgumentException if the number of withdrawals or the fee is negative
     */
    public SavingsAccount(int withdrawals, double fee) {
        // TODO: Implement this constructor
        if (withdrawals < 0 || fee < 0)
            throw new IllegalArgumentException("None can be negative");

        this.withdrawls = withdrawals;
        this.fee = fee;
    }

    // TODO: Override abstract method here
    @Override
    public void internalWithdraw(double amount) {
        if (amount + this.fee > this.balance) throw new IllegalArgumentException("Too much to withdraw, you poor!");

        else if (withdrawls == 0 && this.balance < fee)
            throw new IllegalArgumentException("No more withdrawls and cant pay for more withdrawls");

        else if (withdrawls == 0) {
            this.balance -= this.fee;
            this.balance -= amount;
        }

        else {
            this.balance -= amount;
            this.withdrawls--;
        }
    }
}
