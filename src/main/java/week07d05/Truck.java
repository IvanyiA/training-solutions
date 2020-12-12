package week07d05;

public class Truck extends Vehicle{

    @Override
    public int getNumberOfGears() {
        return 8;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.AUTOMATIC;
    }
}
