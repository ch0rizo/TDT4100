package oving7.train;

/**
 * One of two different types of train cars, both specialized versions for different purposes. A
 * {@code PassengerCar} represents a passenger car that transports passengers.
 * 
 * @see TrainCar
 * @see CargoCar
 */
public class PassengerCar extends TrainCar {

    // TODO: Add fields here
    protected int deadWeight;
    protected int passengerCount;

    /**
     * Constructor for the passenger car.
     * 
     * @param deadWeight the weight of an empty passenger car
     * @param passengerCount the number of passengers in the passenger car
     * @throws IllegalArgumentException if either deadWeight or passengerCount is negative
     * 
     * @see PassengerCarTest#testWeight()
     */
    public PassengerCar(int deadWeight, int passengerCount) {
        // TODO: Implement this constructor
        if (deadWeight < 0 || passengerCount < 0)
            throw new IllegalArgumentException("Cannot be negative");
        this.deadWeight = deadWeight;
        this.passengerCount = passengerCount;
        super(deadWeight);
    }

    /**
     * @return the number of passengers in the passenger car
     * 
     * @see PassengerCarTest#testWeight()
     */
    public int getPassengerCount() {
        // TODO: Implement this method
        return this.passengerCount;
    }

    /**
     * @param passengerCount the number of passengers in the passenger car
     * @throws IllegalArgumentException if passengerCount is negative
     * 
     * @see PassengerCarTest#testWeight()
     */
    public void setPassengerCount(int passengerCount) {
        // TODO: Implement this method
        if (passengerCount < 0)
            throw new IllegalArgumentException("Cannot be negative");
        this.passengerCount = passengerCount;
    }

    @Override
    public int getTotalWeight() {
        // To calculate the total weight of the passenger car, you can assume that an average
        // passenger weighs 80 kg

        // TODO: Implement this method
        int totalWeight = deadWeight + (80 * this.passengerCount);
        return totalWeight;
    }

    @Override
    public String toString() {
        // TODO: Implement this method
        return null;
    }

    public static void main(String[] args) {

    }
}
