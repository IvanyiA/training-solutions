package week05d03;

import inheritanceconstructor.cars.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void testUser() {
        UserValidator userValidator = new UserValidator();

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("", 17))));
        assertEquals("The user's name can't be blank or null", ex1.getMessage());

        List<User> users = null;
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(users));
        assertEquals("Users is null", ex2.getMessage());

        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("Iványi Ágnes", 140))));
        assertEquals("The user's age must be between 0 and 120", ex3.getMessage());


    }
}