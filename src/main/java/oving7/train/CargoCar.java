package oving7.train;

/**
 * One of two different types of train cars, both specialized versions for different purposes. A
 * {@code CargoCar} represents a cargo car that transports various things and stuff.
 * 
 * @see TrainCar
 * @see PassengerCar
 */
public class CargoCar extends TrainCar {

    // TODO: Add fields here
    protected int deadWeight;
    protected int cargoWeight;

    /**
     * Constructor for the cargo car.
     * 
     * @param deadWeight the weight of an empty cargo car
     * @param cargoWeight the weight of the cargo in the cargo car
     * @throws IllegalArgumentException if either deadWeight or cargoWeight is negative
     * 
     * @see CargoCarTest#testWeight()
     */
    public CargoCar(int deadWeight, int cargoWeight) {
        // TODO: Implement this constructor
        if (deadWeight < 0 || cargoWeight < 0)
            throw new IllegalArgumentException("Cannot be negative");
        this.deadWeight = deadWeight;
        this.cargoWeight = cargoWeight;
        super(deadWeight);
    }

    /**
     * @return the weight of the cargo in the cargo car
     * 
     * @see CargoCarTest#testWeight()
     */
    public int getCargoWeight() {
        // TODO: Implement this method
        return cargoWeight;
    }

    /**
     * @param cargoWeight the weight of the cargo in the cargo car
     * @throws IllegalArgumentException if cargoWeight is negative
     * 
     * @see CargoCarTest#testWeight()
     */
    public void setCargoWeight(int cargoWeight) {
        // TODO: Implement this method
        if (cargoWeight < 0)
            throw new IllegalArgumentException("Cannot be negative");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getTotalWeight() {
        // TODO: Implement this method
        int totalWeight = cargoWeight + deadWeight;
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
