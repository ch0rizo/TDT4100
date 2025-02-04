package oving2;

public class Vehicle {
    private char vehicle;
    private char fuel;
    private String regNo;

    public Vehicle(char vehicle, char fuel, String regNo) {
        // Checks fuel is uppercase
        if (!Character.isUpperCase(fuel)) {
            throw new IllegalArgumentException("Fuel must be capitalized");
        }

        // Check valid vehicle
        if (vehicle != 'M' && vehicle != 'C') {
            throw new IllegalArgumentException("Vehicle is either a motorcycle(M) or a car(C)");
        }

        // Checks valid fuel
        if (fuel != 'H' && fuel != 'E' && fuel != 'D' && fuel != 'G') {
            throw new IllegalArgumentException("Allowed fuel is either hydrogen(H), electricity(E), diesel(D) or gasoline(G)");
        }

        String startOfReg = regNo.substring(0, 2);

        // Compares fuel and registration number and checks if its valid
        if ((fuel == 'D'  && startOfReg.equals("EL")) || (fuel == 'D'  && startOfReg.equals("EK"))) {
            throw new IllegalArgumentException("Vehicles on diesel can not have regNo starting with EL or EK");
        } else if ((fuel == 'G'  && startOfReg.equals("EL")) || (fuel == 'G'  && startOfReg.equals("EK"))) {
            throw new IllegalArgumentException("Vehicles on gasoline can not have regNo starting with EL or EK");
        }

        if (fuel == 'E' && !(startOfReg.equals("EL") || startOfReg.equals("EK"))) {
            throw new IllegalArgumentException("RegNo to electrical vehicles must start with EL or EK");
        }

        if (fuel == 'H' && !startOfReg.equals("HY")) {
            throw new IllegalArgumentException("RegNo of hydrogen vehicles must start with HY");
        } else if (vehicle != 'C' && fuel == 'H') {
            throw new IllegalArgumentException("Only cars can have hydrogen fuel");
        }

        // Checks if regNo consist of number after the char
        // Checks if regNo consists of numbers after the char
        // Checks if regNo consists of numbers after the char
        boolean isOnlyNumbers = true;
        int digitsAfterPrefix = regNo.length() - 2; // Subtract the two letters

        for (int i = 2; i < regNo.length(); i++) {
            if (!Character.isDigit(regNo.charAt(i))) { // EL123456
                isOnlyNumbers = false;
                break;
            }
        }

        if (!isOnlyNumbers) {
            throw new IllegalArgumentException("Needs to be digits after letters in regNo");
        } else if (vehicle == 'M' && digitsAfterPrefix != 4) {
            throw new IllegalArgumentException("Motorcycle regNo must only have 4 digits");
        } else if (vehicle == 'C' && digitsAfterPrefix != 5) {
            throw new IllegalArgumentException("Car regNo must only have 5 digits");
        }

        // Ensure uppercase letters
        if (!Character.isUpperCase(regNo.charAt(0)) || !Character.isUpperCase(regNo.charAt(1))) {
            throw new IllegalArgumentException("Registration number must start with uppercase letters");
        }

        // Validate prefix based on fuel type
        String prefix = regNo.substring(0, 2);

        // Check for invalid characters in the prefix (Æ, Ø, Å)
        if (prefix.contains("Æ") || prefix.contains("Ø") || prefix.contains("Å")) {
            throw new IllegalArgumentException("Prefix cannot contain Æ, Ø, or Å");
        }

        if (fuel == 'E' && !(prefix.equals("EL") || prefix.equals("EK"))) {
            throw new IllegalArgumentException("RegNo for electrical vehicles must start with EL or EK");
        } else if (fuel == 'H' && !prefix.equals("HY")) {
            throw new IllegalArgumentException("RegNo for hydrogen vehicles must start with HY");
        } else if (fuel != 'E' && fuel != 'H' && (prefix.equals("EL") || prefix.equals("EK") || prefix.equals("HY"))) {
            throw new IllegalArgumentException("Invalid prefix for this fuel type");
        }

        this.vehicle = vehicle;
        this.fuel = fuel;
        this.regNo = regNo;
    }

    public char getFuelType() {
        return fuel;
    }

    public char getVehicleType() {
        return vehicle;
    }

    public String getRegistrationNumber() {
        return regNo;
    }

    public void setRegistrationNumber(String regNo) {
        String startOfReg = regNo.substring(0, 2);
        // Compares fuel and registration number and checks if its valid
        if ((fuel == 'D'  && startOfReg.equals("EL")) || (fuel == 'D'  && startOfReg.equals("EK"))) {
            throw new IllegalArgumentException("Vehicles on diesel can not have regNo starting with EL or EK");
        } else if ((fuel == 'G'  && startOfReg.equals("EL")) || (fuel == 'G'  && startOfReg.equals("EK"))) {
            throw new IllegalArgumentException("Vehicles on gasoline can not have regNo starting with EL or EK");
        }

        if (fuel == 'E' && !(startOfReg.equals("EL") || startOfReg.equals("EK"))) {
            throw new IllegalArgumentException("RegNo to electrical vehicles must start with EL or EK");
        }

        if (fuel == 'H' && !startOfReg.equals("HY")) {
            throw new IllegalArgumentException("RegNo of hydrogen vehicles must start with HY");
        } else if (vehicle != 'C' && fuel == 'H') {
            throw new IllegalArgumentException("Only cars can have hydrogen fuel");
        }

        // Checks if regNo consist of number after the char
        boolean isOnlyNumbers = true;
        int digitsAfterPrefix = regNo.length() - 2; // Subtract the two letters

        for (int i = 2; i < regNo.length(); i++) {
            if (!Character.isDigit(regNo.charAt(i))) { // EL123456
                isOnlyNumbers = false;
                break;
            }
        }

        if (!isOnlyNumbers) {
            throw new IllegalArgumentException("Needs to be digits after letters in regNo");
        } else if (vehicle == 'M' && digitsAfterPrefix != 4) {
            throw new IllegalArgumentException("Motorcycle regNo must only have 4 digits");
        } else if (vehicle == 'C' && digitsAfterPrefix != 5) {
            throw new IllegalArgumentException("Car regNo must only have 5 digits");
        }

        // Ensure uppercase letters
        if (!Character.isUpperCase(regNo.charAt(0)) || !Character.isUpperCase(regNo.charAt(1))) {
            throw new IllegalArgumentException("Registration number must start with uppercase letters");
        }

        // Validate prefix based on fuel type
        String prefix = regNo.substring(0, 2);

        // Check for invalid characters in the prefix (Æ, Ø, Å)
        if (prefix.contains("Æ") || prefix.contains("Ø") || prefix.contains("Å")) {
            throw new IllegalArgumentException("Prefix cannot contain Æ, Ø, or Å");
        }

        if (fuel == 'E' && !(prefix.equals("EL") || prefix.equals("EK"))) {
            throw new IllegalArgumentException("RegNo for electrical vehicles must start with EL or EK");
        } else if (fuel == 'H' && !prefix.equals("HY")) {
            throw new IllegalArgumentException("RegNo for hydrogen vehicles must start with HY");
        } else if (fuel != 'E' && fuel != 'H' && (prefix.equals("EL") || prefix.equals("EK") || prefix.equals("HY"))) {
            throw new IllegalArgumentException("Invalid prefix for this fuel type");
        }

        this.regNo = regNo;
    }
    
    public static void main(String[] args) {
        String regNo = "EL1234";
        System.out.println(regNo.substring(0, 2));
    }
}
