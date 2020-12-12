package week07d05;

public class Motorcycle extends Vehicle{

    @Override
    public int getNumberOfGears() {
        return 4;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.SEQUENTIAL;
    }
}
