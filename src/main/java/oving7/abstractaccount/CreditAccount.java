package oving7.abstractaccount;

/**
 * A {@code CreditAccount} has in addition to {@code balance} a state for {@code creditLine}, i.e.
 * available credit on the account. This credit line allows the account to be overdrawn (that the
 * balance is negative) within the credit line. If {@link #internalWithdraw()} tries to withdraw
 * more money than is available, taking the credit line into account, an
 * {@code IllegalArgumentException} should be thrown.
 * 
 * @see AbstractAccount
 */
public class CreditAccount extends AbstractAccount {

    // TODO: Add fields here

    /**
     * Initializes a new {@code CreditAccount} with the specified credit line.
     * 
     * @param creditLine the credit line
     * @throws IllegalArgumentException if the credit line is negative
     */
    public CreditAccount(double creditLine) {
        // TODO: Implement this constructor
    }

    // TODO: Override abstract method here

    /**
     * @return the credit line
     * 
     * @see CreditAccountTest#testCreditLine()
     */
    public double getCreditLine() {
        // TODO: Implement this method
        return 0.0;
    }

    /**
     * Sets the credit line.
     * 
     * @param creditLine the credit line
     * @throws IllegalArgumentException if the credit line is negative, or if the new credit line
     *         does not cover the existing balance
     * 
     * @see CreditAccountTest#testCreditLine()
     */
    public void setCreditLine(double creditLine) {
        // TODO: Implement this method
    }
}
