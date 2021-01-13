package week11d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void testCourierCreation() {

        Courier courier = new Courier();

        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(2, 1, 1));

        assertEquals(2, courier.getRides().size()
        );
    }

    @Test
    void testCourierNoWorkingDay() {

        Courier courier = new Courier();

        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(2, 1, 1));

        assertEquals(3, courier.noWork());
    }

    @Test
    void testCourierRepeat() {

        Courier courier = new Courier();

        courier.addRide(new Ride(1, 1, 1));

        assertThrows(IllegalArgumentException.class,
                ()->courier.addRide(new Ride(1, 1, 1)));

    }

    @Test
    void testCourierWrongNumberOrder() {

        Courier courier = new Courier();

        courier.addRide(new Ride(1, 1, 1));

        assertThrows(IllegalArgumentException.class,
                ()->courier.addRide(new Ride(1, 3, 1)));

    }




}