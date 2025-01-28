package oving1;

public class Digit {
    private final int numSys;
    private int digit;

    public Digit(int numSystem) {
        this.numSys = numSystem;
        this.digit = 0;
    }

    public int getValue() {
        return this.digit;
    }

    public int getBase() {
        return this.numSys;
    }

    public boolean increment() {
        this.digit++;
        if ( this.digit >= this.numSys ) {
            this.digit = 0;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if ( this.digit > 9 ) {
            char asciiChar = (char) (this.digit + 55);
            return Character.toString(asciiChar);
        }
        return Integer.toString(this.digit);
    }

    public static void main(String[] args) {
        Digit digit = new Digit(36);
        for (int i = 0; i < 35; i++) {
            digit.increment();
        }
        System.out.println(digit);
    }
}
