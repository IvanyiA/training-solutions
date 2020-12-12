package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void getNumberOfGearsTest() {
        Vehicle vehicle = new Vehicle();

        assertEquals(5, vehicle.getNumberOfGears());
    }

    @Test
    public void getTransmissionTypeTest() {
        Vehicle vehicle = new Vehicle();

        assertEquals(TransmissionType.MANUAL, vehicle.getTransmissionType());
    }

    @Test
    public void testCar() {
        Vehicle car = new Car();

        assertEquals(6, car.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, car.getTransmissionType());
    }

    @Test
    public void testTruck() {
        Vehicle truck = new Truck();

        assertEquals(8, truck.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, truck.getTransmissionType());
    }

    @Test
    public void Motorcycle() {
        Vehicle motorcycle = new Motorcycle();

        assertEquals(4, motorcycle.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, motorcycle.getTransmissionType());
    }



}