package introexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    public void test() {
        assertThrows(IllegalArgumentException.class, () -> new Patient("",
                "000000000", 1952));
    }

    @Test
    public void gettersTest() {
        Patient patient = new Patient("John Doe", "000000000", 1952);
        assertEquals("John Doe", patient.getName());
        assertEquals("000000000", patient.getSocialSecurityNumber());
        assertEquals(1952, patient.getYearOfBirth());
    }

}

