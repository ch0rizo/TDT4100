package oving7.train;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@code Train} represents a train that consists of one or more train cars.
 * 
 * @see TrainCar
 * @see CargoCar
 * @see PassengerCar
 */
public class Train {

    // TODO: Add fields here
    protected List<TrainCar> trainCar = new ArrayList<>();

    /**
     * @param trainCar the train car to check for
     * @return {@code true} if the train contains the train car, {@code false} otherwise
     * 
     * @see TrainTest#testAddCarToTrain()
     */
    public boolean contains(TrainCar trainCar) {
        // TODO: Implement this method
        return this.trainCar.contains(trainCar);
    }

    /**
     * Adds a train car to the train.
     * 
     * @param trainCar the train car to add
     * @throws IllegalArgumentException if the train car is {@code null}
     * 
     * @see TrainTest#testAddCarToTrain()
     */
    public void addTrainCar(TrainCar trainCar) {
        // TODO: Implement this method
        if (trainCar == null)
            throw new IllegalArgumentException("Cant be null");
        this.trainCar.add(trainCar);
    }

    /**
     * @return the sum of the total weight of all the train cars in the train. There is no need to
     *         take the weight of the locomotive into account
     * 
     * @see TrainTest#testTotalTrainWeight()
     */
    public int getTotalWeight() {
        // TODO: Implement this method
        int totalWeight = 0;
        for (TrainCar train : trainCar) {
            totalWeight += train.getTotalWeight();
        }
        return totalWeight;
    }

    /**
     * @return similar to {@link PassengerCar#getPassengerCount()}, but for the entire train
     * 
     * @see TrainTest#testPassengerCount()
     */
    public int getPassengerCount() {
        // TODO: Implement this method
        int totalPassenger = 0;
        for (TrainCar train : trainCar) {
            if (train instanceof PassengerCar passengerCar) {
                totalPassenger += passengerCar.getPassengerCount();
            }
        }
        return totalPassenger;
    }

    /**
     * @return similar to {@link CargoCar#getCargoWeight()}, but for the entire train
     * 
     * @see TrainTest#testCargoWeight()
     */
    public int getCargoWeight() {
        // TODO: Implement this method
        int totalCargoWeight = 0;
        for (TrainCar train : trainCar) {
            if (train instanceof CargoCar cargoCar) {
                totalCargoWeight += cargoCar.getCargoWeight();
            }
        }
        return totalCargoWeight;
    }

    /**
     * @return a string representation of the train. The string should consist of the
     *         {@link #toString()}s of all train cars in the train
     */
    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        // TODO: Write a main method to test the class
    }
}
