package week07d05;

public class Car extends Vehicle {

    @Override
    public int getNumberOfGears() {
        return 6;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.AUTOMATIC;
    }
}
