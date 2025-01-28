package oving1;

public class UpOrDownCounter {
    private int start;
    private int end;
    private int counter;

    public UpOrDownCounter ( int start, int end ) {
        this.start = start;
        this.end = end;
        this.counter = start;
        if ( start == end ) {
            throw new IllegalArgumentException("Start and end can not be the same integer");
        }
    }

    public int getCounter() {
        return this.counter;
    }

    boolean count() {
        if (this.counter != this.end) {
            if (this.counter < this.end) {
                this.counter++;
                if (this.counter == (this.end)) {
                    return false;
                }
                return true;
            } else if (this.counter > this.end) {
                this.counter--;
                if (this.counter == this.end) {
                    return false;
                }
                return true;
            }
        } return false;
    }


    public static void main(String[] args) {
        UpOrDownCounter upOrDownCounter = new UpOrDownCounter(3, 5);
        System.out.println(upOrDownCounter.getCounter());
        upOrDownCounter.count();
        upOrDownCounter.count();
        System.out.println(upOrDownCounter.getCounter());
        System.out.println(upOrDownCounter.count());
    }
}
